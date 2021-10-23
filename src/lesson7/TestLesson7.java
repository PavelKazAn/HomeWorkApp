package lesson7;

import java.util.Random;

public class TestLesson7 {

    public static void main(String[] args) {
        Random random = new Random();

        Cat[] cats = new Cat[5];

        cats[0] = new Cat("Боря", random.nextInt(8) + 2);
        cats[1] = new Cat("Муся", random.nextInt(8) + 2);
        cats[2] = new Cat("Пельмень", random.nextInt(8) + 2);
        cats[3] = new Cat("Мурзик", random.nextInt(8) + 2);
        cats[4] = new Cat("Шифа", random.nextInt(8) + 2);

        Plate plateCat = new Plate(random.nextInt(2) + 8);

        for (int i = 0; i < cats.length; i++) {
            cats[i].printInfo();
        }

        hungerOfCats(cats);

        System.out.println("В миске " + plateCat.getFood() + " едениц еды.");

        feedingsСats(cats, plateCat);

        plateCat.addFood(random.nextInt(30) + 10);

        feedingsСats(cats, plateCat);

    }

    private static void hungerOfCats(Cat[] cats) {
        for (int i = 0; i < cats.length; i++) {
            if (cats[i].getSatiety()) {
                System.out.println(cats[i].getName() + " сытый.");
            } else {
                System.out.println(cats[i].getName() + " голодный.");
            }
        }
    }

    public static void feedingsСats(Cat[] cat, Plate plate) {
        for (int i = 0; i < cat.length; i++) {
            if (!cat[i].eating(plate)) {
                System.out.println("Котам не хватило еды.");
                hungerOfCats(cat);
                return;
            }
        }
        System.out.println("Все коты накормлены.");
    }

}
