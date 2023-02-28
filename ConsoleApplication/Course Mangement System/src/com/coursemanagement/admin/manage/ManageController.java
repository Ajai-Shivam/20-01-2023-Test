package com.coursemanagement.admin.manage;

import com.coursemanagement.dto.Course;
import com.coursemanagement.dto.CourseBuyer;

import java.util.ArrayList;

public class ManageController implements ManageViewControllerCallBack,ManageModelControllerCallBack{
    private ManageControllerModelCallBack manageModel;
    private ManageControllerViewCallBack manageView;
    public ManageController(ManageView manageView) {
        this.manageView = manageView;
        manageModel = new ManageModel(this);
    }

    public void addCourse(String courseName, String courseDuration, String description, int courseFee) {
        manageModel.addCourse(courseName, courseDuration, description, courseFee);
    }

    public void courseAddedResult(String course_added_successfully) {
        manageView.courseAddedResult(course_added_successfully);
    }

    public ArrayList<Course> viewCourse() {
        ArrayList<Course> courseDetails = manageModel.viewCourse();
        return courseDetails;
    }

    public void removeCourse(int courseID) {
        manageModel.removeCourse(courseID);
    }

    public void removeCourseResult(String s) {
        manageView.removeCourseResult(s);
    }

    public ArrayList<CourseBuyer> courseBoughtDetails() {
        ArrayList<CourseBuyer>  courseBuyers = manageModel.courseBoughtDetails();
        return courseBuyers;
    }
}
