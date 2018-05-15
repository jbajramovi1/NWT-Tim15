import Controller from '@ember/controller';

export default Controller.extend({
  offers: function() {
    return this.get('model.offers');
  }.property('model.offers'),
});
