import Service from '@ember/service';
import $ from 'jquery';

export default Service.extend({


  ajax: function(params) {
      var token = this.get('session.data.authenticated.token');
    if(token !== undefined) {
      params.beforeSend = function(request) {
        request.setRequestHeader("Authorization", "Bearer " + token);
      };
    }

    params.url = `${this.apiUrl}${params.url}`;
    params.contentType = "application/json";
    return $.ajax(params);
  },

ajaxWithoutContentType: function(params) {

   var token = this.get('session.data.authenticated.token');
   if(token !== undefined) {
     params.beforeSend = function(request) {
       request.setRequestHeader("Authorization", "Bearer " + token);
     };
   }

   params.url = `${this.apiUrl}${params.url}`;

   return $.ajax(params);
} });
