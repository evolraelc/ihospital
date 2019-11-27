app.controller('doctorWorkController', function ($scope, $http, doctorService, uploadService, $interval, loginService) {

    //获取医生的id


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
            }
        )
    };

//初始化
    $scope.initBody = function () {

        $scope.getLoginId();


    };


    $scope.entity = {drugList: []};

    //添加处方行
    $scope.addDrugRow = function () {
        $scope.entity.drugList.push({});
    };
    //删除处方行

    $scope.deleteDrugRow = function (index) {
        $scope.entity.drugList.splice(index, 1);
    };

});