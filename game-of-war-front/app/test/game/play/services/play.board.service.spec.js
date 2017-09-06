describe("Get Board Service", function () {
    var getBoardService;
    var $httpBackend;
    var ApiPath;

    beforeEach(function () {
        angular.mock.module('gameOfWar');

        //https://stackoverflow.com/questions/25295445/angularjs-change-constant-value-that-gets-passed-to-config-for-unit-test
        angular.mock.module('game', function ($provide) {
            $provide.value("GameUser", {userID: '12'});
        });

        angular.mock.inject(function ($injector) {
            getBoardService = $injector.get('boardSERV');
            $httpBackend = $injector.get('$httpBackend');
            ApiPath = $injector.get('ApiPath');
        });
    });

    it('play.board.service is defined', function () {
        expect(getBoardService).toBeDefined();
    });

    it('getBoard method is defined', function () {
        expect(getBoardService.getBoard).toBeDefined();
    });

    it('GetBoard http service returns data', function() {
        $httpBackend.whenGET(ApiPath + '/get-board/12').respond('USER_ID_12');
        getBoardService.getBoard().then(function(response) {
            expect(response).toEqual('USER_ID_12');
        });
        //$httpBackend.flush();
    });
});