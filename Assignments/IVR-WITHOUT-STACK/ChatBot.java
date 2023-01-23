
public class ChatBot {
    static Scanner sc = new Scanner(System.in);
    public static void homepage(){
        System.out.println("\tWELCOME TO CHATBOT CONSOLE APPLICATION");
        System.out.println("1.Press 1 to Continue");
        System.out.println("2.Press 0 to Exit");
        System.out.print("Enter a Number : ");
        int yesorno = sc.nextInt();
        switch (yesorno){
            case 1:
                mainmenu();
                break;
            case 0:
                System.out.println("Thank You! See you Again");
                break;
            default:
                System.out.println("invalid Number!");
                homepage();
        }
    }
    public static void mainmenu(){
        System.out.println("\tMain Menu");
        System.out.println("1.Set Caller Tune");
        System.out.println("2.Recharge Options");
        System.out.println("3.Network Related Queries");
        System.out.println("4.BroadBand Connection");
        System.out.println("5.Check Balance");
        System.out.println("0.Exit");
        System.out.print("Enter a Number : ");
        int mainmenu_input = sc.nextInt();
        switch (mainmenu_input){
            case 1:
                SetCallerTune();
                break;
            case 2:
               recharge();break;
               case 3:
                    NetRQ();
                    break;

            case 4:
                BroadBand();
                break;
            case 5:
                Balance();
                break;
            case 0:
                System.out.println("Thank You Visting!");
                break;
            default:
                System.out.println("Invalid Number!Try Some Other Number");
                mainmenu();
        }
    }
    public static void SetCallerTune(){
        System.out.println("\tSet Caller Tune");
        System.out.println("Choose the Song language : ");
        System.out.println("1.Tamil");
        System.out.println("2.English");
        System.out.println("3.Hindi");
        System.out.println("4.Telugu");
        System.out.println("5.Malayalam");
        System.out.println("9.Main Menu");
        int Setcaller_input = sc.nextInt();
        switch (Setcaller_input){
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
                mainmenu();
                break;
            default:
                System.out.println("invalid Number!");
                SetCallerTune();
        }
    }
    public static void BroadBand(){
        System.out.println("\tBoardBand Connection");
        System.out.println("1.DSL");
        System.out.println("2.BPL");
        System.out.println("3.Wire Less");
        System.out.println("4.Fiber Cable");
        System.out.println("5.Cable Modem");
        System.out.println("9.Main Menu");
        int BroadBand_input = sc.nextInt();
        switch (BroadBand_input){
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
                case 9 :
                    mainmenu();
                    break;
            default:
                System.out.println("invalid Number!");
                BroadBand();
        }
    }
    public static void recharge(){
        System.out.println("\tRecharge Options");
        System.out.println("1.Data Pack");
        System.out.println("2.Monthly Pack");
        System.out.println("3.Yearly Pack");
        System.out.println("4.Top Ups");
        System.out.println("9.Main Menu");
        int recharge_input = sc.nextInt();
        switch (recharge_input){
            case 1:
                Datapack();
                break;
            case 2:
                monthly();
                break;
                case 3:
                    year();
                    break;
            case 4:
                topups();
            case 9:
                mainmenu();
                break;
            default:
                System.out.println("Invalid Number");
                recharge();
        }
    }
    public static void NetRQ(){
        System.out.println("Enter Your Mobile Number : ");
        long number = sc.nextLong();
        System.out.println("You will Contacted By Our Customer Care Support Within 1 Hours");
    }
    public static void Balance(){
        System.out.println("Available Balance : 126.43 Rupees");
        System.out.println("Enter 9 For Mainmenu");
        System.out.println("Enter 0 For Exit");
        int n = sc.nextInt();
        if(n==9){
            mainmenu();
        }
        else if(n==0){
            System.out.println("ThankYou");
            return;
        }else{
            System.out.println("Invalid Number!");
            Balance();
        }
    }

