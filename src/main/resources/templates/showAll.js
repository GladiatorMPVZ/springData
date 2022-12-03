angular.module('app', []).controller('indexCntroller'), function ($scope, $http) {
    const contextPath = 'http://http://localhost:8180/app';


    $scope.loadStudents = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductList = response.data;
            });
    };

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                $scope.loadStudents();
            });
    }

    $scope.loadStudents();
}