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
            'main/resources/static/js/**/*.js',
            'test/resources/static/js/**/*-spec.js',
        ],

        reporters: ['spec', 'coverage'],

        preprocessors: { 'main/resources/static/js/**/*.js': ['coverage'] },

        coverageReporter: {
          type : 'html',
          dir : 'test/resources/coverage'
        },

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
