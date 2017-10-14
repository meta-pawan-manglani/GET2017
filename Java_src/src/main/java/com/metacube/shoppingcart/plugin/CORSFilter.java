package com.metacube.shoppingcart.plugin;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

/**
 *  @author Pawan Manglani
 *  @version 1.1 27-Sep-2017
 * 
 * The Class CORSFilter.
 */
public class CORSFilter implements ContainerResponseFilter {

	/* (non-Javadoc)
	 * @see com.sun.jersey.spi.container.ContainerResponseFilter#filter(com.sun.jersey.spi.container.ContainerRequest, com.sun.jersey.spi.container.ContainerResponse)
	 */
	@Override
	public ContainerResponse filter(ContainerRequest request,
			ContainerResponse response) {

		response.getHttpHeaders().add("Access-Control-Allow-Origin", "*");
		response.getHttpHeaders().add("Access-Control-Allow-Headers",
				"origin, content-type, accept, authorization");
		response.getHttpHeaders().add("Access-Control-Allow-Credentials",
				"true");
		response.getHttpHeaders().add("Access-Control-Allow-Methods",
				"GET, POST, PUT, DELETE, OPTIONS, HEAD");

		return response;
	}
}