    public static void main(String[] args) {
        homepage();

    }
    public static void Datapack(){
        System.out.println("\tData Pack");
        System.out.println("1. 121 Rupees - 12GB");
        System.out.println("2. 61 Rupees - 6GB");
        System.out.println("3. 25 Rupees - 2GB");
        System.out.println("4. 15 Rupees - 1Gb");
        System.out.println("9.Main Menu");
        int num = sc.nextInt();
        switch (num){
            case 1:
                System.out.println("Your Recharge is SuccesFull For 121 Rupees - 12GB");
                System.out.println("Money Will Be Deducted From Your Balance");
                break;
                case 2:
                System.out.println("Your Recharge is SuccesFull For 61 Rupees - 6GB");
                System.out.println("Money Will Be Deducted From Your Balance");
                break;
                case 3:
                System.out.println("Your Recharge is SuccesFull For 25 Rupees - 2GB");
                System.out.println("Money Will Be Deducted From Your Balance");
                break;
                case 4:

                System.out.println("Your Recharge is SuccesFull For 15 Rupees - 1GB");
                System.out.println("Money Will Be Deducted From Your Balance");
                break;
                case 9:
                mainmenu();
                break;
            default:
                System.out.println("Invalid Number!");
                Datapack();
        }
    }
    public static void monthly(){
        System.out.println("\tMonthly Pack");
        System.out.println("1. 200 Rupees - 1 Month");
        System.out.println("2. 300 Rupees - 2 Month");
        System.out.println("3. 500 Rupees - 4 Month");
        System.out.println("4. 700 Rupees - 6 Month");
        System.out.println("9.Main Menu");
        int num = sc.nextInt();
        switch (num){
            case 1:
                System.out.println("Your Recharge is SuccesFull For 200 Rupees - 1 Month");
                System.out.println("Money Will Be Deducted From Your Balance");
                break;
            case 2:
                System.out.println("Your Recharge is SuccesFull For 300 Rupees - 2 Month");
                System.out.println("Money Will Be Deducted From Your Balance");
                break;
            case 3:
                System.out.println("Your Recharge is SuccesFull For 500 Rupees - 4 Month");
                System.out.println("Money Will Be Deducted From Your Balance");
                break;
            case 4:
                System.out.println("Your Recharge is SuccesFull For 700 Rupees - 6 Month");
                System.out.println("Money Will Be Deducted From Your Balance");
                break;
            case 9:
                mainmenu();
                break;
            default:
                System.out.println("Invalid Number!");
                monthly();
        }
    }
    public static void year(){
        System.out.println("\tMonthly Pack");
        System.out.println("1. 200 Rupees - 1 Month");
        System.out.println("2. 300 Rupees - 2 Month");
        System.out.println("3. 500 Rupees - 4 Month");
        System.out.println("4. 700 Rupees - 6 Month");
        System.out.println("9.Main Menu");
        int num = sc.nextInt();
        switch (num){
            case 1:
                System.out.println("Your Recharge is SuccessFull For 2999 Rupees - 365Days + 23 Days");
                System.out.println("Money Will Be Deducted From Your Balance");
                break;
            case 2:
                System.out.println("Your Recharge is SuccessFull For 2879 Rupees - 365 Days");
                System.out.println("Money Will Be Deducted From Your Balance");
                break;
            case 3:
                System.out.println("Your Recharge is SuccessFull For 2545 Rupees - 336 Days");
                System.out.println("Money Will Be Deducted From Your Balance");
                break;
            case 9:
                mainmenu();
                break;
            default:
                System.out.println("Invalid Number!");
                year();
        }
    }
    public static void topups(){
        System.out.println("\tTop Ups");
        System.out.println("1. 1000 Rupees ");
        System.out.println("2. 500  Rupees ");
        System.out.println("3. 100  Rupees ");

        System.out.println("9.Main Menu");
        int num = sc.nextInt();
        switch (num){
            case 1:
                System.out.println("Your Recharge is SuccessFull For 1000 Rupees");
                System.out.println("Money Will Be Deducted From Your Balance");
                break;
            case 2:
                System.out.println("Your Recharge is SuccessFull For 500 Rupees");
                System.out.println("Money Will Be Deducted From Your Balance");
                break;
            case 3:
                System.out.println("Your Recharge is SuccessFull For 100 Rupees");
                System.out.println("Money Will Be Deducted From Your Balance");
                break;
            case 9:
                mainmenu();
                break;
            default:
                System.out.println("Invalid Number!");
                topups();
        }
    }
}
