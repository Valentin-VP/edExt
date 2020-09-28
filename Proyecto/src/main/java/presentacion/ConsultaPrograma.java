package presentacion;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import datatypes.DtCurso;
import datatypes.DtPrograma;
import datatypes.DtProgramaBase;
import excepciones.ProgramaInexistente;
import excepciones.ProgramaSinCursos;
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

	private static final long serialVersionUID = 1L;
	private IControladorConsultaPrograma icon;
	
	private JComboBox<String> cbPrograma;
	private JComboBox<String> cbCurso;
	private JButton btnPrograma;
	private JButton btnCurso;
	private JButton btnAceptar;
	private JTextArea taPrograma;
	
	@SuppressWarnings("unused")
	private String cursoseleccionado = "";
	private String progseleccionado = "";
	
	private boolean externo = false;
	
	private ArrayList<String> programas = new ArrayList<String>();
	private ArrayList<String> cursos = new ArrayList<String>();
	
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
				btnPrograma.setEnabled(true);
			}
		});
		cbPrograma.setBounds(103, 25, 178, 22);
		getContentPane().add(cbPrograma);
		
		cbCurso = new JComboBox<String>();
		cbCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<?> cb = (JComboBox<?>)e.getSource();
				cursoseleccionado = (String)cb.getSelectedItem().toString();
				btnCurso.setEnabled(true);
			}
		});
		cbCurso.setBounds(102, 333, 179, 22);
		getContentPane().add(cbCurso);
	
		
		taPrograma = new JTextArea();
		taPrograma.setEditable(false);
		taPrograma.setBounds(103, 73, 277, 237);
		getContentPane().add(taPrograma);
		
		btnPrograma = new JButton("Seleccionar");
		btnPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultComboBoxModel<String> cursomodel = new DefaultComboBoxModel<String>();
				cbCurso.setModel(cursomodel);	
				cargarInfoProg();
				cargarCursos();
				
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
		
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}
		});
		btnAceptar.setBounds(318, 421, 89, 23);
		getContentPane().add(btnAceptar);

		setBounds(100, 100, 433, 484);

		DefaultComboBoxModel<String> progmodel = new DefaultComboBoxModel<String>();
		cbPrograma.setModel(progmodel);	
		


	}
	
	public void cargarProgs() {	//Usarlo al entrar

			limpiar();
			ArrayList<String> programas = new ArrayList<String>();
			try {
				for (DtProgramaBase dtpb: icon.listarProgramas()) {
					String pr = dtpb.getNombre();
					programas.add(pr);
				}
				String [] progs = programas.toArray(new String[programas.size()]);
				DefaultComboBoxModel<String> progmodel = new DefaultComboBoxModel<String>(progs);			
				cbPrograma.setModel(progmodel);	

				cbPrograma.setEnabled(true);
			}catch(SinProgramas e) {
				JOptionPane.showMessageDialog(getContentPane(), e.getMessage(), "Consulta Programa", DISPOSE_ON_CLOSE);
			}
		
		
	}
	
	private void cargarCursos() {
		ArrayList<String> cursos = new ArrayList<String>();

		try {
			ArrayList<DtCurso> dtcb = icon.listarCursosPrograma(progseleccionado);
			for(DtCurso dtc: dtcb) {
				String item = dtc.getNombre();
				cursos.add(item);
			}
			String [] strcursos = cursos.toArray(new String[cursos.size()]);
			DefaultComboBoxModel<String> cursomodel = new DefaultComboBoxModel<String>(strcursos);
			cbCurso.setModel(cursomodel);	
			if(!externo)
				cbCurso.setEnabled(true);
		}catch(ProgramaSinCursos | ProgramaInexistente e) {
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage(), "Consulta Programa", DISPOSE_ON_CLOSE);
		}
	}
	
	private void cargarInfoProg(){
		DtPrograma dtprog;
		try {
			dtprog = icon.seleccionarPrograma(progseleccionado);
			String taText = "";
			taText+=dtprog.getNombre()+"\n";
			taText+=dtprog.getDesc()+"\n";
			taText+=dtprog.getFechaI().toString()+"\n";
			taText+=dtprog.getFechaF().toString()+"\n";
			taText+=dtprog.getFechaAlta().toString()+"\n";

			taText+="Tiene a los siguientes Cursos:\n";
			taPrograma.setLineWrap(true);
			taPrograma.setWrapStyleWord(true);
			ArrayList <String> cursosE = new ArrayList<String>();
			if(!dtprog.getCursos().isEmpty()) {
				try {
					for(DtCurso dtc: icon.listarCursosPrograma(progseleccionado)) {
						String curso = dtc.getNombre();
						ArrayList <String> cats = dtc.getCategorias();
						cursosE.add(curso);
						taText+="Dicho curso cuenta con las siguientes categorias:\n";
						for(String cat: cats){
							cursosE.add(cat);
						}
					}
				} catch (ProgramaSinCursos e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(getContentPane(), e.getMessage(), "Consulta Programa", DISPOSE_ON_CLOSE);
				}
			}else {
				taText+="Dicho programa no cuenta con ningun curso.\n";
				cbCurso.setEnabled(false);
				btnCurso.setEnabled(false);
			}
			taPrograma.setText(taText);
		} catch (ProgramaSinCursos | ProgramaInexistente e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(getContentPane(), e1.getMessage(), "Consulta Programa", DISPOSE_ON_CLOSE);
		}
		

		
	}
	
	public void cargarInfoCurso() {
		
	}
	
	public void cargarDesdeAfuera(String nombre) {
		externo = true;
		progseleccionado = nombre;
		btnCurso.setEnabled(false);
		btnPrograma.setEnabled(false);
		cbCurso.setEnabled(false);
		cbPrograma.setEnabled(false);
		cargarCursos();
		cargarInfoProg();
	}
	
	public void cerrar() {
		this.setVisible(false);
		if (externo)
			externo = false;
		limpiar();
	}
	
	public void limpiar() {
		cursos.clear();
		programas.clear();
		DefaultComboBoxModel<String> vacio = new DefaultComboBoxModel<String>();
		cbPrograma.setModel(vacio);
		cbCurso.setModel(vacio);
		btnCurso.setEnabled(false);
		btnPrograma.setEnabled(false);
		cbCurso.setEnabled(false);
		cbPrograma.setEnabled(false);
		taPrograma.setText("");
		progseleccionado = "";
		cursoseleccionado = "";
		
	}
}
