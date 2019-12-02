app.controller('commentController', function ($scope, $controller, loginService, commentService) {
    $controller('baseController', {$scope:$scope, loginService:loginService});
    //获取登录名
    $scope.showLoginName = function () {
        loginService.loginName().success(
            function (response) {
                $scope.loginName=response.loginName;
            }
        )
    };

    $scope.findAll = function() {
        commentService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    };
    $scope.deleteComment = function () {
        commentService.deleteComment($scope.selectIds).success(
            function (response) {
                if(response.success) {
                    $scope.reloadList()
                }
                else {
                    alert(response.message);
                }
            }
        );
    };
    $scope.searchName = "";
    $scope.searchEntity = {};
    $scope.search = function (pageNum, pageSize) {
        $scope.searchEntity.patientName = $scope.searchName;
        $scope.searchEntity.physicianName = $scope.searchName;
        commentService.search(pageNum, pageSize, $scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;
            }
        );
    }
});