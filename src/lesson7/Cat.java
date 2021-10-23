package lesson7;

public class Cat {

    private boolean satiety;

    private final int APPETITE;
    private final String name;

    public Cat(String name, int satiety) {
        this.name = name;
        this.APPETITE = satiety;
        this.satiety = false;
    }

    public boolean getSatiety() {
        return satiety;
    }

    public int getAPPETITE() {
        return APPETITE;
    }

    public String getName() {
        return name;
    }

    public void printInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Cat{" +
                "appetite=" + APPETITE +
                ", satiety=" + satiety +
                ", name='" + name + '\'' +
                '}';
    }

    public boolean eating(Plate plate) {
        if(satiety){
            System.out.println(name + " сытый.");
            return true;
        }
        System.out.println(name + " хочет покушать из миски.");
        if (plate.getFood() >= getAPPETITE()) {
            plate.setFood(plate.getFood() - getAPPETITE());
            System.out.println("В миске осталось " + plate.getFood() + " едениц еды.");
            satiety = true;
            return true;
        } else {
            System.out.println("В миске недостаточно еды.");
            satiety = false;
            return false;
        }
    }
}
