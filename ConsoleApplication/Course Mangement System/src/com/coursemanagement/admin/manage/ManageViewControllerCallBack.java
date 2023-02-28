package com.coursemanagement.admin.manage;

import com.coursemanagement.dto.Course;
import com.coursemanagement.dto.CourseBuyer;

import java.util.ArrayList;

public interface ManageViewControllerCallBack {
    ArrayList<CourseBuyer> courseBoughtDetails();

    ArrayList<Course> viewCourse();

    void removeCourse(int courseID);

    void addCourse(String courseName, String courseDuration, String description, int courseFee);
}
