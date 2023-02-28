package com.coursemanagement.login.enroll;

import com.coursemanagement.dto.Course;
import com.coursemanagement.dto.CourseBuyer;
import com.coursemanagement.repository.Repository;

import java.util.ArrayList;

public class EnrollModel implements EnrollControllerModelCallBack{
    private EnrollModelControllerCallBack enrollController;
    private Repository instance;
    public EnrollModel(EnrollController enrollController) {
        this.enrollController = enrollController;
        instance = Repository.getInstance();
    }

    public ArrayList<Course> showAvailableCourse() {
        ArrayList<Course> courseDetails = instance.showAvailableCourse();
        return courseDetails;
    }
    public void buyCourse(String courseName) {
        if(instance.buyCourse(courseName)){
            enrollController.courseBuyed(courseName);
        }
    }

    public ArrayList<CourseBuyer> yourCourse() {
        ArrayList<CourseBuyer> courseBuyers = instance.yourCourse();
        return courseBuyers;
    }
}
