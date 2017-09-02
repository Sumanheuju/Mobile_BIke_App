// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
var app = angular.module('bajajApp', ['ionic'])

app.config(function($stateProvider, $urlRouterProvider) {

  $stateProvider
    .state('tabs', {
      url: "/tab",
      abstract: true,
      templateUrl: "templates/tabs.html"
    })
    .state('tabs.home', {
      url: "/home",
      views: {
        'home-tab': {
          templateUrl: "templates/home.html",
          controller: 'ProfileUserCtrl'
        }
      }
    })
    .state('tabs.profileDetails', {
      url: "/profileDetails",
      views: {
        'home-tab': {
          templateUrl: "templates/profileDetails.html",
          controller: 'ProfileUserCtrl'
        }
      }
    })
    .state('tabs.editProfileDetails', {
      url: "/editProfileDetails",
      views: {
        'home-tab': {
          templateUrl: "templates/editProfileDetails.html",
          controller: 'ProfileUserCtrl'
        }
      }
    })
    .state('tabs.about', {
      url: "/about",
      views: {
        'about-tab': {
          templateUrl: "templates/about.html"
        }
      }
    })
    .state('tabs.navstack', {
      url: "/navstack",
      views: {
        'about-tab': {
          templateUrl: "templates/nav-stack.html"
        }
      }
    })
    .state('tabs.contact', {
      url: "/contact",
      views: {
        'contact-tab': {
          templateUrl: "templates/contact.html"
        }
      }
    });


   $urlRouterProvider.otherwise("/tab/home");

})

app.controller('ProfileUserCtrl', function($scope,$http) {
    $scope.profileUsers;
      $http({
          method: 'GET',
          url: 'http://127.0.0.1:8080/MavenHibernate/api/profileUser/3'
      }).then(function(response){
          $scope.profileUsers = response.data;
          //console.log($scope.profileUsers);
      });
      $scope.submit = function(Data){
          console.log($scope.profileUsers.name);
          var GetAll={};

          GetAll.name = Data.name;
          GetAll.address = Data.address;
          GetAll.contactNo = Data.contactNo;
          GetAll.licenseNo = Data.licenseNo;
          GetAll.bloodGroup = Data.bloodGroup;
          GetAll.vehicleNo = Data.vehicleNo;
          GetAll.email = Data.email;
          GetAll.profilePicture = Data.profilePicture;
          
          console.log(GetAll);
          $http({
              method: 'POST',
              url: 'http://127.0.0.1:8080/MavenHibernate/api/profileUser/edit/3',
              data: GetAll

          }).then(function(resolve){
              console.log("Resolved!");
          });
      }


});

// app.controller('EditProfileUserCtrl', function(){
//     $scope.profileUsers = [];
//       $http({
//           method: 'GET',
//           url: 'http://127.0.0.1:8080/MavenHibernate/api/profileUser/2'
//       }).then(function(response){
//           var specificData = response.data;
//           $scope.profileUsers = specificData;
//       });
// });
