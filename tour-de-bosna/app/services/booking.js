import Service from '@ember/service';
import ApplicationService from './application';
import ENV from '../config/environment';

export default ApplicationService.extend({
  apiUrl: ENV.APP.API_BOOKING,

  getBookings: function() {
    return this.ajax({url: '/booking-service/booking', type: 'GET'})
      .then(function(result) {
         return result;
      });
  },
  getBooking: function(id) {
    return this.ajax({url: '/booking-service/booking/' + id, type: 'GET'})
      .then(function(result) {
         return result;
      });
  },
  createBooking: function(data) {
    return this.ajax({url: '/booking-service/booking', type: 'POST', data: JSON.stringify(data)})
      .then(function(result) {
        return result;
      });
  },
});
