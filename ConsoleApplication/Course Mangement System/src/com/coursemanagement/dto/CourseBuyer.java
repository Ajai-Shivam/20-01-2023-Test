package com.coursemanagement.dto;

public class CourseBuyer {
    private int userID;
    private String UserName;
    private long phonenumber;
    private String email;
    private int courseID;

    private String courseName;
    private int CourseFee;
    private String courseDuration;
    public CourseBuyer(int userID, String userName, long phonenumber, String email, int courseID, String courseName, String courseDuration, int courseFee) {
        this.userID = userID;
        UserName = userName;
        this.phonenumber = phonenumber;
        this.email = email;
        this.courseID = courseID;
        this.courseName = courseName;
        this.CourseFee = courseFee;
        this.courseDuration = courseDuration;
    }



    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseFee() {
        return CourseFee;
    }

    public void setCourseFee(int courseFee) {
        CourseFee = courseFee;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }
}
