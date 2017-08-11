(function(){
    'use strict';

    angular.module('game')
        .controller('loginCTRL', LoginCTRL);

    LoginCTRL.$inject = ['$q','LoginSERV', 'GameUser'];
    function LoginCTRL($q, LoginSERV, GameUser) {
        var ctrl = this;
        ctrl.info = false;
        ctrl.user = {
            userID: ''
        };
        ctrl.inputUserId ="";

        //TODO - this is probably a little sloppy
        //var promise = log();
        ctrl.login = function() {
            ctrl.info = false;
            var promise = LoginSERV.login(ctrl.inputUserId);

            promise.then(function(result){
                GameUser = result;
                ctrl.user.userID = result.userID;
                console.log(GameUser.userID);
            })
            ctrl.info = true;
        }

    }
})();