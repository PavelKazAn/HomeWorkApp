package lesson6;

public class Dog extends Animals {

    private static int dogCount;

    protected Dog(String name, String color, String breedsOf, int age, int run, int swimming, double highJump, double longJump) {
        super(name, color, breedsOf, age, run, swimming, highJump, longJump);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void swimmingMaxDistance() {
        System.out.println(getName() + " проплыл " + getSwimming() + " метров.");
    }

}
