package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import datatypes.DtProgramaBase;
import excepciones.SinProgramas;
import interfaces.IControladorConsultaPrograma;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ConsultaPrograma extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControladorConsultaPrograma icon;
	
	private JComboBox<String> cbPrograma;
	private JComboBox<String> cbCurso;
	private JComboBox<String> cbInstituto;
	private JButton btnPrograma;
	private JButton btnCurso;
	private JButton btnAceptar;
	private JButton btnInstituto;
	private JTextArea taPrograma;
	
	private String institutoseleccionado;
	private String cursoseleccionado;
	private String progseleccionado;
	
	private ArrayList<String> programas = new ArrayList<String>();
	private ArrayList<String> institutos = new ArrayList<String>();
	private ArrayList<String> cursos = new ArrayList<String>();
	
	/**
	 * Create the frame.
	 */
	public ConsultaPrograma(IControladorConsultaPrograma icon)  {
		this.icon=icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("Consulta de Programa de Formación");
		getContentPane().setLayout(null);
		
		JLabel lblPrograma = new JLabel("Programa:");
		lblPrograma.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrograma.setBounds(27, 29, 66, 14);
		getContentPane().add(lblPrograma);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCurso.setBounds(47, 337, 46, 14);
		getContentPane().add(lblCurso);
		
		cbPrograma = new JComboBox<String>();
		cbPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox<?> cb = (JComboBox<?>)arg0.getSource();
				progseleccionado = (String)cb.getSelectedItem().toString();
			}
		});
		cbPrograma.setBounds(103, 25, 178, 22);
		getContentPane().add(cbPrograma);
		
		cbCurso = new JComboBox<String>();
		cbCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<?> cb = (JComboBox<?>)e.getSource();
				cursoseleccionado = (String)cb.getSelectedItem().toString();

			}
		});
		cbCurso.setBounds(102, 333, 179, 22);
		getContentPane().add(cbCurso);
		
		cbInstituto = new JComboBox<String>();
		cbInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<?> cb = (JComboBox<?>)e.getSource();
				institutoseleccionado = (String)cb.getSelectedItem().toString();

			}
		});
		cbInstituto.setBounds(103, 281, 178, 22);
		getContentPane().add(cbInstituto);
		
		taPrograma = new JTextArea();
		taPrograma.setEditable(false);
		taPrograma.setBounds(103, 58, 277, 177);
		getContentPane().add(taPrograma);
		
		btnPrograma = new JButton("Seleccionar");
		btnPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultComboBoxModel<String> instmodel = new DefaultComboBoxModel<String>();
				cbInstituto.setModel(instmodel);	
			}
		});
		btnPrograma.setBounds(291, 25, 89, 23);
		getContentPane().add(btnPrograma);
		
		btnCurso = new JButton("Seleccionar");
		btnCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnCurso.setBounds(290, 333, 89, 23);
		getContentPane().add(btnCurso);
		

		
		btnInstituto = new JButton("Seleccionar");
		btnInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultComboBoxModel<String> cursomodel = new DefaultComboBoxModel<String>();
				cbCurso.setModel(cursomodel);	
			}
		});
		btnInstituto.setBounds(290, 281, 89, 23);
		getContentPane().add(btnInstituto);
		
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(318, 421, 89, 23);
		getContentPane().add(btnAceptar);
		
		JLabel lblInstituto = new JLabel("Instituto:");
		lblInstituto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInstituto.setBounds(47, 285, 46, 14);
		getContentPane().add(lblInstituto);

		setBounds(100, 100, 433, 484);

		DefaultComboBoxModel<String> progmodel = new DefaultComboBoxModel<String>();
		cbPrograma.setModel(progmodel);	
		


	}
	
	public void cargarProgs() {	//Usarlo al entrar
		ArrayList<String> programas = new ArrayList<String>();
		try {
			for (DtProgramaBase dtpb: icon.listarProgramas()) {
				String pr = dtpb.getNombre();
				programas.add(pr);
			}
			String [] progs = programas.toArray(new String[programas.size()]);
			DefaultComboBoxModel<String> progmodel = new DefaultComboBoxModel<String>(progs);			
			cbPrograma.setModel(progmodel);	 
		}catch(SinProgramas e) {
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage(), "Consulta Programa", DISPOSE_ON_CLOSE);
			setVisible(false);
		}
	}
}
