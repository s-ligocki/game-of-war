( function () {
    'use strict';

    angular.module('game')
        .config(routeConfig);

    routeConfig.$inject = ['$stateProvider'];
    function routeConfig($stateProvider) {

        $stateProvider
            .state('game', {
                abstract: true,
                templateUrl: ''
            }).state('game.login', {
                //TODO
            })
    }
})();