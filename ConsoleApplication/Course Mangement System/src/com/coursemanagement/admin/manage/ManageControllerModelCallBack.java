package com.coursemanagement.admin.manage;

import com.coursemanagement.dto.Course;
import com.coursemanagement.dto.CourseBuyer;

import java.util.ArrayList;

public interface ManageControllerModelCallBack {
    void addCourse(String courseName, String courseDuration, String description, int courseFee);

    ArrayList<Course> viewCourse();

    void removeCourse(int courseID);

    ArrayList<CourseBuyer> courseBoughtDetails();
}
