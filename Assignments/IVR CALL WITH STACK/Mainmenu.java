import java.util.*;
public class Mainmenu extends Main {
    public void display() {
        System.out.println("\tMain Menu");
        System.out.println("1.Set Caller Tune");
        System.out.println("2.Recharge Options");
        System.out.println("3.Network Related Queries");
        System.out.println("4.BroadBand Connection");
        System.out.println("5.Check Balance");
        System.out.println("9.Back");
        System.out.print("Enter a Number : ");
        int n = Main.sc.nextInt();
        switch (n){
            case 1:
                SetCallerTune objset = new SetCallerTune();
                Main.ForBack.push(objset);
                objset.display();
                break;
            case 2:
                Recharge objrecharge = new Recharge();
                Main.ForBack.push(objrecharge);
                objrecharge.display();
                break;
            case 3:
                NetworkRelated objNetRelated = new NetworkRelated();
                Main.ForBack.push(objNetRelated);
                objNetRelated.display();
                break;
            case 4:
                BroadBand objBroad = new BroadBand();
                Main.ForBack.push(objBroad);
                objBroad.display();
                break;
            case 5:
                CheckBalance objcheck = new CheckBalance();
                Main.ForBack.push(objcheck);
                objcheck.display();
                break;
            case 9:
                ForBack.pop();
                Main obj = ForBack.peek();
                obj.display();
                break;
            default:
                System.out.println("Invalid Entry! Choose a Different!");

        }
    }
}
