angular.module('app.controllers', []).controller('SuperheroListController', function($scope, $state, popupService, $window, Superhero) {
  $scope.superheroes = Superhero.query(); //fetch all superheroes. Issues a GET to /api/vi/superheroes

  $scope.deleteSuperhero = function(superhero) { // Delete a Superhero. Issues a DELETE to /api/v1/superheroes/:id
    if (popupService.showPopup('Really delete this?')) {
      shipwreck.$delete(function() {
        $scope.superheroes = Superhero.query();
        $state.go('Superheroes');
      });
    }
  };
}).controller('SuperheroViewController', function($scope, $stateParams, Superhero) {
  $scope.superhero = Superhero.get({ id: $stateParams.id }); //Get a single superhero.Issues a GET to /api/v1/superheroes/:id
}).controller('SuperheroCreateController', function($scope, $state, $stateParams, Superhero) {
  $scope.superhero = new Superhero();  //create new superhero instance. Properties will be set via ng-model on UI

  $scope.addSuperhero = function() { //create a new superhero. Issues a POST to /api/v1/superheroes
    $scope.superhero.$save(function() {
      $state.go('superheroes'); // on success go back to the list i.e. superheroes state.
    });
  };
}).controller('SuperheroEditController', function($scope, $state, $stateParams, Superhero) {
  $scope.updateSuperhero = function() { //Update the edited superhero. Issues a PUT to /api/v1/superheroes/:id
    $scope.superhero.$update(function() {
      $state.go('superheroes'); // on success go back to the list i.e. superheroes state.
    });
  };

  $scope.loadSuperhero = function() { //Issues a GET request to /api/v1/superheroes/:id to get a superhero to update
    $scope.superhero = Superhero.get({ id: $stateParams.id });
  };

  $scope.loadSuperhero(); // Load a shipwreck which can be edited on UI
});
