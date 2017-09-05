(function () {
    'use strict';

    angular.module('game')
        .service('boardSERV', BoardSERV);

    BoardSERV.$inject = ['$http', 'GameUser', 'ApiPath'];
    function BoardSERV($http, GameUser, ApiPath) {
        var serv = this;
        var board;

        serv.getBoard = function () {
            board = getRestBoard(GameUser);
            return board;
        }

        function getRestBoard(gameUser) {
            return $http
                .get(
                    ApiPath + '/get-board/' + gameUser.userID
                ).then(
                    function(response) {
                        console.log('boardSERV response: ',response.data);
                        console.log('boardSERV GameUser:', GameUser);
                        return response.data;
                    }
                ).catch(
                    function(error){
                        return "ERROR during getting board: " + error;
                    }
                );
        }
    }
})();