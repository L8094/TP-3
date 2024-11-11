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
	import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
	
	public class MenuCrearOferta  {
		
		JTextArea espacioOfertas = new JTextArea();
		private JFrame frmFormulario;
		private JTextField espacioMonto;
		private JLabel labelHorarioInicio;
		private JLabel labelHorarioFin;
		private JLabel labelMonto;
		private JLabel fondoOfertas;
		private JComboBox<Integer> horaInicio;
		private JComboBox<Integer> horaFin;
	    private Presentador presenter;
	    private JTextField espacioNombreUsuario;
	    
	
	
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

		
		
		public MenuCrearOferta() {
	        initialize();
		}
	
		private void botonEnviarOfer() {
			JButton botonEnviarOferta = new JButton("Crear nueva oferta");
			botonEnviarOferta.setFocusPainted(false);
			botonEnviarOferta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			botonEnviarOferta.setFont(new Font("Tahoma", Font.PLAIN, 13));
			botonEnviarOferta.setForeground(Color.BLUE);
			botonEnviarOferta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Integer horaInicioSeleccionada = (Integer)horaInicio.getSelectedItem();  
					Integer horaFinSeleccionada= (Integer)horaFin.getSelectedItem();
					if (horaInicioSeleccionada > horaFinSeleccionada) {
			            JOptionPane.showMessageDialog(null, "Seleccione un rango horario valido");
					} else {
			            String montoText = espacioMonto.getText();
			            String usuarioText = espacioNombreUsuario.getText();
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
			botonEnviarOferta.setBounds(70, 360, 182, 23);
			frmFormulario.getContentPane().add(botonEnviarOferta);
		}
		
		private void imputOfertaUsuario() {
			horaInicio = new JComboBox<Integer>();
			horaInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			horaInicio.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23}));
			horaInicio.setBounds(112, 92, 59, 22);
			frmFormulario.getContentPane().add(horaInicio);
			
			horaFin = new JComboBox<Integer>();
			horaFin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			horaFin.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
			horaFin.setBounds(112, 125, 59, 22);
			frmFormulario.getContentPane().add(horaFin);
			
			espacioMonto = new JTextField();
			espacioMonto.setBounds(112, 171, 125, 20);
			frmFormulario.getContentPane().add(espacioMonto);
			espacioMonto.setColumns(10);
			
		}
		
		private void lblVentana() {
			labelHorarioInicio = new JLabel("Hs inicio :");
			labelHorarioInicio.setFont(new Font("Tahoma", Font.PLAIN, 13));
			labelHorarioInicio.setForeground(Color.BLUE);
			labelHorarioInicio.setBounds(43, 97, 59, 14);
			frmFormulario.getContentPane().add(labelHorarioInicio);
			
			labelHorarioFin = new JLabel("Hs fin:");
			labelHorarioFin.setForeground(Color.BLUE);
			labelHorarioFin.setFont(new Font("Tahoma", Font.PLAIN, 13));
			labelHorarioFin.setBounds(43, 133, 59, 14);
			frmFormulario.getContentPane().add(labelHorarioFin);
			
			labelMonto = new JLabel("Oferta :");
			labelMonto.setFont(new Font("Tahoma", Font.PLAIN, 13));
			labelMonto.setForeground(Color.BLUE);
			labelMonto.setBounds(43, 173, 59, 14);
			frmFormulario.getContentPane().add(labelMonto);
		}

		private void btnAgregarOferta() {
			JButton btnGuardarOfertas = new JButton("Guardar Ofertas");
			btnGuardarOfertas.setFocusPainted(false);
			btnGuardarOfertas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnGuardarOfertas.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnGuardarOfertas.setForeground(Color.BLUE);
			btnGuardarOfertas.setBounds(417, 360, 194, 23);
			frmFormulario.getContentPane().add(btnGuardarOfertas);
			
			espacioNombreUsuario = new JTextField();
			espacioNombreUsuario.setBounds(125, 31, 153, 20);
			frmFormulario.getContentPane().add(espacioNombreUsuario);
			espacioNombreUsuario.setColumns(10);
			
			JLabel labelUsuario = new JLabel("Nombre y Apellido:");
			labelUsuario.setForeground(Color.BLUE);
			labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
			labelUsuario.setBounds(10, 29, 127, 23);
			frmFormulario.getContentPane().add(labelUsuario);
			
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
			btnVueltaMenuPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnVueltaMenuPrincipal.setBounds(277, 410, 127, 83);
			frmFormulario.getContentPane().add(btnVueltaMenuPrincipal);
			
			fondoOfertas = new JLabel("");
			fondoOfertas.setIcon(new ImageIcon(MenuCrearOferta.class.getResource("/Imagenes/fondoTp.jpg")));
			fondoOfertas.setBounds(0, 0, 734, 561);
			frmFormulario.getContentPane().add(fondoOfertas);
			
			btnGuardarOfertas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					presenter.agregarOfertas();
					espacioOfertas.setText("");
				}
			});
			
		}
		private void initialize() {
			frmFormulario = new JFrame();
			frmFormulario.setIconImage(Toolkit.getDefaultToolkit().getImage(MenuCrearOferta.class.getResource("/Imagenes/fondoTPM.jpg")));
			frmFormulario.setTitle("FORMULARIO");
			frmFormulario.setBounds(100, 100, 700, 600);
			frmFormulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmFormulario.getContentPane().setLayout(null);
			frmFormulario.setResizable(false);
			botonEnviarOfer();
			imputOfertaUsuario();
			lblVentana();

			espacioOfertas.setBackground(Color.LIGHT_GRAY);
			espacioOfertas.setEditable(false);
			espacioOfertas.setBounds(417, 20, 194, 257);
			frmFormulario.getContentPane().add(espacioOfertas);
			btnAgregarOferta();

		}
		
		private void setearImputUsuario() {
			horaInicio.setSelectedIndex(0);
			horaFin.setSelectedIndex(0);
			espacioMonto.setText("");
			espacioNombreUsuario.setText("");
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
