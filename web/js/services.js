'use strict';

bulletinApp.factory('Post', function($resource){
    return $resource('rest/bulletin/post');
});