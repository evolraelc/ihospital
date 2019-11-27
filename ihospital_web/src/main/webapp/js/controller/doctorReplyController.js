app.controller('doctorReplyController', function ($scope, $controller, loginService, patientService, doctorService
                , replyService, commentService) {
    $controller('baseController', {$scope:$scope, loginService:loginService});
    $scope.getLoginId = function () {
        loginService.loginName().success(
            function (response) {
                $scope.getLoginDoctor(response.loginName);
            }
        )
    };
    //获取医生实体
    $scope.doctorEntity = {};
    $scope.getLoginDoctor = function (id) {
        doctorService.findOne(id).success(
            function (response) {
                $scope.doctorEntity = response;
                $scope.reloadList();
            }
        )
    };
    //初始化
    $scope.initBody = function () {
        $scope.getLoginId();
    };
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 5,
        itemsPerPage: 5,
        perPageOptions: [5, 10, 15, 20],
        onChange: function () {
            $scope.reloadList();
        }
    };
    // $scope.reloadList = function () {
    //     $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    // };
    $scope.searchEntity = {};
    $scope.commentList = {};
    $scope.search = function (pageNum, pageSize) {
        if($scope.doctorEntity === {}) return;
        $scope.searchEntity.physicianId = $scope.doctorEntity.physicianId;
        commentService.search(pageNum, pageSize, $scope.searchEntity).success(
            function (response) {
                $scope.commentList = response.rows;
                $scope.paginationConf.totalItems = response.total;
                for(var i = 0;i < response.rows.length;i++) {
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
    $scope.newReply = {};
    $scope.addReply = function (comment) {
        $scope.newReply.body = comment.newReply;
        $scope.newReply.consultId = comment.consultId;
        $scope.newReply.type = 0;
        replyService.addReply($scope.newReply).success(
            function (response) {
                if(response.success !== true){
                    alert(response.message);
                }
                else {
                    $scope.reloadList();
                }
                $scope.newReply = {};
                comment.newReply = "";
            }
        );
    }
});