/**
 * Created by jakub on 18.08.2017.
 */
(function () {
    'use strict';

    angular.module('game')
        .service('resetSERV', ResetSERV);

    ResetSERV.$inject = ['$http', 'ApiPath', '$state'];
    function ResetSERV($http, ApiPath, $state) {
        var serv = this;

        serv.reset = function (gameUser) {
            return $http
                .get(
                    ApiPath + '/reset/' + gameUser.userID
                ).then(
                    function(response) {
                        console.log('response: ',response.data);
                        $state.go('game.waiting');
                    }
                ).catch(
                    function(error){
                        return "ERROR during reset: " + error;
                    }
                );
        }
    }
})();