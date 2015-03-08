/**
 * 
 */
package com.homedepot.di.xd.efs.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.homedepot.di.xd.efs.to.ResponseTO;

/**
 * @author 588893
 *
 */
public class MessageResponseTest {

	@Test
	public void testGetSuccessfulJsonResponse() {
		
		MessageResponse response = new MessageResponse();
		ResponseTO responseTo = new ResponseTO();
		List<String> results = new ArrayList<String>();
		results.add("EFSUpload");
		responseTo.setResults((ArrayList<String>) results);
		String result = response.getSuccessfulJsonResponse(responseTo);
		assertNotNull(result);
	}
	
	@Test
	public void testGetSuccessfulJsonResponseWithErrMsg() {
		
		MessageResponse response = new MessageResponse();
		ResponseTO responseTo = new ResponseTO();
		List<String> results = new ArrayList<String>();
		results.add("EFSUpload");
		responseTo.setResults((ArrayList<String>) results);
		responseTo.setErrorMsg("Failed to Process File");
		String result = response.getSuccessfulJsonResponse(responseTo);
		assertNotNull(result);
	}

}
