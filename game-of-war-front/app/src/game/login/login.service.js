(function () {
    'use strict';

    angular.module('game')
        .service("loginSERV", LoginSERV);

    LoginSERV.$inject = ['$http', 'GameUser', 'ApiPath', '$state'];
    function LoginSERV($http, GameUser, ApiPath, $state) {
        var serv = this;
        var userData;

        serv.login = function(userId) {
            userData = checkLoginData(userId);
            return userData;
        };

        function checkLoginData(userId) {
            return $http
                .get(
                    ApiPath + '/login/' + userId
                ).then(
                    function(response) {
                        //TODO - na razie logowanie zawsze się udaje
                        GameUser.userID = response.data.userID;
                        console.log(GameUser.userID);
                        $state.go('game.waiting');
                        return response.data;
                    }
                ).catch(
                    function(error){
                        return "ERROR during login: " + error;
                    }
                );
        }
    }
})();