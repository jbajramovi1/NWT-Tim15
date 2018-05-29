import Route from '@ember/routing/route';

export default Route.extend({
  offer: Ember.inject.service(),
  booking: Ember.inject.service(),

  model: function(params, transition) {
    return Ember.RSVP.hash({
      //offers: this.get('offer').getOffers()
      //booking: this.get('booking').getBookings()
    })
  }
});
