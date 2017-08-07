( function () {
    'use strict';

    angular.module('gameOfWar', ['game']);

    angular.module('gameOfWar')
        .config(config);

    config.$inject = ['$urlRouterProvider'];
    function config($urlRouterProvider) {

        // If user goes to a path that doesn't exist, redirect to game root
        $urlRouterProvider.otherwise('/');
    }
})();