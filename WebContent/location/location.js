(function() {
    'use strict';

    angular.module('efs.location')
        .controller('LocationCtrl', LocationCtrl);

    LocationCtrl.$inject = ['$scope','$http'];
    function LocationCtrl($scope, $http) {

    $scope.gridOptions = {
        enableSorting: true,
        enableFiltering: true,
        enableGridMenu: true,
        enableSelectAll: true,
        exporterCsvFilename: 'EFS_location.csv',
        columnDefs: [
            {field: 'LocationNumber', enableCellEdit: true,editableCellTemplate: 'xxxxxxx', width: '30%', maxWidth: 200, minWidth: 70},
            {field: 'LocationDesc',enableCellEdit: true,editableCellTemplate: 'xxxxxxx',  width: '30%', maxWidth: 200, minWidth: 70},
            {field: 'Address', enableCellEdit: true,editableCellTemplate: 'xxxxxxx', width: '20%'},
            {field: 'City', enableCellEdit: true,editableCellTemplate: 'xxxxxxx', width: '30%', maxWidth: 200, minWidth: 70},
            {field: 'State', width: '30%', maxWidth: 200, minWidth: 70},
            {field: 'ZIP', width: '30%', maxWidth: 200, minWidth: 70}


        ] ,
        onRegisterApi: function(gridApi){
           $scope.gridApi = gridApi;
            }
         };
    $http.get('location/location-test.json')
        .success(function (data) {
            console.log(data);
            $scope.gridOptions.data = data;
        });
    }
}   )();