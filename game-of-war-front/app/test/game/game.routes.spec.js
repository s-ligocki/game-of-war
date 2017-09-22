describe("Game ui-router", function () {

    xit('should go to the state', function () {
        module('gameOfWar');
        inject(function ($rootScope, $state, $templateCache) {
            // When you transition to the state with $state, UI-ROUTER
            // will look for the 'templateUrl' mentioned in the state's
            // configuration, so supply those templateUrls with templateCache
            //$templateCache.put('app/templates/someTemplate.html');
            // Now GO to the state.
            $state.go('game.login');
            // Run a digest cycle to update the $state object
            // you can also run it with $state.$digest();
            $state.$digest();

            // TEST EXPECTATION
            expect($state.current.name)
                .toBe('someState');
        });
    });
    /* var $rootScope;
    var $state;

    beforeEach(function() {
        angular.mock.module('gameOfWar');
        angular.mock.module('ui-router');
        angular.mock.inject(function(_$rootScope_, _$state_) {
            $rootScope = _$rootScope_;
            $state = _$state_;
        });
    });

    xit('should transition to game.login', function(){
        console.log($state.current.name);

        $state.transitionTo('game.login');
        $rootScope.$apply();
        expect($state.current.name).toBe('game.login');
        console.log($state.current.name);
    });*/
});