app.controller('patientReplyController', function ($scope, $controller, loginService, patientService, doctorService
    , replyService, commentService) {
    $controller('baseController', {$scope:$scope, loginService:loginService});
    $scope.getPhone = function () {
        loginService.loginName().success(
            function (response) {
                $scope.getLoginPatient(response.loginName);
            }
        )
    };

    $scope.patientEntity = {};
    $scope.getLoginPatient = function (phone) {
        patientService.getPatient(phone).success(
            function (response) {
                $scope.patientEntity = response;
                $scope.newComment.patientId = response.patientId;
            }
        )
    };
    //初始化
    $scope.initBody = function () {
        $scope.getPhone();
    };
    // $scope.paginationConf = {
    //     currentPage: 1,
    //     totalItems: 5,
    //     itemsPerPage: 5,
    //     perPageOptions: [5, 10, 15, 20],
    //     onChange: function () {
    //         $scope.reloadList();
    //     }
    // };
    // $scope.reloadList = function () {
    //     $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    // };
    $scope.physicianId = 2;
    $scope.searchEntity = {};
    $scope.commentList = {};
    $scope.search = function (pageNum, pageSize) {
        if($scope.doctorEntity === {}) return;
        $scope.searchEntity.physicianId = $scope.physicianId;
        commentService.search(pageNum, pageSize, $scope.searchEntity).success(
            function (response) {
                $scope.commentList = response.rows;
                $scope.paginationConf.totalItems = response.total;
                for(let i = 0; i < response.rows.length; i++) {
                    (function(e) {
                        replyService.getReplyList($scope.commentList[e].consultId).success(
                            function (response) {
                                $scope.commentList[e].replyList = response;
                            }
                        )
                    })(i)
                }
            }
        );
    };
    $scope.newComment = {physicianId:$scope.physicianId, patientId:$scope.patientEntity.patientId};
    $scope.addComment = function () {
        if($scope.patientEntity.utype === "Denied") {
            alert("你目前被禁言中，无法评论");
            return;
        }
        if(!$scope.newComment.body || $scope.newComment.body === "") {
            alert("评论不能为空");
            return;
        }
        if(!$scope.newComment.patientId || !$scope.newComment.physicianId) {
            alert("评论失败，请重试");
            return;
        }
        commentService.addComment($scope.newComment).success(
            function (response) {
                if(!response.success){
                    alert(response.message);
                }else {
                    $scope.reloadList();
                }
                $scope.newComment.body = "";
            }
        );
    };
    $scope.addReply = function (comment) {
        if(!$scope.patientEntity.patientId) {
            alert("系统正在加载，请重试");
            return;
        }
        if($scope.patientEntity.utype === "Denied") {
            alert("你目前被禁言中，无法回复");
            return;
        }
        if($scope.patientEntity.patientId !== comment.patientId) {
            alert("你不能回复他人的评论");
            return;
        }
        let reply = {};
        reply.body =  prompt("输入回复:");
        if(!reply.body || reply.body === "") {
            alert("回复不能为空");
            return;
        }
        reply.type = 1;
        reply.consultId = comment.consultId;
        replyService.addReply(reply).success(
            function (response) {
                if(response.success !== true){
                    alert(response.message);
                }
                else {
                    $scope.reloadList();
                }
            }
        );
    }
});