import Service from '@ember/service';
import $ from 'jquery';

export default Service.extend({
  ajax: function(params) {
    params.url = `${this.apiUrl}${params.url}`;
    params.contentType = "application/json";
    return $.ajax(params);
  },
});
