package com.binay.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.binay.model.Activity;

public class ActivityClient {

	private Client client;

	public ActivityClient() {
		client = ClientBuilder.newClient();
	}

	public Activity get(String id) {
		// http://localhost:8080/exercise-services/webapi/activities/123
		WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");
		Activity response = target.path("activities/" + id).request().get(Activity.class);
		//String response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(String.class);
		//System.out.println(response);
		return response;

	}
	
	public List<Activity> get(){
		WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");
		List<Activity> response = target.path("activities").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>(){});
		
		return response;
	}

}
