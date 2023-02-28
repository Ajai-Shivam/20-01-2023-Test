package com.coursemanagement.dto;

public class Course {
    private int CourseID;
    private String courseName;
    private String courseDuration;
    private String Description;
    private int courseFee;


    public Course(int courseID, String courseName, String courseDuration, String description, int courseFee) {
        CourseID = courseID;
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        Description = description;
        this.courseFee = courseFee;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public int getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(int courseFee) {
        this.courseFee = courseFee;
    }
}
