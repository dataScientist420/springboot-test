angular.module('app.services', []).factory('Superhero', function($resource) {
  return $resource('/api/v1/superheroes/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
