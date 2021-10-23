package lesson7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        if (0 > food) {
            System.out.println("В миске не может быть отрицательное число.");
            this.food = 0;
            return;
        }
        this.food = food;
    }

    public void addFood(int addFood) {
        System.out.println("Добавили корма на " + addFood + " едениц еды.");
        food = food + addFood;
        System.out.println("В миске " + food + " едениц еды.");
    }
}
