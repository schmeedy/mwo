define(function(require, exports, module) {

    var Kinetic = require("kinetic");

    var LayerManager = function(stage) {
        var createLayer = function(name) {
            var layer = new Kinetic.Layer({
                name: name
            });
            stage.add(layer);
            return layer;
        };

        this.layers = {
            board: createLayer('layer-board'),
            units: createLayer('layer-units')
        };
    };

    module.exports = LayerManager;

});