package Lesson8;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CounterApp extends JFrame {

    private int counter = 0;

    public CounterApp() {
        setTitle("CounterApp window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(650, 350, 250, 120);

        Font font = new Font("Arial", Font.BOLD, 30);

        setLayout(new GridLayout(2, 3));
        JButton decrementButton = new JButton("<");
        add(decrementButton);
        JLabel counterView = new JLabel(String.valueOf(counter));
        counterView.setHorizontalAlignment(SwingConstants.CENTER);
        counterView.setFont(font);
        add(counterView, BorderLayout.CENTER);
        JButton incrementButton = new JButton(">");
        add(incrementButton);
        JButton minus10Button = new JButton("-10");
        add(minus10Button);
        JButton resetButton = new JButton("Reset");
        add(resetButton);
        JButton plus10Button = new JButton("+10");
        add(plus10Button);

        ActionListener actionListener = e -> {
            if (e.getSource() == plus10Button) {
                counter += 10;
            } else if (e.getSource() == minus10Button) {
                counter -= 10;
            } else if (e.getSource() == incrementButton) {
                counter++;
            } else if (e.getSource() == decrementButton) {
                counter--;
            } else if (e.getSource() == resetButton) {
                counter = 0;
            }
            refreshCounterView(counterView);
        };

        decrementButton.addActionListener(actionListener);
        incrementButton.addActionListener(actionListener);
        minus10Button.addActionListener(actionListener);
        plus10Button.addActionListener(actionListener);
        resetButton.addActionListener(actionListener);

        setVisible(true);
    }

    private void refreshCounterView(JLabel counterView) {
        counterView.setText(String.valueOf(counter));
    }

    public static void main(String[] args) {
        new CounterApp();
    }
}