import Controller from '@ember/controller';

export default Controller.extend({
offer: function() {
  return this.get('model.offer');
}.property('model.offer')

});
