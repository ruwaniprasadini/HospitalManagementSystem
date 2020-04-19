package com;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.core.Response;

import com.sun.jersey.core.util.Base64;
import com.sun.jersey.spi.container.ContainerRequestFilter;

public class SecurityFilter implements ContainerRequestFilter {
	
	private static final String AUTH_HEADER_KEY = "Authorization";
	private static final String AUTH_HEADER_PREFIX = "Basic ";
	private static final String SECURE_URL_PREFIX = "";
	
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if (requestContext.getUriInfo().getPath().contains(SECURE_URL_PREFIX)) {
			List<String> authHeader = requestContext.getHeaders().get(AUTH_HEADER_KEY);
			if (authHeader != null && authHeader.size() > 0) {
				String authTocken = authHeader.get(0);
				authTocken = authTocken.replaceFirst(AUTH_HEADER_PREFIX, "");
				String decodeString = Base64.decodeAsString(authTocken);
				StringTokenizer tockenizer = new StringTokenizer(decodeString, ":");
				String username = tockenizer.nextToken();
				String password = tockenizer.nextToken();
				
				if ("Patient".equals(username) && "pass".equals(password)) {
					return ;
				}
			}
			
			Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED).entity("User cannot access").build();
			requestContext.abortWith(unauthorizedStatus);
		}
		
	}


	

}
