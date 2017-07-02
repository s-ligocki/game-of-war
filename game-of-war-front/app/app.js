(function () {

'use strict';
// Declare app level module which depends on views, and components
var myapp = angular.module('myApp', [])

myapp.controller('Hello', function($scope, $http) {
    $http.get('http://localhost:8080/get-new-board').
    then(function(response) {
        $scope.board = response.data;
    });
});

myapp.controller('test', function($scope) {
    $scope.variable = "a string for testing";
});
})();
