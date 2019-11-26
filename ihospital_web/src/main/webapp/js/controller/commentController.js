app.controller('commentController', function ($scope, $http, $filter, loginService, commentService) {
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
                for(var i = 0; i < response.length; i++) {
                    $scope.list[i].createTime = $filter("date")(response[i].createTime, "yyyy-MM-dd HH:mm:ss");
                }
            }
        );
    };
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();
        }
    };
    $scope.reloadList = function () {
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };
    $scope.findPage = function (pageNum, pageSize) {
        commentService.findPage(pageNum, pageSize).success(
            function (response) {
                $scope.list = response.rows;
                for(var i = 0; i < response.rows.length; i++) {
                    $scope.list[i].createTime = $filter("date")(response.rows[i].createTime, "yyyy-MM-dd HH:mm:ss");
                }
                $scope.paginationConf.totalItems = response.total;
            }
        );
    };
    $scope.selectIds = [];
    $scope.updateSelect = function($event, id) {
        if($event.target.checked) {
            $scope.selectIds.push(id);
        }
        else {
            var index = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(index, 1);
        }
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
                for(var i = 0; i < response.rows.length; i++) {
                    $scope.list[i].createTime = $filter("date")(response.rows[i].createTime, "yyyy-MM-dd HH:mm:ss");
                }
                $scope.paginationConf.totalItems = response.total;
            }
        );
    }
});