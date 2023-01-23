//Write a program to give the following output for the given input:
//        Eg 1:  Input: a1b10
//        Output: abbbbbbbbbb
//        Eg: 2:  Input: b3c6d15
//        Output: bbbccccccddddddddddddddd
//        The number varies from 1 to 99.

import java.util.Scanner;

public class Question53 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String ans  = "";
        int i = s.length()-1,len = s.length();
        while (i>=0){
            if (Character.isAlphabetic(s.charAt(i))){
                int num = Integer.parseInt(s.substring(i+1,len));
                for (int j = 0; j < num; j++) {
                    ans = s.charAt(i)+ans;
                }
                len = i;
            }
            i--;
        }
        System.out.println(ans);
    }
}
