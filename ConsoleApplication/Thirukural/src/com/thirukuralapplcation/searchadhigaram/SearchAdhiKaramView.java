package com.thirukuralapplcation.searchadhigaram;

import com.thirukuralapplcation.welcome.WelcomeSearchCallBack;
import com.thirukuralapplcation.welcome.WelcomeView;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class SearchAdhiKaramView implements WelcomeSearchCallBack,SearchControllerViewCallBack {
    private WelcomeView welcomeView;
    private SearchAdhiKaramController searchAdhiKaramController;
    private Scanner sc = new Scanner(System.in);

    public SearchAdhiKaramView(WelcomeView welcomeView) throws IOException, ParseException {
        this.welcomeView = welcomeView;
        searchAdhiKaramController = new SearchAdhiKaramController(this);
    }
    public void searchAdhikaramDisplayEnglish() {
        System.out.print("\nEnter Adhikaram Number ( 'Within 1-133' ) : ");
        int searchAdhikaramNumber = sc.nextInt();
        searchAdhiKaramController.getSearchAdhikaramEnglish(searchAdhikaramNumber);
    }

    public void searchAdhikaramDisplayTamil() {
        System.out.print("\n முதல் 133க்குள் ஒரு எண்ணைக் கொடுங்கள் : ");
        int searchAdhikaramNumber = sc.nextInt();
        searchAdhiKaramController.getSearchAdhikaramTamil(searchAdhikaramNumber);
    }
    public void getSearchAdhikaramSuccessful(JSONObject[] adhikaram) {
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<---- Thirukkural Adhikaram ---->");
        System.out.println();
        for (int i = 0; i < adhikaram.length; i++) {
            System.out.println("\t-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("\t| Thirukkural Number : %-179d|",adhikaram[i].get("Number"));
            System.out.printf("\n\t| %-200s|","");
            System.out.printf("\n\t| %-200s|",adhikaram[i].get("transliteration1"));
            System.out.printf("\n\t| %-200s|",adhikaram[i].get("transliteration2"));
            System.out.printf("\n\t| %-200s|","");
            System.out.printf("\n\t| %-200s|","Explanation :");
            System.out.printf("\n\t| %-200s|","");
            System.out.printf("\n\t| %-200s|",adhikaram[i].get("explanation"));
            System.out.println("\n\t-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
        System.out.println("\n Press 0 to Back");
        System.out.println("\n Press 1 to Exit");
        int n = sc.nextInt();
        if(n == 0){
            welcomeView.englishLanguage();
        }else{
            System.out.println("\n Thank You For Visting Thiruvalluvar'in Thirukkural Application");
        }
    }

    public void getSearchAdhikaramSuccessfulTamil(JSONObject[] adhikaram) {
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<---- திருக்குறள் அதிகாரம் ---->");
        System.out.println();
        for (int i = 0; i < adhikaram.length; i++) {
            System.out.println();
            System.out.println("\t-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("\t| திருக்குறள் என் : %-183d|", adhikaram[i].get("Number"));
            System.out.printf("\n\t| %-200s|", "");
            System.out.printf("\n\t| %-200s|", adhikaram[i].get("Line1"));
            System.out.printf("\n\t| %-200s|", adhikaram[i].get("Line2"));
            System.out.printf("\n\t| %-200s|", "");
            System.out.printf("\n\t| %-200s|", "விளக்கம் :");
            System.out.printf("\n\t| %-200s|", "");
            System.out.printf("\n\t| %-200s|", adhikaram[i].get("mv"));
            System.out.println("\n\t-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
        System.out.println("\n Press 0 to Back");
        System.out.println("\n Press 1 to Exit");
        int n = sc.nextInt();
            if(n == 0){
                welcomeView.tamilLanguage();
            }else{
                System.out.println("\n திருவள்ளுவரின் திருக்குறள் மென்பொருள் பார்வையிட்டதற்கு நன்றி");
            }
    }
    public void InvalidNumberEnglish(String give_a_valid_number) {
        System.out.println("\n"+give_a_valid_number);
        searchAdhikaramDisplayEnglish();
    }

    public void InvalidNumberTamil(String சரியான_எண்ணைக்_கொடுங்கள்) {
        System.out.println("\n"+சரியான_எண்ணைக்_கொடுங்கள்);
        searchAdhikaramDisplayTamil();
    }
}
