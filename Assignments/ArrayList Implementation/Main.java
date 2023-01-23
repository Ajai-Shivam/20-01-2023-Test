class arraylist{
    final private int initial_size = 5;
    public int[] arr = new int[initial_size];
    private int postion = 0;
    //Add Element Method
    public void add(int value){ // Adding Function
        if(postion==arr.length-2){
           arr = increment(arr);

        }

        arr[postion] = value;
        postion++;
    }
    //Insert Method
    public void insert(int insert_pos,int value){
        if(postion==arr.length-1){
            increment(arr);
        }
        int[] temp = arr.clone();
        int j =0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0 && i>=postion){
                break;
            }
            if(i==insert_pos){
                arr[i] = value;
                postion++;
            }else{
                arr[i] = temp[j];
                j++;
            }

        }

    }
    // Delete Element Method
    public void delete(int value){
        int index = -1;
        for (int i = 0; i <= postion; i++) {
            if(arr[i] == value){
                arr[i] = 0;
                index = i;
                break;
            }
        }
        if(index!=postion){
            for (int i = index; i <= postion ; i++) {
                arr[i] = arr[i+1];
            }
        }
        postion--;

    }
    //Array Size Increment Method
    private int[] increment(int [] arr){
        int[] temp = arr.clone();
        arr= new int[arr.length+5];

        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];

        }

        return arr;
    }
    // Printing The Array Method
    public void print(){
        System.out.print("[");
        for (int i = 0; i < postion; i++) {
            if(i==postion-1){
                System.out.print(arr[i]);
            }
            else{
                System.out.print(arr[i]+", ");
            }
        }
        System.out.print("]");
    }
}
public class Main {
    public static void main(String[] args) {
        arraylist ar = new arraylist();
        ar.add(12);
        ar.add(10);
        ar.add(15);
        ar.insert(1,-1);
        ar.print();

    }
}
