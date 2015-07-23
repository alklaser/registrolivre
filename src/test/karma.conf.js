module.exports = function (config) {
    'use strict';
    config.set({

        basePath: '../',

        frameworks: ['jasmine', 'sinon-chai'],

        files: [
            '../node_modules/angular/angular.js',
            '../node_modules/angular-mocks/angular-mocks.js',
            'main/webapp/js/*.js',
            'test/webapp/js/*-spec.js'
        ],

        reporters: ['spec'],

        port: 9876,
        colors: true,
        autoWatch: false,
        singleRun: false,

        // level of logging
        // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
        logLevel: config.LOG_INFO,

        browsers: ['PhantomJS']

    });
};