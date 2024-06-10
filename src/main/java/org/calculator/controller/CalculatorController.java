/**
 * Clase que actua como controlador para la calculadora.
 *
 * @author Melissa Vasquez
 * @author Jose Andres Vargas
 * @version 1.0 09 de Junio de 2024
 */
package org.calculator.controller;

import org.calculator.model.CalculatorModel;
import org.calculator.view.CalculatorView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;
    private double primerNumero;
    private char operador;

    /**
     * Constructor de la clase CalculatorController.
     *
     * @param view La vista de la calculadora.
     */
    public CalculatorController(CalculatorView view) {
        this.model = new CalculatorModel();
        this.view = view;

        for (int i = 0; i < 10; i++) {
            final int num = i;
            view.addNumeroListener(i, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    view.agregarNumero(num);
                }
            });
        }

        view.addNumeroListener(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.agregarNumero(10);
            }
        });
        view.addOperacionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operador = ((JButton) e.getSource()).getText().charAt(0);
                primerNumero = Double.parseDouble(view.getTextField());
                view.limpiar();
            }
        });
        view.addIgualListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double segundoNumero = Double.parseDouble(view.getTextField());
                double resultado = calcularResultado(primerNumero, segundoNumero, operador);
                view.mostrarResultado(resultado);
            }
        });

        view.addLimpiarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });
    }

    /**
     * Calcula el resultado de la operacion.
     *
     * @param num1 El primer numero.
     * @param num2 El segundo numero.
     * @param op   El operador (+, -, *, /).
     * @return El resultado de la operacion.
     */
    private double calcularResultado(double num1, double num2, char op) {
        switch (op) {
            case '+':
                return model.sumar(num1, num2);
            case '-':
                return model.restar(num1, num2);
            case '*':
                return model.multiplicar(num1, num2);
            case '/':
                try {
                    return model.dividir(num1, num2);
                } catch (ArithmeticException ex) {
                    view.mostrarError("No se puede dividir por cero");
                    return 0;
                }
            default:
                return 0;
        }
    }

    /**
     * Limpia la pantalla de la calculadora.
     */
    private void limpiar() {
        view.limpiar();
    }
}
