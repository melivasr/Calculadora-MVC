package Controller;

import model.CalculatorModel;
import view.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;
    private double tempNumber;
    private String operator;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        this.view.addNumberButtonListener(new NumberButtonListener());
        this.view.addOperationButtonListener(new OperationButtonListener());
    }

    class NumberButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String number = e.getActionCommand();
            String currentText = view.getDisplayText();
            view.setDisplayText(currentText + number);
        }
    }

    class OperationButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            try {
                switch (command) {
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        tempNumber = Double.parseDouble(view.getDisplayText());
                        operator = command;
                        view.setDisplayText("");
                        break;
                    case "=":
                        double secondNumber = Double.parseDouble(view.getDisplayText());
                        switch (operator) {
                            case "+":
                                model.add(tempNumber + secondNumber);
                                break;
                            case "-":
                                model.subtract(tempNumber - secondNumber);
                                break;
                            case "*":
                                model.multiply(tempNumber * secondNumber);
                                break;
                            case "/":
                                model.divide(tempNumber / secondNumber);
                                break;
                        }
                        view.setDisplayText(String.valueOf(model.getResult()));
                        break;
                    case "C":
                        model.clear();
                        view.setDisplayText("");
                        break;
                }
            } catch (ArithmeticException ex) {
                view.showError(ex.getMessage());
            }
        }
    }
}