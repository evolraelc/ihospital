app.controller('patientController', function ($scope, $http , $controller,patientService,uploadService,$interval) {


  $controller('baseController',{$scope:$scope});


  //查询病人列表
  $scope.findAll = function () {
    patientService.findAll.success(
      function (response) {
        $scope.list = response;
      }
    )


  }


  //查询分页后的病人列表
  $scope.findPage = function (page, size) {
    patientService.findPage(page,size).success(
      function (response) {
        //显示当前页的数据
        $scope.list=response.rows;
        //更新分页控件配置
        $scope.paginationConf.totalItems =response.total;

      }
    );
  }


  //新增病人，不上传图片用post请求
  $scope.addPatient = function () {

    if (!$scope.entity.userAvatar==""){
      patientService.addPatient($scope.entity).success(
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
    } else {
      alert("Need a Picture");
    }



  };

  //转换病人禁言状态
  $scope.reversePatient = function (id) {
    patientService.reversePatient(id).success(
      function (response) {
        if (response.success){
          //局部刷新
          $scope.reloadList();
        } else {
          //弹出错误，样式我还不知道怎么改
          alert(response.message);
        }
      }
    )

  };



  $scope.deletePatient = function () {
    patientService.deletePatient($scope.selectIds).success(
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


  $scope.searchEntity={};
  //条件查询
  $scope.search = function (page,size) {
    patientService.search(page,size,$scope.searchEntity).success(
      function (response) {
        //显示当前页的数据
        $scope.list=response.rows;
        //更新分页控件配置
        $scope.paginationConf.totalItems =response.total;

      }
    );

  };

  // //性别下拉框
  // $scope.sexList={data:[{id:1,text:"Male"},{id:2,text:"Female"}]};
  //
  //
  // //禁言状态下拉框
  // $scope.statusList={data:[{id:1,text:"Approved"},{id:2,text:"Denied"}]};


  //图片上传
  $scope.uploadFile=function () {
    uploadService.uploadFile().success(
      function (response) {
        if (response.success){
          $scope.entity.userAvatar = response.message;
          var file = document.getElementById('file');
          file.outerHTML = file.outerHTML;
        } else{
          alert(response.message)
          var file = document.getElementById('file');
          file.outerHTML = file.outerHTML;
        }
      }
    );
  }
  //取消
  $scope.resetFile = function () {
    $scope.entity.userAvatar="";
    var file = document.getElementById('file');
    file.outerHTML = file.outerHTML;
  };
  $scope.initForm = function () {

    $scope.entity={};
    $scope.entity.patientName='';
    $scope.entity.patientAge='';
    $scope.entity.patientGenderStr='Male';
    $scope.entity.utype='Approved';
    $scope.patientForm.$setPristine();

  };
  //轮询
  var stop;
  $scope.$on(
    '$ionicView.beforeLeave',function () {
      $interval.cancel(stop);//离开后停止轮询
    }
  )
  stop=$interval(function () {
    $scope.reloadList();

  },6000);






});