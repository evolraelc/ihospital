app.controller('doctorCenterController', function ($scope, $controller, loginService, patientService, doctorService
                , replyService, commentService, uploadService) {
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

    $scope.searchEntity = {};
    $scope.commentList = {};
    $scope.search = function (pageNum, pageSize) {
        if($scope.doctorEntity.physicianId === undefined) return;
        $scope.searchEntity.physicianId = $scope.doctorEntity.physicianId;
        commentService.search(pageNum, pageSize, $scope.searchEntity).success(
            function (response) {
                $scope.commentList = response.rows;
                $scope.paginationConf.totalItems = response.total;
                for( i = 0; i < response.rows.length; i++) {
                    (function(e) {
                        $scope.commentList[e].show = false;
                        replyService.getReplyList($scope.commentList[e].consultId).success(
                            function (response) {
                                $scope.commentList[e].replyList = response;
                            }
                        );
                        patientService.findOne($scope.commentList[e].patientId).success(
                            function (response) {
                                $scope.commentList[e].avatar = response.userAvatar;
                            }
                        )
                    })(i)
                }
            }
        );
    };
    $scope.showReply = function(comment) {
        for(i = 0;i < $scope.commentList.length;i++) {
            if($scope.commentList[i].consultId === comment.consultId) {
                $scope.commentList[i].show = !$scope.commentList[i].show
            }
        }

    };
    $scope.newReply = {};
    $scope.addReply = function (comment) {
        if(!comment.newReply || comment.newReply === "") {
            alert("回复不能为空");
            return;
        }
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
    };
    $scope.uploadFile=function () {
        uploadService.uploadFile().success(
            function (response) {
                if (response.success){
                    $scope.doctorEntity.physicianAvatar = response.message;
                    var file = document.getElementById('file');
                    file.outerHTML = file.outerHTML;
                } else{
                    alert(response.message)
                    var file = document.getElementById('file');
                    file.outerHTML = file.outerHTML;
                }
            }
        );
    };
    //清空图片
    $scope.resetFile = function () {
        var file = document.getElementById('file');
        file.outerHTML = file.outerHTML;
    };
    $scope.oldPwd = "";
    $scope.newPwd = "";
    $scope.update = function () {
        if($scope.doctorEntity.physicianId === null) {
            alert("系统加载失败");
            return;
        }
        if($scope.newPwd !== "") {
            if(!($scope.doctorEntity.pwd === null && $scope.oldPwd === "123456") && $scope.oldPwd !== $scope.doctorEntity.pwd) {
                alert("密码错误");
                return;
            }
            else $scope.doctorEntity.pwd = $scope.newPwd;
            $scope.oldPwd = "";
            $scope.newPwd = "";
        }
        doctorService.update($scope.doctorEntity).success(
            function (response) {
                alert(response.message);
                if(!response.success) {
                    doctorService.findOne($scope.doctorEntity.physicianId).success(
                        function (response) {
                            $scope.doctorEntity = response;
                        }
                    )
                }
            }
        );
    }
});