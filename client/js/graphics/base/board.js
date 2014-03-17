define(function(require, exports, module) {

    var Kinetic = require("kinetic");
    var Zone = require("./zone");

    module.exports = Ember.Object.extend({

        // 'constructor' arguments
        _layer: null,

        init: function() {
            var zoneGroup = new Kinetic.Group({});
            this.get('_layer').add(zoneGroup);

            this._boardImg = new Image();

            this._boardImg.onload = function() {
                var ZONE_WIDTH  = 400;
                var ZONE_HEIGHT = 400;

                this.zones = [];

                for (var x = 0; x < 4; x++) {
                    this.zones[x] = [];
                    for (var y = 0; y < 3; y++) {
                        var zoneImage = new Kinetic.Image({
                            image: this._boardImg,
                            x: x * ZONE_WIDTH,
                            y: y * ZONE_HEIGHT,
                            width: ZONE_WIDTH,
                            height: ZONE_HEIGHT,
                            crop: {
                                width: ZONE_WIDTH,
                                height: ZONE_HEIGHT,
                                x: x * ZONE_WIDTH,
                                y: y * ZONE_HEIGHT
                            }
                        });
                        zoneGroup.add(zoneImage);

                        this.zones[x][y] = Zone.create({
                            image: zoneImage,
                            zoneX: x,
                            zoneY: y
                        });
                    }
                }

                this.setDefaultScale();
            }.bind(this);
            this._boardImg.src = '/assets/board.jpg';
        },

        setDefaultScale: function() {
            var stage = this.get('_layer').getStage();
            var ratio = stage.height() / this._boardImg.height;
            stage.scale({
                x: ratio,
                y: ratio
            });
            stage.draw();
        }

    });

});