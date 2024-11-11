package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JCalendar;
import Model.Oferta;
import Presenter.Presentador;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.Rectangle;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.Font;

public class MenuPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel frameMenuPpal;
    private Presentador presenter;
    private MenuCrearOferta ventanaOferta;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuPrincipal frame = new MenuPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        frameMenuPpal = new JPanel();
        frameMenuPpal.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(frameMenuPpal);
        frameMenuPpal.setLayout(null);
        this.setResizable(false);
        botonAgregarOferta();
        calendario();
    }

    public MenuPrincipal() {
    	setTitle("CALENDARIO(MENU PRINCIPAL)");
        ventanaOferta = new MenuCrearOferta(); 
        presenter = new Presentador(ventanaOferta, this);
        ventanaOferta.setPresenter(presenter);
        
        initialize();
    }

    private void calendario() {
        JCalendar calendar_1 = new JCalendar();
        calendar_1.getDayChooser().getDayPanel().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        calendar_1.setBounds(46, 11, 493, 224);
        frameMenuPpal.add(calendar_1);
        btnObtenerFecha(calendar_1);
        
        JLabel fondoCalendario = new JLabel("");
        fondoCalendario.setBounds(0, 0, 584, 361);
        fondoCalendario.setIcon(new ImageIcon(MenuCrearOferta.class.getResource("/Imagenes/fondoCalendario.jpg")));
        frameMenuPpal.add(fondoCalendario);

    }
    
    private void btnObtenerFecha(JCalendar calend) {
        JButton btnObtenerFecha = new JButton("Obtener adjudicaciones en la fecha seleccionada");
        btnObtenerFecha.setHorizontalTextPosition(SwingConstants.CENTER);
        btnObtenerFecha.setIcon(null);
        btnObtenerFecha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnObtenerFecha.setBorder(new LineBorder(new Color(0, 0, 0)));
        btnObtenerFecha.setBounds(122, 245, 349, 29);
        btnObtenerFecha.setBorder(new LineBorder(Color.BLACK, 1, true));
        btnObtenerFecha.setFocusPainted(false);
        frameMenuPpal.add(btnObtenerFecha);
      
    
        btnObtenerFecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date fechaSeleccionada = calend.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String fechaSelecConFormato = sdf.format(fechaSeleccionada);
                presenter.obtenerOfertasPorFecha(fechaSelecConFormato);
            }
        });
    }

    private void botonAgregarOferta() {
        JButton btnAgregarOferta = new JButton("Agregar oferta para mañana");
        btnAgregarOferta.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnAgregarOferta.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnAgregarOferta.setHorizontalTextPosition(SwingConstants.CENTER);
        btnAgregarOferta.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/flechaDerecha.png")));
        btnAgregarOferta.setContentAreaFilled(false);
        btnAgregarOferta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAgregarOferta.setBounds(209, 273, 169, 88);
        btnAgregarOferta.setBorder(null);
        btnAgregarOferta.setFocusPainted(false);
        
        frameMenuPpal.add(btnAgregarOferta);
        btnAgregarOferta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuPrincipal.this.setVisible(false);
                presenter.setVistaMenuOferta(true);
            }
        });
    }


    public void mostrarOfertasEnVentana(List<Oferta> todasLasOfertas, List<Oferta> ofertasAdjudicadas, String fechaSeleccionada) {
        if (todasLasOfertas.isEmpty()) {
        	noHayOfertasEnFecha();
        } else {
            JFrame frame = new JFrame("Ofertas del dia: " + fechaSeleccionada);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);

            DefaultListModel<String> model = new DefaultListModel<>();
            for (Oferta oferta : todasLasOfertas) {
                model.addElement("Oferta: " + oferta.getMonto() + " desde " 
                                 + oferta.getInicio() + " hasta " + oferta.getFin());
            }
            JList<String> list = new JList<>(model);
            
            //Cambiamos de color a las ofertas adjudicadas
            list.setCellRenderer((list1, value, index, isSelected, cellHasFocus) -> {
                JLabel labelListaOfertas = new JLabel(value);
                if (ofertasAdjudicadas.contains(todasLasOfertas.get(index))) {
                    labelListaOfertas.setForeground(Color.RED); 
                } else {
                    labelListaOfertas.setForeground(Color.BLACK); 
                }
                return labelListaOfertas;
            });
            
            JLabel referenciaLabel = new JLabel("REFERENCIAS: Ofertas adjudicadas en color rojo");
            referenciaLabel.setHorizontalAlignment(JLabel.CENTER);
            frame.getContentPane().add(referenciaLabel, BorderLayout.SOUTH); 

            JScrollPane scrollPane = new JScrollPane(list);
            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
            frame.setVisible(true);
        }
    }

	public void noHayOfertasEnFecha() {
        JOptionPane.showMessageDialog(frameMenuPpal, "No hay ofertas para la fecha seleccionada.");
	}
}
    



