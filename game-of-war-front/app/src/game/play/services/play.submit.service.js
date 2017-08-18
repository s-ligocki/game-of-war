/**
 * Created by jakub on 18.08.2017.
 */
(function () {
    'use strict';

    angular.module('game')
        .service('submitMoveSERV', SubmitMoveSERV);

    SubmitMoveSERV.$inject = ['$http', 'ApiPath'];
    function SubmitMoveSERV($http, ApiPath) {
        var serv = this;

        serv.submitMove = function (gameUser, board) {
            return $http
                .post(
                    ApiPath + '/play/' + gameUser.userID
                ).then(
                    function(response) {
                        console.log('response: ',response.data);
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