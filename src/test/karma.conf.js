module.exports = function (config) {
    'use strict';
    config.set({

        basePath: '../',

        frameworks: ['jasmine', 'sinon-chai'],

        files: [
            '../node_modules/angular/angular.js',
            '../node_modules/lodash/index.js',
            '../node_modules/angular-mocks/angular-mocks.js',
            '../node_modules/angular-route/angular-route.js',
            '../node_modules/ng-table/dist/ng-table.js',
            '../node_modules/angular-ui-mask/dist/mask.min.js',
            'main/resources/static/js/*.js',
            'main/resources/static/js/controllers/*.js',
            'main/resources/static/js/factories/*.js',
            'main/resources/static/js/services/*.js',
            'test/resources/static/js/controllers/*-spec.js',
            'test/resources/static/js/factories/*-spec.js',
            'test/resources/static/js/services/*-spec.js',
            'test/resources/static/js/*-spec.js'
        ],

        reporters: ['spec'],

        port: 9876,
        colors: true,
        autoWatch: true,
        singleRun: false,

        // level of logging
        // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
        logLevel: config.LOG_INFO,

        browsers: ['PhantomJS']

    });
};
