package lesson6;

import java.util.Objects;

public class Animals {

    private final String name;
    private final String color;
    private final String breedsOf;
    private final int age;
    private final int run;
    private final int swimming;
    private final double highJump;
    private final double longJump;
    private static int animalCount;

    public Animals(String name, String color, String breedsOf, int age, int run, int swimming, double highJump, double longJump) {
        this.name = name;
        this.color = color;
        this.breedsOf = breedsOf;
        this.age = age;
        this.run = run;
        this.swimming = swimming;
        this.highJump = highJump;
        this.longJump = longJump;
        animalCount++;
    }

    public double getHighJump() {
        return highJump;
    }

    public double getLongJump() {
        return longJump;
    }

    public void runningDistance() {
        System.out.println(name + " пробежал " + run);
    }

    public void swimmingMaxDistance() {
        getSwimming();
    }

    public void runMaxDistance() {
        System.out.println(name + " пробежал " + run + " метров.");
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getBreedsOf() {
        return breedsOf;
    }

    public int getAge() {
        return age;
    }

    public int getRun() {
        return run;
    }

    public void printInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", breedsOf='" + breedsOf + '\'' +
                ", age=" + age +
                ", run=" + run +
                ", swimming=" + swimming +
                ", highJump=" + highJump +
                ", longJump=" + longJump +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animals = (Animals) o;
        return age == animals.age && run == animals.run && swimming == animals.swimming && Objects.equals(name, animals.name) && Objects.equals(color, animals.color) && Objects.equals(breedsOf, animals.breedsOf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, breedsOf, age, run, swimming);
    }

    public int getSwimming() {
        return swimming;
    }
}
