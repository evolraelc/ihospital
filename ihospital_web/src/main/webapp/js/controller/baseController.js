app.controller('baseController', function ($scope,loginService) {

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
    $scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);

  };

  //用户勾选的id集合
  $scope.selectIds=[];

  $scope.updateSelection = function ($event,id) {
    if($event.target.checked){
      $scope.selectIds.push(id);
    }else{
      var index= $scope.selectIds.indexOf(id);
      $scope.selectIds.splice(index,1);
    }



  };


  $scope.jsonToString=function (jsonString,key) {
    var json =JSON.parse(jsonString);
    var value="";


    for (var i=0;i<json.length;i++){
      if (i>0){
        value+=",";
      }

      value+=json[i][key];
    }
    
  }

  //获取登录名
  $scope.showLoginName = function () {
    loginService.loginName().success(
      function (response) {
        $scope.loginName=response.loginName;
      }
    )
  };

});