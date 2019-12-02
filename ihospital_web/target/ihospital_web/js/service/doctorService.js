app.service("doctorService",function ($http) {


  this.findOne=function (id) {
    return $http.get('../doctor/findOne.do?id='+id);
  };
  this.getPatients=function (date,deptId) {
    return $http.get('../treat/getPatients.do?date='+date+'&deptId='+deptId);

  };
  this.getNextPatient=function (date,deptId) {
    return $http.get('../treat/getNextPatient.do?date='+date+'&deptId='+deptId);

  };
  this.findConfigOfDrug=function () {
    return $http.get('../treat/findConfigOfDrug.do');
    
  };

  this.getPrice=function (id) {
    return $http.get('../treat/getPrice.do?id='+id);

  };
  this.addTreatment=function (entity) {
    return $http.post('../treat/addTreatment.do',entity);

  };
  this.addAppointment=function (entity) {
    return $http.post('../treat/addAppointment.do',entity);

  };



});