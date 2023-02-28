package com.coursemanagement.login.enroll;

import com.coursemanagement.dto.Course;
import com.coursemanagement.dto.CourseBuyer;

import java.util.ArrayList;

public class EnrollController implements EnrollViewControllerCallBack,EnrollModelControllerCallBack{
    private EnrollControllerViewCallBack enrollView;
    private EnrollControllerModelCallBack enrollModel;
    public EnrollController(EnrollView enrollView) {
        this.enrollView = enrollView;
        enrollModel = new EnrollModel(this);
    }

    public ArrayList<Course> showAvailableCourse() {
        ArrayList<Course> courseDetails = enrollModel.showAvailableCourse();
        return courseDetails;
    }

    public void buyCourse(String courseName) {
        enrollModel.buyCourse(courseName);
    }

    public void courseBuyed(String courseName) {
        enrollView.courseBuyed(courseName);
    }

    public ArrayList<CourseBuyer> yourCourse() {
        ArrayList<CourseBuyer> courseBuyers = enrollModel.yourCourse();
        return courseBuyers;
    }
}
