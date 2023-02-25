package com.thirukuralapplcation.getthirukkural;

import com.thirukuralapplcation.welcome.WelcomeGetThiruCallBack;
import com.thirukuralapplcation.welcome.WelcomeView;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class GetThirukkuralView implements WelcomeGetThiruCallBack,GetControllerViewCallBack {
    private WelcomeView welcomeView;
    private GetViewControllerCallBack getThirukkuralController;
    private Scanner sc = new Scanner(System.in);

    public GetThirukkuralView(WelcomeView welcomeView) throws IOException, ParseException {
        this.welcomeView = welcomeView;
        getThirukkuralController = new GetThirukkuralController(this);
    }

    public void getThirukkuralDisplayEnglish() {
        System.out.println("\n\t<---- Get Thirukkural ---->");
        System.out.print("\n Enter A Number (' Within 1 - 1330 ') : ");
        int thirukkuralnumber = sc.nextInt();
        getThirukkuralController.getThirukkuralEnglish(thirukkuralnumber);
    }

    public void getThirukkuralDisplayTamil() {
        System.out.println("\n\t<---- திருக்குறள் ---->");
        System.out.print("\n1 முதல் 1330 வரையிலான எண்ணைக் கொடுங்கள் : ");
        int thirukkuralnumber = sc.nextInt();
        getThirukkuralController.getThirukkuralTamil(thirukkuralnumber);
    }

    public void InvalidNumberEnglish(String give_a_valid_number) {
        System.out.println("\n" + give_a_valid_number);
        getThirukkuralDisplayEnglish();
    }

    public void InvalidNumberTamil(String சரியான_எண்ணைக்_கொடுங்கள்) {
        System.out.println("\n" + சரியான_எண்ணைக்_கொடுங்கள்);
        getThirukkuralDisplayTamil();
    }

    public void getThirukkuralSuccessFullEnglish(JSONObject thirukkural) {
        System.out.println();
        System.out.println("\t-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("\t| Thirukkural Number : %-179d|", thirukkural.get("Number"));
        System.out.printf("\n\t| %-200s|", "");
        System.out.printf("\n\t| %-200s|", thirukkural.get("transliteration1"));
        System.out.printf("\n\t| %-200s|", thirukkural.get("transliteration2"));
        System.out.printf("\n\t| %-200s|", "");
        System.out.printf("\n\t| %-200s|", "Explanation :");
        System.out.printf("\n\t| %-200s|", "");
        System.out.printf("\n\t| %-200s|", thirukkural.get("explanation"));
        System.out.println("\n\t-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\n Press 0 to Back");
        System.out.println("\n Press 1 to Exit");
        int n = sc.nextInt();
        if (n == 0) {
            welcomeView.englishLanguage();
        } else {
            System.out.println("\n Thank You For Visting Thiruvalluvar'in Thirukkural Application");
        }
    }

    public void getThirukkuralSuccessFullTamil(JSONObject thirukkural) {
        System.out.println();
        System.out.println("\t-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("\t| திருக்குறள் என் : %-183d|", thirukkural.get("Number"));
        System.out.printf("\n\t| %-200s|", "");
        System.out.printf("\n\t| %-200s|", thirukkural.get("Line1"));
        System.out.printf("\n\t| %-200s|", thirukkural.get("Line2"));
        System.out.printf("\n\t| %-200s|", "");
        System.out.printf("\n\t| %-200s|", "விளக்கம் :");
        System.out.printf("\n\t| %-200s|", "");
        System.out.printf("\n\t| %-200s|", thirukkural.get("mv"));
        System.out.println("\n\t-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\n Press 0 to Back");
        System.out.println("\n Press 1 to Exit");
        int n = sc.nextInt();
        if(n == 0){
            welcomeView.tamilLanguage();
        }else{
            System.out.println("\n திருவள்ளுவரின் திருக்குறள் மென்பொருள் பார்வையிட்டதற்கு நன்றி");
        }
    }
}
