(function() {
    'use strict';

    angular
        .module('efs.upload')
        .constant('LOCATION_FILE_TYPE', 1)
        .constant('LOCATION_HEADER_LIST', [
            'Location Number',
            'Location Description',
            'Address 1',
            'Address 2',
            'Address 3',
            'Address 4',
            'Address 5',
            'City',
            'State',
            'Zip',
            'Latitude',
            'Longitude',
            'Country Code',
            'Location Type Code',
            'Active flag'
        ])
        .constant('ORDER_GROUP_FILE_TYPE', 2)
        .constant('ORDER_GROUP_HEADER_LIST', [
            'Location Number',
            'Location Destination',
            'Lane Name',
            'MVNDR',
            'Primary Location',
            'Vendor Effective Begin Date',
            'Vendor Effective End Date',
            'Load Group Name',
            'LG Effective Begin Date',
            'LG Effective End Date',
            'Lane Active flag'
        ])
        .constant('LOAD_GROUP_PARAMETER_FILE_TYPE', 3)
        .constant('LOAD_GROUP_PARAMETERS_HEADER_LIST', [
            'Location Number',
            'Destination',
            'Load Group Name',
            'Max Truck Height',
            'TL Cube Threshold',
            'TL Weight Threshold',
            'Directional Rounding Threshold',
            'Threshold Increment',
            'Full TL Threshold',
            'Load Configurator',
            'Smoothing Interval',
            'TL Daily Min Qty',
            'TL Daily Max Qty',
            'Effective Begin',
            'Effective End'
        ])
        .constant('VENDOR_PARAMETERS_FILE_TYPE', 4)
        .constant('VENDOR_PARAMETERS_HEADER_LIST', [
            'MVNDR Number',
            'Origin',
            'Destination',
            'Default MVNDR Parameters',
            'Max Pull Forward Days',
            'Max Order Days',
            'TL Round Up',
            'TL Round Down',
            'OUTL Threshold',
            'Effective Begin',
            'Effective End',
            'Default'
        ])
        .constant('ROUTE_FILE_TYPE', 5)
        .constant('ROUTE_HEADER_LIST', [
			'Route Type Code',
			'Route Config Code',
			'Route Description',
			'Carrier Code',
			'Route Effective Begin Date',
			'Route Effective End Date'
        ])
        .constant('SCHEDULE_FILE_TYPE', 6)
        .constant('SCHEDULE_HEADER_LIST', [
            'Location Number', 
            'Destination', 
            'Schedule Type Code', 
            'Schedule Group Code', 
            'Schedule Name', 
            'Order Day', 
            'VTT (days)',
			'Ship Day',
			'Arrive Day',
			'Vendor Ready Time',
			'Expected Carrier Depart Time',
			'Transit Time (in hours)',
			'DC Appointment Time',
			'DC Start Work Day',
			'DC End Work Day',
			'Start Shift Sequence Number',
			'End Shift Sequence Number',
			'Number of Shifts Worked',
			'Order Week Number',
			'Tender Week Number',
			'Ship Week Number',
			'Arrive Week Number',
			'DC Start Work Week Number',
			'DC End Work Week Number',
			'Effective Begin Date',
			'Effective End Date'
        ])
        .constant('UNKNOWN_FILE_TYPE', -1)
        .factory('templateParser', templateParser);

    function templateParser(csvParser,$q,
                            LOCATION_HEADER_LIST,
                            ORDER_GROUP_HEADER_LIST,
                            LOAD_GROUP_PARAMETERS_HEADER_LIST,
                            VENDOR_PARAMETERS_HEADER_LIST,
                            ROUTE_HEADER_LIST,
                            SCHEDULE_HEADER_LIST,
                            LOCATION_FILE_TYPE,
                            ORDER_GROUP_FILE_TYPE,
                            LOAD_GROUP_PARAMETER_FILE_TYPE,
                            VENDOR_PARAMETERS_FILE_TYPE,
                            ROUTE_FILE_TYPE,
                            SCHEDULE_FILE_TYPE,
                            UNKNOWN_FILE_TYPE) {

        var parser ={};

        parser.validateTemplate = function (file){
            var deferred = $q.defer();

            csvParser.parseHeader(file).then(
                function(header){
                    var fileType = parser.verifyTemplates(header);

                    if(fileType === -1) {
                        deferred.reject(fileType);
                    } else {
                        deferred.resolve(fileType);
                    }
            },
                function(error){
                    deferred.reject(error);
            });

            return deferred.promise;

        };

        parser.verifyTemplates = function(header){
            var fileType;

            if (angular.equals(header, LOCATION_HEADER_LIST)) {

                fileType = LOCATION_FILE_TYPE;

            } else if (angular.equals(header, ORDER_GROUP_HEADER_LIST)) {

                fileType = ORDER_GROUP_FILE_TYPE;

            } else if (angular.equals(header, LOAD_GROUP_PARAMETERS_HEADER_LIST)) {

                fileType = LOAD_GROUP_PARAMETER_FILE_TYPE;

            } else if (angular.equals(header, VENDOR_PARAMETERS_HEADER_LIST)) {

                fileType = VENDOR_PARAMETERS_FILE_TYPE;

            }  else if (angular.equals(header, ROUTE_HEADER_LIST)) {

                fileType = ROUTE_FILE_TYPE;

            } else if (angular.equals(header, SCHEDULE_HEADER_LIST)) {  

                fileType = SCHEDULE_FILE_TYPE;

            }else {

                fileType = UNKNOWN_FILE_TYPE;

            }
            console.log("File type:",fileType);
            return fileType
        };

        return {
            validateTemplate: parser.validateTemplate
        }

    }

})();