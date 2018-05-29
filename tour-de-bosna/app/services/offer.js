import Service from '@ember/service';
import ApplicationService from './application';
import ENV from '../config/environment';

export default ApplicationService.extend({
  apiUrl: ENV.APP.API_OFFER,

  getOffers: function() {
    return this.ajax({url: '/offer/getAll', type: 'GET'})
      .then(function(result) {
         return result;
      });
  },
  getOfferTypes: function(){
    return this.ajax({url: '/offertype/getAll', type: 'GET'})
    .then(function(result) {
       return result;
    });
  },
  getOfferSeasons: function(){
    return this.ajax({url: '/offerseason/getAll', type: 'GET'})
    .then(function(result) {
       return result;
    });
  },
  getOffer: function(id) {
    return this.ajax({url: '/offer/get' + id, type: 'GET'})
      .then(function(result) {
         return result;
      });
  },
  createOffer: function(data) {
    console.log("data", data);
    return this.ajax({url: '/offer/create', type: 'POST', data: JSON.stringify(data)})
      .then(function(result) {
        return result;
      });
  },
  updateOffer: function(id, data) {
    return this.ajax({url: '/offer/update' + id, type: 'POST', data: JSON.stringify(data)})
      .then(function(result) {
        return result;
      });
  },
  deleteOffer: function(id) {
    return this.ajax({url: '/offer/delete' + id, type: 'DELETE'})
      .then(function(result) {
        return result;
      });
  },
});
