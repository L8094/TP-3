		package View;
		
		import java.awt.BorderLayout;
import java.awt.Color;
		import java.awt.EventQueue;
		import java.awt.Font;
	import java.awt.Image;
	import java.awt.event.ActionEvent;
		import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
		import javax.swing.JFrame;
		import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
		import javax.swing.JTextField;
		
		import Model.Oferta;
		import Presenter.Presentador;
		import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
	
	import java.awt.Cursor;
	import javax.swing.SwingConstants;
	import java.awt.Toolkit;
		
		public class MenuCrearOferta  {
			
			JTextArea espacioOfertas = new JTextArea();
			private JFrame frameMenuOferta;
			private JLabel fondoOfertas;
		    private Presentador presenter;
	        JFrame transicionFrame = new JFrame("  SALA DE ENSAYOS GENERALES");

	
		     
		public MenuCrearOferta() {
		        initialize();
			}
		
		private void verLicitacionesEnSistema() {
			
			JButton btnNewButton = new JButton("Ver licitaciones en sistema");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					presenter.obtenerLicitaciones();
					
				}
			});
			btnNewButton.setBounds(22, 70, 197, 35);
			frameMenuOferta.getContentPane().add(btnNewButton);
			
		}
		    
		private void espacioOfertas() {
				
			JLabel lblLicitacinPara = new JLabel("- Ingrese las ofertas que quiere licitar -");
			lblLicitacinPara.setForeground(Color.WHITE);
			lblLicitacinPara.setFont(new Font("Segoe UI", Font.BOLD, 18));
			lblLicitacinPara.setBackground(Color.WHITE);
			lblLicitacinPara.setBounds(10, 11, 500, 35);
			frameMenuOferta.getContentPane().add(lblLicitacinPara);
			
		espacioOfertas.setBackground(Color.LIGHT_GRAY);

			espacioOfertas.setEditable(false); 
			espacioOfertas.setBounds(22, 125, 536, 304);
			frameMenuOferta.getContentPane().add(espacioOfertas);
		}

		
		 private void configurarBotones() {
			 
		        JButton btnVueltaMenuPrincipal = new JButton("HOME");
		        configurarBoton(btnVueltaMenuPrincipal, "/Imagenes/flechaIzquierda1.png", 00, 440, new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	mostrarTransicionImagen();
		            }});
		        
		        JButton btnGuardarOferta = new JButton("AGREGAR");
		        configurarBoton(btnGuardarOferta, "/Imagenes/lgoCrear2.png", 130, 440, new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                crearNuevaOferta();
		            }});

		        JButton btnBorrarOfertas = new JButton("BORRAR");
		        configurarBoton(btnBorrarOfertas, "/Imagenes/papelera1.png", 270, 440, new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                borrarOfertas();
		            }});
		        
		        JButton btnEnviarOfertasJson = new JButton("ENVIAR");
		        configurarBoton(btnEnviarOfertasJson, "/Imagenes/lgoGuardar3.png", 410, 440, new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                enviarOfertasJson();
		            } });


		    }
		 
		    private void mostrarTransicionImagen() {
		        TransicionImagen transicion = new TransicionImagen(presenter, transicionFrame);
		        transicionFrame.setSize(600, 600); 
		        transicionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        transicionFrame.setLocationRelativeTo(null);
		        transicionFrame.setVisible(true);

		        transicionFrame.getContentPane().add(transicion); 
		        transicion.iniciarTransicionIzquierda();  
		    }
		
		    
		    private void configurarBoton(JButton boton, String iconPath, int x, int y, ActionListener action) {
		        boton.setBorderPainted(false);
		        boton.setContentAreaFilled(false);
		        boton.setHorizontalTextPosition(SwingConstants.CENTER);
		        boton.setVerticalTextPosition(SwingConstants.BOTTOM);

		        ImageIcon originalIcon = new ImageIcon(MenuCrearOferta.class.getResource(iconPath));
		        Image scaledImage = originalIcon.getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH);
		        ImageIcon scaledIcon = new ImageIcon(scaledImage);
		        ImageIcon darkIcon = createDarkIcon(scaledImage);

		        boton.setIcon(scaledIcon);
		        boton.setFocusPainted(false);
		        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		        boton.setFont(new Font("Tahoma", Font.BOLD, 13));
		        boton.setForeground(Color.WHITE);
		        boton.setBounds(x, y, 170, 110);
		        boton.addActionListener(action);

		        boton.addMouseListener(new java.awt.event.MouseAdapter() {
		            @Override
		            public void mouseEntered(java.awt.event.MouseEvent e) {
		                boton.setIcon(darkIcon); 
		            }
		            @Override
		            public void mouseExited(java.awt.event.MouseEvent e) {
		                boton.setIcon(scaledIcon); 
		            }
		        });

		        frameMenuOferta.getContentPane().add(boton);
		    }

		    private ImageIcon createDarkIcon(Image image) {
		        Image darkImage = new ImageIcon(image).getImage();
		        java.awt.image.BufferedImage bufferedImage = new java.awt.image.BufferedImage(
		            darkImage.getWidth(null), darkImage.getHeight(null), java.awt.image.BufferedImage.TYPE_INT_ARGB);

		        java.awt.Graphics2D g2d = bufferedImage.createGraphics();
		        g2d.drawImage(darkImage, 0, 0, null);
		        g2d.setComposite(java.awt.AlphaComposite.SrcOver.derive(0.6f));
		        g2d.setColor(Color.BLACK);
		        g2d.fillRect(0, 0, darkImage.getWidth(null), darkImage.getHeight(null));
		        g2d.dispose();

		        return new ImageIcon(bufferedImage);
		    }

	    
		    private void crearNuevaOferta() {
		    	
		        JTextField nombreField = new JTextField(10);
		        JComboBox<Integer> horaInicioBox = new JComboBox<>(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23});
		        JComboBox<Integer> horaFinBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
		        JTextField montoField = new JTextField(10);

		        JPanel panel = new JPanel();
		        panel.setLayout(new java.awt.GridLayout(4, 2, 5, 5));
		        panel.add(new JLabel("Nombre:"));
		        panel.add(nombreField);
		        panel.add(new JLabel("Horario desde:"));
		        panel.add(horaInicioBox);
		        panel.add(new JLabel("Hasta:"));
		        panel.add(horaFinBox);
		        panel.add(new JLabel("Monto:                      $"));
		        panel.add(montoField);

		        int result = JOptionPane.showConfirmDialog(frameMenuOferta, panel, 
		            "Crear Nueva Oferta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		        if (result == JOptionPane.OK_OPTION) {
		            try {
		                String nombre = nombreField.getText().trim();
		                int horaInicio = (int) horaInicioBox.getSelectedItem();
		                int horaFin = (int) horaFinBox.getSelectedItem();
		                int monto = Integer.parseInt(montoField.getText().trim());

		                if (horaInicio >= horaFin) {
		                    JOptionPane.showMessageDialog(frameMenuOferta, "El horario seleccionado no es valido", "Error", JOptionPane.ERROR_MESSAGE);
		                    return;
		                }
		                if (monto <= 0) {
		                    JOptionPane.showMessageDialog(frameMenuOferta, "El monto ingresado no es valido", "Error", JOptionPane.ERROR_MESSAGE);
		                    return;
		                }
		                presenter.agregarOferta(horaInicio, horaFin, String.valueOf(monto), nombre);
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(frameMenuOferta, "El monto ingresado no es valido (Solo numeros)", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        }
		    }

	    private void borrarOfertas() {
	        if (presenter.hayOfertas()) {
	            presenter.borrarOfertasDeMemoria();
	            espacioOfertas.setText("");
	        } else {
	            JOptionPane.showMessageDialog(null, "No hay ofertas para eliminar");
	        }
	    }

	    private void enviarOfertasJson() {
	        if (presenter.hayOfertas()) {
	            presenter.agregarOfertas();
	            espacioOfertas.setText("");
	        } else {
	            JOptionPane.showMessageDialog(null, "No hay ofertas para guardar en el sistema");
	        }
	    }

				
		private void fondo() {
		    ImageIcon icon = new ImageIcon(MenuCrearOferta.class.getResource("/Imagenes/fondoCalendario.jpg"));
		    Image image = icon.getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH);
		    ImageIcon scaledIcon = new ImageIcon(image);
	
		    fondoOfertas = new JLabel(scaledIcon);
		    fondoOfertas.setForeground(Color.BLACK);
		    fondoOfertas.setBounds(0, 0, 600, 600); 
		    frameMenuOferta.getContentPane().add(fondoOfertas);
		}
		
			public static void main(String[] args) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							MenuCrearOferta window = new MenuCrearOferta();
							window.frameMenuOferta.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}}});
			}
			
			private void verificarCierreVentana() {
				frameMenuOferta.addWindowListener(new java.awt.event.WindowAdapter() {
				    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				        int option = JOptionPane.showConfirmDialog(frameMenuOferta, 
				            "Seguro queres salir? \n Las ofertas no guardadas se perderan", "Confirmar salida", 
				            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				        if (option == JOptionPane.YES_OPTION) {
				        	frameMenuOferta.dispose(); 
				        } 
				    }
				});

			}
			
			public void mostrarOfertasEnVentana(List<Oferta> todasLasOfertas, String fechaSeleccionada) {
			    if (todasLasOfertas.isEmpty()) {
			        noHayOfertasEnFecha();
			    } else {
			        JFrame frame = new JFrame("Ofertas del día: " + fechaSeleccionada);
			        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        frame.setSize(400, 300);
			        frame.setLocationRelativeTo(null);
			        DefaultListModel<String> model = new DefaultListModel<>();
			        for (Oferta oferta : todasLasOfertas) {
			            model.addElement(oferta.toString());
			        }
			        JList<String> list = new JList<>(model);
			        JScrollPane scrollPane = new JScrollPane(list);
			        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

			        frame.setVisible(true);
			    }
			}

						
				
			public void noHayOfertasEnFecha() {
		        JOptionPane.showMessageDialog(frameMenuOferta, "No hay ofertas para la fecha seleccionada.");
				
			}

			private void initialize() {
				frameMenuOferta = new JFrame();
				frameMenuOferta.setIconImage(Toolkit.getDefaultToolkit().getImage(MenuCrearOferta.class.getResource("/Imagenes/icono.jpg")));
				frameMenuOferta.setTitle("  LICITAR SALA DE ENSAYO");
				frameMenuOferta.setBounds(100, 100, 600, 600);
				frameMenuOferta.getContentPane().setLayout(null);
				frameMenuOferta.setResizable(false);
		        frameMenuOferta.setLocationRelativeTo(null);
		        frameMenuOferta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				verLicitacionesEnSistema();
		        espacioOfertas();
				configurarBotones();
				fondo();
				verificarCierreVentana();
				
			}
			
			public void actualizarOferta(Oferta ofer) {
				 espacioOfertas.append(ofer.toString() + "\n");
			}
			
			public void setPresenter(Presentador pres) {
				this.presenter = pres;
			}
	
			public void setVisible(boolean o) {
				this.frameMenuOferta.setVisible(o);
				
			}
		}
