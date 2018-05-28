import Controller from '@ember/controller';

export default Controller.extend({
  user: Ember.inject.service(),
  router: Ember.inject.service(),

  actions: {
    register: function() {
      var self = this;
      var data = {
          firstName: self.get('firstName'),
          lastName: self.get('lastName'),
          email: self.get('email'),
          username: self.get('username'),
          phoneNumber: self.get('phoneNumber'),
          country: self.get('country'),
          passwordHash: self.get('password')
      };
      this.get("user").registerUser(data).then(x => {
        self.get('router').transitionTo('dashboard.offers');
        self.set("serverSuccess", true);
        self.set("serverError", false);
        self.set("serverErrorText", "");

        }).catch(err => {
          self.set("serverSuccess", false);
          self.set("serverError", true);
          self.set("serverErrorText", err.responseText);
      });
    }
  }
});
