package com.coursemanagement.login.enroll;

import com.coursemanagement.dto.Course;
import com.coursemanagement.dto.CourseBuyer;
import com.coursemanagement.login.UserLoginView;

import java.util.ArrayList;
import java.util.Scanner;

public class EnrollView implements EnrollControllerViewCallBack{
    private EnrollViewControllerCallBack enrollController;
    private UserLoginView userLoginView;
    private Scanner sc = new Scanner(System.in);

    public EnrollView(UserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        enrollController = new EnrollController(this);
    }
    public void enrollDisplay(){
        System.out.println("\n\t<---- Enroll Panel ---->");
        System.out.println("Press 1 --> Enroll Course");
        System.out.println("Press 2 --> Your Course");
        System.out.println("Press 0 --> Go Back");
        int option = sc.nextInt();
        switch (option){
            case 0:
                userLoginView.userloginDisplay();
                break;
            case 1:
                enrollCourse();
                break;
            case 2:
                yourCourse();
                break;
        }
    }

    private void yourCourse() {
       ArrayList<CourseBuyer> details = enrollController.yourCourse();
       System.out.println("Your Course : ");
       System.out.println("\nCourseName\t\tCourse Fee\t\tStatus");
       for (int i = 0; i < details.size(); i++) {
           System.out.println(details.get(i).getCourseName()+"\t\t"+details.get(i).getCourseDuration()+"\t\t"+"Paid");
       }
        System.out.println("Press 0 --> Go Back");
        System.out.println("Press 9 --> Exit");
        int option = sc.nextInt();
        if(option == 0){
            enrollDisplay();
        } else if (option == 9) {
            System.out.println("Thank You For Visiting Hogward's Course Management");
        }
    }

    public void enrollCourse(){

        ArrayList<Course> courseDetails = enrollController.showAvailableCourse();
        System.out.printf("\n%-25s%-30s%-25s","Course Name","Course Duration","Description","Course Fee");
        for (int i = 0; i < courseDetails.size(); i++) {
            System.out.printf("\n%-25s%-30s%-25s",courseDetails.get(i).getCourseName(),courseDetails.get(i).getCourseDuration(),courseDetails.get(i).getDescription(),courseDetails.get(i).getCourseFee());
        }
        System.out.println();
        System.out.print("Enter Course Name : ");
        String courseName = sc.next();
        System.out.println("Press 1 --> Buy Course");
        System.out.println("Press 0 --> Back");
        int option = sc.nextInt();
        if(option == 1){
           enrollController.buyCourse(courseName);
        }else{
            userLoginView.userloginDisplay();
        }
    }
    public void courseBuyed(String courseName) {
        System.out.printf(courseName+" Was Buyed !");
        System.out.println("Press 0 --> Go Back");
        System.out.println("Press 9 --> Exit");
        int option = sc.nextInt();
        if(option == 0){
            enrollDisplay();
        } else if (option == 9) {
            System.out.println("Thank You For Visiting Hogward's Course Management");
        }
    }
}
