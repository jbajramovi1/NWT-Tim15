import Service from '@ember/service';
import ApplicationService from './application';
import ENV from '../config/environment';

export default ApplicationService.extend({
  apiUrl: ENV.APP.API_TOUR_HOST,

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
  registerTourHost: function(data) {
    return this.ajax({url: '/register', type: 'POST', data: JSON.stringify(data)})
      .then(function(result) {
        return result;
      });
  },
});