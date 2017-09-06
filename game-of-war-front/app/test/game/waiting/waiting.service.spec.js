describe("Waiting Service", function () {
    var waitingService;
    var $httpBackend;
    var ApiPath;

    beforeEach(function () {
        angular.mock.module('gameOfWar');

        //https://stackoverflow.com/questions/25295445/angularjs-change-constant-value-that-gets-passed-to-config-for-unit-test
        angular.mock.module('game', function ($provide) {
            $provide.value("GameUser", {userID: '12'});
        });

        angular.mock.inject(function ($injector) {
            waitingService = $injector.get('waitSERV');
            $httpBackend = $injector.get('$httpBackend');
            ApiPath = $injector.get('ApiPath');
        });
    });

    it('waiting.service is defined', function () {
        expect(waitingService).toBeDefined();
    });

    it('getGameState method is defined', function () {
        expect(waitingService.getGameState).toBeDefined();
    });

    it('Waiting http service returns data', function() {
        $httpBackend.whenGET(ApiPath + '/get-game-state/12').respond('USER_ID_12');
        waitingService.getGameState().then(function(response) {
            expect(response).toEqual('USER_ID_12');
        });
        //$httpBackend.flush();
    });
});