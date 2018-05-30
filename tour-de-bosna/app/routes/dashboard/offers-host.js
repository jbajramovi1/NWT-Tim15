import Route from '@ember/routing/route';

export default Route.extend({
  offer: Ember.inject.service(),
  authentication:Ember.inject.service(),
  model: function(params, transition) {
    return Ember.RSVP.hash({
      offers: this.get('offer').getOffersByHost(this.get('authentication').get('username'))
      })
  }
});
