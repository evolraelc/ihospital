//病人服务
app.service("patientService",function ($http) {
    this.findAll=function () {
        return $http.get('../patient/findAll.do');
    };
    this.findPage=function (page,size) {
        return $http.get('../patient/findPage.do?page=' + page + '&size=' + size);
    };
    this.reversePatient=function (id) {
        return $http.get('../patient/reversePatient.do?id='+id);
    };
    this.addPatient=function (entity) {
        return $http.post('../patient/addPatient.do',entity);
    };
    this.updatePatient=function (entity) {
        return $http.post('../patient/updatePatient.do',entity);
    };
    this.deletePatient=function (ids) {
        return $http.get('../patient/deletePatient.do?ids='+ids)
    };
    this.search=function (page,size,searchEntity) {
        return $http.post('../patient/searchPatient.do?page=' + page + '&size=' + size,searchEntity)
    };
    this.approve = function (patientId) {
        return $http.get('../patient/changeStatus.do?id='+patientId+'&target=Approved')
    };
    this.deny = function (patientId) {
        return $http.get('../patient/changeStatus.do?id='+patientId+'&target=Denied')
    };
    this.getPatient = function (phone) {
        return $http.get('../patient/getPatient.do?phone='+phone)
    };
    this.findOne = function (patientId) {
        return $http.get('../patient/findOne.do?patientId='+patientId)
    };
});
