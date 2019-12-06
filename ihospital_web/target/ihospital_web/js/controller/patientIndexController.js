app.controller('patientIndexController', function ($scope, $http,$window, doctorService, patientService, uploadService, $interval, loginService, $filter) {
  $scope.getPhone = function () {
    loginService.loginName().success(
      function (response) {
        $scope.getLoginPatient(response.loginName);
      }
    )
  };

  $scope.patientEntity = {};
  $scope.getLoginPatient = function (phone) {
    patientService.getPatient(phone).success(
      function (response) {
        $scope.patientEntity = response;

      }
    )
  };
  //初始化
  $scope.initBody = function () {
    $scope.getPhone();
    $scope.findConfigOfDepartment();
    $scope.appointEntity = {};
  };

//用select2实现科室下拉列表
  $scope.departmentList = {};
  $scope.findConfigOfDepartment = function () {
    $http.get('../medicalRecord/findConfigOfDepartment.do').success(
      function (response) {
        $scope.departmentList = {data: response};
      }
    )
  };

  $scope.typeList = {data: [{id: 1, text: '复诊'}, {id: 2, text: '初诊'}, {id: 3, text: '转诊'}]};

  $interval(function () {

    $scope.appointEntity.appointTime = new Date();

  }, 1000);

  //挂号
  $scope.appoint = function () {
    $scope.appointEntity.patientId = $scope.patientEntity.patientId;
    doctorService.addAppointment($scope.appointEntity).success(
      function (response) {
        if (response.success) {
          alert("appoint success");
          alert(response.message);
          $scope.appointEntity = {};
          // $scope.isAppointed=1;
          // $scope.getNextPatient($scope.nowDate,$scope.doctorEntity.departId);
        } else {
          alert(response.message);
          $scope.appointEntity = {};
        }
      }
    )


  };
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
  };
  //清空图片
  $scope.resetFile = function () {
    var file = document.getElementById('file');
    file.outerHTML = file.outerHTML;
  };
  $scope.initForm = function () {

    $scope.entity={};
    $scope.entity.patientId=$scope.patientEntity.patientId;
    $scope.entity.patientName=$scope.patientEntity.patientName;
    $scope.entity.patientAge=$scope.patientEntity.patientAge;
    $scope.entity.userAvatar=$scope.patientEntity.userAvatar;
    $scope.entity.oldPwd="";
    $scope.entity.newPwd="";
    $scope.patientForm.$setPristine();

  };

  $scope.updatePatient = function () {
    if (!$scope.entity.userAvatar==""){

      patientService.updatePatient($scope.entity).success(
        function (response) {
          if (response.success){
            //局部刷新
            alert("Modify Success!");
            $window.location.href ="../logout";
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

});