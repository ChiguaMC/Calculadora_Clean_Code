package Vista;

import javax.swing.JOptionPane;

/**
 *
 * @author Chigua
 */
public class Interface {
    public VistaPrincipal vistaPrincipal;
    
    public Interface()
    {
        this.vistaPrincipal = new VistaPrincipal();
    }
    
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
