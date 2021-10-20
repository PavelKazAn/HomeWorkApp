package lesson6;

import java.util.Random;

public class Test {

    public static void main(String[] args) {

        Random random = new Random();

        Animals randomCat = new Cat("Random cat name", "Random cat color", "Random cat breed", random.nextInt(20), random.nextInt(300) + 50, 2.2, 2.1);
        Animals randomDog = new Dog("Random dog name", "Random cat color", "Random dog breed", random.nextInt(20), random.nextInt(500) + 100, random.nextInt(300) + 10, 1.2, 2);

        Animals bobik = new Dog("Бобик", "Черно-кремовый", "Овчарка", 7, 400, 30, 1.2, 2.1);
        Animals muhtar = new Dog("Мухтар", "Черный", "Доберман", 4, 600, 50, 0.7, 1.2);
        Animals murzik = new Cat("Мурзик", "Белый", "Турецкая ангора", 2, 100, 1.1, 1.2);

        countingAnimals();// Общее количество животных.

        randomDog.printInfo(); // Проверка метода вывода полной информации
        randomCat.printInfo();
        bobik.printInfo();
        muhtar.printInfo();
        murzik.printInfo();

        System.out.println(chekRun(200, randomCat)); // Припятсвие в забег на 200 метров
        System.out.println(chekRun(200, randomDog));
        System.out.println(chekRun(200, muhtar));
        System.out.println(chekRun(200, murzik));

        System.out.println(chekLongJump(1.5, randomCat));// Припятсвие прыжок в длину на 1.5 метра.
        System.out.println(chekLongJump(1.5, muhtar));
        System.out.println(chekLongJump(1.5, murzik));

        System.out.println(chekHighJump(1.7, randomDog));// Припятсвие прыжок в высоту на 1.7 метра.
        System.out.println(chekHighJump(1.7, bobik));

        System.out.println(chekSwimming(10, randomCat)); // Припятсвие в заплыв на 10 метров
        System.out.println(chekSwimming(10, randomDog));
        System.out.println(chekSwimming(10, bobik));

        muhtar.swimmingMaxDistance();// Проверка вывода максималного расстояния заплыва
        randomCat.runMaxDistance();// Проврека вывода максимального расстояния бега


    }

    private static boolean chekHighJump(double distance, Animals animals) {
        System.out.println();
        System.out.println("Прыжок в высоту на " + distance + "метра.");
        System.out.println(animals.getName() + " прыгнул " + animals.getHighJump() + " метра.");
        return animals.getHighJump() >= distance;
    }

    private static boolean chekLongJump(double distance, Animals animals) {
        System.out.println();
        System.out.println("Прыжок в длину на " + distance + " метра.");
        System.out.println(animals.getName() + " прыгнул " + animals.getLongJump() + " метра.");
        return animals.getLongJump() >= distance;
    }

    private static boolean chekSwimming(int distance, Animals animals) {
        System.out.println();
        System.out.println("Заплыв на " + distance + " метров.");
        System.out.println(animals.getName() + " проплыл " + distance + " метров.");
        return animals.getSwimming() >= distance;
    }

    private static boolean chekRun(int distance, Animals animals) {
        System.out.println();
        System.out.println("Забег на " + distance + " метров.");
        System.out.println(animals.getName() + " пробежал " + animals.getRun() + " метров.");
        return animals.getRun() >= distance;
    }

    private static void countingAnimals() {
        System.out.println("Общее количество кошек: " + Cat.getCatCount());
        System.out.println("Общее количество собак: " + Dog.getDogCount());
        System.out.println("Общее количество животных: " + Animals.getAnimalCount());
    }

}
