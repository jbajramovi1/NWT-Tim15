import EmberRouter from '@ember/routing/router';
import config from './config/environment';

const Router = EmberRouter.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('dashboard', function() {
    this.route('offers');
    this.route('booking');
    this.route('login');
    this.route('register-user');
    this.route('register-host');
    this.route('offers-host');
  });
  this.route('welcome');




});

export default Router;
