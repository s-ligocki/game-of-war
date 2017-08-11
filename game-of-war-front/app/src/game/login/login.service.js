(function () {
    'use strict';

    angular.module('game')
        .service("LoginSERV", LoginSERV);

    LoginSERV.$inject = ['$http', 'ApiPath'];
    function LoginSERV($http, ApiPath) {
        var serv = this;
        var userData;

        serv.login = function(userId) {
            userData = checkLoginData(userId);
            return userData;
        };

        function checkLoginData(userId) {
            console.log(ApiPath + '/login/' + userId);
            return $http
                .get(
                    ApiPath + '/login/' + userId
                ).then(
                    function(response) {
                        return response.data;
                    }
                ).catch(
                    function(){
                        return "ERROR during login";
                    }
                );
        }
    }
})();