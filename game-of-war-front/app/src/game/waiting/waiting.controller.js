/**
 * Created by jakub on 18.08.2017.
 */
(function () {
    'use strict';

    angular.module('game')
        .controller('waitCTRL', WaitCTRL);

    WaitCTRL.$inject = ['GameUser'];
    function WaitCTRL(GameUser) {
        var ctrl = this;
        ctrl.gameUser = GameUser;
    }
})();