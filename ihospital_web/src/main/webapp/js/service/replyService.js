app.service('replyService', function ($http) {
    this.getReplyList = function (id) {
        return $http.get('../reply/findAll.do?consultId='+id);
    };
    this.addReply = function (reply) {
        return $http.post('../reply/addReply.do', reply);
    };
});