public class DataPack extends Main {
    public void display() {
        System.out.println("\tData Pack");
        System.out.println("1. 121 Rupees - 12GB");
        System.out.println("2. 61 Rupees - 6GB");
        System.out.println("3. 25 Rupees - 2GB");
        System.out.println("4. 15 Rupees - 1Gb");
        System.out.println("9.Main Menu");
        input();
    }

    public void input() {
        int num = sc.nextInt();
        switch (num) {
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
                ForBack.pop();
                Main obj = ForBack.peek();
                obj.display();
                break;

        }
    }
}
