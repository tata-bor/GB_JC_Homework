package lesson_2;

import java.lang.reflect.Array;

public class MyArray {

    public int sumArray(String [][] array) throws MyArraySizeException, MyArrayDataException {
    if (array.length != 4 || array[0].length != 4) {
        throw new MyArraySizeException ();
        }

    int sum = 0;

    for (int x = 0; x < 4; x++) {
        for (int y = 0; y < 4; y++) {
            int foo;
            try {
                foo = Integer.parseInt(array[x][y]);
                sum += foo;
            } catch (NumberFormatException e) {
                throw new MyArrayDataException();
            }
        }
    }
    return sum;


    }
}
