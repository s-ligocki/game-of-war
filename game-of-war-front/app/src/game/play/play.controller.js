/**
 * Created by jakub on 18.08.2017.
 */
(function () {
    'use strict';

    angular.module('game')
        .controller('playCTRL', PlayCTRL);

    PlayCTRL.$inject = ['GameUser', 'resetSERV', 'submitMoveSERV', 'boardSERV'];
    function PlayCTRL(GameUser, resetSERV, submitMoveSERV, boardSERV) {
        var ctrl = this;
        var board;

        ctrl.resetGame = function () {
            resetSERV.reset(GameUser.userID);
        };

        ctrl.submitTurn = function () {
            submitMoveSERV.submitMove(GameUser.userID, GameUser.userID);
        };
        
        ctrl.getBoard = function () {
            boardSERV.getBoard(GameUser.userID);
        };
    }
})();