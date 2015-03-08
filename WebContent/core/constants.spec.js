describe('EFS Block: Constants tests:: ', function() {

    var availableTemplates;

    beforeEach(angular.mock.module('efs'));

    beforeEach(angular.mock.inject(function(_availableTemplates_){
        availableTemplates = _availableTemplates_;
    }));

    var dropDownMenu = [
        {
            'text': 'Location',
            'href': 'templates/EFS_Location_Template.csv'
        },
        {
            'text': 'Order Group',
            'href': 'templates/Order_Group_Template.csv'
        },
        {
            'text': 'Load Group Parameters',
            'href': 'templates/LG_Parm_Template.csv'
        },
        {
            'text': 'Vendor Parameters',
            'href': 'templates/Vndr_Parm_Template.csv'
        },
        {
            'text': 'Route',
            'href': 'templates/Route_Template.csv'
        },
        {
            'text': 'Schedule',
            'href': 'templates/Schedule_Template.csv'
        }
    ];

    it('availableTemplates constant exists', function() {
        angular.mock.inject(function(_availableTemplates_) {
            expect(_availableTemplates_).toBeDefined();
        });
    });

   it('dropDownMenu contains example data', function() {
        expect(availableTemplates()).toEqual(dropDownMenu);
    })

});
