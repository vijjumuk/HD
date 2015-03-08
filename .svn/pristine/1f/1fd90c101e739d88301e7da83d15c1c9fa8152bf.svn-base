/*
 * This program is proprietary to The Home Depot and is not to be 
 * reproduced, used, or disclosed without permission of:
 *    
 *  The Home Depot
 *  2455 Paces Ferry Road, N.W.
 *  Atlanta, GA 30339-4053
 * 
 * File Name: FileUploadFactory.java 
 * author: The Home Depot Inc
 */
package com.homedepot.di.xd.efs.businesshelper;

import com.homedepot.di.xd.efs.constants.UploadConstants;

/**
 * @author MXG8621
 * 
 */
public class FileUploadFactory {

	/**
	 * This method will return the object based on type of upload to process.
	 * 
	 * @param uploadType
	 * @return Object of upload class
	 */
	public static IUploadProcessor getUploadObj(String fileType) {
		if (fileType.equals(UploadConstants.EFS_LOCATION)) {
			return new LocationUploadProcessor();
		} 
		if (fileType.equals(UploadConstants.EFS_LANE)) {
			return new LaneUploadProcessor();
		}  
		if (fileType.equals(UploadConstants.EFS_SCHEDULE)) {
			return new ScheduleUploadProcessor();
		} 
		return null;
	}
}
