package presentacion;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import datatypes.DtFecha;
import datatypes.DtTime;
import interfaces.IControladorAltaUsuario;

import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import interfaces.IControladorAltaCurso;
import excepciones.InstitutoInexistente;
import excepciones.CursoRepetido;

public class AgregarCurso extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IControladorAltaCurso icon;
	private JTextField altaCursoInstitutotextField;
	private JTextField altaCursoNombretextField;
	private JTextField altaCursoDescripciontextField;
	private JTextField altaCursoDuraciontextField;
	private JTextField altaCursoCantHorastextField;
	private JTextField altaCursoCreditostextField;
	private JTextField altaCursoUrltextField;


	public AgregarCurso(IControladorAltaCurso icon) {
		this.icon = icon;
		setTitle("Alta Curso");
		setBounds(100, 100, 361, 427);
		getContentPane().setLayout(null);
		
		JLabel altaCursoInstitutoLabel = new JLabel("Instituto");
		altaCursoInstitutoLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		altaCursoInstitutoLabel.setBounds(12, 13, 86, 28);
		getContentPane().add(altaCursoInstitutoLabel);
		
		altaCursoInstitutotextField = new JTextField();
		altaCursoInstitutotextField.setBounds(110, 16, 203, 22);
		getContentPane().add(altaCursoInstitutotextField);
		altaCursoInstitutotextField.setColumns(10);
		
		JLabel altaCursoCustoLabel = new JLabel("Nombre");
		altaCursoCustoLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		altaCursoCustoLabel.setBounds(12, 54, 86, 28);
		getContentPane().add(altaCursoCustoLabel);
		
		altaCursoNombretextField = new JTextField();
		altaCursoNombretextField.setColumns(10);
		altaCursoNombretextField.setBounds(110, 57, 203, 22);
		getContentPane().add(altaCursoNombretextField);
		
		JLabel altaCursoDescripcionLabel = new JLabel("Descripcion");
		altaCursoDescripcionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		altaCursoDescripcionLabel.setBounds(12, 95, 86, 28);
		getContentPane().add(altaCursoDescripcionLabel);
		
		altaCursoDescripciontextField = new JTextField();
		altaCursoDescripciontextField.setColumns(10);
		altaCursoDescripciontextField.setBounds(110, 98, 203, 22);
		getContentPane().add(altaCursoDescripciontextField);
		
		JLabel altaCursoDuracionLabel = new JLabel("Duracion");
		altaCursoDuracionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		altaCursoDuracionLabel.setBounds(12, 136, 93, 28);
		getContentPane().add(altaCursoDuracionLabel);
		
		altaCursoDuraciontextField = new JTextField();
		altaCursoDuraciontextField.setColumns(10);
		altaCursoDuraciontextField.setBounds(110, 139, 203, 22);
		getContentPane().add(altaCursoDuraciontextField);
		
		JLabel altaCursoCantHorasLabel = new JLabel("Cant. Horas");
		altaCursoCantHorasLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		altaCursoCantHorasLabel.setBounds(12, 177, 93, 28);
		getContentPane().add(altaCursoCantHorasLabel);
		
		altaCursoCantHorastextField = new JTextField();
		altaCursoCantHorastextField.setColumns(10);
		altaCursoCantHorastextField.setBounds(110, 180, 203, 22);
		getContentPane().add(altaCursoCantHorastextField);
		
		JLabel altaCursoCreditosLabel = new JLabel("Creditos");
		altaCursoCreditosLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		altaCursoCreditosLabel.setBounds(12, 218, 93, 28);
		getContentPane().add(altaCursoCreditosLabel);
		
		altaCursoCreditostextField = new JTextField();
		altaCursoCreditostextField.setColumns(10);
		altaCursoCreditostextField.setBounds(110, 221, 203, 22);
		getContentPane().add(altaCursoCreditostextField);
		
		JButton altaCursoCancelarButton = new JButton("Cancelar");
		altaCursoCancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				limpiar();
			}
		});
		altaCursoCancelarButton.setBounds(12, 316, 97, 25);
		getContentPane().add(altaCursoCancelarButton);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// altaCurso
				altaCursoAceptarActionPerformed(arg0);
				limpiar();
			}
		});
		btnNewButton.setBounds(216, 316, 97, 25);
		getContentPane().add(btnNewButton);
		
		JLabel altaCursoUrlLabel = new JLabel("URL");
		altaCursoUrlLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		altaCursoUrlLabel.setBounds(12, 259, 93, 28);
		getContentPane().add(altaCursoUrlLabel);
		
		altaCursoUrltextField = new JTextField();
		altaCursoUrltextField.setColumns(10);
		altaCursoUrltextField.setBounds(110, 262, 203, 22);
		getContentPane().add(altaCursoUrltextField);
		

	}
	// String instituto, String nombre, String descripcion, 
	// String duracion, int cantHoras, int creditos, 
	// String url, DtFecha fechaR
	protected void altaCursoAceptarActionPerformed(ActionEvent arg0) {
		String instituto = this.altaCursoInstitutotextField.getText();
		String nombre = this.altaCursoNombretextField.getText();
		String descripcion = this.altaCursoDescripciontextField.getText();
		String duracion = this.altaCursoDuraciontextField.getText();
		int cantHoras = 0;
		try {
			cantHoras = Integer.parseInt(this.altaCursoCantHorastextField.getText());
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Alta Curso", JOptionPane.ERROR_MESSAGE);
		}
		int creditos = 0;
		try {
			creditos = Integer.parseInt(this.altaCursoCreditostextField.getText());
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Alta Curso", JOptionPane.ERROR_MESSAGE);
		}
		String url = this.altaCursoUrltextField.getText();
		LocalDate date = LocalDate.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("D-M-u");
		ArrayList<Integer> datos = new ArrayList<>();
		String valores [] = (date.format(format)).split("-");
		for(String s: valores) {
			int temp = Integer.parseInt(s);
			datos.add(temp);
		}
		DtFecha fechaR = new DtFecha(datos.get(0),datos.get(1),datos.get(2));
		if(checkeo(instituto,nombre,descripcion,duracion,cantHoras,creditos,url)) {
			try {
				this.icon.altaCurso(instituto, nombre, descripcion, duracion, cantHoras, creditos, url, fechaR);
				this.icon.confirmarAltaCurso();
				JOptionPane.showMessageDialog(this, "El curso fue ingresado con exito", "Alta Curso", JOptionPane.INFORMATION_MESSAGE);
			}catch(CursoRepetido | InstitutoInexistente e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Alta Curso", JOptionPane.ERROR_MESSAGE);
			}
			limpiar();
		}
	}
	
	private boolean checkeo(String instituto, String nombre, String descripcion, String duracion, int cantHoras, int creditos, String url) {
		if(instituto.isEmpty() || nombre.isEmpty() || nombre.isEmpty() || descripcion.isEmpty() || duracion.isEmpty() || cantHoras == 0 || creditos == 0){
			JOptionPane.showConfirmDialog(this, "No puede haber campos vacios", "Alta Curso", 
			JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void limpiar() {
		this.altaCursoInstitutotextField.setText("");
		this.altaCursoNombretextField.setText("");
		this.altaCursoDescripciontextField.setText("");
		this.altaCursoDuraciontextField.setText("");
		this.altaCursoCantHorastextField.setText("");
		this.altaCursoCreditostextField.setText("");
		this.altaCursoUrltextField.setText("");
	}
}
