import Controller from '@ember/controller';

export default Controller.extend({
  router: Ember.inject.service(),

  actions: {
    redirectTo: function(userRole) {
      if (userRole === 'ROLE_USER') {
        this.get('router').transitionTo('dashboard.register-user');
      } else {
        this.get('router').transitionTo('dashboard.register-host');
      }
    }
  }
});
