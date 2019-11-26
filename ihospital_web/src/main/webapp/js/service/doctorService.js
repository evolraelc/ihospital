app.service("doctorService",function ($http) {


  this.findOne=function (id) {
    return $http.get('../doctor/findOne.do?id='+id);
  }
  this.addPatient=function (entity) {
    return $http.post('../patient/addPatient.do',entity);

  }
  this.deletePatient=function (ids) {
    return $http.get('../patient/deletePatient.do?ids='+ids)


  }
  this.search=function (page,size,searchEntity) {
    return $http.post('../patient/searchPatient.do?page=' + page + '&size=' + size,searchEntity)

  }


});