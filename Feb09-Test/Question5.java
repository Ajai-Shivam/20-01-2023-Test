import java.util.ArrayList;
import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String Org_Str = sc.next(); // Orginal String
        int T = sc.nextInt(); // Number of TestCases
        while (T>0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            String Pro_str = Org_Str.substring(l-1,r);
            char[] arr = Pro_str.toCharArray();
            Question5 obj = new Question5();
            ArrayList<String> palindromes = new ArrayList<>();
            int max = obj.helper(arr,palindromes);
            int count = 0;
            for (int i = 0; i < palindromes.size(); i++) {
                if(palindromes.get(i).length() == max){
                    count++;
                }
            }
            System.out.println(count);
            T--;
        }
    }
    public int helper (char[] arr, ArrayList<String>palindromes){  // For InterChanging the positons Of Character in the given String and Get the Max Length palindromic Substring
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j <arr.length ; j++) {
                if(i == j){
                    continue;
                }
                swap(arr,i,j);
                String check = toString(arr);
                for (int k = 0; k < check.length(); k++) {
                    int last_index = check.lastIndexOf(check.charAt(k));
                    if(last_index == k){
                        continue;
                    }
                    else {
                        if(ispalindrome(check.substring(k,last_index+1))){
                            if(palindromes.contains(check.substring(k,last_index+1))){
                                continue;
                            }
                            palindromes.add(check.substring(k,last_index+1));
                          maxLength =  Math.max(last_index+1-k,maxLength);
                        }
                    }
                }
                swap(arr,i,j);
            }
        }
        return maxLength;
    }
    public void swap (char[] arr,int i , int j){ // Swap The character in the String
        char temp  =arr[i];
        arr[i] =arr[j];
        arr[j] = temp;
    }
    public String toString(char[] arr){ // Converting  char Array to string
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            s.append(arr[i]);
        }
        return s.toString();
    }
    public boolean ispalindrome(String s){ // checking whether it is palindrome or not.
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        if(s.equals(sb.toString())){
            return true;
        }
        return false;
    }
}
