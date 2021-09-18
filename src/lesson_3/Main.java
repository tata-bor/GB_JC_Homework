package lesson_3;

public class Main {
    public static void main(String[] args) {

    // тест 1 задания

   var obj = new Method<String>();
   var array = new String[]{"1","2","3"};
   obj.changeMethod (array,0,2);
        System.out.println( array [0] + array [1] + array [2]);


    // тест 2 задания

    var box1 = new Box<Apple>(new Apple[] {new Apple(), new Apple(), new Apple()});
    var box2 = new Box<Apple>(new Apple[] {new Apple(), new Apple()});
        System.out.println("Вес первой коробки: " + box1.getWeight());
        System.out.println("Вес второй коробки: " + box2.getWeight());

        boolean result;
        result = box1.compare(box2);
        System.out.println("Результат сравнения: " + result);

        box2.move(box1);
        System.out.println("Вес первой коробки: " + box1.getWeight());
        System.out.println("Вес второй коробки: " + box2.getWeight());

    };
}
