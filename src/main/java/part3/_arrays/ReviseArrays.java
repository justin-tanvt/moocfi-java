package part3._arrays;

public class ReviseArrays {
    public static void main(String[] args) {
        String[] helloArray = {
                "Hello",
                "World!"
        };

        // use array.length to iterate (can also use simplified for loop
        for (int i = 0; i < helloArray.length; i++) {
            System.out.println(helloArray[i]);
        }

        /*
        // array index OOB exception
        for (int i = 0; i < 3; i++) {
            System.out.println(array[i]);
        }
        */

        int[] array = {5, 1, 3, 4, 2};
        printNeatly(array);
    }

    public static void printNeatly(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            // print whitespace and comma between numbers
            // don't put comma after last number
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }
    }
}
