package lesson8;

import javax.swing.*;
import java.awt.*;

public class PracticalTask extends JFrame {

    private static int counter = 0;
    private static int stepNumber = 1;
    private static JLabel counterValueView;

    public static void main(String[] args) {

        Font font = new Font("Arial", Font.BOLD, 32);

        JFrame mainFrame = initFrame(font);

        createButtonApplications(mainFrame, font);
        createMenu(mainFrame, font);

        mainFrame.setVisible(true);
    }

    private static void createMenu(JFrame mainFrame, Font font) {
        JMenuBar menu = new JMenuBar();
        JMenu list = new JMenu("Приложения");
        JMenuItem counterMenu = new JMenuItem("Счетчик");
        JMenuItem ticTacToe = new JMenuItem("Крестики нолики");
        list.add(counterMenu);
        list.add(ticTacToe);
        menu.add(list);
        mainFrame.setJMenuBar(menu);

        counterMenu.addActionListener(e -> createCounterMap(mainFrame,font));

        ticTacToe.addActionListener(e -> createTicTacToeMap(mainFrame, font));
    }


    public static void createTicTacToeMap(JFrame mainFrame, Font font) {
        mainFrame.setVisible(false);
        mainFrame = new JFrame();
        mainFrame.setTitle("Tic Tac Toe");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setBounds(300, 300, 400, 400);
        createMenu(mainFrame, font);
        mainFrame.setVisible(true);

    }

    public static void createButtonApplications(JFrame mainFrame, Font font) {
        JButton counter = new JButton("Счетчик");
        counter.setFont(font);
        mainFrame.add(counter, BorderLayout.PAGE_START);
        counter.addActionListener(e -> createCounterMap(mainFrame, font));

        JButton ticTacToe = new JButton("Крестики нолики");
        ticTacToe.setFont(font);
        mainFrame.add(ticTacToe, BorderLayout.PAGE_END);
        ticTacToe.addActionListener(e -> createTicTacToeMap(mainFrame, font));
    }

    private static void createCounterMap(JFrame mainFrame, Font font) {
        mainFrame.setVisible(false);
        mainFrame = initFrame(font);
        createMenu(mainFrame, font);
        createCounterView(mainFrame, font);
        createButtons(mainFrame, font);
        createInputNumbers(mainFrame);
        mainFrame.setVisible(true);
    }


    private static void createInputNumbers(JFrame mainFrame) {
        Font font = new Font("Arial", Font.BOLD, 22);

        JLabel text = new JLabel("Шаг " + stepNumber + ". Введите шаг:");
        text.setFont(font);

        JTextField inputLine = new JTextField(3);
        inputLine.addActionListener(e -> {
            stepNumber = Integer.parseInt(inputLine.getText());
            inputLine.setText(null);
            text.setText("Шаг " + stepNumber + ". Введите шаг:");
        });

        JPanel panel = new JPanel();
        panel.add(text);
        panel.add(inputLine);
        mainFrame.add(panel, BorderLayout.PAGE_START);

    }

    private static void createButtons(JFrame mainFrame, Font font) {

        JButton decrementButton = new JButton("<");
        decrementButton.setFont(font);
        mainFrame.add(decrementButton, BorderLayout.LINE_START);

        JButton incrementButton = new JButton(">");
        incrementButton.setFont(font);
        mainFrame.add(incrementButton, BorderLayout.LINE_END);

        JButton resetButton = new JButton("RESET");
        resetButton.setFont(font);
        mainFrame.add(resetButton, BorderLayout.PAGE_END);

        decrementButton.addActionListener(e -> {
            counter = counter - stepNumber;
            counterValueView.setText(String.valueOf(counter));
        });
        incrementButton.addActionListener(e -> {
            counter = stepNumber + counter;
            counterValueView.setText(String.valueOf(counter));
        });

        resetButton.addActionListener(e -> {
            counter = 0;
            counterValueView.setText(String.valueOf(counter));
        });

    }

    private static JFrame initFrame(Font font) {
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Counter");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setBounds(300, 300, 400, 200);
        createMenu(mainFrame, font);
        return mainFrame;
    }

    private static void createCounterView(JFrame mainFrame, Font font) {
        counterValueView = new JLabel(getCounterValueAsText());
        counterValueView.setHorizontalAlignment(SwingConstants.CENTER);
        counterValueView.setFont(font);
        mainFrame.add(counterValueView, BorderLayout.CENTER);
    }

    private static String getCounterValueAsText() {
        return String.valueOf(counter);
    }

}