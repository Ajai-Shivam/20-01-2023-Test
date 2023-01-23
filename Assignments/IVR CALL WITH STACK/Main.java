import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static Stack<Main> ForBack = new Stack<Main>();
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Main obj0 = new Main();
        ForBack.push(obj0);
        obj0.display();

    }
    public void display(){
        System.out.println("\tWelcome To Ajai Cellular");
        System.out.println("1.Press 1 to Continue");
        System.out.println("2.Press 0 to Exit");
        System.out.print("Enter a Number : ");
        int n = sc.nextInt();
        if(n==1){
            Mainmenu obj1 = new Mainmenu();
            ForBack.push(obj1);
            obj1.display();
        } else if (n==0) {
            System.out.println("thank You Visiting Ajai Cellular.");
        }else{
            System.out.println("Invalid Entry! Choose Different Option");
        }
    }
}
