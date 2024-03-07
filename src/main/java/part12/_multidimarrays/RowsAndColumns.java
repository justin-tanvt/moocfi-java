package part12._multidimarrays;

public class RowsAndColumns {
    public static void main(String[] args) {
//        int rows = 2;
//        int columns = 3;
//        int[][] twoDimensionalArray = new int[rows][columns];
//
//        twoDimensionalArray[0][1] = 4;
//        twoDimensionalArray[1][1] = 1;
//        twoDimensionalArray[1][0] = 8;
//
//        System.out.println("row, column, value");
//        for (int row = 0; row < twoDimensionalArray.length; row++) {
//            for (int column = 0; column < twoDimensionalArray[row].length; column++) {
//                int value = twoDimensionalArray[row][column];
//                System.out.println("" + column + ", " + row + ", " + value);
//            }
//        }

        int[][] matrix = {
                {3, 2, 7, 6},
                {2, 4, 1, 0},
                {3, 2, 1, 0}
        };
        System.out.println(arrayAsString(matrix));
    }

    public static String arrayAsString(int[][] array) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                sb.append(array[row][column]);
            }
            // append EOL to end of each row except the last
            // this is so to prevent a duplicate EOL when the String is println()-ed
            if (row != array.length - 1) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}
