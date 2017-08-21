(function () {
    'use strict';

    angular.module('game')
        .service('resetSERV', ResetSERV);

    ResetSERV.$inject = ['$http', 'GameUser', 'ApiPath', '$state'];
    function ResetSERV($http, GameUser, ApiPath, $state) {
        var serv = this;
        var resetStatus;

        serv.reset = function () {
            resetStatus = resetRest(GameUser);
            return resetStatus;
        }

        function resetRest(gameUser){
            return $http
                .get(
                    ApiPath + '/reset/' + gameUser.userID
                ).then(
                    function(response) {
                        console.log('resetSERV response: ',response.data);
                        console.log('resetSERV GameUser:', GameUser);
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