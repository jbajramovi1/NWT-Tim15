import Controller from '@ember/controller';

export default Controller.extend({
  host: Ember.inject.service(),
  router: Ember.inject.service(),

  actions: {
    register: function() {
      var self = this;
      var data = {
          nameTourHost: self.get('name'),
          emailTourHost: self.get('email'),
          usernameTourHost: self.get('username'),
          passwordTourHost: self.get('password'),
          role: "ROLE_TOURHOST"
      };
      this.get("host").registerTourHost(data).then(x => {
            self.get('router').transitionTo('dashboard.login');
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
