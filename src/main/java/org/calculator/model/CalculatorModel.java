/**
 * Clase que representa el modelo de la calculadora.
 *
 * @author Melissa Vasquez
 * @author Jose Andres Vargas
 * @version 1.0 09 de Junio de 2024
 */
package org.calculator.model;

public class CalculatorModel {
    /**
     * Realiza la suma de dos numeros.
     *
     * @param num1 El primer numero.
     * @param num2 El segundo numero.
     * @return La suma de los dos numeros.
     */
    public double sumar(double num1, double num2) {
        return num1 + num2;
    }

    /**
     * Realiza la resta de dos numeros.
     *
     * @param num1 El primer numero.
     * @param num2 El segundo numero.
     * @return La resta de los dos numeros.
     */
    public double restar(double num1, double num2) {
        return num1 - num2;
    }

    /**
     * Realiza la multiplicacion de dos numeros.
     *
     * @param num1 El primer numero.
     * @param num2 El segundo numero.
     * @return La multiplicacion de los dos numeros.
     */
    public double multiplicar(double num1, double num2) {
        return num1 * num2;
    }

    /**
     * Realiza la divisinn de dos numeros.
     *
     * @param num1 El dividendo.
     * @param num2 El divisor.
     * @return El resultado de la división.
     * @throws ArithmeticException Si se intenta dividir por cero.
     */
    public double dividir(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return num1 / num2;
    }
}
