package com.binay;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.binay.model.Activity;
import com.binay.model.User;
import com.binay.repository.ActivityRepository;
import com.binay.repository.ActivityRepositoryStub;

@Path("activities") // http:localhost:8080/exercise-services/webapi/activities
public class ActivityResource {

	private ActivityRepository activityRepository = new ActivityRepositoryStub();

	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Activity createActivity(Activity activity) {
		System.out.println(activity.getDescription());
		System.out.println(activity.getDuration());
		activityRepository.create(activity);
		return activity;
	}

	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Activity createActivityParams(MultivaluedMap<String, String> formParams) {
		Activity activity = new Activity();
		activity.setDescription(formParams.getFirst("description"));
		activity.setDuration(Integer.parseInt(formParams.getFirst("duration")));
		activityRepository.create(activity);
		return activity;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Activity> getAllActivities() {
		return activityRepository.findAllActivities();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("{activityId}")
	public Response getAllActivity(@PathParam("activityId") String activityId) {
		if (activityId == null || activityId.length() < 4) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		Activity activity = activityRepository.findAllActivity(activityId);
		if (activity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok().entity(activity).build();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("{activityId}/user")
	public User getAllActivityUser(@PathParam("activityId") String activityId) {
		return activityRepository.findAllActivity(activityId).getUser();
	}

}
