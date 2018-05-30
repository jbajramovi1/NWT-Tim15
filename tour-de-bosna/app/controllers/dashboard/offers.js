import Controller from '@ember/controller';

export default Controller.extend({
  offer: Ember.inject.service(),
  offers: function() {
    return this.get('model.offers');
  }.property('model.offers'),

  actions:{
    replace:function(){
      document.getElementById('offer-image').src = '/assets/images/alt.png';
    }
  }
});
