(function () {
    'use strict';

    angular.module('game')
        .service('waitSERV', WaitSERV);

    WaitSERV.$inject = ['$http', 'GameUser', 'ApiPath', '$state']
    function WaitSERV($http, GameUser, ApiPath, $state) {
        var serv = this;
        var gameState;

        serv.getGameState = function() {
            gameState = getRestGameState(GameUser.userID);
            return gameState;
        };

        function getRestGameState(userId) {
            return $http
                .get(
                    ApiPath + '/get-game-state/' + userId
                ).then(
                    function(response) {
                        if(response.data.gameState == 'YOUR_TURN') {
                            $state.go('game.play');
                        }
                        console.log('waitSERV response:', response.data);
                        console.log('waitSERV GameUser:', GameUser);
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