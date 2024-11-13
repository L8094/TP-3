	package View;
	
	import java.awt.Color;
	import java.awt.EventQueue;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JTextArea;
	import javax.swing.JTextField;
	
	import Model.Oferta;
	import Presenter.Presentador;
	import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
	
	public class MenuCrearOferta  {
		
		JTextArea espacioOfertas = new JTextArea();
		private JFrame frmFormulario;
		private JTextField espacioMonto;
		private JLabel labelUsuario;
		private JLabel labelHorarioInicio;
		private JLabel labelHorarioFin;
		private JLabel labelMonto;
		private JLabel fondoOfertas;
		private JComboBox<Integer> horaInicio;
		private JComboBox<Integer> horaFin;
	    private Presentador presenter;
	    private JTextField espacioNombre;

	     
	public MenuCrearOferta() {
	        initialize();
		}
	    
	
	private void labelVentana() {
		labelUsuario = new JLabel("Nombre:");
		labelUsuario.setForeground(Color.BLUE);
		labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelUsuario.setBounds(24, 156, 59, 14);
		frmFormulario.getContentPane().add(labelUsuario);
	
		labelHorarioInicio = new JLabel("Hs inicio :");
		labelHorarioInicio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelHorarioInicio.setForeground(Color.BLUE);
		labelHorarioInicio.setBounds(24, 210, 59, 14);
		frmFormulario.getContentPane().add(labelHorarioInicio);
		
		labelHorarioFin = new JLabel("Hs fin:");
		labelHorarioFin.setForeground(Color.BLUE);
		labelHorarioFin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelHorarioFin.setBounds(24, 255, 59, 14);
		frmFormulario.getContentPane().add(labelHorarioFin);
		
		labelMonto = new JLabel("Oferta :");
		labelMonto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelMonto.setForeground(Color.BLUE);
		labelMonto.setBounds(24, 304, 59, 14);
		frmFormulario.getContentPane().add(labelMonto);
	}
	
	private void imputOfertaUsuario() {
		
		espacioNombre = new JTextField();
		espacioNombre.setBounds(128, 154, 125, 20);
		frmFormulario.getContentPane().add(espacioNombre);
		espacioNombre.setColumns(10);
		
		horaInicio = new JComboBox<Integer>();
		horaInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		horaInicio.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23}));
		horaInicio.setBounds(128, 207, 59, 22);
		frmFormulario.getContentPane().add(horaInicio);
		
		horaFin = new JComboBox<Integer>();
		horaFin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		horaFin.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
		horaFin.setBounds(128, 252, 59, 22);
		frmFormulario.getContentPane().add(horaFin);
		
		espacioMonto = new JTextField();
		espacioMonto.setBounds(128, 302, 125, 20);
		frmFormulario.getContentPane().add(espacioMonto);
		espacioMonto.setColumns(10);
		
	}
	
	private void espacioOfertas() {
	espacioOfertas.setBackground(Color.LIGHT_GRAY);
	espacioOfertas.setEditable(false);
	espacioOfertas.setBounds(350, 95, 194, 257);
	frmFormulario.getContentPane().add(espacioOfertas);
	}
	
	private void btnGuardarOferta() {
		JButton btnGuardarOferta = new JButton("Crear nueva oferta");
		btnGuardarOferta.setBorderPainted(false);
		btnGuardarOferta.setContentAreaFilled(false);
		btnGuardarOferta.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGuardarOferta.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnGuardarOferta.setIcon(new ImageIcon(MenuCrearOferta.class.getResource("/Imagenes/lgoCrear.png")));
		btnGuardarOferta.setFocusPainted(false);
		btnGuardarOferta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardarOferta.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGuardarOferta.setForeground(Color.BLUE);
		btnGuardarOferta.setBounds(138, 457, 160, 92);
		frmFormulario.getContentPane().add(btnGuardarOferta);
		btnGuardarOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer horaInicioSeleccionada = (Integer)horaInicio.getSelectedItem();  
				Integer horaFinSeleccionada= (Integer)horaFin.getSelectedItem();
				if (horaInicioSeleccionada > horaFinSeleccionada) {
		            JOptionPane.showMessageDialog(null, "Seleccione un rango horario valido");
				} else {
		            String montoText = espacioMonto.getText();
		            String usuarioText = espacioNombre.getText();
		            try {
		                int monto = Integer.parseInt(montoText);
		                if (monto < 1) {
		                    JOptionPane.showMessageDialog(null, "Ingrese un monto positivo.");
		                } else {
		                    presenter.agregarOferta(horaInicioSeleccionada, horaFinSeleccionada, montoText,usuarioText);
		                    setearImputUsuario();
		                }
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(null, "Ingrese un monto valido (solo numeros).");
		            }
		        }
		    }
		});
		
	}
	
	private void setearImputUsuario() {
		horaInicio.setSelectedIndex(0);
		horaFin.setSelectedIndex(0);
		espacioMonto.setText("");
		espacioNombre.setText("");
		}
	
	
	private void btnBorrarOfertas() {
		JButton btnBorrarOfertas = new JButton("Borrar Ofertas");
		btnBorrarOfertas.setContentAreaFilled(false);
		btnBorrarOfertas.setBorderPainted(false);
		btnBorrarOfertas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBorrarOfertas.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnBorrarOfertas.setIcon(new ImageIcon(MenuCrearOferta.class.getResource("/Imagenes/papelera.png")));
		btnBorrarOfertas.setFocusPainted(false);
		btnBorrarOfertas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBorrarOfertas.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBorrarOfertas.setForeground(Color.BLUE);
		btnBorrarOfertas.setBounds(298, 457, 153, 92);
		frmFormulario.getContentPane().add(btnBorrarOfertas);
		btnBorrarOfertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(	presenter.hayOfertas()) {
					presenter.borrarOfertasDeMemoria();
					espacioOfertas.setText("");
				}
				 JOptionPane.showMessageDialog(null, "No hay ofertas para eliminar");
				}
		});
	}
	
	   
	private void btnEnviarOfertaJson() {
		JButton btnEnviarOfertasJson = new JButton("Enviar Ofertas");
		btnEnviarOfertasJson.setContentAreaFilled(false);
		btnEnviarOfertasJson.setBorderPainted(false);
		btnEnviarOfertasJson.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEnviarOfertasJson.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEnviarOfertasJson.setIcon(new ImageIcon(MenuCrearOferta.class.getResource("/Imagenes/lgoGuardar.png")));
		btnEnviarOfertasJson.setFocusPainted(false);
		btnEnviarOfertasJson.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnviarOfertasJson.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEnviarOfertasJson.setForeground(Color.BLUE);
		btnEnviarOfertasJson.setBounds(431, 457, 153, 92);
		frmFormulario.getContentPane().add(btnEnviarOfertasJson);
		btnEnviarOfertasJson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(	presenter.hayOfertas()) {
				presenter.agregarOfertas();
				espacioOfertas.setText("");
			}
			 JOptionPane.showMessageDialog(null, "No hay ofertas para guardar en el sistema");
			}
		});
		
	}
	    
	
	
	private void btnMenuPrincipal() {		
		JButton btnVueltaMenuPrincipal = new JButton("Menu Principal");
		btnVueltaMenuPrincipal.setBorderPainted(false);
		btnVueltaMenuPrincipal.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVueltaMenuPrincipal.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnVueltaMenuPrincipal.setContentAreaFilled(false);
		btnVueltaMenuPrincipal.setIcon(new ImageIcon(MenuCrearOferta.class.getResource("/Imagenes/flechaIzquierda.png")));
		btnVueltaMenuPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVueltaMenuPrincipal.setFocusPainted(false);
		btnVueltaMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFormulario.setVisible(false);
				presenter.setVistaMenuPpal(true);
				
			}
		});
		btnVueltaMenuPrincipal.setForeground(Color.BLUE);
		btnVueltaMenuPrincipal.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVueltaMenuPrincipal.setBounds(0, 462, 127, 83);
		frmFormulario.getContentPane().add(btnVueltaMenuPrincipal);
	}

	
	private void fondo() {
		fondoOfertas = new JLabel("");
		fondoOfertas.setForeground(Color.BLACK);
		fondoOfertas.setIcon(new ImageIcon(MenuCrearOferta.class.getResource("/Imagenes/fondoTp.jpg")));
		fondoOfertas.setBounds(0, 0, 584, 561);
		frmFormulario.getContentPane().add(fondoOfertas);
		}
	
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						
						MenuCrearOferta window = new MenuCrearOferta();
						window.frmFormulario.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}});
		}
					
			
		private void initialize() {
			frmFormulario = new JFrame();
			frmFormulario.setIconImage(Toolkit.getDefaultToolkit().getImage(MenuCrearOferta.class.getResource("/Imagenes/fondoTp.jpg")));
			frmFormulario.setTitle("CREAR OFERTAS");
			frmFormulario.setBounds(100, 100, 600, 600);
			frmFormulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmFormulario.getContentPane().setLayout(null);
			frmFormulario.setResizable(false);

			
			labelVentana();
			imputOfertaUsuario();
			espacioOfertas();
			btnMenuPrincipal();
			btnGuardarOferta();
			btnBorrarOfertas();
			btnEnviarOfertaJson();
			fondo();
			
		}
		
		public void actualizarOferta(Oferta ofer) {
			 espacioOfertas.append("Nueva oferta: " + ofer.getMonto() +"\n");
		}
		
		public void setPresenter(Presentador pres) {
			this.presenter = pres;
		}

		public void setVisible(boolean o) {
			this.frmFormulario.setVisible(o);
			
		}
	}
