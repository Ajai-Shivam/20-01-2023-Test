package com.thirukuralapplcation.randomthirukural;

import com.thirukuralapplcation.welcome.WelcomeRandomCallBack;
import com.thirukuralapplcation.welcome.WelcomeView;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class RandomThirukkuralView implements WelcomeRandomCallBack,RandomControllerViewCallBack {
    private Scanner sc = new Scanner(System.in);
    private WelcomeView welcomeView;
    private RandomViewControllerCallBack randomThirukkuralController;
    public RandomThirukkuralView(WelcomeView welcomeView) throws IOException, ParseException {
        this.welcomeView = welcomeView;
         randomThirukkuralController = new RandomThirukkuralController(this);
    }

    public void getRandomThirukkuralDisplayTamil() {
        randomThirukkuralController.getRandomThirukkuralTamil((int)(Math.random() * 1333 +1));
    }

    public void getRandomThirukkuralDisplayEnglish() {
        randomThirukkuralController.getRandomThirukkuralEnglish((int)(Math.random() * 1333 +1));
    }

    public void getRandomSuccesfull(JSONObject randomThirukkural) {
        System.out.println();
        System.out.println("\t-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("\t| Thirukkural Number : %-179d|",randomThirukkural.get("Number"));
        System.out.printf("\n\t| %-200s|","");
        System.out.printf("\n\t| %-200s|",randomThirukkural.get("transliteration1"));
        System.out.printf("\n\t| %-200s|",randomThirukkural.get("transliteration2"));
        System.out.printf("\n\t| %-200s|","");
        System.out.printf("\n\t| %-200s|","Explanation :");
        System.out.printf("\n\t| %-200s|","");
        System.out.printf("\n\t| %-200s|",randomThirukkural.get("explanation"));
        System.out.println("\n\t-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("\n Press 0 to Back");
        System.out.println("\n Press 1 to Exit");
        int n = sc.nextInt();
        if(n == 0){
            welcomeView.englishLanguage();
        }else{
            System.out.println("\n Thank You For Visting Thiruvalluvar'in Thirukkural Application");
        }
    }

    public void getRandomTamilSuccesfull(JSONObject randomThirukkural) {
        System.out.println();
        System.out.println("\t-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("\t| திருக்குறள் என் : %-183d|",randomThirukkural.get("Number"));
        System.out.printf("\n\t| %-200s|","");
        System.out.printf("\n\t| %-200s|",randomThirukkural.get("Line1"));
        System.out.printf("\n\t| %-200s|",randomThirukkural.get("Line2"));
        System.out.printf("\n\t| %-200s|","");
        System.out.printf("\n\t| %-200s|","விளக்கம் :");
        System.out.printf("\n\t| %-200s|","");
        System.out.printf("\n\t| %-200s|",randomThirukkural.get("mv"));
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
