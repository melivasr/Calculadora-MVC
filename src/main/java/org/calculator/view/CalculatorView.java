/**
 * Clase que representa la vista de la calculadora.
 *
 * @author Melissa Vasquez
 * @author Jose Andres Vargas
 * @version 1.0 09 de Junio de 2024
 */
package org.calculator.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    private JTextField textField;
    private JButton sumarButton;
    private JButton restarButton;
    private JButton multiplicarButton;
    private JButton dividirButton;
    private JButton igualButton;
    private JButton limpiarButton;
    private JButton[] numeroButtons;

    private boolean puntoDecimalAgregado = false; // Flag para controlar si se ha agregado un punto decimal

    /**
     * Constructor de la clase CalculatorView.
     */
    public CalculatorView() {
        initComponents();
        setLayout(new BorderLayout());
        JPanel panelNumeros = new JPanel(new GridLayout(4, 3));
        for (JButton button : numeroButtons) {
            button.setFont(new Font("Arial", Font.BOLD, 20)); // Cambiar el tamaño y tipo de letra
            button.setBackground(Color.LIGHT_GRAY); // Cambiar el color de fondo
            panelNumeros.add(button);
        }
        panelNumeros.add(numeroButtons[10]);
        add(panelNumeros, BorderLayout.CENTER);
        JPanel panelOperaciones = new JPanel(new GridLayout(5, 1));
        panelOperaciones.add(limpiarButton);
        panelOperaciones.add(dividirButton);
        panelOperaciones.add(multiplicarButton);
        panelOperaciones.add(restarButton);
        panelOperaciones.add(sumarButton);
        add(panelOperaciones, BorderLayout.EAST);
        igualButton.setFont(new Font("Arial", Font.BOLD, 20));
        igualButton.setBackground(Color.CYAN);
        add(igualButton, BorderLayout.SOUTH);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        add(textField, BorderLayout.NORTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calculadora");
        setSize(300, 250);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        textField = new JTextField();
        sumarButton = new JButton("+");
        restarButton = new JButton("-");
        multiplicarButton = new JButton("*");
        dividirButton = new JButton("/");
        limpiarButton = new JButton("Limpiar");
        igualButton = new JButton("=");

        numeroButtons = new JButton[11];
        for (int i = 0; i < 10; i++) {
            numeroButtons[i] = new JButton(Integer.toString(i));
        }
        numeroButtons[10] = new JButton(".");
    }

    /**
     * Agrega un numero a la pantalla de la calculadora.
     *
     * @param numero El numero a agregar.
     */
    public void agregarNumero(int numero) {
        String textoActual = textField.getText();
        if (numero == 10) {
            if (!puntoDecimalAgregado) {
                textField.setText(textoActual + ".");
                puntoDecimalAgregado = true;
            }
        } else {
            textField.setText(textoActual + numero);
        }
    }

    /**
     * Obtiene el texto actual en la pantalla de la calculadora.
     *
     * @return El texto actual en la pantalla.
     */
    public String getTextField() {
        return textField.getText();
    }

    /**
     * Muestra el resultado en la pantalla de la calculadora.
     *
     * @param resultado El resultado a mostrar.
     */
    public void mostrarResultado(double resultado) {
        textField.setText(formatearResultado(resultado));
    }

    /**
     * Formatea el resultado para mostrarlo en la pantalla.
     *
     * @param resultado El resultado a formatear.
     * @return El resultado formateado.
     */
    private String formatearResultado(double resultado) {
        String resultadoString = Double.toString(resultado);
        if (resultadoString.endsWith(".0")) {
            return resultadoString.substring(0, resultadoString.length() - 2);
        }
        return resultadoString;
    }

    /**
     * Limpia la pantalla de la calculadora.
     */
    public void limpiar() {
        textField.setText("");
        puntoDecimalAgregado = false;
    }

    /**
     * Muestra un mensaje de error en la calculadora.
     *
     * @param mensaje El mensaje de error a mostrar.
     */
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Agrega un ActionListener para los botones de operación.
     *
     * @param listener El ActionListener a agregar.
     */
    public void addOperacionListener(ActionListener listener) {
        sumarButton.addActionListener(listener);
        restarButton.addActionListener(listener);
        multiplicarButton.addActionListener(listener);
        dividirButton.addActionListener(listener);
    }

    /**
     * Agrega un ActionListener para el boton de igual.
     *
     * @param listener El ActionListener a agregar.
     */
    public void addIgualListener(ActionListener listener) {
        igualButton.addActionListener(listener);
    }

    /**
     * Agrega un ActionListener para el boton de limpiar.
     *
     * @param listener El ActionListener a agregar.
     */
    public void addLimpiarListener(ActionListener listener) {
        limpiarButton.addActionListener(listener);
    }

    /**
     * Agrega un ActionListener para los botones numericos.
     *
     * @param numero   El numero asociado al boton.
     * @param listener El ActionListener a agregar.
     */
    public void addNumeroListener(int numero, ActionListener listener) {
        numeroButtons[numero].addActionListener(listener);
    }
}

