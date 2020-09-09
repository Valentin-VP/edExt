package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.IControladorConsultaCurso;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTextArea;

import datatypes.DtCurso;
import datatypes.DtInstituto;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import excepciones.SinInstitutos;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class InfoCurso extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private IControladorConsultaCurso icon;
	private JComboBox<String> InstitutoComboBox;
	private JButton institutoButton;
	private JLabel cursoLabel;
	private JComboBox<String> cursoComboBox;
	private JButton cursoButton;
	private JScrollPane scrollPane;
	private JTextArea infoCursoTextArea;
	private JButton programaButton;
	private JComboBox<String> programaComboBox;
	private JLabel programaLabel;
	private JLabel edicionLabel;
	private JComboBox<String> edicionComboBox;
	private JButton edicionButton;
	private JButton cerrarButton;
	private String institutoseleccionado;
	
	
	public InfoCurso(IControladorConsultaCurso icon) {
		this.icon=icon;
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("Consulta de Curso");
		setBounds(100, 100, 348, 441);
		getContentPane().setLayout(null);
		
		JLabel institutoLabel = new JLabel("Instituto");
		institutoLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		institutoLabel.setBounds(12, 13, 63, 20);
		getContentPane().add(institutoLabel);
		
		InstitutoComboBox = new JComboBox<String>();
		InstitutoComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
		        institutoseleccionado = (String)cb.getSelectedItem().toString();
		        institutoButton.setEnabled(true);
			}
		});
		InstitutoComboBox.setBounds(90, 13, 121, 22);
		getContentPane().add(InstitutoComboBox);
		
		institutoButton = new JButton("Seleccionar");
		institutoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultComboBoxModel<String> cursocombo = new DefaultComboBoxModel<String>();
				cursoComboBox.setModel(cursocombo);	
				cursoLabel.setEnabled(true);
				cursoComboBox.setEnabled(true);
				cargarCursos();
			}
		});
		institutoButton.setEnabled(false);
		institutoButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		institutoButton.setBounds(223, 12, 99, 25);
		getContentPane().add(institutoButton);
		
		cursoLabel = new JLabel("Curso");
		cursoLabel.setEnabled(false);
		cursoLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cursoLabel.setBounds(12, 47, 63, 20);
		getContentPane().add(cursoLabel);
		
		cursoComboBox = new JComboBox<String>();
		cursoComboBox.setEnabled(false);
		cursoComboBox.setBounds(90, 47, 121, 22);
		getContentPane().add(cursoComboBox);
		
		cursoButton = new JButton("Seleccionar");
		cursoButton.setEnabled(false);
		cursoButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cursoButton.setBounds(223, 46, 99, 25);
		getContentPane().add(cursoButton);
		
		scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(12, 80, 310, 175);
		getContentPane().add(scrollPane);
		
		infoCursoTextArea = new JTextArea();
		scrollPane.setViewportView(infoCursoTextArea);
		
		programaButton = new JButton("Seleccionar");
		programaButton.setEnabled(false);
		programaButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		programaButton.setBounds(223, 302, 99, 25);
		getContentPane().add(programaButton);
		
		programaComboBox = new JComboBox();
		programaComboBox.setEnabled(false);
		programaComboBox.setBounds(90, 303, 121, 22);
		getContentPane().add(programaComboBox);
		
		programaLabel = new JLabel("Programa");
		programaLabel.setEnabled(false);
		programaLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		programaLabel.setBounds(12, 303, 75, 20);
		getContentPane().add(programaLabel);
		
		edicionLabel = new JLabel("Edicion");
		edicionLabel.setEnabled(false);
		edicionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		edicionLabel.setBounds(12, 269, 63, 20);
		getContentPane().add(edicionLabel);
		
		edicionComboBox = new JComboBox();
		edicionComboBox.setEnabled(false);
		edicionComboBox.setBounds(90, 269, 121, 22);
		getContentPane().add(edicionComboBox);
		
		edicionButton = new JButton("Seleccionar");
		edicionButton.setEnabled(false);
		edicionButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		edicionButton.setBounds(223, 268, 99, 25);
		getContentPane().add(edicionButton);
		
		cerrarButton = new JButton("Cerrar");
		cerrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		cerrarButton.setBounds(225, 367, 97, 25);
		getContentPane().add(cerrarButton);

		
	}
	
	public void cargarInstitutos() {
		ArrayList<String> institutos = new ArrayList<String>();
		try {
			for(DtInstituto dti: icon.listarInstitutos()) {
					String item = dti.getNombre();
					institutos.add(item);
			}
			String [] strinstitutos = institutos.toArray(new String[institutos.size()]);
			DefaultComboBoxModel<String> institutocombo = new DefaultComboBoxModel<String>(strinstitutos);			
			InstitutoComboBox.setModel(institutocombo);	 
		}catch(SinInstitutos e) {
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage(), "Consulta Curso", DISPOSE_ON_CLOSE);
			setVisible(false);
		}

	}
	
	public void cargarCursos() {
		ArrayList<String> cursos = new ArrayList<String>();
		try {
			for(DtCurso dtc: icon.listarCursosInstituto(institutoseleccionado)) {
				String item = dtc.getNombre();
				cursos.add(item);
			}
			String [] strcursos = cursos.toArray(new String[cursos.size()]);
			DefaultComboBoxModel<String> cursocombo = new DefaultComboBoxModel<String>(strcursos);
			cursoComboBox.setModel(cursocombo);	
		}catch(InstitutoInexistente | InstitutoSinCursos e) {
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage(), "Consulta Curso", DISPOSE_ON_CLOSE);
		}
		
	}
	
	private void limpiar() {
		DefaultComboBoxModel<String> cursocombo = new DefaultComboBoxModel<String>();
		cursoComboBox.setModel(cursocombo);
	}

}
