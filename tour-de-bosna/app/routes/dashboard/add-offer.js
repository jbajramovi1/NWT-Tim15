import Route from '@ember/routing/route';

export default Route.extend({
  offer: Ember.inject.service(),
  model: function(params, transition) {
    return Ember.RSVP.hash({
      offerTypes: this.get('offer').getOfferTypes(),
      offerSeasons: this.get('offer').getOfferSeasons()
    })
  }
});
