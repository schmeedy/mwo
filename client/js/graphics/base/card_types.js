define(function(require, exports, module) {

    var Kinetic = require("kinetic");

    var CardType = function(id, name, imageSrc) {
        this.id = id;
        this.name = name;
        this._imageSrc = imageSrc;
    };

    CardType.prototype =  {
        imageElement: function() {
            if (!this._cachedImage) {
                this._imageLoad = {
                    loaded: false,
                    redrawQueue: [],
                    register: function(kineticImage) {
                        if (!this.loaded) {
                            this.redrawQueue.push(kineticImage);
                        }
                    }
                };
                this._cachedImage = new Image();
                this._cachedImage.onload = function() {
                    this._imageLoad.loaded = true;
                    this._imageLoad.redrawQueue.forEach(function(kImage) {
                        kImage.draw();
                    });
                    this._imageLoad.redrawQueue.splice(this._imageLoad.redrawQueue.length);
                }.bind(this);
                this._cachedImage.src = this._imageSrc;
            }
            return this._cachedImage;
        },

        createKineticImage: function() {
            var kineticImage = new Kinetic.Image({
                image: this.imageElement(),
                width: 122,
                height: 170,
                draggable: true
            });

            this._imageLoad.register(kineticImage);

            return kineticImage;
        }
    };

    module.exports = {
        CREATURE_ADRAMELECH: new CardType('adramelech', 'Adramelech, Lord of Fire', 'assets/cards/adramelech_low.jpg'),
        PLAYER_WIZARD: new CardType('wizard', 'Wizard', 'assets/cards/wizard_low.jpg')
    };

});