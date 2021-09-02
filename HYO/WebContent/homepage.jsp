<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/angular-material.min.css">
<link rel="stylesheet" href="css/homepage.css">
<script src="lib/bootstrap.min.js"></script>
<script src="lib/angular.min.js"></script>
<script src="lib/angular-animate.min.js"></script>
<script src="lib/angular-aria.min.js"></script>
<script src="lib/angular-messages.min.js"></script>
<script src="lib/angular-material.min.js"></script>
<script src="js/homepage.js"></script>
<script src="js/searchProduct.js"></script>
<head>
<meta charset="ISO-8859-1">
<title>HYO Inc</title>
</head>
<body ng-app="homeApp">
	<div ng-controller="AppCtrl as ctrl" layout="column" style="width: 100%;height: 100%;" ng-cloak>

  <section layout="row" flex>

    <md-sidenav
        class="md-sidenav-left"
        md-component-id="left"
        md-is-locked-open="$mdMedia('gt-md')"
        md-whiteframe="4"
        style="width:200px">

      <md-toolbar class="md-theme-indigo">
        <h1 class="md-toolbar-tools">HYO Inc</h1>
      </md-toolbar>
      <md-content layout-padding ng-controller="LeftCtrl">
       <md-button ng-click="close()" class="md-primary" hide-gt-md>
          Close Menu
        </md-button>
        <div class="menuItem" ng-repeat= "(key,value) in ctrl.menuMap" ng-click="ctrl.navigateToPage(key)">
        	{{value}}
        </div>
      </md-content>

    </md-sidenav>

    <md-content flex layout-padding>

     	<div>
          <md-button ng-click="toggleLeft()"
            class="md-primary" hide-gt-md>
            Show Menu
          </md-button>
        </div>

      <div flex style="width:100%;height:97%">
      	<div style="width:100%;height:100%" ng-include="ctrl.selectedPage"></div>
      </div>

    </md-content>
  </section>

</div>
</body>
</html>