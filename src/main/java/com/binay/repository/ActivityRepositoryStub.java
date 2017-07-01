package com.binay.repository;

import java.util.ArrayList;
import java.util.List;

import com.binay.model.Activity;
import com.binay.model.User;

public class ActivityRepositoryStub implements ActivityRepository {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.binay.repository.ActivityRepository#findAllActivities()
	 */
	@Override
	public List<Activity> findAllActivities() {
		List<Activity> activities = new ArrayList<Activity>();

		Activity activity1 = new Activity();
		activity1.setDescription("Swimming");
		activity1.setDuration(55);
		activities.add(activity1);

		Activity activity2 = new Activity();
		activity2.setDescription("Cycling");
		activity2.setDuration(120);
		activities.add(activity2);

		return activities;
	}

	@Override
	public Activity findAllActivity(String activityId) {
		Activity activity1 = new Activity();
		activity1.setId("123");
		activity1.setDescription("Swimming");
		activity1.setDuration(55);
		User user = new User();
		user.setId("1234");
		user.setName("binay");
		activity1.setUser(user);
		return activity1;
	}
}
