public class SetCallerTune extends Main{
    public  void display(){
        System.out.println("\tSet Caller Tune");
        System.out.println("Choose the Song language : ");
        System.out.println("1.Tamil");
        System.out.println("2.English");
        System.out.println("3.Hindi");
        System.out.println("4.Telugu");
        System.out.println("5.Malayalam");
        System.out.println("9.Back");
        input();
    }
    public void input (){
        int n = sc.nextInt();
        switch (n){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.print("Enter the Song Name : ");
                String song_name = sc.next();
                System.out.println("Your Request For Song "+song_name+" Will Be Caller Tune For Your Number Within 5mins");
                System.out.println("Thank You");
                break;
            case 9 :
                ForBack.pop();
                Main obj = ForBack.peek();
                obj.display();
                break;
            default:
                System.out.println("invalid Number!");
        }

    }
}
