package lesson_3;

// задание 1

public class Method <T extends Object>  {
    public void changeMethod(T[] args, int number1, int number2) {
    T x = args[number1];
    args[number1] = args[number2];
    args[number2] = x;
    }
}
