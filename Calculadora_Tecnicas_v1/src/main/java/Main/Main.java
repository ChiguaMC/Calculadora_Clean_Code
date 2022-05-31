package Main;

import Controlador.Control;
import Vista.Interface;

/**
 *
 * @author Chigua
 */
public class Main {

    public static void main(String[] args) {
        
        Interface vista = new Interface();
        Control control = new Control(vista);
        control.controlar();
    }
}
