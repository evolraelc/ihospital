app.controller('loginController', function ($scope, $http,$window, patientService, uploadService, $interval, loginService, $filter) {


  $scope.addPatient = function () {

    if (!$scope.entity.userAvatar==""){
      $scope.entity.utype='Approved';
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
    $scope.entity.phoneNumber='';
    $scope.entity.idcard='';
    $scope.entity.pwd='';
    $scope.entity.patientAge='';
    $scope.entity.patientGenderStr='Male';
    $scope.entity.utype='Approved';
    $scope.patientForm.$setPristine();
  };

});