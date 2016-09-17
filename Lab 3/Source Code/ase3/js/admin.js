
angular.module('ID', [])
.controller('qrcode', function ($scope, $http) {
    $scope.username=document.getElementById('username');
    $scope.idno=document.getElementById('idno');

        //document.getElementById('username').innerHTML += localStorage.getItem('UserName');

 
$scope.storeinQR = function() {
 document.getElementById("qrimg").src = "https://api.qrserver.com/v1/create-qr-code/?data="+document.getElementById("idno").value +"&amp;size=100x100" ; 
}





});

                

