import Controller from '@ember/controller';

export default Controller.extend({
  router: Ember.inject.service(),
  authentication: Ember.inject.service(),
  role: function() {
    return this.get('model.role');
  }.property('model.role'),
  isNotLoggedIn: function() {
    return this.get('model.isNotLoggedIn');
  }.property('model.isNotLoggedIn'),
  roleIsHost: function() {
  return this.get('model.role') === 'ROLE_TOURHOST';
}.property('model.role'),
actions:{
  logout:function(){
    this.set('model.isNotLoggedIn',false);
    this.get('authentication').set('username',null);
    this.get('authentication').set('role',null);
    this.get('router').transitionTo("welcome");

  }
}
});
