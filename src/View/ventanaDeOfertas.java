package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Model.Json;
import Model.Oferta;
import Model.SalaEnsayo;
import Presenter.Observador;
import Presenter.ObservadoresOferta;
import Presenter.SalaControlador;

public class ventanaDeOfertas implements ObservadoresOferta  {
	private SalaEnsayo salaLogica= new SalaEnsayo();
	private  SalaControlador sala = new SalaControlador(salaLogica);
	
	Json json = new Json(sala);
	
	JTextArea espacioOfertas = new JTextArea();
	private JFrame frame;
	private JTextField espacioMonto;
	private Observador observador;
	private JTextField espacioHorarioInicio;
	private JTextField espacioHorarioFin;
	private JLabel labelHorarioInicio;
	private JLabel labelHorarioFin;
	private JLabel labelMonto;
	private JLabel fondoOfertas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaDeOfertas window = new ventanaDeOfertas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	
	public ventanaDeOfertas() {
		this.observador = new Observador (this.sala.getSala());
		this.sala.getSala().agregarObservador(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 
	        json.guardarOfertasEnJson();
		
		JButton botonEnviarOferta = new JButton("Enviar Oferta");
		botonEnviarOferta.setForeground(Color.BLUE);
		botonEnviarOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				observador.enviarOferta(espacioHorarioInicio.getText(), espacioHorarioFin.getText(),espacioMonto.getText());
				setear();
			}

	
	
		});
		botonEnviarOferta.setBounds(304, 360, 125, 23);
		frame.getContentPane().add(botonEnviarOferta);
		
		espacioMonto = new JTextField();
		espacioMonto.setBounds(129, 101, 125, 20);
		frame.getContentPane().add(espacioMonto);
		espacioMonto.setColumns(10);
		
		espacioHorarioInicio = new JTextField();
		espacioHorarioInicio.setBounds(129, 22, 125, 20);
		frame.getContentPane().add(espacioHorarioInicio);
		espacioHorarioInicio.setColumns(10);
		
		espacioHorarioFin = new JTextField();
		espacioHorarioFin.setBounds(129, 53, 125, 20);
		frame.getContentPane().add(espacioHorarioFin);
		espacioHorarioFin.setColumns(10);
		
		labelHorarioInicio = new JLabel("Hs inicio :");
		labelHorarioInicio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelHorarioInicio.setForeground(Color.BLUE);
		labelHorarioInicio.setBounds(43, 25, 59, 14);
		frame.getContentPane().add(labelHorarioInicio);
		
		labelHorarioFin = new JLabel("Hs fin:");
		labelHorarioFin.setForeground(Color.BLUE);
		labelHorarioFin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelHorarioFin.setBounds(43, 56, 59, 14);
		frame.getContentPane().add(labelHorarioFin);
		
		labelMonto = new JLabel("Oferta :");
		labelMonto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelMonto.setForeground(Color.BLUE);
		labelMonto.setBounds(43, 104, 59, 14);
		frame.getContentPane().add(labelMonto);
		espacioOfertas.setBackground(Color.LIGHT_GRAY);
		espacioOfertas.setEditable(false);
		
		
		espacioOfertas.setBounds(417, 20, 194, 257);
		frame.getContentPane().add(espacioOfertas);
		
		fondoOfertas = new JLabel("");
		//fondoOfertas.setIcon(new ImageIcon(ventanaDeOfertas.class.getResource("/Imagenes/fondoTp3.jpg")));
		fondoOfertas.setBounds(0, 0, 734, 561);
		frame.getContentPane().add(fondoOfertas);
	}
	
	//------------------------------------------------------------------------------------------------------------
	private void setear() {
		espacioHorarioInicio.setText("");
		espacioHorarioFin.setText("");
		espacioMonto.setText("");
		}
	//------------------------------------------------------------------------------------------------------------
	@Override
	public void notificar(Oferta ofer) {
		 espacioOfertas.append("Nueva oferta: " + ofer.getMonto() +"\n");
		
	}
}
