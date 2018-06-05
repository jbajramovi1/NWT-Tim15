import Route from '@ember/routing/route';
import { isEmpty } from '@ember/utils';
export default Route.extend({
  authentication:Ember.inject.service(),
  model: function(params, transition) {
    return Ember.RSVP.hash({
      role: this.controllerFor('welcome').get('userRole'),
      isNotLoggedIn:isEmpty(null)
      })
  }
});
