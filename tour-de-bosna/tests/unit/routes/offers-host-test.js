import { module, test } from 'qunit';
import { setupTest } from 'ember-qunit';

module('Unit | Route | offers-host', function(hooks) {
  setupTest(hooks);

  test('it exists', function(assert) {
    let route = this.owner.lookup('route:offers-host');
    assert.ok(route);
  });
});
