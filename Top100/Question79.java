import java.util.Scanner;

//Java Program to determine whether a given matrix is an identity matrix
public class Question79 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j]= sc.nextInt();
            }
        }

        method1(arr,n);
        method2(arr,n);
    }
    public static void method1(int[][] arr, int n) {
        System.out.println("Method 1 : ");
        int count1=0,count0=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==j){
                    if(arr[i][j]==1){
                        count1++;
                    }
                }else{
                    count0++;
                }
            }
        }
        int total = n*n;
        if(count1==n && count0==(total-n)){
            System.out.println("It is Indentity Matrixs");
        }else {
            System.out.println("It not is Indentity Matrixs");
        }
    }
    public static void method2(int[][] arr, int n) {
        System.out.println("Method 2 : ");
        boolean point = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j && arr[i][j] != 1){
                    point = false;
                    break;
                }
                if(i != j && arr[i][j] != 0){
                    point= false;
                    break;
                }
            }
        }

        if(point)
            System.out.println("it is an identity matrix");
        else
            System.out.println("it is not an identity matrix");
    }
}

