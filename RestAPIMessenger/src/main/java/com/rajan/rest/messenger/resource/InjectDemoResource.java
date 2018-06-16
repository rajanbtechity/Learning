package com.rajan.rest.messenger.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	@GET
	@Path("/annotations")
	public String getParamsUsingAnnotations(
			@MatrixParam("param") String matrixParam,
			@HeaderParam("userInfo") String headerParam,
			@CookieParam("name") String cookieParam)
	{
		return "MatrixParam:"+matrixParam+" Header Param userInfo:"
	           +headerParam+" cookie param name:"+cookieParam;
	}
	
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriinfo,@Context HttpHeaders httpheaders)
	{
		String path=uriinfo.getAbsolutePath().toString();
		return "Absolute Path:"+path+" userInfo Header:"+httpheaders.getHeaderString("userInfo");
		
	}

}
