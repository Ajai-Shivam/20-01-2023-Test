package com.coursemanagement.admin.manage;

import com.coursemanagement.admin.AdminView;
import com.coursemanagement.dto.Course;
import com.coursemanagement.dto.CourseBuyer;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageView implements ManageControllerViewCallBack{
    private AdminView adminView;
    private ManageViewControllerCallBack manageController;
    private Scanner sc = new Scanner(System.in);
    public ManageView(AdminView adminView) {
        this.adminView = adminView;
        manageController = new ManageController(this);
    }

    public void manageDisplay(){
        System.out.println("\n\t<---- Manage Courses ---->");
        System.out.println("Press 1 --> Add Course");
        System.out.println("Press 2 --> Remove Course");
        System.out.println("Press 3 --> View Courses");
        System.out.println("Press 4 --> Course Bought Details");
        System.out.println("Press 0 --> Go Back");
        int option = sc.nextInt();
        switch (option){
            case 0 :
                adminView.adminDisplay();
                break;
            case 1:
                addCourse();
                break;
                case 2:
                    removeCourse();
                    break;
            case 3:
                ViewCourses();
                    break;
            case 4:
                courseBoughtDetails();
                break;

        }
    }

    private void courseBoughtDetails() {
        ArrayList<CourseBuyer> courseBuyers = manageController.courseBoughtDetails();
        if(courseBuyers.size()==0){
            System.out.println("No One Buyed The Course Yet");
        }else{
            System.out.printf("\n%-6s%-20s%-20s%-20s%-20s%-20s%-20s%-20s","userID","UserName","Phone Number","Email","courseID","Course Name","Course Duration","Course Fee");
            for (int i = 0; i < courseBuyers.size(); i++) {
                System.out.printf("\n%-6s%-20s%-20s%-20s%-20s%-20s%-20s%-20s",courseBuyers.get(i).getUserID(),courseBuyers.get(i).getUserName(),courseBuyers.get(i).getPhonenumber(),courseBuyers.get(i).getEmail(),courseBuyers.get(i).getCourseID(),courseBuyers.get(i).getCourseName(),courseBuyers.get(i).getCourseName(),courseBuyers.get(i).getCourseDuration(),courseBuyers.get(i).getCourseFee());
            }
        }
    }

    private void ViewCourses() {
        ArrayList<Course> coursesDetails = manageController.viewCourse();
        System.out.printf("\n%-25s%-25s%-30s%-25s","Course ID","Course Name","Course Duration","Description","Course Fee");
        for (int i = 0; i < coursesDetails.size(); i++) {
            System.out.printf("\n%-25s%-25s%-30s%-25s",coursesDetails.get(i).getCourseID(),coursesDetails.get(i).getCourseName(),coursesDetails.get(i).getCourseDuration(),coursesDetails.get(i).getDescription(),coursesDetails.get(i).getCourseFee());
        }
        System.out.println("\nPress 0 --> Go Back");
        System.out.println("Press 9 --> Exit");
        int option = sc.nextInt();
        if(option == 0){
            manageDisplay();
        } else if (option == 9) {
            System.out.println("Thank You For Visiting Hogward's Course Management");
        }
    }

    private void removeCourse() {
        System.out.println("<---- Remove Course ---->");
        System.out.print("\nEnter Course ID : ");
        int courseID = sc.nextInt();
        System.out.println("Press 1 --> Conform");
        System.out.println("Press 0 --> Back");
        int option = sc.nextInt();
        if(option == 1){
            manageController.removeCourse(courseID);
        }else{
            manageDisplay();
        }
    }
    private void addCourse() {
        System.out.println("<---- Add Course ---->");
        System.out.print("\nEnter Course Name : ");
        String courseName  = sc.next();
        System.out.print("\nEnter Course Duration : ");
        String courseDuration = sc.next();
        System.out.print("\nGive Description About the Course : ");
        String description = sc.next();
        System.out.print("\nEnter Course Fee : ");
        int CourseFee = sc.nextInt();
        System.out.println("Press 1 --> Conform");
        System.out.println("Press 0 --> Back");
        int option = sc.nextInt();
        if(option == 1){
            manageController.addCourse(courseName,courseDuration,description,CourseFee);
        }else{
            manageDisplay();
        }
    }
    public void courseAddedResult(String course_added_successfully) {
        System.out.println(course_added_successfully);
        manageDisplay();
    }
    public void removeCourseResult(String s) {
        System.out.println(s);
        System.out.println("Press 0 --> Go Back");
        System.out.println("Press 9 --> Exit");
        int option = sc.nextInt();
        if(option == 0){
            manageDisplay();
        } else if (option == 9) {
            System.out.println("Thank You For Visiting Hogward's Course Management");
        }
    }
}
