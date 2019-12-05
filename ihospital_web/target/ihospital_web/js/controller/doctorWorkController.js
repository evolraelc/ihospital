app.controller('doctorWorkController', function ($scope, $http, doctorService, uploadService, $interval, loginService, $filter) {
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
        $scope.getPatients($scope.nowDate, $scope.doctorEntity.departId);
      }
    )
  };
//初始化
  $scope.initBody = function () {

    $scope.getLoginId();
    $scope.Datetime = new Date();
    $scope.entity = {pathography: {}, drugList: []};
    $scope.appointEntity={};
    $scope.nowDate = $filter('date')($scope.Datetime, "yyyy-MM-dd");//获取当前日期
    $scope.findConfigOfDrug();
    $scope.findConfigOfDepartment();
  };


  //获取等待的病人列表
  $scope.getPatients = function (date, deptId) {
    doctorService.getPatients(date, deptId).success(
      function (response) {
        $scope.list = response;
      }
    )
  };

  //下一位

  $scope.isInit = 1;//默认是初始阶段
  $scope.isSubmited = 0;//默认当前表单没有提交
  $scope.isAppointed = 0;//默认初始没有转诊


  $scope.getNextPatient = function (date, deptId) {
    if ($scope.isInit == 1||($scope.isSubmited == 1 && $scope.isAppointed==1)) {

      doctorService.getNextPatient(date, deptId).success(
        function (response) {
          $scope.isInit = 0;
          $scope.totalPrice = 0;
          $scope.isSubmited=0;
          $scope.isAppointed=0;
          $scope.entity = {pathography: {}, drugList: []};
          $scope.appointEntity={};



          //$scope.getPatients($scope.nowDate,$scope.doctorEntity.departId);

          $scope.currentpatient = response;
          $scope.picture=$scope.currentpatient.patient.userAvatar;
          $scope.entity.pathography.patientId = $scope.currentpatient.patient.patientId;
          $scope.entity.pathography.appointId = $scope.currentpatient.appointment.appointmentId;
          $scope.entity.pathography.physicianId = $scope.doctorEntity.physicianId;
          $scope.appointEntity.patientId = $scope.currentpatient.patient.patientId;

        }
      )
    } else if ($scope.isSubmited == 0){
      alert("Please submit first!");
    } else if ($scope.isAppointed==0){
      alert("Please appoint first!");
    }

  };

  $interval(function () {
    /*$scope.entity.time = $filter('date')(new Date(), "yyyy-MM-dd HH:mm:ss");*/
    $scope.entity.pathography.time = new Date();
    $scope.appointEntity.appointTime = $scope.entity.pathography.time;
    $scope.nowTime = $filter('date')($scope.entity.pathography.time, "yyyy-MM-dd HH:mm:ss");
  }, 1000);


  //轮询
  var stop;
  $scope.$on(
    '$ionicView.beforeLeave', function () {
      $interval.cancel(stop);//离开后停止轮询
    }
  )
  stop = $interval(function () {
    $scope.getPatients($scope.nowDate, $scope.doctorEntity.departId);
    //$scope.setPrice($scope.pojo.medicineId);
    $scope.getDrug();


  }, 100000);

  $scope.getDrug = function () {

    $scope.entity.drugList.forEach(
      function (e) {
        doctorService.getPrice(e.medicineId).success(
          function (response) {
            e.price = response * e.num;

          }
        )
      }
    );

  };

  $scope.getTotalPrice = function () {

    $scope.totalPrice = 0;

    $scope.entity.drugList.forEach(
      function (e) {

        if (e.price != null) {
          $scope.totalPrice += e.price;
        }

      }
    );
  };


  // $scope.setPrice = function (id) {
  //   doctorService.getPrice(id).success(
  //     function (response) {
  //
  //
  //       $scope.pojo.medicinePrice=response;
  //       $scope.totalPrice+=$scope.pojo.price;
  //     }
  //   )
  // };

  //药的下拉框
  $scope.medicineList = {data: []};
  $scope.findConfigOfDrug = function () {
    doctorService.findConfigOfDrug().success(
      function (response) {
        $scope.medicineList = {data: response};

      }
    )

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
  //添加处方行
  $scope.addDrugRow = function () {
    $scope.entity.drugList.push({});
  };
  //删除处方行

  $scope.deleteDrugRow = function (index) {
    $scope.entity.drugList.splice(index, 1);
  };
  //保存处方
  $scope.save = function () {
    doctorService.addTreatment($scope.entity).success(
      function (response) {
        if (response.success) {
          //局部刷新
          alert("submit success");
          $scope.isSubmited = 1;
          //$scope.reloadList();
        } else {
          //弹出错误，样式我还不知道怎么改
          alert(response.message);
        }
      }
    )
  };
  //转诊挂号
  $scope.appoint = function () {
    if ($scope.isSubmited==1){
      doctorService.addAppointment($scope.appointEntity).success(
        function (response) {
          if (response.success){
            alert("appoint success");
            alert(response.message);
            $scope.justNext();
            // $scope.isAppointed=1;
            // $scope.getNextPatient($scope.nowDate,$scope.doctorEntity.departId);
          } else {
            alert(response.message);
          }
        }
      )

    } else{
      alert("Please submit first!");
    }

  };
  $scope.justNext = function () {
    $scope.isAppointed=1;
    $scope.getNextPatient($scope.nowDate,$scope.doctorEntity.departId);

  };


  //控制药的价格输入
  $scope.checkNum = function (event, value) {
    var keyCode = event.keyCode;
    if (value < 1) {
      if (keyCode < 49 || keyCode > 57) {
        alert('只能输入正整数');
        event.returnValue = false;
        return false;
      }
    } else {
      if (keyCode < 48 || keyCode > 57) {
        alert('只能输入正整数');
        event.returnValue = false;
        return false;
      }
    }
  };


});