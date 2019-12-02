var app = angular.module('ihospital', ['pagination']);

app.service('loginService', function ($http) {

  this.loginName = function () {

    return $http.get('../login/name.do');

  }

});

app.controller('doctorController', function ($scope, $http, loginService) {

  //获取登录名
  $scope.showLoginName = function () {
    loginService.loginName().success(
      function (response) {
        $scope.loginName = response.loginName;
      }
    )
  };


  //查询列表
  $scope.findAll = function () {
    $http.get('../patient/findAll.do').success(
      function (response) {
        $scope.list = response;
      }
    )
  }

  $scope.list = [];
  $scope.searchEntity = {physicianGender: 0};

  //分页控件初始配置
  $scope.paginationConf = {
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

  // $scope.updatePaginationConf = function($event){
  //     $scope.paginationConf.itemsPerPage = $event.target.value;
  //     $scope.paginationConf.onChange();
  // }

  //刷新列表
  $scope.reloadList = function () {
    console.log('reload list');
    $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
  };

  //条件查询
  $scope.search = function (page, size) {

    $http.post('../doctor/searchPhysician.do?page=' + page + '&size=' + size, $scope.searchEntity).success(
      function (response) {
        //显示当前页的数据
        $scope.list = response.rows;
        //更新分页控件配置
        $scope.paginationConf.totalItems = response.total;
      }
    ).error(
      function (data) {

      }
    )
  };


  //查询分页后的列表
  $scope.findPage = function (page, size) {

    $http.get('../doctor/findPage.do?page=' + page + '&size=' + size).success(
      function (response) {
        //显示当前页的数据
        $scope.list = response.rows;
        //更新分页控件配置
        $scope.paginationConf.totalItems = response.total;

      }
    ).error(
      function (response) {

      }
    )
  }

  /*
      get all department and fill in @all_depart_list
  */
  $scope.getAllDepartment = function () {

    $http.get("../department/findAll.do").success(
      function (data) {

        var departNames = [];
        for (var i = 0; i < data.length; i++) {
          departNames.push(data[i]["departName"]);

        }
        $scope.all_depart_list = Array.from(new Set(departNames));

        $scope.all_depart_list = $scope.all_depart_list.filter(x => (x !== null && x.length > 0)
      );

      }
    ).error(
      function (data) {

      }
    )
  }


  $scope.addedItemDoctor = {}
  $scope.departOfDoctor = {}


  /*
      添加请求后清除缓存
   */
  $scope.addDoctorRefresh = function () {
    $scope.addedItemDoctor = {};
    $scope.departOfDoctor = {};
  }

  /*
      add physician
   */
  $scope.addDoctor = function () {
    $scope.addedItemDoctor.physicianId = $scope.changeId;
    var para1 = JSON.stringify($scope.addedItemDoctor);
    var para2 = JSON.stringify($scope.departOfDoctor);

    var param = {};
    param.data = para1 + "&" + para2;
    $http.post("../doctor/addPhysician.do", param).success(
      function (data) {


        //局部刷新
        $scope.reloadList();
        $scope.addDoctorRefresh();
      }
    ).error( //// ajax 异常 必须在非web层解决
      function (data) {

        $scope.addDoctorRefresh();
      }
    )
  };


  $scope.updateDoctorRefresh = function () {
    $scope.addedItemDoctor = {};
    $scope.departOfDoctor = {};
  }

  $scope.updateDoctor = function () {
      $scope.addedItemDoctor.physicianId = $scope.changeId;
      var para1 = JSON.stringify($scope.addedItemDoctor);
      var para2 = JSON.stringify($scope.departOfDoctor);
      var param = {};
      param.data = para1 + "&" + para2;
      $http.post("../doctor/updatePhysician.do", param).success(
        function (data) {

          //局部刷新
          $scope.reloadList();
          $scope.updateDoctorRefresh();
        }
    ).error( //// ajax 异常 必须在非web层解决
      function (data) {

        $scope.updateDoctorRefresh();
      }
    )
  }

  //用户勾选的id集合
  $scope.selectIds = [];

  $scope.updateSelection = function ($event, id) {
    if ($event.target.checked) {
      $scope.selectIds.push(id);
    } else {
      var index = $scope.selectIds.indexOf(id);
      $scope.selectIds.splice(index, 1);
    }
  };

  $scope.updateChangeSelection = function ($event, id) {
    $scope.changeId = id;
  }

  $scope.getGender = function ($event) {

    if ($event.target.value == "male") {
      $scope.addedItemDoctor.physicianGender = 0;
    } else if ($event.target.value == "female") {
      $scope.addedItemDoctor.physicianGender = 1;
    } else {

    }
  }

  $scope.freshAddedItemCache = function () {
    $scope.addedItemDoctor = {};
  }

  $scope.freshUpdateItemCache = function () {
    $scope.addedItemDoctor = {};
    $scope.changeId = null;
  }

  $scope.deletePhysician = function () {
    $http.get('../doctor/deletePhysicians.do?ids=' + $scope.selectIds).success(
      function (response) {
        if (response.success) {
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
