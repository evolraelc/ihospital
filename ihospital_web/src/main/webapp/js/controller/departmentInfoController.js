 var app = angular.module('ihospital', ['pagination']);
    app.config(['$locationProvider', function ($locationProvider){
        $locationProvider.html5Mode(true);
    }]);

 app.service('loginService', function ($http) {

   this.loginName = function () {

     return $http.get('../login/name.do');

   }

 });

    app.controller('departmentInfoController', function ($scope, $http, $filter, $location,loginService) {


        $scope.searchDoctorEntity = {};
        $scope.searchDepartEntity = {};
        $scope.addedItemDepartment = {};
        $scope.addedItemDoctor = {};
        $scope.departOfDoctor = {};
        $scope.id = null;
        $scope.departName = null;
        $scope.all_depart_list = [];

        /*
            get id from url
         */

      //获取登录名
      $scope.showLoginName = function () {
        loginService.loginName().success(
          function (response) {
            $scope.loginName = response.loginName;
          }
        )
      };
        if ($location.search().id && $location.search().departName){
            $scope.id = $location.search().id;
            $scope.departName = $location.search().departName;
            if ($scope.id != null) {
                console.log($scope.id);
                console.log($scope.departName);
                $scope.searchDepartEntity.departId = $scope.id;
                $scope.searchDoctorEntity.departId = $scope.id;
            }
            else{


            }
        }

        /*
            added item set id
         */
        $scope.setaddedItemDepartId = function(){
            if ($scope.id != null) {
                $scope.addedItemDepartment.departId = $scope.id;
                $scope.addedItemDoctor.departId = $scope.id;
                $scope.departOfDoctor.departId = $scope.id;
                // $scope.departOfDoctor.departName = $scope.departName;
            }
            else{

            }
        }
        /*
            get all department and fill in @all_depart_list
        */
        $scope.getAllDepartment= function () {

            $http.get("../department/findAll.do").success(
                function (data) {

                    var departNames = [];
                    for (var i = 0; i < data.length; i++) {
                        departNames.push(data[i]["departName"]);

                    }
                    $scope.all_depart_list = Array.from(new Set(departNames));

                    $scope.all_depart_list = $scope.all_depart_list.filter(x => (x !== null && x.length > 0));

                }
            ).error(
                function (data) {

                }
            )
        }
            /*
                added item clear cache
             */
        $scope.refreshaddedItem = function(){
            $scope.addedItemDepartment.departId = null;
            $scope.addedItemDoctor.departId = null;
            $scope.departOfDoctor.departId = null;
            $scope.departOfDoctor.departName = null;
        }

        //分页控件初始配置
        $scope.paginationConf_doctor = {
            //当前页
            currentPage: 1,
            //总记录数
            totalItems: 10,
            //每页记录数
            itemsPerPage: 10,
            //分页选项
            perPageOptions: [10, 20, 30, 40, 50],
            //页码变更后触发
            onChange: function () {

                $scope.reloadList();
            }
        }

        //刷新列表
        $scope.reloadList = function () {
            $scope.searchDoctor($scope.paginationConf_doctor.currentPage,
                $scope.paginationConf_doctor.itemsPerPage);
        };

        //条件查询*2
        $scope.searchDoctor = function (page,size) {

            $http.post('../doctor/searchPhysician.do?page=' + page + '&size=' + size
                                ,$scope.searchDoctorEntity).success(
                function (response) {
                    //显示当前页的数据
                    $scope.list=response.rows;
                    if ($scope.list.length ==0){

                    }
                    //更新分页控件配置
                    $scope.paginationConf_doctor.totalItems =response.total;

                }
            ).error(
                function (data) {

                }
            )
        };

        $scope.searchDepart = function (page,size) {

            $http.post('../department/searchDepartment.do?page=' + page + '&size=' + size,$scope.searchDepartEntity).success(
                function (response) {
                    console.log('depart info');

                    //显示当前页的数据
                    $scope.departinfo=response.rows;
                }
            ).error(
                function (data) {

                }
            )
        };



        //查询分页后的列表
        $scope.findPage = function (page, size) {

            $http.get('../department/findPage.do?page=' + page + '&size=' + size).success(
                function (response) {
                    //显示当前页的数据
                    $scope.list=response.rows;
                    //更新分页控件配置
                    $scope.paginationConf.totalItems =response.total;

                }
            ).error(
                function (response) {

                }
            )
        }


        /*
            update department info
         */
        $scope.updateDepartment = function () {
            $http.post("../department/updateDepartment.do",$scope.addedItemDepartment).success(
                function (data) {

                    //局部刷新
                    $scope.reloadList();
                }
            ).error( //// ajax 异常 必须在非web层解决
                function (data){


                }
            )
        };

        /*
            update doctor list
         */
        $scope.updateDoctor = function (){
            $scope.addedItemDoctor.physicianId = $scope.changeId;
            var para1 = JSON.stringify($scope.addedItemDoctor);
            var para2 = JSON.stringify($scope.departOfDoctor);
            var param = {};
            param.data = para1 +"&"+para2;
            $http.post("../doctor/updatePhysician.do",param).success(
                function (data) {

                    //局部刷新
                    $scope.reloadList();
                    $scope.refreshaddedItem();
                }
            ).error( //// ajax 异常 必须在非web层解决
                function (data){

                    $scope.refreshaddedItem();
                }
            )
        }

        /*
            get gender into boolean type
         */
        $scope.getGender = function($event){

            if ($event.target.value == "male"){
                $scope.addedItemDoctor.physicianGender = 0;
            }
            else if ($event.target.value == "female"){
                $scope.addedItemDoctor.physicianGender = 1;
            }
            else{

            }
        }

        //用户勾选的id集合
        $scope.selectIds=[];

        $scope.updateSelection = function ($event,id) {
            if($event.target.checked){
                $scope.selectIds.push(id);
            }else{
                var index= $scope.selectIds.indexOf(id);
                $scope.selectIds.splice(index,1);
            }
        }

        /*
            add physician
         */
        $scope.addDoctor = function () {
            $scope.addedItemDoctor.physicianId = $scope.changeId;
            $scope.departOfDoctor.departId = $scope.id;
            $scope.departOfDoctor.departName = $scope.departName;
            var para1 = JSON.stringify($scope.addedItemDoctor);
            var para2 = JSON.stringify($scope.departOfDoctor);

            var param = {};
            param.data = para1 +"&"+para2;
            $http.post("../doctor/addPhysician.do",param).success(
                function (data) {

                    //局部刷新
                    $scope.reloadList();
                    $scope.refreshaddedItem();
                }
            ).error( //// ajax 异常 必须在非web层解决
                function (data){

                    $scope.refreshaddedItem();
                }
            )
        };

        $scope.deletePhysician = function () {
            $http.get('../doctor/deletePhysicians.do?ids='+$scope.selectIds).success(
                function (response) {
                    if (response.success){
                        //局部刷新
                        $scope.reloadList();
                    } else {
                        //弹出错误，样式我还不知道怎么改
                        alert(response.message);
                    }
                }
            );
        };


        $scope.reloadList();
        $scope.getAllDepartment();

    });
