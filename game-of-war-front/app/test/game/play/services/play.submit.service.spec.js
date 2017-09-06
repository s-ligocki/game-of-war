describe("Submit Service", function () {
    var submitMoveService;
    var $httpBackend;
    var ApiPath;
    var board ={board: '??'}

    beforeEach(function () {
        angular.mock.module('gameOfWar');

        //https://stackoverflow.com/questions/25295445/angularjs-change-constant-value-that-gets-passed-to-config-for-unit-test
        angular.mock.module('game', function ($provide) {
            $provide.value("GameUser", {userID: '12'});
        });

        angular.mock.inject(function ($injector) {
            submitMoveService = $injector.get('submitMoveSERV');
            $httpBackend = $injector.get('$httpBackend');
            ApiPath = $injector.get('ApiPath');
        });
    });

    it('play.submit.service is defined', function () {
        expect(submitMoveService).toBeDefined();
    });

    it('submitMove method is defined', function () {
        expect(submitMoveService.submitMove).toBeDefined();
    });

    xit('Play http service returns data', function() {
        $httpBackend.whenGET(ApiPath + '/play/12').respond('USER_ID_12');
        submitMoveService.submitMove(board).then(function(response) {
            expect(response).toEqual('USER_ID_12');
        });
        //$httpBackend.flush();
    });
});