angular.module('app', []).controller('indexCntroller'), function ($scope, $http) {
    const contextPath = 'http://http://localhost:8080/product';


    $scope.loadStudents = function () {
        $http.get(contextPath)
            .then(function (response) {
                $scope.ProductList = response.data;
            });
    };

    $scope.loadStudents();
}