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
                templateUrl: 'src/game/login/login.html',
                controller: 'loginCTRL',
                controllerAs: 'ctrl'
            }).state('game.waiting', {
            url: '/wait',
            templateUrl: 'src/game/waiting/waiting.html'
            }).state('game.play', {
            url: '/play', //TODO - probably add some gameID here
            templateUrl: 'src/game/play/play.html'
            })
    }
})();