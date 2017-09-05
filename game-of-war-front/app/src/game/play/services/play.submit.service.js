(function () {
    'use strict';

    angular.module('game')
        .service('submitMoveSERV', SubmitMoveSERV);

    SubmitMoveSERV.$inject = ['$http', 'GameUser', 'ApiPath'];
    function SubmitMoveSERV($http, GameUser, ApiPath) {
        var serv = this;

        serv.submitMove = function (board) {
            submitRestMove(board, GameUser);
        }

        function  submitRestMove(board, gameUser) {
            return $http
                .post(
                    ApiPath + '/play/' + gameUser.userID
                ).then(
                    function(response) {
                        //TODO - board needed
                        console.log('submitMoveSERV response: ',response.data);
                        console.log('submitMoveSERV GameUser:', gameUser);
                        return response.data;
                    }
                ).catch(
                    function(error){
                        return "ERROR during submit: " + error;
                    }
                );
        }
    }
})();