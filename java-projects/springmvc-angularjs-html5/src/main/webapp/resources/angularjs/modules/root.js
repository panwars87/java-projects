angular.module("myApp", ['serviceModule'])
  .value("udemy", {
     courseName: "Java Spring MVC",
     author: "Tuna Tore",
     getCourseDetails: function (){
    	 return this.courseName + " " + this.author;
    }
})
.controller("valueController", function ($scope, udemy)
{
    $scope.udemyObject = udemy;
});