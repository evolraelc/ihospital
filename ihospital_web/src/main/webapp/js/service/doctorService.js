app.service("doctorService",function ($http) {


    this.findOne=function (id) {
        return $http.get('../doctor/findOne.do?id='+id);
    };
});