package com.coursemanagement.admin.manage;

import com.coursemanagement.dto.Course;
import com.coursemanagement.dto.CourseBuyer;
import com.coursemanagement.repository.Repository;

import java.util.ArrayList;

public class ManageModel implements ManageControllerModelCallBack{
    private ManageModelControllerCallBack manageController;
    private Repository instance;
    public ManageModel(ManageController manageController) {
        this.manageController = manageController;
        instance = Repository.getInstance();
    }
    public void addCourse(String courseName, String courseDuration, String description, int courseFee) {
        boolean addedCourse = instance.addCourse(courseName, courseDuration, description, courseFee);
        if(addedCourse){
            manageController.courseAddedResult("Course Added Successfully");
        }else{
            manageController.courseAddedResult("Course Was Already Exist Try Some Other");
        }
    }
    public ArrayList<Course> viewCourse() {
        ArrayList<Course> coursesDetails = instance.viewCourse();
        return coursesDetails;
    }
    public void removeCourse(int courseID) {
        if(instance.removeCourse(courseID)){
            manageController.removeCourseResult("Course Was Deleted Successfully");
        }else{
            manageController.removeCourseResult("Course ID Was Invalid !");
        }
    }
    public ArrayList<CourseBuyer> courseBoughtDetails() {
        ArrayList<CourseBuyer>  courseBuyers = instance.courseBoughtDetails();
        return courseBuyers;
    }
}
