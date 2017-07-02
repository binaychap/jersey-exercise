package com.binay.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.binay.model.Activity;

public class ActivityClient {

	private Client client;
	private static final String URL = "http://localhost:8080/exercise-services/webapi/";

	public ActivityClient() {
		client = ClientBuilder.newClient();
	}

	public Activity get(String id) {
		// http://localhost:8080/exercise-services/webapi/activities/123
		WebTarget target = client.target(URL);
		Response response = target.path("activities/" + id).request().get(Response.class);
		//String response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(String.class);
		//System.out.println(response);
		if(response.getStatus() != 200){
			throw new RuntimeException(response.getStatus() +": there was an error on the server");
		}
		return response.readEntity(Activity.class);

	}
	
	public List<Activity> get(){
		WebTarget target = client.target(URL);
		List<Activity> response = target.path("activities").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>(){});
		return response;
	}

}
