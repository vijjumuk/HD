(function() {
    'use strict';

    angular
        .module('efs.core')
        .constant('efsUploadMessage','Please select a new template or upload a completed file...')
        .constant('availableTemplates', availableTemplates);

    function availableTemplates() {
      return [
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
    }
})();
