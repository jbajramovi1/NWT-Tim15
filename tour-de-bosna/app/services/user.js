import Service from '@ember/service';
import ApplicationService from './application';
import ENV from '../config/environment';

export default ApplicationService.extend({
  apiUrl: ENV.APP.API_USER,

  getUsers: function() {
    return this.ajax({url: '/', type: 'GET'})
      .then(function(result) {
         return result;
      });
  },
  getUser: function(id) {
    return this.ajax({url: '/' + id, type: 'GET'})
      .then(function(result) {
         return result;
      });
  },
  registerUser: function(data) {
    return this.ajax({url: '/register', type: 'POST', data: JSON.stringify(data)})
      .then(function(result) {
        return result;
      });
  },
});