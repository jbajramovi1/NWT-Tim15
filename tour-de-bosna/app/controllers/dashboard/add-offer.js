import Controller from '@ember/controller';

export default Controller.extend({
  offer: Ember.inject.service(),
  router: Ember.inject.service(),
  authentication: Ember.inject.service(),
  offerType:1,
  offerSeason:1,

  offerTypes: function() {
    return this.get('model.offerTypes');
  }.property('model.offerTypes'),

  offerSeasons: function() {
    return this.get('model.offerSeasons');
  }.property('model.offerSeasons'),

  actions: {
    setType: function(selected) {
      this.set('offerType', selected)
    },
    setSeason: function(selected) {
      this.set('offerSeason', selected)
    },
    createOffer: function() {
      var self = this;
      var data = {
          name: self.get('name'),
          language: self.get('language'),
          participantsLimit: self.get('participantsLimit'),
          description: self.get('description'),
          price: self.get('price'),
          duration: self.get('duration'),
          offerType: {id:self.get('offerType')},
          offerSeason: {id:self.get('offerSeason')},
          tourHost: this.get('authentication').get('username')
      };
      this.get('offer').createOffer(data).then(x => {
            self.set("serverSuccess", true);
            self.set("serverError", false);
            self.set("serverErrorText", "");
            this.get('router').transitionTo('dashboard.offers-host');

        }).catch(err => {
            self.set("serverSuccess", false);
            self.set("serverError", true);
            self.set("serverErrorText", err.responseText);
      });
    }
  }

});
