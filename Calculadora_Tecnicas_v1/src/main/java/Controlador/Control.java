package Controlador;

import Vista.Interface;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author Chigua
 */
public class Control implements MouseListener {

    private Interface vista;
    private int primerNumero;
    private String operando;

    public Control(Interface vista) {
        this.vista = vista;
        this.primerNumero = 0;
        this.operando = "";
    }

    public void controlar() {

        //Posiciona la vista en el centro de la pantalla
        this.vista.vistaPrincipal.setLocationRelativeTo(null);

        //Muestra la pantalla
        this.vista.vistaPrincipal.setVisible(true);

        //Agrega los listeners a los botones
        vista.vistaPrincipal.botonCero.addMouseListener(this);
        vista.vistaPrincipal.botonUno.addMouseListener(this);
        vista.vistaPrincipal.botonDos.addMouseListener(this);
        vista.vistaPrincipal.botonTres.addMouseListener(this);
        vista.vistaPrincipal.botonCuatro.addMouseListener(this);
        vista.vistaPrincipal.botonCinco.addMouseListener(this);
        vista.vistaPrincipal.botonSeis.addMouseListener(this);
        vista.vistaPrincipal.botonSiete.addMouseListener(this);
        vista.vistaPrincipal.botonOcho.addMouseListener(this);
        vista.vistaPrincipal.botonNueve.addMouseListener(this);
        vista.vistaPrincipal.botonDobleCero.addMouseListener(this);
        vista.vistaPrincipal.botonSuma.addMouseListener(this);
        vista.vistaPrincipal.botonResta.addMouseListener(this);
        vista.vistaPrincipal.botonMultiplicacion.addMouseListener(this);
        vista.vistaPrincipal.botonDivision.addMouseListener(this);
        vista.vistaPrincipal.botonIgual.addMouseListener(this);
        vista.vistaPrincipal.botonPrimo.addMouseListener(this);
        vista.vistaPrincipal.botonPalindromo.addMouseListener(this);
        vista.vistaPrincipal.botonBorrar.addMouseListener(this);
    }

    public void switchBotonesNumeros(String comandoAccion) {
        switch (comandoAccion) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "00":
                vista.vistaPrincipal.inputPantalla.setText(vista.vistaPrincipal.inputPantalla.getText() + comandoAccion);
                break;
            default:
        }
    }

    public void switchBotonesOperadores(String comandoAccion) {
        switch (comandoAccion) {
            case "+":
                primerNumero = primerNumero + Integer.parseInt(vista.vistaPrincipal.inputPantalla.getText());
                break;
            case "-":
                primerNumero = primerNumero - Integer.parseInt(vista.vistaPrincipal.inputPantalla.getText());
                break;
            case "*":
                primerNumero = primerNumero * Integer.parseInt(vista.vistaPrincipal.inputPantalla.getText());
                break;
            case "/":
                primerNumero = primerNumero / Integer.parseInt(vista.vistaPrincipal.inputPantalla.getText());
                break;
            default:
        }
    }

    public void switchOperadoresSubtotal(String comandoAccion) {
        switch (comandoAccion) {
            case "+":
            case "-":
            case "*":
            case "/":
                vista.vistaPrincipal.inputSubtotal.setText(Integer.toString(primerNumero));
                vista.vistaPrincipal.inputPantalla.setText("");
                this.operando = comandoAccion;
                break;
            default:
        }
    }

    public void switchOperadoresDelIgual() {
        switch (this.operando) {
            case "+":
                primerNumero += Integer.parseInt(vista.vistaPrincipal.inputPantalla.getText());
                break;
            case "-":
                primerNumero -= Integer.parseInt(vista.vistaPrincipal.inputPantalla.getText());
                break;
            case "*":
                primerNumero *= Integer.parseInt(vista.vistaPrincipal.inputPantalla.getText());
                break;
            case "/":
                primerNumero /= Integer.parseInt(vista.vistaPrincipal.inputPantalla.getText());
                break;
            default:
        }
    }

    public void switchBotonIgual(String comandoAccion) {
        switch (comandoAccion) {
            case "=":
                switchOperadoresDelIgual();
                vista.vistaPrincipal.inputPantalla.setText(Integer.toString(primerNumero));
                primerNumero = 0;
                vista.vistaPrincipal.inputSubtotal.setText("");
                break;
            default:
        }
    }

    public boolean esPrimo(int numeroIntroducido) {
        for (int i = 2; i < numeroIntroducido; i++) {
            if (numeroIntroducido % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int voltearNumero(int numeroAVoltear) {
        int numeroInvertido = 0;
        while (numeroAVoltear != 0) {
            int ultimoDigito = numeroAVoltear % 10;
            numeroInvertido = numeroInvertido * 10 + ultimoDigito;
            numeroAVoltear = numeroAVoltear / 10;
        }
        return numeroInvertido;
    }

    public boolean compararNumeros(int numeroOriginal, int numeroInvertido) {
        if (numeroOriginal == numeroInvertido) {
            return true;
        }
        return false;
    }

    public void accionesBotonesCalculadora(String comandoAccion) {

        try {
            switchBotonesNumeros(comandoAccion);

            if ((comandoAccion.equals("+") || comandoAccion.equals("-") || comandoAccion.equals("*") || comandoAccion.equals("/")) && (vista.vistaPrincipal.inputSubtotal.getText().isBlank())) {
                primerNumero = Integer.parseInt(vista.vistaPrincipal.inputPantalla.getText());
            } else {
                switchBotonesOperadores(comandoAccion);
            }

            switchOperadoresSubtotal(comandoAccion);

            switchBotonIgual(comandoAccion);

            int numeroARevisar = 0;

            switch (comandoAccion) {
                case "Primo":
                    numeroARevisar = Integer.parseInt(vista.vistaPrincipal.inputPantalla.getText());
                    if (this.esPrimo(numeroARevisar)) {
                        vista.mensajeEsPrimo(Integer.toString(numeroARevisar));
                    } else {
                        vista.mensajeNoEsPrimo(Integer.toString(numeroARevisar));
                    }
                    break;
                case "Palindromo":
                    numeroARevisar = Integer.parseInt(vista.vistaPrincipal.inputPantalla.getText());
                    if (this.compararNumeros(numeroARevisar, this.voltearNumero(numeroARevisar))) {
                        vista.mensajeEsPalindromo(Integer.toString(numeroARevisar));
                    } else {
                        vista.mensajeNoEsPalindromo(Integer.toString(numeroARevisar));
                    }
                    break;
                case "Borrar":
                    vista.vistaPrincipal.inputPantalla.setText("");
                    vista.vistaPrincipal.inputSubtotal.setText("");
                    this.primerNumero = 0;
                    this.operando = "";
                    break;
            }
        } catch (Exception exception) {
            System.out.print(exception.getMessage());
            System.out.print("\nNo hay nada en pantalla para procesar");
        }

    }

    //Métodos listeners de mouse por defecto
    @Override
    public void mouseClicked(MouseEvent fuenteClick) {
        switch (fuenteClick.getSource().getClass().getSimpleName()) {
            case "JButton":
                JButton boton = (JButton) fuenteClick.getSource();
                accionesBotonesCalculadora(boton.getActionCommand());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
