package presentacion;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import datatypes.DtCursoBase;
import datatypes.DtFecha;
import datatypes.DtTime;
import interfaces.IControladorAltaUsuario;
import interfaces.IControladorConsultaCurso;

import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import interfaces.IControladorAltaCurso;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import excepciones.CursoRepetido;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import java.awt.Component;

public class AgregarCurso extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IControladorAltaCurso icon;
	private IControladorConsultaCurso iconaux;
	private JTextField altaCursoInstitutotextField;
	private JTextField altaCursoNombretextField;
	private JTextField altaCursoDescripciontextField;
	private JTextField altaCursoDuraciontextField;
	private JTextField altaCursoCantHorastextField;
	private JTextField altaCursoCreditostextField;
	private JTextField altaCursoUrltextField;
	private JRadioButton altaCursoPreviasButtonNo;
	private JRadioButton altaCursoPreviasButtonSi;


	public AgregarCurso(IControladorAltaCurso icon, IControladorConsultaCurso iconaux) {
		this.icon = icon;
		setTitle("Alta Curso");
		setBounds(100, 100, 561, 449);
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
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(325, 54, 208, 229);
		getContentPane().add(scrollPane);
		
		JList altaCursoPreviasList = new JList();
		// --Lista de Cursos Disponibles
		scrollPane.setViewportView(altaCursoPreviasList);
		altaCursoPreviasList.setVisible(false);
		
		// aqui
		
		JButton altaCursoAgregarPreviasButton = new JButton("Agregar");
		altaCursoAgregarPreviasButton.setBounds(436, 299, 97, 25);
		getContentPane().add(altaCursoAgregarPreviasButton);
		
		JButton altaCursoLimpiarPreviasButton = new JButton("Limpiar");
		altaCursoLimpiarPreviasButton.setBounds(325, 299, 97, 25);
		getContentPane().add(altaCursoLimpiarPreviasButton);
		
		JLabel altaCursotienePreviasLabel = new JLabel("Tiene Previas");
		altaCursotienePreviasLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		altaCursotienePreviasLabel.setBounds(325, 13, 107, 28);
		getContentPane().add(altaCursotienePreviasLabel);
		
		altaCursoPreviasButtonNo = new JRadioButton("No");
		altaCursoPreviasButtonNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaCursoPreviasButtonNo.setSelected(true);
				altaCursoPreviasButtonSi.setSelected(false);
			}
		});
		altaCursoPreviasButtonNo.setSelected(true);
		altaCursoPreviasButtonNo.setBounds(431, 16, 43, 25);
		getContentPane().add(altaCursoPreviasButtonNo);
		
		altaCursoPreviasButtonSi = new JRadioButton("Si");
		altaCursoPreviasButtonSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaCursoPreviasButtonSi.setSelected(true);
				altaCursoPreviasButtonNo.setSelected(false);
				populatePreviasList();
				altaCursoPreviasList.setVisible(true);
				//arrojar excepcion "Instituto invalido" en caso que el Instituto no sea correcto, y "Debe seleccionar un instituto" en caso que no se haya cargado nada.
			}
		});
		altaCursoPreviasButtonSi.setSelected(false);
		altaCursoPreviasButtonSi.setBounds(478, 16, 43, 25);
		getContentPane().add(altaCursoPreviasButtonSi);

	}

	protected void altaCursoAceptarActionPerformed(ActionEvent arg0) {
		String instituto = this.altaCursoInstitutotextField.getText();
		String nombre = this.altaCursoNombretextField.getText();
		String descripcion = this.altaCursoDescripciontextField.getText();
		String duracion = this.altaCursoDuraciontextField.getText();
		int cantHoras = 0;
		int creditos = 0;
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
				limpiar();
				setVisible(false);
			}catch(CursoRepetido | InstitutoInexistente e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Alta Curso", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private boolean checkeo(String instituto, String nombre, String descripcion, String duracion, int cantHoras, int creditos, String url) {
		if(instituto.isEmpty() || nombre.isEmpty() || nombre.isEmpty() || descripcion.isEmpty() || duracion.isEmpty()){
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Alta Curso", 
			JOptionPane.ERROR_MESSAGE);
			return false;
		}else {
			try {
				cantHoras = Integer.parseInt(this.altaCursoCantHorastextField.getText());
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Valor incorrecto en cantHoras", "Alta Curso", JOptionPane.ERROR_MESSAGE);
			}
			try {
				creditos = Integer.parseInt(this.altaCursoCreditostextField.getText());
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Valor incorrecto en creditos", "Alta Curso", JOptionPane.ERROR_MESSAGE);
			}
			int duracionint = Integer.parseInt(duracion);
			if(cantHoras == 0 || creditos == 0 || duracionint == 0) {
				JOptionPane.showMessageDialog(this, "No se permiten valores iguales a 0", "Alta Curso", 
				JOptionPane.ERROR_MESSAGE);
				return false;
			}
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
	
	private void populatePreviasList() {
		ArrayList<String> cursosdisponibles = new ArrayList<String>();
		try {
			String instituto = this.altaCursoInstitutotextField.getText();
			ArrayList<DtCursoBase> dtcursosbase = iconaux.listarCursosInstituto(instituto);
			for(DtCursoBase cb: dtcursosbase) {
				 cursosdisponibles.add(cb.getNombre());
			}
		}catch(InstitutoInexistente | InstitutoSinCursos e) { // | NullPointerException
			JOptionPane.showMessageDialog(this, e.getMessage(), "Alta Curso", JOptionPane.ERROR_MESSAGE);
		}
	}
}
