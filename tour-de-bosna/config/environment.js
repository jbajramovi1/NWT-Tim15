module.exports = function(environment) {
  let ENV = {
    modulePrefix: 'tour-de-bosna',
    environment,
    rootURL: '/',
    locationType: 'auto',
    EmberENV: {
      FEATURES: {
        // Here you can enable experimental features on an ember canary build
        // e.g. 'with-controller': true
      },
      EXTEND_PROTOTYPES: {
        // Prevent Ember Data from overriding Date.parse.
        Date: false
      }
    },

    APP: {
      // Here you can pass flags/options to your application instance
      // when it is created
    }
  };

  ENV['ember-simple-auth'] = {
   authorizer: 'authorizer:token',
   baseURL: ''
 };

 ENV['ember-simple-auth-token'] = {
   refreshAccessTokens: false,
   authorizer: 'authorizer:token',
   identificationField: 'username',
   passwordField: 'password',
   serverTokenEndpoint: ""
 };

  if (environment === 'development') {
    // ENV.APP.LOG_RESOLVER = true;
    // ENV.APP.LOG_ACTIVE_GENERATION = true;
    // ENV.APP.LOG_TRANSITIONS = true;
    // ENV.APP.LOG_TRANSITIONS_INTERNAL = true;
    // ENV.APP.LOG_VIEW_LOOKUPS = true;
    ENV.APP.API_BOOKING = "http://localhost:8085";
    ENV.APP.API_OFFER = "http://localhost:8060";
    ENV.APP.API_TOUR_HOST = "http://localhost:8090";
    ENV.APP.API_USER = "http://localhost:8010";
    ENV.APP.API_GATEWAY = "http://localhost:9090";
  }

  if (environment === 'test') {
    // Testem prefers this...
    ENV.locationType = 'none';

    // keep test console output quieter
    ENV.APP.LOG_ACTIVE_GENERATION = false;
    ENV.APP.LOG_VIEW_LOOKUPS = false;

    ENV.APP.rootElement = '#ember-testing';
    ENV.APP.autoboot = false;
  }

  if (environment === 'production') {
    // here you can enable a production-specific feature
    ENV.APP.API_BOOKING = "http://localhost:8085";
    ENV.APP.API_OFFER = "http://localhost:8060";
  }

  apiHost = "http://localhost:9090"

  ENV['ember-simple-auth'].baseURL = ENV.apiHost;
  ENV['ember-simple-auth-token'].serverTokenEndpoint = `user-login`;

  return ENV;
};
