package lesson2;

public class HomeWorkLesson2 {

    public static void main(String[] args) {
        System.out.println(checkSum( 2000 ,-1980)); // Вывод в консоль сделал,чтобы было проще проверить возвращаемое значение.
        сheckTheNumber(-5);
        System.out.println(chekTheNumberBoolean(3)); // Вывод в коносоль только для проверки. Надеюсь так делать можно.
        writerOfLines("Строка",1);
        System.out.println(chekLeapYear(2000));

    }

    public static boolean checkSum (int a, int b ){
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void сheckTheNumber (int number){
        if (number>=0){
            System.out.println("Число положительное.");
        }else{
            System.out.println("Число отрицательное.");
        }
    }

    public static boolean chekTheNumberBoolean (int number){
        return number<0;
    }

    public static void writerOfLines(String line , int quantity ){
        for (int i = 0;i<quantity;i++){
            System.out.println(line);
        }
    }

    public static boolean chekLeapYear(int year){
        return year % 4 ==0 && (year % 100 != 0 || year % 400 ==0);// Хотел сделать максимально короткий код, надеюсь без ошибок.
    }

}
