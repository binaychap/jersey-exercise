package com.binay.repository;

import java.util.List;

import com.binay.model.Activity;

public interface ActivityRepository {

	List<Activity> findAllActivities();

	Activity findAllActivity(String activityId);

}