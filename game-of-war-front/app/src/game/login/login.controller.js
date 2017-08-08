(function(){
    'use strict';

    angular.module('game')
        .controller('loginCTRL', LoginCTRL);

    LoginCTRL.$inject = ['$q','LoginSERV'];
    function LoginCTRL($q, LoginSERV) {
        var ctrl = this;

        //TODO - this is probably a little sloppy
        var promise = log();
        promise.then(function(result){
            ctrl.loginInfo = result;
                console.log(ctrl.loginInfo);
        })

        function log() {
            var deferred = $q.defer();
            deferred.resolve(LoginSERV.login(123,123));

            return deferred.promise;
        }
    }
})();