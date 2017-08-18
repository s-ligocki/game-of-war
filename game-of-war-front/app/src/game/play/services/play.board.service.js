/**
 * Created by jakub on 18.08.2017.
 */
(function () {
    'use strict';

    angular.module('game')
        .service('boardSERV', BoardSERV);

    BoardSERV.$inject = ['$http', 'ApiPath'];
    function BoardSERV($http, ApiPath) {
        var serv = this;

        serv.getBoard = function (gameUser) {
            return $http
                .get(
                    ApiPath + '/get-board/' + gameUser.userID
                ).then(
                    function(response) {
                        console.log('response: ',response.data);
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