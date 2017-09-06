describe("Reset Service", function () {
    var resetService;
    var $httpBackend;
    var ApiPath;

    beforeEach(function () {
        angular.mock.module('gameOfWar');

        //https://stackoverflow.com/questions/25295445/angularjs-change-constant-value-that-gets-passed-to-config-for-unit-test
        angular.mock.module('game', function ($provide) {
            $provide.value("GameUser", {userID: '12'});
        });

        angular.mock.inject(function ($injector) {
            resetService = $injector.get('resetSERV');
            $httpBackend = $injector.get('$httpBackend');
            ApiPath = $injector.get('ApiPath');
        });
    });

    it('play.reset.board.service is defined', function () {
        expect(resetService).toBeDefined();
    });

    it('reset method is defined', function () {
        expect(resetService.reset).toBeDefined();
    });

    it('Reset http service returns data', function() {
        $httpBackend.whenGET(ApiPath + '/reset/12').respond('USER_ID_12');
        resetService.reset().then(function(response) {
            expect(response).toEqual('USER_ID_12');
        });
        //$httpBackend.flush();
    });
});