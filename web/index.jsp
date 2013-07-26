<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="description" content="News Bulletin Website">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="styles/main.css">
    <title>Bulletin</title>
</head>
<body ng-app="BulletinApp">
    <h1>Bulletin Board</h1>
    <div class="container" ng-view="$ng-view"></div>
    <!--Angular Dependencies-->
    <script src="js/libs/angular.js"></script>
    <script src="js/libs/angular-resource.js"></script>
    <!--Application Dependencies-->
    <script src="js/app.js"></script>
    <script src="js/directives.js"></script>
    <script src="js/filters.js"></script>
    <script src="js/services.js"></script>
    <script src="js/controllers.js"></script>
</body>
</html>