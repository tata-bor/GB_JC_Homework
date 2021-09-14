package lesson_2;

public class Main {

    public static void main(String[] args)  {
        MyArray array = new MyArray();
        String ar[][]  = {{"1","2","3","4"},{"7","3","2","5"},{"1","2","3","4"},{"7","3","2","5"}};
        try {
            var sum = array.sumArray(ar);
            System.out.println(sum);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

    }
}
