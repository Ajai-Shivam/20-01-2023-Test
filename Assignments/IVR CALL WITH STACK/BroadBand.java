public class BroadBand extends Main{
    public  void display(){
        System.out.println("\tBoardBand Connection");
        System.out.println("1.DSL");
        System.out.println("2.BPL");
        System.out.println("3.Wire Less");
        System.out.println("4.Fiber Cable");
        System.out.println("5.Cable Modem");
        System.out.println("9.Back");
        input();
    }
    public void input(){
        int n = sc.nextInt();
        switch (n){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Enter Your Ten Digit Phone Number : ");
                long number = sc.nextLong();
                System.out.println("Our Sale Executive Will Contact To Your Phone Number : "+number+" Regarding Broadband Connection Within 24 hour.");
                System.out.println("Thank You");
                break;
            case 9:
                ForBack.pop();
                Main obj = ForBack.peek();
                obj.display();
                break;
        }
    }


}
