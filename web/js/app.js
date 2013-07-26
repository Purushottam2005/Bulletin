'use strict';

var bulletinApp = angular.module('BulletinApp',['ngResource']);

bulletinApp.config(function($routeProvider){
    $routeProvider
        .when('/',{
            templateUrl: 'views/main.html',
            controller: 'MainCtrl'
        })
        .when('/post',{
            templateUrl: 'views/post.html',
            controller: 'MainCtrl'
        })
        .otherwise({
            redirectTo: '/'
        });
    });