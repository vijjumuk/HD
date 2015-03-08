package com.homedepot.di.xd.efs.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.homedepot.di.xd.efs.constants.UploadConstants;
import com.homedepot.di.xd.efs.to.ResponseTO;

public class MessageResponse {

	/**
	 * Method converts responseTO to JSON.
	 * 
	 * @param responseTo
	 * @return JSON response as String
	 */
	public String getSuccessfulJsonResponse(ResponseTO responseTo) {

		ResponseTO respTo = new ResponseTO();
		if (responseTo != null && responseTo.getErrorMsg() == null) {
			respTo.setReturnCode(UploadConstants.SUCCESSFUL_RETURN_CODE);
			respTo.setResults(responseTo.getResults());
			respTo.setReturnMessage(responseTo.getReturnMessage());
		} else if(responseTo.getErrorMsg() != null) {
			respTo.setReturnCode(UploadConstants.SUCCESSFUL_RETURN_CODE);
			respTo.setReturnMessage(responseTo.getErrorMsg());
		} else {
			respTo.setReturnCode(UploadConstants.EXCEP_ERR_CD);
			respTo.setReturnMessage(UploadConstants.FAILED_MSG);
		}

		Gson gson = new Gson();
		JsonElement je = gson.toJsonTree(respTo);
		JsonObject jo = new JsonObject();
		jo.add(ResponseTO.class.getSimpleName(), je);

		return jo.toString();
	}
}
