package com.coursemanagement.repository;
import com.coursemanagement.dto.Course;
import com.coursemanagement.dto.CourseBuyer;
import com.coursemanagement.dto.User;

import java.util.ArrayList;

public class Repository {
    private User user;
    private static  int userIDGenerate = 1;
    private static int courseIDGenerator = 1000;
    private Repository() {
        defaultInitailisation();
    }

    private void defaultInitailisation() {
        usersDetails.add(new User(userIDGenerate++,"Admin",637428867,"Admin@gmail.com","Admin",true));
        usersDetails.add(new User(userIDGenerate++,"Ajai",957822023,"Ajai@gmail.com","Ajai",false));
        coursesDetails.add(new Course(courseIDGenerator++,"Full Stack Development","6Months","How To Build A Web Application From End To End",60000));
        coursesDetails.add(new Course(courseIDGenerator++,"Core Java","3Months","Basic Java And Advance Java",20000));
    }

    private static Repository instance;
    private ArrayList<User> usersDetails = new ArrayList<>();
    private ArrayList<Course> coursesDetails = new ArrayList<>();
    private ArrayList<CourseBuyer> courseBuyersDetails = new ArrayList<>();

    public static Repository getInstance() {
        if(instance!= null){
            return instance;
        }
        instance = new Repository();
        return instance;
    }

    /* Check Admin Credentials*/
    public boolean checkValidAdmin(String userName, String passWord){
        for (User user : usersDetails) {
            if(user.getUserName().equals(userName) && user.getPassword().equals(passWord) && user.isAdmin()){
                return true;
            }
        }
        return false;
    }
    /*------------------------*/

    public boolean addCourse(String courseName, String courseDuration, String description, int courseFee) {
        for (int i = 0; i < coursesDetails.size(); i++) {
            if(coursesDetails.get(i).getCourseName().equals(courseName)){
                return false;
            }
        }
        coursesDetails.add(new Course(courseIDGenerator++,courseName, courseDuration, description, courseFee));
        return true;
    }
    public ArrayList<Course> viewCourse() {
        return coursesDetails;
    }
    public boolean removeCourse(int courseID) {
        for (int i = 0; i < coursesDetails.size(); i++) {
            if(coursesDetails.get(i).getCourseID()==courseID){
                coursesDetails.remove(i);
                return true;
            }
        }
        return false;
    }
    public ArrayList<CourseBuyer> courseBoughtDetails() {
        return courseBuyersDetails;
    }

    public boolean checkValidUser(String userName, String passWord) {
        for (int i = 0; i < usersDetails.size(); i++) {
            if(usersDetails.get(i).getUserName().equals(userName) && usersDetails.get(i).getPassword().equals(passWord) && usersDetails.get(i).isAdmin()==false){
                this.user = usersDetails.get(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Course> showAvailableCourse() {
        return coursesDetails;
    }
    public boolean buyCourse(String courseName) {
        Course course = null;
        for (int i = 0; i < coursesDetails.size(); i++) {
            if(coursesDetails.get(i).getCourseName().equals(courseName)){
                course = coursesDetails.get(i);
                break;
            }
        }
        courseBuyersDetails.add(new CourseBuyer(user.getUserID(),user.getUserName(),user.getPhoneNumber(),user.getEmail(),course.getCourseID(),course.getCourseName(),course.getCourseDuration(),course.getCourseFee()));
        return true;
    }

    public ArrayList<CourseBuyer> yourCourse() {
        ArrayList<CourseBuyer> courseBuyers = new ArrayList<>();
        for (int i = 0; i < courseBuyersDetails.size(); i++) {
            if(user.getUserID() == courseBuyers.get(i).getUserID()){
                courseBuyers.add(courseBuyers.get(i));
            }
        }
    return courseBuyers;
    }
}
