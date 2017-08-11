( function () {
    'use strict';

    angular.module('game', ['ui.router'])
        .constant('ApiPath', 'http://localhost:8080')
        .value('GameUser', {
            userID : ""
        });
})();