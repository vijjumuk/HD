package com.homedepot.di.xd.efs.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.homedepot.di.xd.efs.businesshelper.ReportTypeManager;
import com.homedepot.di.xd.efs.constants.EFSConstants;
import com.homedepot.di.xd.efs.exception.ApplicationException;
import com.homedepot.di.xd.efs.to.ReportTypeTO;


@Path("/reportTypes")
public class ReportTypeService {

	private static final Logger LOGGER = Logger.getLogger(ReportTypeService.class);
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getProjects(@Context HttpServletRequest request) throws ApplicationException{
		
		try{
			List<ReportTypeTO> reportTypesList = ReportTypeManager.getReportTypeCodes();
			return Response.status(200).entity(new GenericEntity<List<ReportTypeTO>>(reportTypesList) {}).build();
		}
		catch(Exception e){
			LOGGER.error(e.getMessage(), e);
			throw new ApplicationException(500, EFSConstants.GET_ALL_REPORT_TYPES_ERROR_CODE, e.getMessage(), e.getMessage());
		}
		
	}
}
