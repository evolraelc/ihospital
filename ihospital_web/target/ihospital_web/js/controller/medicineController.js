app.controller('medicineController',function ($scope,$http,medicineService,loginService) {



  //获取登录名
  $scope.showLoginName = function () {
    loginService.loginName().success(
      function (response) {
        $scope.loginName=response.loginName;
      }
    )
  };


    //查询所有药
    $scope.findAll=function () {
       medicineService.findAll().success(
            function (response) {
                $scope.list=response;
            }
        )
    }

    //分页控件初始配置
    $scope.paginationConf = {
        //当前页
        currentPage: 1,
        //总记录数
        totalItems: 10,
        //每页记录数
        itemsPerPage: 10,
        //分页选项
        perPageOptions: [10, 20, 30, 40, 50],
        //页码变更后触发
        onChange: function () {
            $scope.reloadList();
        }
    }


    //刷新列表
    $scope.reloadList = function () {
        $scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
    };

    //查询分页后的药表单
    $scope.findPage = function (page, size) {
        medicineService.findPage(page,size).success(
            function (response) {
                //显示当前页的数据
                $scope.list=response.rows;
                //更新分页控件配置
                $scope.paginationConf.totalItems =response.total;

            }
        );
    }

   // 保存修改或添加
    $scope.save=function(){
        var obj=null;
        if($scope.entity.medicineId!=null){
            obj=medicineService.update($scope.entity);
        }
        else {
            obj=medicineService.add($scope.entity);
        }
        obj.success(
            function (response) {
                if(response.success){
                    $scope.reloadList();
                }else {
                    alert(response.message)
                }
            }
        )
    }


    //通过id查询到药
    $scope.findOne=function (medicineId) {

       medicineService.findOne(medicineId).success(
            function(response){
                $scope.entity=response;
            }
        )
    }

    //用户勾选的ID集合
    $scope.selectIds=[];

    $scope.updateSelection=function ($event,medicineId) {
        if($event.target.checked){
            $scope.selectIds.push(medicineId);
        }else{
            //返回id的位置（从0开始
            var index=$scope.selectIds.indexOf(id);

            //index: 移除的位置，  1：移除的个数
            $scope.selectIds.splice(index,1);
        }
    }

    //删除
    $scope.delete=function () {
        medicineService.delete($scope.selectIds).success(
            function(response){
                if (response.success){
                    $scope.reloadList();
                }else{
                    alert(response.message)
                }
            }
        )

    }

    //条件查询
    $scope.searchEntity={};

    $scope.search=function(page,size){

       medicineService.search(page,size,$scope.searchEntity).success(
            function (response) {
                //显示当前页的数据
                $scope.list=response.rows;
                //更新分页控件配置
                $scope.paginationConf.totalItems =response.total;
            }
        );
    }

  $scope.initForm = function () {

    $scope.entity={};
    $scope.entity.medicineName='';
    $scope.entity.medicinePrice='';

    $scope.drugForm.$setPristine();


  };


})