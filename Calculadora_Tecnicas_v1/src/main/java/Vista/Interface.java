package Vista;

import javax.swing.JOptionPane;

/**
 *
 * @author Chigua
 */
public class Interface {
    
    //Este es un JFrame
    public VistaPrincipal vistaPrincipal;
    
    //Constructor + inicialización del JFrame
    public Interface()
    {
        this.vistaPrincipal = new VistaPrincipal();
    }
    
    //Mensajes usados desde la vista control
    public void mensajeEsPrimo(String numero)
    {
     JOptionPane.showMessageDialog(vistaPrincipal, "El número " + numero + " es primo", "Primo", JOptionPane.INFORMATION_MESSAGE);
    }
    public void mensajeNoEsPrimo(String numero)
    {
        JOptionPane.showMessageDialog(vistaPrincipal, "El número " + numero + " no es primo","Primo", JOptionPane.INFORMATION_MESSAGE);
    }
    public void mensajeEsPalindromo(String numero)
    {
        JOptionPane.showMessageDialog(vistaPrincipal, "El número " + numero + " es palíndromo","Palíndromo", JOptionPane.INFORMATION_MESSAGE);
    }
    public void mensajeNoEsPalindromo(String numero)
    {
        JOptionPane.showMessageDialog(vistaPrincipal, "El número " + numero + " no es palíndromo","Palíndromo", JOptionPane.INFORMATION_MESSAGE);
    }
}
