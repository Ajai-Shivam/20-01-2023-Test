public class NetworkRelated extends Main{
     public void display(){
         System.out.println("Enter Your Mobile Number : ");
         long number = sc.nextLong();
         System.out.println("You will Contacted By Our Customer Care Support Within 1 Hours");
         System.out.println("Press 9 to Back");
         System.out.println("Press 0 to Exit");
         int n = sc.nextInt();
         if(n==9){
             ForBack.pop();
             Main obj = ForBack.peek();
             obj.display();

         }else if (n==0){
             System.out.println("Thank you Vist again");
         }else{
             System.out.println("Invalid input !");
         }

     }

}
