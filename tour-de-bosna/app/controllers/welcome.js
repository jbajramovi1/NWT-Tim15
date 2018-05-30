import Controller from '@ember/controller';

export default Controller.extend({
  router: Ember.inject.service(),

  actions: {
    redirectTo: function(userRole) {
      this.set('userRole', userRole);
      this.get('router').transitionTo('dashboard.login');

    }
  }
});
