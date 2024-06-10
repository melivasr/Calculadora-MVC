package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    private JTextField display;
    private JButton[] numberButtons;
    private JButton addButton, subtractButton, multiplyButton, divideButton, equalsButton, clearButton;

    public CalculatorView() {
        // Configuración de la ventana principal
        setTitle("Calculadora");
        setSize(400, 500);  // Asegúrate de que este método esté aquí
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Configuración del display
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        add(display, BorderLayout.NORTH);

        // Configuración de los botones
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            panel.add(numberButtons[i]);
        }

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");
        clearButton = new JButton("C");

        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(multiplyButton);
        panel.add(divideButton);
        panel.add(equalsButton);
        panel.add(clearButton);

        add(panel, BorderLayout.CENTER);
    }

    public void setDisplayText(String text) {
        display.setText(text);
    }

    public String getDisplayText() {
        return display.getText();
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void addNumberButtonListener(ActionListener listener) {
        for (JButton button : numberButtons) {
            button.addActionListener(listener);
        }
    }

    public void addOperationButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
        subtractButton.addActionListener(listener);
        multiplyButton.addActionListener(listener);
        divideButton.addActionListener(listener);
        equalsButton.addActionListener(listener);
        clearButton.addActionListener(listener);
    }
}
