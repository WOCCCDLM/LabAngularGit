var app = angular.module("app",[]);

app.controller("blogCtrl", function($scope,$log,$http) {
    $scope.entry = {title : "Title",
                    content : "Content"};
    $scope.entries = [];
    $log.debug('se creo el $scope');

   


 $scope.loadData = function() {
        $http({
            method: "GET",
            url: "http://localhost:8080/blogs"
          }).success(function(data) {
            $scope.entries = data;
        }).error(function(data,status,headers,config) {
            alert("Ha fallado la petición. Estado HTTP:"+status);
        });
    };


 $scope.processForm = function() {
        $log.debug($scope.entry);
        $http({
            method  : 'POST',
            url     : 'http://localhost:8080/blog',
            data    : $scope.entry,
        }).success(function(data) {
            console.log(data);
            $scope.loadData();
        });
    };

 $scope.eliminar = function(obj) {
	alert(obj);
        $log.debug($scope.entries[obj]);   
        $http({
            method  : 'DELETE',
            url     : 'http://localhost:8080/blog',
            data    : obj,
	headers: {"Content-Type": "application/json;charset=utf-8"}
        }).success(function() { 
            $scope.loadData(); 
		
        });
    };

 $scope.editar = function(obj) {
	alert(obj);
        $log.debug($scope.entries[obj]);   
        $http({
            method  : 'PUT',
            url     : 'http://localhost:8080/blogs',
            data    : obj,
        }).success(function() { 
            $scope.loadData(); 
		
        });
    };

});
