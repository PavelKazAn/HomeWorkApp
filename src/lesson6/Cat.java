package lesson6;

public class Cat extends Animals {

    private static int catCount;

    protected Cat(String name, String color, String breedsOf, int age, int run, double highJump, double longJump) {
        super(name, color, breedsOf, age, run, 0, highJump, longJump);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public int getSwimming() {
        System.out.println("Кошки не умеют плавать.");
        return 0;
    }

}
