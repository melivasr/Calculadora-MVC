/**
 * Clase principal que inicia la aplicación de la calculadora.
 *
 * @author Melissa Vásquez
 * @author José Andrés Vargas
 * @version 1.0 09 de Junio de 2024
 */
package org.calculator;

import org.calculator.controller.CalculatorController;
import org.calculator.view.CalculatorView;

public class Main {
    /**
     * Método principal que inicia la aplicación de la calculadora.
     */
    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(view);
        view.setVisible(true);
    }
}
