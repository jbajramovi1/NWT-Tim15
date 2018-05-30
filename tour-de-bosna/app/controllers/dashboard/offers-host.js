import Controller from '@ember/controller';

export default Controller.extend({
  offer: Ember.inject.service(),
  router:Ember.inject.service(),
  offers: function() {
    return this.get('model.offers');
  }.property('model.offers'),

  actions:{
    createtour:function(){
      this.get('router').transitionTo('dashboard.add-offer');
    }
  }


});
