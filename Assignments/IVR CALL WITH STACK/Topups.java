public class Topups extends Main {
    public void display() {
        System.out.println("\tTop Ups");
        System.out.println("1. 1000 Rupees ");
        System.out.println("2. 500  Rupees ");
        System.out.println("3. 100  Rupees ");
        System.out.println("9.Back");
        input();
    }

    public void input() {
        int num = sc.nextInt();
        switch (num) {
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
                ForBack.pop();
                Main obj = ForBack.peek();
                obj.display();
                break;
        }
    }
}
