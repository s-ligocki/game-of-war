'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'myApp.view1',
  'myApp.view2',
  'myApp.version'
])
    .controller('Hello', function($scope, $http) {
        $http.get('http://localhost:8080/get-new-board').
        then(function(response) {
            $scope.board = response.data;
        });
    });