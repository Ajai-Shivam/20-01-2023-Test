public class yearlypack extends Main{
    public void display() {
        System.out.println("\tMonthly Pack");
        System.out.println("1. 2999 Rupees - 365 + 23 Days");
        System.out.println("2. 2879 Rupees - 365 Days");
        System.out.println("3. 2545 Rupees - 336 Days");
        System.out.println("9.Back");
    }

    public void input() {
        int num = sc.nextInt();
        switch (num) {
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
                ForBack.pop();
                Main obj = ForBack.peek();
                obj.display();
                break;
        }
    }
}
