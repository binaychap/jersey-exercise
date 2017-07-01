package com.binay;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.binay.model.Activity;
import com.binay.model.User;
import com.binay.repository.ActivityRepository;
import com.binay.repository.ActivityRepositoryStub;

@Path("activities") // http:localhost:8080/exercise-services/webapi/activities
public class ActivityResource {

	private ActivityRepository activityRepository = new ActivityRepositoryStub();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Activity> getAllActivities() {
		return activityRepository.findAllActivities();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("{activityId}")
	public Activity getAllActivity(@PathParam("activityId") String activityId) {
		return activityRepository.findAllActivity(activityId);
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("{activityId}/user")
	public User getAllActivityUser(@PathParam("activityId") String activityId) {
		return activityRepository.findAllActivity(activityId).getUser();
	}

}
