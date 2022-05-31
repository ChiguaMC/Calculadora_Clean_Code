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

    
    //Atributo para poder llamar a la vistaPrincipal y de ahí un Jfram
    private Interface vista;
    private int primerNumeroDigitado;
    private String operandoSolicitado;
    
    public Control(Interface vista) {
        this.vista = vista;
        this.primerNumeroDigitado = 0;
        this.operandoSolicitado = "";
    }

    //Esta es la función que se va a llamar desde el main para empezar a controlar.
    public void controlar() {

        this.vista.vistaPrincipal.setLocationRelativeTo(null);
        
        this.vista.vistaPrincipal.setVisible(true);

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

    //Si se presionan los botones del 0 al 00
    public void switchNumeros(String comandoAccion) {
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

    //Si se presionan los botones de operaciones excluyendo "=" "primo" "palindromo"
    public void switchOperadores(String comandoAccion) {
        switch (comandoAccion) {
            case "+":
                primerNumeroDigitado = primerNumeroDigitado + Integer.parseInt(vista.vistaPrincipal.inputPantalla.getText());
                break;
            case "-":
                primerNumeroDigitado = primerNumeroDigitado - Integer.parseInt(vista.vistaPrincipal.inputPantalla.getText());
                break;
            case "*":
                primerNumeroDigitado = primerNumeroDigitado * Integer.parseInt(vista.vistaPrincipal.inputPantalla.getText());
                break;
            case "/":
                primerNumeroDigitado = primerNumeroDigitado / Integer.parseInt(vista.vistaPrincipal.inputPantalla.getText());
                break;
            default:
        }
    }

    //Si se presionan los botones de operaciones excluyendo "=" "primo" "palindromo"
    //Lo hago en un switch nuevo para evitar tener que poner las mismas instrucciones en cada caso del case de arriba
    public void switchSubtotal(String comandoAccion) {
        switch (comandoAccion) {
            case "+":
            case "-":
            case "*":
            case "/":
                vista.vistaPrincipal.inputSubtotal.setText(Integer.toString(primerNumeroDigitado));
                vista.vistaPrincipal.inputPantalla.setText("");
                this.operandoSolicitado = comandoAccion;
                break;
            default:
        }
    }

    //Si se presionan los botones de operaciones excluyendo "=" "primo" "palindromo"
    //Lo hago en un switch separado para poder poner un if independiente del switch anterior.
    public void switchOperadoresIgual() {
        switch (this.operandoSolicitado) {
            case "+":
                primerNumeroDigitado += Integer.parseInt(vista.vistaPrincipal.inputPantalla.getText());
                break;
            case "-":
                primerNumeroDigitado -= Integer.parseInt(vista.vistaPrincipal.inputPantalla.getText());
                break;
            case "*":
                primerNumeroDigitado *= Integer.parseInt(vista.vistaPrincipal.inputPantalla.getText());
                break;
            case "/":
                primerNumeroDigitado /= Integer.parseInt(vista.vistaPrincipal.inputPantalla.getText());
                break;
            default:
        }
    }

    //Controla el switch del botón "="
    public void switchIgual(String comandoAccion) {
        switch (comandoAccion) {
            case "=":
                switchOperadoresIgual();
                vista.vistaPrincipal.inputPantalla.setText(Integer.toString(primerNumeroDigitado));
                primerNumeroDigitado = 0;
                vista.vistaPrincipal.inputSubtotal.setText("");
                break;
            default:
        }
    }
    
    //Este switch controla las funciones restantes no operadoras, primo, palindromo y borrar
    public void switchPrimoPalindromoBorrar(String comandoAccion)
    {
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
                    this.primerNumeroDigitado = 0;
                    this.operandoSolicitado = "";
                    break;
            }
    }

    //Función que retorna true en caso de que sea un número primo, false en caso de que no lo sea
    public boolean esPrimo(int numeroIntroducido) {
        for (int i = 2; i < numeroIntroducido; i++) {
            if (numeroIntroducido % i == 0) {
                return false;
            }
        }
        return true;
    }

    //Esta es una función de apoyo para la verificación de número palíndromo. Se encarga de descomponer el número original en residuos (último dígito) y reconstruirlo con sumas en una variable separada
    public int voltearNumero(int numeroAVoltear) {
        int numeroInvertido = 0;
        while (numeroAVoltear != 0) {
            int ultimoDigito = numeroAVoltear % 10;
            numeroInvertido = numeroInvertido * 10 + ultimoDigito;
            numeroAVoltear = numeroAVoltear / 10;
        }
        return numeroInvertido;
    }

    //Compara el número original a revisar si es palíndromo con el número volteado
    public boolean compararNumeros(int numeroOriginal, int numeroInvertido) {
        if (numeroOriginal == numeroInvertido) {
            return true;
        }
        return false;
    }

    //Esta es la función principal en la que se incluyen los main de cada proceso
    public void accionesCalculadora(String comandoAccion) {

        //Este try lo que hace es ignorar el proceso en caso de que cualquier botón de operación se presione sin que haya un número en pantalla
        try {
            switchNumeros(comandoAccion);

            //Revisa si existe un número previamente añadido o no
            if ((comandoAccion.equals("+") || comandoAccion.equals("-") || comandoAccion.equals("*") || comandoAccion.equals("/")) && (vista.vistaPrincipal.inputSubtotal.getText().isBlank())) {
                primerNumeroDigitado = Integer.parseInt(vista.vistaPrincipal.inputPantalla.getText());
            } else {
                switchOperadores(comandoAccion);
            }

            switchSubtotal(comandoAccion);

            switchIgual(comandoAccion);
            
            switchPrimoPalindromoBorrar(comandoAccion);
            
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
                accionesCalculadora(boton.getActionCommand());
        }
    }

    //Métodos vacíos porque no son necesarios para la función del programa
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
