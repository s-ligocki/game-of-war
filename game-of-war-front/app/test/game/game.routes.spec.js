describe("Game ui-router", function () {
    var $rootScope;
    var $state;

    beforeEach(function() {
        angular.mock.module('gameOfWar');
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
    });
});