package View;

import javax.swing.*;
import Presenter.Presentador;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransicionImagen extends JPanel {
    private static final long serialVersionUID = 1L;

    private int offsetX;
    private final ImageIcon fondoCompleto;
    private final Timer timer;
    private final JFrame frame;
    private boolean moviendoIzquierda = false; 

    public TransicionImagen(Presentador presenter, JFrame frame) {
        this.frame = frame;
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MenuCrearOferta.class.getResource("/Imagenes/icono.jpg")));
        fondoCompleto = new ImageIcon(getClass().getResource("/Imagenes/fondoCompleto.jpg"));

        Image img = fondoCompleto.getImage().getScaledInstance(1200, 600, Image.SCALE_SMOOTH);
        fondoCompleto.setImage(img);

        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!moviendoIzquierda && offsetX < 600) {
                    offsetX += 10; 
                    repaint();
                } else if (moviendoIzquierda && offsetX > 0) {
                    offsetX -=10 ;
                    repaint();
                } else {
                    timer.stop();  
                    frame.setVisible(false);  
                    if (moviendoIzquierda) {
                        presenter.setVistaMenuPpal(true);
                        presenter.setVistaMenuOferta(false);
                    } else {
                        presenter.setVistaMenuOferta(true);
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondoCompleto.getImage(), -offsetX, 0, this);
    }

    public void iniciarTransicionDerecha() {
        offsetX = 0; 
        moviendoIzquierda = false;
        frame.setVisible(true);
        timer.start(); 
    }

    public void iniciarTransicionIzquierda() {
        offsetX = 600;      
        moviendoIzquierda = true; 
        frame.setVisible(true);
        timer.start();  
    }
}
