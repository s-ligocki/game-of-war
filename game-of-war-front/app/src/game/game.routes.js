( function () {
    'use strict';

    angular.module('game')
        .config(routeConfig);

    routeConfig.$inject = ['$stateProvider'];
    function routeConfig($stateProvider) {

        $stateProvider
            .state('game', {
                abstract: true,
                templateUrl: 'src/game/game.html'
            }).state('game.login', {
                url: '/',
                templateUrl: 'src/game/login/login.html'
            })
    }
})();