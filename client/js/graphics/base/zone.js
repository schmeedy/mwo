define(function(require, exports, module) {

    var Kinetic = require("kinetic");

    module.exports = Ember.Object.extend({

        zoneX: null,
        zoneY: null,
        image: null,

        init: function() {
            this.image.cache();
            this.image.filters([Kinetic.Filters.Brighten]);

            this.image.on('mouseenter', function() {
                this.image.brightness(0.2);
                this.image.draw();
            }.bind(this));

            this.image.on('mouseleave', function() {
                this.image.brightness(0);
                this.image.draw();
            }.bind(this));
        }

    });

});