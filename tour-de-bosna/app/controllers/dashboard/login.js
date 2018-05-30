import Controller from '@ember/controller';

export default Controller.extend({
  authentication: Ember.inject.service(),
  router: Ember.inject.service(),
  host:Ember.inject.service(),
  welcome:  Ember.inject.controller(),

  userRole: function() {
    return this.get('welcome.userRole');
  }.property('welcome.userRole'),

  actions: {
    login: function() {
      var self = this;

      var data = {
          username: self.get('username'),
          password: self.get('password')
      };
      if (this.get('userRole') === 'ROLE_USER') {
        this.get("authentication").loginUser(data).then(x => {
          self.get('router').transitionTo('dashboard.offers');
          //self.get('authentication').set('username',self.get('host').getTourHostByUsername(data.username).id);
          console.log(self.get('authentication').get('username'));
          self.get('authentication').set('role','user');
          self.set("serverSuccess", true);
          self.set("serverError", false);
          self.set("serverErrorText", "");

          }).catch(err => {
            self.set("serverSuccess", false);
            self.set("serverError", true);
            self.set("serverErrorText", err.responseText);
        });
      } else {
        this.get("authentication").loginTourHost(data).then(x => {


          self.get('host').getTourHostByUsername(data.username);
          self.get('authentication').set('role','host');
          self.set("serverSuccess", true);
          self.set("serverError", false);
          self.set("serverErrorText", "");


          }).catch(err => {
            self.set("serverSuccess", false);
            self.set("serverError", true);
            self.set("serverErrorText", err.responseText);
        });
      }
    },
    register:function(){
        if (this.get('userRole') === 'ROLE_USER'){
      this.get('router').transitionTo('dashboard.register-user');
    }
    else{
      this.get('router').transitionTo('dashboard.register-host');
    }
    }
  }
});
