package edu.pitt.sis.infsci2711.tutorial.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.pitt.sis.infsci2711.multidbs.utils.JerseyClientUtil;
import edu.pitt.sis.infsci2711.multidbs.utils.PropertiesManager;
import edu.pitt.sis.infsci2711.tutorial.viewModels.SomeViewModel;

@Path("Demo/")
public class DemoRestApi {
	
	@Path("helloWorld")
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response helloWorld() {
		return Response.status(200).entity("{\"msg\" : \"Hello World\"}").build();
	}
	
	
	@Path("helloWorld2")
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response helloWorld2() {
		
		// This will send GET request to 54.152.26.131:7654/datasources
		Response result = JerseyClientUtil.doGet(PropertiesManager.getInstance().getStringProperty("metastore.rest.base"),
				PropertiesManager.getInstance().getStringProperty("metastore.rest.getAllDatasources"));
		
		// do something with result if you needed
		
		//Can send another request. Here is example of POST
		
		Response result2 = JerseyClientUtil.doPost(PropertiesManager.getInstance().getStringProperty("metastore.rest.base"),
				PropertiesManager.getInstance().getStringProperty("metastore.rest.addDatasource"),
				new SomeViewModel(123));
		
		// do something with result2 if needed
		
		//finally send response to the client to their original request
		return Response.status(200).entity("{\"msg\" : \"Hello World\"}").build();
	}
}

