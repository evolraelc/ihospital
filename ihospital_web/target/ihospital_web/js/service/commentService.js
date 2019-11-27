app.service("commentService",function ($http){
    this.findAll = function() {
        return $http.get('../comment/findAll.do');
    };
    this.findPage = function (pageNum, pageSize) {
        return $http.get('../comment/findPage.do?pageNum='+pageNum+'&pageSize='+pageSize);
    };
    this.deleteComment = function (selectIds) {
        return $http.get('../comment/deleteComment.do?ids='+selectIds);
    };
    this.search = function (pageNum, pageSize, searchEntity) {
        return $http.post('../comment/searchComment.do?pageNum='+pageNum+'&pageSize='+pageSize, searchEntity);
    };
    this.getComment = function (id) {
        return $http.get('../comment/getComment.do?id='+id);
    };
});