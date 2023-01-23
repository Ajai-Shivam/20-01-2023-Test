public class Monthlypack extends Main {
    public void display() {
        System.out.println("\tMonthly Pack");
        System.out.println("1. 200 Rupees - 1 Month");
        System.out.println("2. 300 Rupees - 2 Month");
        System.out.println("3. 500 Rupees - 4 Month");
        System.out.println("4. 700 Rupees - 6 Month");
        System.out.println("9.Back");
        input();
    }

    public void input() {
        int num = sc.nextInt();
        switch (num) {
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
                ForBack.pop();
                Main obj = ForBack.peek();
                obj.display();
                break;
        }
    }
}
