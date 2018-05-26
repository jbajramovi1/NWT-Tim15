import { module, test } from 'qunit';
import { setupTest } from 'ember-qunit';

module('Unit | Route | register-user', function(hooks) {
  setupTest(hooks);

  test('it exists', function(assert) {
    let route = this.owner.lookup('route:register-user');
    assert.ok(route);
  });
});
