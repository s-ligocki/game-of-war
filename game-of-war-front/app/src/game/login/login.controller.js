(function(){
    'use strict';

    angular.module('game')
        .controller('loginCTRL', LoginCTRL);

    LoginCTRL.$inject = ['loginSERV'];
    function LoginCTRL(loginSERV) {
        var ctrl = this;
        ctrl.info = false;
        ctrl.inputUserId ="";

        ctrl.login = function() {
            ctrl.info = false;
            var promise = loginSERV.login(ctrl.inputUserId);

            ctrl.info = true;
        }

    }
})();