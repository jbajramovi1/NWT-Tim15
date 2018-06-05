import Controller from '@ember/controller';

export default Controller.extend({
  authentication: Ember.inject.service(),
  booking: Ember.inject.service(),
  isShowingModal: false,
  offers: function() {
    return this.get('model.offers');
  }.property('model.offers'),

  actions:{
    replace:function(){
      document.getElementById('offer-image').src = '/assets/images/alt.png';
    },
    toggleModal: function() {
      this.toggleProperty('isShowingModal');
    },
    saveBooking: function(offer) {
      var date = this.get('date');
      var newDate = new Date(date);
      newDate = newDate.toISOString();
      var data = {
          userId: this.get("authentication").get("username"),
          offerId: offer.id,
          bookingDate: newDate
      };
      console.log("data", offer);
      this.get('booking').createBooking(data).then(x => {
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
