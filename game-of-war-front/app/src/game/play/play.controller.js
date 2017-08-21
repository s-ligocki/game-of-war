(function () {
    'use strict';

    angular.module('game')
        .controller('playCTRL', PlayCTRL);

    PlayCTRL.$inject = ['resetSERV', 'submitMoveSERV', 'boardSERV'];
    function PlayCTRL(resetSERV, submitMoveSERV, boardSERV) {
        var ctrl = this;
        var board;

        ctrl.resetGame = function () {
            resetSERV.reset();
        };

        ctrl.submitTurn = function () {
            submitMoveSERV.submitMove(board);
        };
        
        ctrl.getBoard = function () {
            board = boardSERV.getBoard();
        };
    }
})();