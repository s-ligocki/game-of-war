/**
 * Created by jakub on 18.08.2017.
 */
(function () {
    'use strict';

    angular.module('game')
        .controller('waitCTRL', WaitCTRL);

    WaitCTRL.$inject = ['ifGameReadyGoToIt'];
    function WaitCTRL(ifGameReadyGoToIt) {
        var ctrl = this;
        ctrl.state = ifGameReadyGoToIt;
    }
})();