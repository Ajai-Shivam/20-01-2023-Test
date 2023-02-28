package com.coursemanagement.login.enroll;

import com.coursemanagement.dto.Course;
import com.coursemanagement.dto.CourseBuyer;

import java.util.ArrayList;

public interface EnrollViewControllerCallBack {
    ArrayList<CourseBuyer> yourCourse();

    ArrayList<Course> showAvailableCourse();

    void buyCourse(String courseName);
}
