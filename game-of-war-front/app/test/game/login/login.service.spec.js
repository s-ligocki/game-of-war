describe("Login Service", function () {
    var loginService;
    var $httpBackend;
    var ApiPath;

    beforeEach(function () {
        angular.mock.module('gameOfWar');

        angular.mock.inject(function ($injector) {
            loginService = $injector.get('loginSERV');
            $httpBackend = $injector.get('$httpBackend');
            ApiPath = $injector.get('ApiPath');
        });
    });

    it('Login http service returns data', function() {
        $httpBackend.whenGET(ApiPath + '/login/12').respond('USER_ID_12');
        loginService.login(12).then(function(response) {
            expect(response).toEqual('USER_ID_12');
        });
        $httpBackend.flush();
    });
});