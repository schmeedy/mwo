define(function(require, exports, module) {

    var Modifier = Ember.Object.extend({
        value: 0,
        sourceDescription: null,
        sourceCardId: null // optional
    });

    module.exports = Ember.Object.extend({
        baseValue: 0,
        modifiers: Ember.A(),
        value: function() {
            return this.modifiers.reduce(function(acc, item) {
                return acc + item.get('value');
            }, this.get('baseValue'));
        }.property('baseValue', 'modifiers.@each.value')
    });

});