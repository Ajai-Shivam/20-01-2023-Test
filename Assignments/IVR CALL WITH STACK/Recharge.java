public class Recharge extends Main{
    public void display(){
        System.out.println("\tRecharge Options");
        System.out.println("1.Data Pack");
        System.out.println("2.Monthly Pack");
        System.out.println("3.Yearly Pack");
        System.out.println("4.Top Ups");
        System.out.println("9.Back");
        input();
    }
    public void input () {
        int n = sc.nextInt();
        switch (n) {
            case 1:
                DataPack objDP = new DataPack();
                Main.ForBack.push(objDP);
                objDP.display();
                break;
            case 2:
                Monthlypack objMP = new Monthlypack();
                Main.ForBack.push(objMP);
                objMP.display();
                break;
            case 3:
                yearlypack objYP = new yearlypack();
                Main.ForBack.push(objYP);
                objYP.display();
                break;
            case 4 :
                Topups objTP = new Topups();
                Main.ForBack.push(objTP);
                objTP.display();
                break;
            case 9:
                ForBack.pop();
                Main obj = ForBack.peek();
                obj.display();
                break;
        }
    }
}
