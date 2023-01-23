public class Question26 {
    public static void main(String[] args) {
        // Int can store Value in the range -2,147,483,648 to 2,147,483,647
        // if we store value more than 2,147,483,647 it will goes back to begin value of Int i.e -2,147,483,648.
        // lets implement it ..
        int value = 2147483647+ 1;
        // Here I added 1 to max value and lets see what will happen.
        System.out.println(value);
        // Output - -2147483648
        // So it cannot store value great than 2147483647
        //In this case We can use long datatypes
        // In long data types we can store values in range of -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        long value1 = Long.MAX_VALUE;
        System.out.println(value1);
    }
}
