//.Java Program to find the given two strings are anagram to each other

import java.util.Arrays;
import java.util.Scanner;

public class Question94 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        if(str1.length() == str2.length()) {
            char[] arr1 = str1.toCharArray();
            char[] arr2 = str2.toCharArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            boolean result = Arrays.equals(arr1,arr2);
            if(result) {
                System.out.println(str1 + " and " + str2 + " are anagram.");
            }
            else {
                System.out.println(str1 + " and " + str2 + " are not anagram.");
            }
        }
        else {
            System.out.println(str1 + " and " + str2 + " are not anagram.");
        }
        method2(str1,str2);

    }
    public static void method2(String str1,String str2){
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        if(areAnagram(arr1,arr2)){
            System.out.println("The Two String Are Anagaram");
        }else{
            System.out.println("The Two String Are Not Anagaram");
        }
    }
    static boolean areAnagram(char str1[], char str2[])
    {
        int nc = 256;
        int count1[] = new int[nc];
        Arrays.fill(count1, 0);
        int count2[] = new int[nc];
        Arrays.fill(count2, 0);
        int i;
        for (i = 0; i < str1.length && i < str2.length;
             i++) {
            count1[str1[i]]++;
            count2[str2[i]]++;
        }
        if (str1.length != str2.length)
            return false;
        for (i = 0; i < nc; i++)
            if (count1[i] != count2[i])
                return false;

        return true;
    }
}
