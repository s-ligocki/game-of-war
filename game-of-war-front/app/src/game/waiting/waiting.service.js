/**
 * Created by jakub on 18.08.2017.
 */
(function () {
    'use strict';

    angular.module('game')
        .service('waitSERV', WaitSERV);

    WaitSERV.$inject = ['$http', 'GameUser', 'ApiPath', '$state']
    function WaitSERV($http, GameUser, ApiPath, $state) {
        var serv = this;
        var gameState;

        serv.getGameState = function() {
            gameState = checkGameState(GameUser.userID);
            return gameState;
        };

        function checkGameState(userId) {

            console.log(ApiPath + '/get-game-state/' + userId);
            return $http
                .get(
                    ApiPath + '/get-game-state/' + userId
                ).then(
                    function(response) {
                        if(response.data.gameState == 'YOUR_TURN') {
                            $state.go('game.play');
                        }
                        console.log(response.data);
                        return response.data;
                    }
                ).catch(
                    function(error){
                        return "ERROR during getting state: " + error;
                    }
                );
        }
    }
})();