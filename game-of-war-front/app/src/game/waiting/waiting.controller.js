/**
 * Created by jakub on 18.08.2017.
 */
(function () {
    'use strict';

    angular.module('game')
        .controller('waitCTRL', WaitCTRL);

    WaitCTRL.$inject = ['GameUser', 'ifGameReadyGoToIt'];
    function WaitCTRL(GameUser, ifGameReadyGoToIt) {
        var ctrl = this;
        ctrl.gameUser = GameUser;
        ctrl.state = ifGameReadyGoToIt;


    }
})();