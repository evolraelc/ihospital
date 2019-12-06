app.service('medicineService',function ($http) {
    this.findAll=function () {
        return $http.get('../medicine/findAll.do')
    }

    this.findPage=function(page, size){
        return $http.get('../medicine/findPage.do?page='+page+'&size='+size)

    }

    this.findOne=function (medicineId) {


        return  $http.get('../medicine/findOne.do?medicineId='+medicineId)
    }

    this.add=function (entity) {
        return  $http.post('../medicine/addMedicine.do',entity)
    }

    this.update=function (entity) {
        return  $http.post('../medicine/updateMedicine.do',entity)
    }

    this.delete=function (selectIds) {
        return  $http.get('../medicine/deleteMedicine.do?ids='+selectIds)
    }

    this.search=function(page,size,searchEntity){
        return $http.post('../medicine/searchMedicine.do?page='+page+'&size='+size,searchEntity)
    }

})