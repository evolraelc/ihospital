app.controller("commentInfoController", function ($scope, $location, loginService, patientService, replyService, commentService) {
    var id = "";
    if($location.search().id) {
        id = $location.search().id;
    }
    $scope.comment = {};
    $scope.replyList = {};
    $scope.getComment = function () {
        if(id !== "") {
            commentService.getComment(id).success(
                function (response) {
                    $scope.comment = response;
                }
            );
        }
    };
    $scope.getReplyList = function () {
        replyService.getReplyList(id).success(
            function (response) {
                $scope.replyList = response;
            }
        );
    };
    $scope.initInfo = function () {
        $scope.showLoginName();
        $scope.getComment();
        $scope.getReplyList();
    };
    $scope.approve = function () {
        patientService.approve($scope.comment.patientId).success(
            function (response) {
                if(!response.success) {
                    alert(response.msg);
                }
            }
        );
    };
    $scope.deny = function () {
        patientService.deny($scope.comment.patientId).success(
            function (response) {
                if(!response.success) {
                    alert(response.msg);
                }
            }
        );
    };

    //获取登录名
    $scope.showLoginName = function () {
        loginService.loginName().success(
            function (response) {
                $scope.loginName=response.loginName;
            }
        )
    };
});