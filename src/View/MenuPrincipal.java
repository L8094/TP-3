package View;
	
	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.EventQueue;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.MouseEvent;
	import java.util.List;
	import javax.swing.DefaultListModel;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
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
	import java.util.Calendar;
	import java.util.Date;
	import java.awt.Cursor;
	import javax.swing.SwingConstants;

	import java.awt.Font;
	import java.awt.Image;
	import java.awt.Toolkit;
	
	import javax.swing.UIManager;
	import javax.swing.JMenuItem;
	
	public class MenuPrincipal extends JFrame {
	
	    private static final long serialVersionUID = 1L;
	    private JPanel frameMenuPpal;
	    private Presentador presenter;
	    private MenuCrearOferta ventanaOferta;
        JFrame transicionFrame = new JFrame("  SALA DE ENSAYOS GENERALES"); 
        
        
	    public MenuPrincipal() {
	        setSize(600, 600);
	        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setVisible(true);
	    	setTitle("  SALA DE ENSAYOS GENERALES");
	        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.jpg")));

	        ventanaOferta = new MenuCrearOferta(); 
	        presenter = new Presentador(ventanaOferta, this);
	        ventanaOferta.setPresenter(presenter);
	        initialize();
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
	                model.addElement(oferta.toString());
	            }
	            JList<String> list = new JList<>(model);
	            
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
	
	
	    private void calendario() {
	        JCalendar calendar_1 = new JCalendar();
	        calendar_1.getYearChooser().setBackground(new Color(128, 0, 0));
	        calendar_1.getMonthChooser().setBackground(new Color(139, 69, 19));
	        calendar_1.setWeekOfYearVisible(false);
	        calendar_1.setTodayButtonVisible(true);
	        calendar_1.setBorder(UIManager.getBorder("Button.border"));
	        calendar_1.setWeekdayForeground(new Color(0, 0, 0));
	        calendar_1.setSundayForeground(new Color(255, 0, 0));
	        calendar_1.setDecorationBackgroundColor(new Color(220, 220, 220));
	        calendar_1.setForeground(Color.BLACK);
	        calendar_1.getDayChooser().getDayPanel().setForeground(Color.WHITE);
	        calendar_1.getDayChooser().getDayPanel().setLocation(119, 0);
	        calendar_1.getDayChooser().getDayPanel().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        calendar_1.getDayChooser().getDayPanel().setBackground(new Color(255, 255, 255, 100));
	        calendar_1.setOpaque(false);
	        calendar_1.setBounds(126, 129, 349, 219);
	        frameMenuPpal.add(calendar_1);
	        btnObtenerFecha(calendar_1);
	    }
	        

	    private void establecerFondo() {
	        JLabel fondoCalendario = new JLabel();
	        fondoCalendario.setBounds(0, 0, 600, 600); 
	        
	        ImageIcon fondoIcon = new ImageIcon(
	            new ImageIcon(getClass().getResource("/Imagenes/fondoTp.jpg"))
	                .getImage()
	                .getScaledInstance(600, 600, Image.SCALE_SMOOTH)
	        );
	        
	        fondoCalendario.setIcon(fondoIcon);
	        frameMenuPpal.add(fondoCalendario);
	        
	        JMenuItem menuItem = new JMenuItem("New menu item");
	        menuItem.setBounds(10, 0, 137, 26);
	        frameMenuPpal.add(menuItem);
	    }
	    
	    private void btnObtenerFecha(JCalendar calend) {
	        JButton btnObtenerFecha = new JButton("Ver adjudicaciones en la fecha seleccionada");
	        btnObtenerFecha.setHorizontalTextPosition(SwingConstants.CENTER);
	        btnObtenerFecha.setIcon(null);
	        btnObtenerFecha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        btnObtenerFecha.setBorder(new LineBorder(new Color(0, 0, 0)));
	        btnObtenerFecha.setBounds(126, 383, 349, 29);
	        btnObtenerFecha.setBorder(new LineBorder(Color.BLACK, 1, true));
	        btnObtenerFecha.setFocusPainted(false);
	        frameMenuPpal.add(btnObtenerFecha);
	      
	    
	        btnObtenerFecha.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                Date fechaSeleccionada = calend.getDate();
	                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	                String fechaSelecConFormato = sdf.format(fechaSeleccionada);
	                presenter.obtenerOfertasPorFecha(fechaSelecConFormato);
	            }
	        });
	    }

	    private void botonAgregarOferta() {
	        Date fechaActual = new Date();
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(fechaActual);
	        calendar.add(Calendar.DAY_OF_YEAR, 1); 
	        Date fechaManana = calendar.getTime();
	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM");
	        String fechaFormateada = sdf.format(fechaManana);

	        ImageIcon originalIcon = new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/lgoCrear1.png"));
	        ImageIcon darkIcon = createDarkIcon(originalIcon.getImage());
	        ImageIcon scaledOriginalIcon = new ImageIcon(originalIcon.getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH));
	        ImageIcon scaledDarkIcon = new ImageIcon(darkIcon.getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH));

	        JButton btnAgregarOferta = new JButton("Agregar oferta " + fechaFormateada);
	        btnAgregarOferta.setForeground(Color.WHITE);
	        btnAgregarOferta.setFont(new Font("Tahoma", Font.BOLD, 11));
	        btnAgregarOferta.setVerticalTextPosition(SwingConstants.BOTTOM);
	        btnAgregarOferta.setHorizontalTextPosition(SwingConstants.CENTER);
	        btnAgregarOferta.setIcon(scaledOriginalIcon);
	        btnAgregarOferta.setContentAreaFilled(false);
	        btnAgregarOferta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        btnAgregarOferta.setBounds(200, 428, 200, 130);
	        btnAgregarOferta.setBorder(null);
	        btnAgregarOferta.setFocusPainted(false);

	        btnAgregarOferta.addMouseListener(new java.awt.event.MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                btnAgregarOferta.setIcon(scaledDarkIcon); 
	            }
	            @Override
	            public void mouseExited(MouseEvent e) {
	                btnAgregarOferta.setIcon(scaledOriginalIcon); 
	            }
	        });

	        frameMenuPpal.add(btnAgregarOferta);
	        btnAgregarOferta.addActionListener(e -> {
	            MenuPrincipal.this.setVisible(false);
	            mostrarTransicionImagen();
	        });
	    }

	    private ImageIcon createDarkIcon(Image image) {
	        java.awt.image.BufferedImage bufferedImage = new java.awt.image.BufferedImage(
	                image.getWidth(null), image.getHeight(null), java.awt.image.BufferedImage.TYPE_INT_ARGB);

	        java.awt.Graphics2D g2d = bufferedImage.createGraphics();
	        g2d.drawImage(image, 0, 0, null);
	        g2d.setComposite(java.awt.AlphaComposite.SrcOver.derive(0.6f)); 
	        g2d.setColor(Color.BLACK);
	        g2d.fillRect(0, 0, image.getWidth(null), image.getHeight(null));
	        g2d.dispose();

	        return new ImageIcon(bufferedImage);
	    }

	    
	    
	    private void mostrarTransicionImagen() {
	        TransicionImagen transicion = new TransicionImagen(presenter, transicionFrame);
	        transicionFrame.setSize(600, 600);
	        transicionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        transicionFrame.setLocationRelativeTo(null);
	        transicionFrame.setVisible(true);
	        transicionFrame.getContentPane().add(transicion);
	        transicion.iniciarTransicionDerecha(); 
	    }

	    private void verificarCierreVentana() {
	        this.addWindowListener(new java.awt.event.WindowAdapter() {
	            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
	                int option = JOptionPane.showConfirmDialog(MenuPrincipal.this, 
	                    "Seguro queres salir? \n Las ofertas no guardadas se perderán.", 
	                    "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	                if (option == JOptionPane.YES_OPTION) {
	                    System.exit(0); 
	                } 
	            }
	        });
	    }
	    
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
	        frameMenuPpal = new JPanel();
	        frameMenuPpal.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(frameMenuPpal);
	        frameMenuPpal.setLayout(null);
	        this.setResizable(false);
	        botonAgregarOferta();
	        calendario();
	        establecerFondo();
	        verificarCierreVentana();
	    }
	}
	    
	
	
	
