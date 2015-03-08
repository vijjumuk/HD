package com.homedepot.di.xd.efs.upload;

import java.util.Date;

/**
 * @author x3aydjb
 *
 */
public class RecordFormatFactory {

	
	
	private static final RecordFormat FORMAT_LANE_LOCATION = 
			new RecordFormatImpl(
					FileType.LANE,
			new Field[] {
					new Field("LOCATION_NUMBER", String.class, false),
					new Field("LOCATION_DESTINATION", Integer.class, true),
					new Field("LANE_NAME", String.class, true),
					new Field("VENDOR", String.class, true),
					new Field("PRIMARY_LOCATION", String.class, true),
					new Field("VENDOR_EFF_BEGIN_DATE", Date.class, true),
					new Field("VENDOR_EFF_END_DATE", Date.class, true),
					new Field("LOAD_GROUP_NAME", String.class, true),
					new Field("LOAD_GROUP_EFF_BEGIN_DATE", Date.class, true),
					new Field("LOAD_GROUP_EFF_END_DATE", Date.class, true),
					new Field("LANE_ACTIVE_FLAG", String.class, true)
			}
	);  
	
	private static final RecordFormat FORMAT_SCHEDULE_LOCATION = 
			new RecordFormatImpl(
					FileType.SCHEDULE,
			new Field[] {
							new Field("Location Number", String.class, true),
							new Field("Destination", Integer.class, true),
							new Field("Schedule Type Code", Short.class, true),
							new Field("Schedule Group Code", Short.class, true),
							new Field("Schedule Name", String.class, true),
							new Field("Order Day", Short.class, true),
							new Field("VTT", Short.class, true),
							new Field("Ship Day", Short.class, true),
							new Field("Arrive Day", Short.class, true),
							new Field("Vendor Ready Time", String.class, true),
							new Field("Expected Carrier Depart Time", String.class, true),
							new Field("Transit Time", Short.class, true),
							new Field("DC Appointment Time", String.class, true),
							new Field("DC Start Work Day", Short.class, true),
							new Field("DC End Work Day", Short.class, true),
							new Field("Start Shift Sequence Number", Short.class, true),
							new Field("End Shift Sequence Number", Short.class, true),
							new Field("Number of Shifts Worked", Short.class, true),
							//new Field("DEST_LOC_HRS_WRKD_CNT", Short.class, true),
							new Field("Order Week Number", Short.class, true),
							new Field("Tender Week Number", Short.class, true),
							new Field("Ship Week Number", Short.class, true),
							new Field("Arrive Week Number", Short.class, true),
							new Field("DC Start Work Week Number", Short.class, true),
							new Field("DC End Work Week Number", Short.class, true),
							new Field("Effective Begin Date", Date.class, true),
							new Field("Effective End Date", Date.class, true)
					
			}
	);
	
	
	
	private static RecordFormat[] cFormats = 
			new RecordFormat[] {
							FORMAT_LANE_LOCATION, FORMAT_SCHEDULE_LOCATION
							
	}; 
	
	private static RecordFormatFactory cInstance = new RecordFormatFactory();
					
	private RecordFormatFactory() {}

	public static RecordFormatFactory getInstance() {
		return cInstance;
	}
	
	public static RecordFormat getRecordFormatFor(FileType uploadtype) 
			throws FormatException {
		
		for (int i = 0; i < cFormats.length; i++) {
			RecordFormat format = cFormats[i];
			if (format.getUploadType() == uploadtype) {
				return format;
			}
		}
			
		throw new FormatException("Unsupported Upload Format(" +
				uploadtype.name() + ")");
	}

}
