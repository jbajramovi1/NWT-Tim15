import Route from '@ember/routing/route';

export default Route.extend({
    offer: Ember.inject.service(),
    queryParams: {
      id: {
        refreshModel: true
      }
    },
    model(params) {
        return Ember.RSVP.hash({
          offer: this.get('offer').getOffer(params.id),
      })
  },
});
