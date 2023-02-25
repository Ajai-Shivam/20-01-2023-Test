package com.thirukuralapplcation.welcome;

import com.thirukuralapplcation.getthirukkural.GetThirukkuralView;

import com.thirukuralapplcation.randomthirukural.RandomThirukkuralView;
import com.thirukuralapplcation.searchadhigaram.SearchAdhiKaramView;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class WelcomeView{
    private WelcomeGetThiruCallBack getThirukkuralView;
    private WelcomeSearchCallBack searchAdhiKaramView;
    private WelcomeRandomCallBack randomThirukkuralView;
    public WelcomeView() throws IOException, ParseException {
        searchAdhiKaramView = new SearchAdhiKaramView(this);
        getThirukkuralView = new GetThirukkuralView(this);
        randomThirukkuralView = new RandomThirukkuralView(this);
        welcomeDisplay();
    }
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ParseException {
        WelcomeView welcomeView = new WelcomeView();
    }
    public void welcomeDisplay(){
        System.out.println("<---- Thiruvalluvar'in Thirukkural Application ---->");
        System.out.println("\nதமிழுக்கு எண் 1ஐ அழுத்தவும்");
        System.out.println("\nPress 2 --> English");
        System.out.println("\nPress 0 --> Exit");
        int option = sc.nextInt();

        switch (option){
            case 1:
                tamilLanguage();
                break;
            case 2:
                englishLanguage();
                break;
            case 0:
                System.out.println("Thank You For Visting Thiruvalluvar'in Thirukkural Application");
                break;
            default:
                System.out.println("\nEnter A Valid Option !");
                welcomeDisplay();
        }
    }

    public void englishLanguage() {
        System.out.println("\nPress 1 --> Thirukkural !");
        System.out.println("\nPress 2 --> Adhikaram !");
        System.out.println("\nPress 3 --> Today's Kural");
        System.out.println("\nPress 0 --> Back");
        int option = sc.nextInt();
        switch (option){
            case 1:
                getThirukkuralView.getThirukkuralDisplayEnglish();
                break;
            case 2:
                searchAdhiKaramView.searchAdhikaramDisplayEnglish();
                break;
            case 3:
                randomThirukkuralView.getRandomThirukkuralDisplayEnglish();
                break;
                case 0 :
                welcomeDisplay();
                break;
            default:
                System.out.println("\nEnter A Valid Option !");
                englishLanguage();
        }
    }


    public void tamilLanguage(){
        System.out.println("\nதிருக்குறளுக்கு 1ஐ அழுத்தவும்");
        System.out.println("\nஅதிகாரம் பெற 2ஐ அழுத்தவும்");
        System.out.println("\nஇன்றைய திருக்குறள் பெற 3ஐ அழுத்தவும்");
        System.out.println("\nதிரும்பிச் செல்ல 0ஐ அழுத்தவும்");
        int option = sc.nextInt();
        switch (option){
            case 1:
                getThirukkuralView.getThirukkuralDisplayTamil();
                break;
            case 2:
                searchAdhiKaramView.searchAdhikaramDisplayTamil();
                break;
            case 3:
                randomThirukkuralView.getRandomThirukkuralDisplayTamil();
                break;
            case 0 :
                welcomeDisplay();
                break;
            default:
                System.out.println("\nEnter A Valid Option !");
                tamilLanguage();
        }
    }


}
