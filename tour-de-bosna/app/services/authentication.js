import Service from '@ember/service';
import ApplicationService from './application';
import ENV from '../config/environment';

export default ApplicationService.extend({
  apiUrl: ENV.APP.API_GATEWAY,
  username:null,
  role:null,

  loginUser: function(data) {
    return this.ajax({url: '/user-login', type: 'POST', data: JSON.stringify(data)})
      .then(function(result) {
        return result;
      });
  },
  loginTourHost: function(data) {
    return this.ajax({url: '/tourhost-login', type: 'POST', data: JSON.stringify(data)})
      .then(function(result) {
        return result;
      });
  },
});
