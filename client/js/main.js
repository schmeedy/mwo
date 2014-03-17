require.config({
    baseUrl: "js",
    paths: {
        'jquery': 'lib/jquery',
        'jquery-mousewheel': 'lib/jquery-mousewheel',
        'ember': 'lib/ember',
        'handlebars': 'lib/handlebars',
        'kinetic': 'lib/kinetic'
    },
    shim: {
        'jquery': {
            exports: 'jQuery'
        },
        'jquery-mousewheel': ['jquery'],
        'handlebars': ['jquery'],
        'ember': ['handlebars']
    }
});

require(['base_deps'], function() {

    require([ 'graphics/kinetic_gui' ], function(KineticGui) {
        var kineticGui = new KineticGui($('#container'));
    });

});