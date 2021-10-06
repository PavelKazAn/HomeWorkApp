public class HomeWorkLesson1 {

    public static void printThreeWords(){

        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void chekSumSign(){
        int a = 5;
        int b = 23;

        if ((a+b)>=0){
            System.out.println("Сумма положительная");
        }else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor(){
        int value = 43;

        if (value<=0){
            System.out.println("Красный");
        }else if(value<=100){
            System.out.println("Желтый");
        }else{
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 24;
        int b = 82;

        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
    }

    public static void main(String[] arqs){
        printThreeWords();
        chekSumSign();
        printColor();
        compareNumbers();
    }
}

