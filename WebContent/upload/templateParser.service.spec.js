describe('Blocks Common: templateParser tests :: ', function() {

    var templateParser,
        LOCATION_HEADER_LIST,
        ORDER_GROUP_HEADER_LIST,
        LOAD_GROUP_PARAMETERS_HEADER_LIST,
        VENDOR_PARAMETERS_HEADER_LIST,
        badLocationFile = [
            'Bad Bad Bad',
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
        ];

    beforeEach(angular.mock.module('efs.upload'));
    beforeEach(angular.mock.module('efs'));

    beforeEach(angular.mock.inject(function(_templateParser_,
                                            _LOCATION_HEADER_LIST_,
                                            _ORDER_GROUP_HEADER_LIST_,
                                            _LOAD_GROUP_PARAMETERS_HEADER_LIST_,
                                            _VENDOR_PARAMETERS_HEADER_LIST_ ) {
        templateParser = _templateParser_;
        LOCATION_HEADER_LIST = _LOCATION_HEADER_LIST_;
        ORDER_GROUP_HEADER_LIST = _ORDER_GROUP_HEADER_LIST_;
        LOAD_GROUP_PARAMETERS_HEADER_LIST = _LOAD_GROUP_PARAMETERS_HEADER_LIST_;
        VENDOR_PARAMETERS_HEADER_LIST = _VENDOR_PARAMETERS_HEADER_LIST_;
    }));

    it('templateParser factory service exists', function() {
        expect(templateParser).toBeDefined();
    });

    it('csvParser parseHeaders method exists', function() {
        expect(templateParser.validateTemplate).toBeDefined();
    });

/*    it('csvParser getFileType method exists', function() {
        expect(csvParser.getFileType).toBeDefined();
    });

    it('getFileType returns -1 if file type does not match known file types', function() {
        expect(csvParser.getFileType({})).toEqual(-1);
    });

    it('getFileType returns 1 if file type matches location', function() {
        expect(csvParser.getFileType(LOCATION_HEADER_LIST)).toEqual(1);
    });

    it('getFileType returns 1 if file type matches location', function() {
        expect(csvParser.getFileType(badLocationFile)).toEqual(-1);
    });

    it('getFileType returns 2 if file type matches load group', function() {
        expect(csvParser.getFileType(ORDER_GROUP_HEADER_LIST)).toEqual(2);
    });

    it('getFileType returns 3 if file type matches load group parameters', function() {
        expect(csvParser.getFileType(LOAD_GROUP_PARAMETERS_HEADER_LIST)).toEqual(3);
    });

    it('getFileType returns 4 if file type matches vendor parameters', function() {
        expect(csvParser.getFileType(VENDOR_PARAMETERS_HEADER_LIST)).toEqual(4);
    });*/

});
