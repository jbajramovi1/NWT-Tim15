import Service from '@ember/service';
import ApplicationService from './application';
import ENV from '../config/environment';

export default ApplicationService.extend({
  apiUrl: ENV.APP.API_TOUR_HOST,
  authentication:Ember.inject.service(),
  router:Ember.inject.service(),
  getTourHosts: function() {
    return this.ajax({url: '/findall', type: 'GET'})
      .then(function(result) {
         return result;
      });
  },
  getTourHost: function(id) {
    return this.ajax({url: '/find/user' + id, type: 'GET'})
      .then(function(result) {
         return result;
      });
  },
  getTourHostByUsername(username) {
    var self=this;
    return this.ajax({url: '/findbyusername?user=' + username, type: 'GET'})
      .then(function(result) {
        self.get('authentication').set('username',result.idTourHost);
        console.log(self.get('authentication').get('username'));
        self.get('router').transitionTo('dashboard.offers-host');
        return result;
      });
  },
  registerTourHost: function(data) {
    return this.ajax({url: '/register', type: 'POST', data: JSON.stringify(data)})
      .then(function(result) {
        return result;
      });
  },
});
