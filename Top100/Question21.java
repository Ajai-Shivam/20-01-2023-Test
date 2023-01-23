import java.util.Scanner;

//Evaluate the following expression on paper and on program and understand the
//        difference
//        If int y = 10 then find int z = (++y * (y++ + 5));
public class Question21 {
    public static void main(String[] args) {
        int y = 10;
        int z = (++y * (y++ + 5));
        System.out.println(z);
    }
}
