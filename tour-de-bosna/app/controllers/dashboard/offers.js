import Controller from '@ember/controller';

export default Controller.extend({
  offer: Ember.inject.service(),

  offers: function() {
    return this.get('model.offers');
  }.property('model.offers'),

  actions: {
    createOffer: function() {
      var self = this;
      var data = {
          name: self.get('name'),
          language: self.get('langauge'),
          participantsLimit: 6,
          description: self.get('description'),
          price: self.get('price'),
          duration: self.get('duration'),
          tourHost: 4
      };
      this.get("offer").createOffer(data).then(x => {
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
