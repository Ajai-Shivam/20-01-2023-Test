public class CheckBalance extends Main{
public void display(){
    System.out.println("Available Balance : 126.43 Rupees");
    System.out.println("Enter 9 For Back");
    System.out.println("Enter 0 For Exit");
    int n = sc.nextInt();
    if(n==9){
        ForBack.pop();
        Main obj = ForBack.peek();
        obj.display();
    }else{
        System.out.println("Thankyou Vist Again");
    }

}
}
