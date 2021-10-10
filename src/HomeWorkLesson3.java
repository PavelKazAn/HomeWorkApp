import java.util.Arrays;
import java.util.Random;

public class HomeWorkLesson3 {
    public static void main(String[] args) {
        System.out.println("Первое задание.");
        replaceNumberArray();
        System.out.println("Второе задание");
        longArray();
        System.out.println("Третье задание.");
        smallValuesDoubled();
        System.out.println("Четвертое задание");
        squareArray();
        System.out.println("Пятое задание.");
        System.out.println(Arrays.toString(arraySameVariable(15, 123)));
        System.out.println("* Шестое задание");
        findLargerSmallerNumber();
        System.out.println("** Седьмое задание");
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(chekBalance(arr));
        System.out.println("*** Восьмое задание");
        System.out.println(Arrays.toString(moveNumbersArray(-6, arr)));
    }

    public static void replaceNumberArray() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(array));
        for (int j = 0; j < array.length; j++) {
            if (array[j] == 1) {
                array[j] = 0;
            } else {
                array[j] = 1;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void longArray() {
        int[] array = new int[100];
        int number = 1;
        for (int i = 0; i < array.length; i++) {
            array[i] = number;
            number++;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void smallValuesDoubled() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2; // В задании  не было указано, что содержимое массива нужно перезаписывать,но на всякий случай добавил
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void squareArray() {
        int[][] array = new int[3][3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----");
        for (int k = 0; k < array.length; k++) {
            array[k][k] = 1;
        }
        for (int v = 0; v < array.length; v++) {
            array[array.length - v - 1][v] = 1;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] arraySameVariable(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    public static void findLargerSmallerNumber() {
        int[] array = new int[new Random().nextInt(20)];
        int max = 0;
        int min = 999;
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(100);
        }
        System.out.println(Arrays.toString(array));
        for (int j = 0; j < array.length; j++) {
            if (max <= array[j]) {
                max = array[j];
            } else if (min >= array[j]) {
                min = array[j];
            }
        }
        System.out.println("Наибольшее значение = " + max);
        System.out.println("Наименьшее значние = " + min);
    }

    public static boolean chekBalance(int[] array) {
        int right = 0;
        int sumArray = 0;
        int left = 0;
        for (int i = 0; i < array.length; i++) {
            sumArray = sumArray + array[i];
        }
        for (int j = array.length - 1; j >= 0; j--) {
            right = right + array[j];
            left = sumArray - right;
            if (left == right) {
                break;
            }
        }
        return left == right;
    }

    public static int[] moveNumbersArray(int n, int[] array) {
        int[] copyArray = new int[array.length];
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (j == array.length - 1) {
                        copyArray[0] = array[array.length - 1];
                    }
                    if (j < array.length - 1) {
                        copyArray[j + 1] = array[j];
                    }
                }
                for (int h = 0; h < array.length; h++) {
                    array[h] = copyArray[h];
                    copyArray[h] = 0;
                }
            }
        }
        if (n < 0) {
            for (int i = 0; i > n; i--) {
                for (int j = array.length - 1; j >= 0; j--) {
                    if (j == 0) {
                        copyArray[array.length - 1] = array[0];
                    }
                    if (j > 0) {
                        copyArray[j - 1] = array[j];
                    }
                }
                for (int h = 0; h < array.length; h++) {
                    array[h] = copyArray[h];
                    copyArray[h] = 0;
                }
            }
        }
        return array;
    }
}
