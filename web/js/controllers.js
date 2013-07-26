'use strict';

function MainCtrl($scope,$location, Post) {
    $scope.posts = Post.query();

    $scope.publish = function(){
        $location.path("/post");
    }

    $scope.create = function(){
        $scope.newPost.publishDate = new Date();
        Post.save($scope.newPost, function(resource){
            $scope.posts.push(resource);
            $scope.newPost = {};
            $location.path("/");
        }, function(response){
            console.log("Error " + response.status);
        });
    }
}