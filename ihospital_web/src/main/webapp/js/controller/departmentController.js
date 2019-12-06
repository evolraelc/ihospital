var app = angular.module('ihospital', ['pagination']);


app.service('loginService', function ($http) {

  this.loginName = function () {

    return $http.get('../login/name.do');

  }

});


app.controller('departmentController', function ($scope, $http,loginService) {


  // name 查询 分页展示

  // refresh

  // delete

  // previous & next

  // details

  // show ? entries

  // 上传 信息

  // save info

  //获取登录名
  $scope.showLoginName = function () {
    loginService.loginName().success(
      function (response) {
        $scope.loginName = response.loginName;
      }
    )
  };

  //查询病人列表
  $scope.findAll = function () {
    $http.get('../patient/findAll.do').success(
      function (response) {
        $scope.list = response;
      }
    )
  }

  $scope.searchEntity = {};

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

  //刷新列表
  $scope.reloadList = function () {
    $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    // $scope.findPage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
  };

  //条件查询
  $scope.search = function (page, size) {

    $http.post('../department/searchDepartment.do?page=' + page + '&size=' + size, $scope.searchEntity).success(
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


  $scope.searchDepartment = function () {
    var key = $scope.searchKey;
    var item = {};

    if (key instanceof String) {

      item.departName = key;
    } else if (key instanceof Number) {

      item.departId = key;
    }
    var request = '../department/searchDepartment.do?page=' + $scope.paginationConf.currentPage.toString()
      + '&size=' + $scope.paginationConf.itemsPerPage.toString();

    $http.post(request, item).success(
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
  }

  //查询分页后的病人列表
  $scope.findPage = function (page, size) {

    $http.get('../department/findPage.do?page=' + page + '&size=' + size).success(
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
      add department
      1.这里 url 没有包括进来
      2.字段不完全，视图和DB不一致性
   */
  $scope.addDepartment = function () {
    $http.post("../department/addDepartment.do", $scope.addedItemDepartment).success(
      function (data) {

        //局部刷新
        $scope.reloadList();
      }
    ).error( //// ajax 异常 必须在非web层解决
      function (data) {

      }
    )
  };

  //转换病人禁言状态
  $scope.reversePatient = function (id) {
    $http.get('../patient/reversePatient.do?id=' + id).success(
      function (response) {
        if (response.success) {
          //局部刷新
          $scope.reloadList();
        } else {
          //弹出错误，样式我还不知道怎么改
          alert(response.message);
        }
      }
    )

  };

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

  $scope.deleteDepartment = function () {
    $http.get('../department/deleteDepartments.do?ids=' + $scope.selectIds).success(
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


  $scope.refreshTable = function () {
    // $('#dataList').fadeOut();
    $scope.reloadList();
    // $('#dataList').fadeOut();
  }


  // $("[name='theName']");
  $scope.jumpToDepartDetail = function ($event, id) {

    $scope.detailDepartId = id;
    // location.href="all-administrator-departmentinfo.html";
  }

  $scope.reloadList();

});
