package pedr0ni;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import pedr0ni.sockets.*;
import pedr0ni.ui.NewJFrame;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }

        System.out.println("Conectando...");
        Servidor con = null;
        try {
            con = new Servidor("localhost", 25565);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível iniciar o ProjetoMusicas por: \n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        new NewJFrame(con).setVisible(true);
    }
}
