package lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '•';
    private static final int SIZE = 6;
    private static final int CHIPS_IN_ROW_TO_WIN = 4;

    private static Scanner scanner = new Scanner(System.in);
    private static char[][] map;


    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (isWin(DOT_X, "checking the winner")) {
                System.out.println("Вы победили!");
                break;
            }

            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();
            if (isWin(DOT_O, "checking the winner")) {
                System.out.println("Вы проиграли!");
                break;
            }
        }
    }

    private static boolean isWin(char symbol, String forWhat) {
        int chipsInRow;

        chipsInRow = chekWinByRow(symbol, forWhat);
        if (chipsInRow >= CHIPS_IN_ROW_TO_WIN) {
            return true;
        }

        chipsInRow = chekWinByCol(symbol, forWhat);
        if (chipsInRow >= CHIPS_IN_ROW_TO_WIN) {
            return true;
        }
//        chipsInRow = chekWinMainDiagonal(symbol,forWhat);
        chipsInRow = chekWinDiagonalAllMap(symbol, forWhat);
        return chipsInRow >= CHIPS_IN_ROW_TO_WIN;
    }

    private static int chekWinMainDiagonal(char symbol, String forWhat) {
        char[][] chekMap = new char[SIZE][SIZE];
        zeroingMap(chekMap);
        int chipsInRow = 0;
        for (int i = 0; i < SIZE; i++) {
            chekMap[i][i] = symbol;
            if (map[i][i] == chekMap[i][i]) {
                chipsInRow++;
            } else {
                chipsInRow = 0;
            }
            if (chipsInRow >= CHIPS_IN_ROW_TO_WIN) {
                showWinMove(forWhat, chekMap);
                return chipsInRow;
            }
        }
        chipsInRow = 0;
        zeroingMap(chekMap);
        for (int i = 0; i < SIZE; i++) {
            chekMap[SIZE - 1 - i][i] = symbol;
            if (map[SIZE - 1 - i][i] == chekMap[SIZE - 1 - i][i]) {
                chipsInRow++;
            } else {
                chipsInRow = 0;
            }
            if (chipsInRow >= CHIPS_IN_ROW_TO_WIN) {
                showWinMove(forWhat, chekMap);
                return chipsInRow;
            }
        }
        return chipsInRow = 0;
    }

    private static void showWinMove(String forWhat, char[][] chekMap) {
        if (forWhat.equals("checking the winner")) {
            printMapHeader();
            for (int i = 0; i < map.length; i++) {
                printRowNumber(i);
                printRow(chekMap[i]);
                System.out.println();
            }
        }
    }

    private static int chekWinDiagonalAllMap(char symbol, String forWhat) {
        char[][] chekMap = new char[SIZE][SIZE];
        zeroingMap(chekMap);
        int chipsInRow = 0;
        int numberToCalculate;
        for (int step = 0; step < SIZE; step++) {
            for (int initialNumber = 0; initialNumber < SIZE; initialNumber++) {
                for (int number = initialNumber; number - step >= 0; number--) {
                    if (chipsInRow >= CHIPS_IN_ROW_TO_WIN) {
                        break;
                    }
                    chekMap[number][number - step] = symbol;
                    if (map[number][number - step] == chekMap[number][number - step]) {
                        chipsInRow++;
                    } else {
                        chipsInRow = 0;
                        zeroingMap(chekMap);
                    }
                }
                if (chipsInRow >= CHIPS_IN_ROW_TO_WIN) {
                    showWinMove(forWhat, chekMap);
                }
                chipsInRow = 0;
                zeroingMap(chekMap);
                for (int number = initialNumber; number - step >= 0; number--) {
                    if (chipsInRow >= CHIPS_IN_ROW_TO_WIN) {
                        break;
                    }
                    chekMap[number - step][number] = symbol;
                    if (map[number - step][number] == chekMap[number - step][number]) {
                        chipsInRow++;
                    } else {
                        chipsInRow = 0;
                        zeroingMap(chekMap);
                    }
                }
                if (chipsInRow >= CHIPS_IN_ROW_TO_WIN) {
                    showWinMove(forWhat, chekMap);
                    return chipsInRow;
                }
                chipsInRow = 0;
                zeroingMap(chekMap);
            }
            for (int number = 0; number < SIZE; number++) {
                if (chipsInRow >= CHIPS_IN_ROW_TO_WIN || number + step >= SIZE) {
                    break;
                }
                chekMap[SIZE - 1 - number - step][number] = symbol;
                if (map[SIZE - 1 - number - step][number] == chekMap[SIZE - 1 - number - step][number]) {
                    chipsInRow++;
                } else {
                    chipsInRow = 0;
                    zeroingMap(chekMap);
                }
            }
            if (chipsInRow >= CHIPS_IN_ROW_TO_WIN) {
                showWinMove(forWhat, chekMap);
                return chipsInRow;
            }
            chipsInRow = 0;
            zeroingMap(chekMap);
            numberToCalculate = step;
            for (int i = SIZE - 1; i >= 0; i--) {
                numberToCalculate++;
                if (chipsInRow >= CHIPS_IN_ROW_TO_WIN || numberToCalculate >= SIZE) {
                    break;
                }
                chekMap[i][numberToCalculate] = symbol;
                if (chekMap[i][numberToCalculate] == map[i][numberToCalculate]) {
                    chipsInRow++;
                } else {
                    chipsInRow = 0;
                    zeroingMap(chekMap);
                }
            }
            if (chipsInRow >= CHIPS_IN_ROW_TO_WIN) {
                showWinMove(forWhat, chekMap);
                return chipsInRow;
            }
        }
        return chipsInRow;
    }

    private static int chekWinByCol(char symbol, String forWhat) {
        char[][] chekMap = new char[SIZE][SIZE];
        zeroingMap(chekMap);
        int chipsInRow = 0;
        for (int col = 0; col < SIZE; col++) {
            for (int row = 0; row < SIZE; row++) {
                chekMap[row][col] = symbol;
                if (map[row][col] == chekMap[row][col]) {
                    chipsInRow++;
                } else {
                    zeroingMap(chekMap);
                    chipsInRow = 0;
                }
                if (chipsInRow >= CHIPS_IN_ROW_TO_WIN) {
                    showWinMove(forWhat, chekMap);
                    return chipsInRow;
                }
            }
            chipsInRow = 0;
            zeroingMap(chekMap);
        }
        return chipsInRow;
    }

    private static void zeroingMap(char[][] chekMap) {
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(chekMap[i], '░');
        }
    }

    private static int chekWinByRow(char symbol, String forWhat) {
        char[][] chekMap = new char[SIZE][SIZE];
        zeroingMap(chekMap);
        int chipsInRow = 0;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                chekMap[row][col] = symbol;
                if (map[row][col] == chekMap[row][col]) {
                    chipsInRow++;
                } else {
                    zeroingMap(chekMap);
                    chipsInRow = 0;
                }
                if (chipsInRow >= CHIPS_IN_ROW_TO_WIN) {
                    showWinMove(forWhat, chekMap);
                    return chipsInRow;
                }
            }
            chipsInRow = 0;
        }
        return chipsInRow;
    }

    private static boolean isMapFull() {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (isEmptyCell(row, col)) {
                    return false;
                }
            }

        }
        return true;
    }

    private static int readIndex() {
        while (!scanner.hasNextInt()) {
            System.out.println("Координаты должны иметь целочисленные значения");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static boolean isEmptyCell(int row, int col) {
        return map[row][col] == DOT_EMPTY;
    }

    private static void humanTurn() {
        while (true) {
            System.out.println("Введите координаты строки(row) и столбца(col): ");
            int row = readIndex();
            int col = readIndex();
            if (chekRange(row) || chekRange(col)) {
                System.out.println("Координаты должны быть в диапазоне от 1 до " + SIZE);
            } else if (!isEmptyCell(row - 1, col - 1)) {
                System.out.println("Данные координаты заняты");
            } else {
                map[row - 1][col - 1] = DOT_X;
                break;
            }
        }
    }

    private static void aiTurn() {
        int[] toGo = winningMove(DOT_O);
        if (toGo == null) {
            toGo = winningMove(DOT_X);
        }
        if (toGo == null) {
            toGo = randomMove();
        }
        map[toGo[0]][toGo[1]] = DOT_O;
    }

    private static int[] winningMove(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY && chekWinningMove(i, j, symbol)) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static boolean chekWinningMove(int row, int col, char symbol) {
        map[row][col] = symbol;
        boolean chek = isWin(symbol, "checking for a bot");
        map[row][col] = DOT_EMPTY;
        return chek;
    }


    private static int[] randomMove() {
        int row, col;
        Random random = new Random();
        do {
            row = random.nextInt(SIZE);
            col = random.nextInt(SIZE);
        } while (!isEmptyCell(row, col));
        return new int[]{row, col};
    }

    private static boolean chekRange(int number) {
        return (number < 1 || number > SIZE);
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];

        for (int row = 0; row < map.length; row++) {
            Arrays.fill(map[row], DOT_EMPTY);
        }
    }

    private static void printMap() {
        printMapHeader();
        printMapState();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" —");
        }
        System.out.println();
    }

    private static void printMapState() {
        for (int i = 0; i < map.length; i++) {
            printRowNumber(i);
            printRow(map[i]);
            System.out.println();
        }
    }

    private static void printRow(char[] chars) {
        for (int j = 0; j < chars.length; j++) {
            System.out.print(chars[j] + " ");
        }
    }

    private static void printRowNumber(int rowNumber) {
        System.out.print((rowNumber + 1) + " ");
    }

    private static void printMapHeader() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
