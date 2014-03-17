define(function(require, exports, module) {

    var Kinetic = require('kinetic');
    var LayerManager = require('./layer_manager');
    var Board = require('./base/board');
    var cardTypes = require('./base/card_types');

    var KineticGui = function(container) {
        this._container = container;

        this._stage = new Kinetic.Stage({
            container: this._container.get(0),
            width: $(window).width(),
            height: $(window).height()
        });

        $(window).on('resize', function() {
            this._stage.width($(window).width());
            this._stage.height($(window).height());
        }.bind(this));

        this._container.mousewheel(function(event) {
            var ratio = this._stage.scale().x - event.deltaY / 700;
            this._stage.scale({
                x: ratio,
                y: ratio
            });
            this._stage.draw();
        }.bind(this));

        this._layerManager = new LayerManager(this._stage);

        this._board = Board.create({
            _layer: this._layerManager.layers.board
        });

        this.demo();
    };

    KineticGui.prototype.demo = function() {
        var adramelech = cardTypes.CREATURE_ADRAMELECH.createKineticImage();
        this._layerManager.layers.units.add(adramelech);

        var adramelech2 = cardTypes.CREATURE_ADRAMELECH.createKineticImage();
        adramelech2.x(50);
        adramelech2.y(50);
        this._layerManager.layers.units.add(adramelech2);

        var wizard = cardTypes.PLAYER_WIZARD.createKineticImage();
        wizard.x(200);
        this._layerManager.layers.units.add(wizard);
    };

    module.exports = KineticGui;

});