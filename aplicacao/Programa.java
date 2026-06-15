package aplicacao;

import javax.swing.SwingUtilities;

public class Programa {
    public static void main(String[] args) {
        // Uso do Swing para criação da interface gráfica de forma segura
        SwingUtilities.invokeLater(new Runnable() { 
            @Override
            public void run() {
                new TelaSistema();
            }
        });
    }
}