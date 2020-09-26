package presentacion;

import javax.swing.JInternalFrame;
import interfaces.IControladorConsultaCurso;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTextArea;

import datatypes.DtCurso;
import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtInstituto;
import datatypes.DtProgramaBase;
import excepciones.CategoriaInexistente;
import excepciones.CategoriaSinCursos;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import excepciones.SinCategorias;
import excepciones.SinInstitutos;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class InfoCurso extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private IControladorConsultaCurso icon;
	private JComboBox<String> InstitutoComboBox;
	private JButton institutoButton;
	private JComboBox<String> CategoriaComboBox;
	private JButton categoriaButton;
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
	private String categoriaseleccionada;
	private String cursoseleccionado;
	private String edicionseleccionada;
	private String programaseleccionado; // *Next Release
	private InfoEdicionCurso infoEdicionCursoInternalFrame;
	private boolean institutoButtonSelected = false;
	private boolean categoriaButtonSelected = false;
	
	public InfoCurso(IControladorConsultaCurso icon, InfoEdicionCurso infoEdicionCursoInternalFrame) {
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
				JComboBox<?> cb = (JComboBox<?>)e.getSource();
		        institutoseleccionado = (String)cb.getSelectedItem().toString();
		        institutoButton.setEnabled(true);
		        cursoLabel.setEnabled(false);
		        cursoComboBox.setEnabled(false);
		        scrollPane.setEnabled(false);
		        infoCursoTextArea.setEnabled(false);
		        infoCursoTextArea.setText("");
				programaLabel.setEnabled(false);
				programaButton.setEnabled(false);
				programaComboBox.setEnabled(false);
				edicionLabel.setEnabled(false);
				edicionButton.setEnabled(false);
				edicionComboBox.setEnabled(false);
				categoriaButtonSelected = false;
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
				scrollPane.setEnabled(false);
				infoCursoTextArea.setEnabled(false);
				infoCursoTextArea.setText("");
				programaLabel.setEnabled(false);
				programaButton.setEnabled(false);
				programaComboBox.setEnabled(false);
				edicionLabel.setEnabled(false);
				edicionButton.setEnabled(false);
				edicionComboBox.setEnabled(false);
				institutoButtonSelected = true;
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
		cursoLabel.setBounds(12, 74, 63, 20);
		getContentPane().add(cursoLabel);
		
		cursoComboBox = new JComboBox<String>();
		cursoComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<?> cb = (JComboBox<?>)e.getSource();
		        cursoseleccionado = (String)cb.getSelectedItem().toString();
		        cursoButton.setEnabled(true);
		        scrollPane.setEnabled(false);
				infoCursoTextArea.setEnabled(false);
				infoCursoTextArea.setText("");
				programaLabel.setEnabled(false);
				programaButton.setEnabled(false);
				programaComboBox.setEnabled(false);
				edicionLabel.setEnabled(false);
				edicionButton.setEnabled(false);
				edicionComboBox.setEnabled(false);
			}
		});
		cursoComboBox.setEnabled(false);
		cursoComboBox.setBounds(90, 74, 121, 22);
		getContentPane().add(cursoComboBox);
		
		cursoButton = new JButton("Seleccionar");
		cursoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setEnabled(true);
				infoCursoTextArea.setEnabled(true);
				scrollPane.setEnabled(false);
				infoCursoTextArea.setEnabled(false);
				infoCursoTextArea.setText("");
				programaLabel.setEnabled(false);
				programaButton.setEnabled(false);
				programaComboBox.setEnabled(false);
				edicionLabel.setEnabled(false);
				edicionButton.setEnabled(false);
				edicionComboBox.setEnabled(false);
				scrollPane.setEnabled(false);
				cargarInfoCurso();
			}
		});
		cursoButton.setEnabled(false);
		cursoButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cursoButton.setBounds(223, 73, 99, 25);
		getContentPane().add(cursoButton);
		
		scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(12, 107, 310, 175);
		scrollPane.setEnabled(false);
		getContentPane().add(scrollPane);
		
		infoCursoTextArea = new JTextArea();
		infoCursoTextArea.setEnabled(false);
		scrollPane.setViewportView(infoCursoTextArea);

		programaButton = new JButton("Seleccionar");
		programaButton.setEnabled(false);
		programaButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		programaButton.setBounds(223, 329, 99, 25);
		getContentPane().add(programaButton);
		
		programaComboBox = new JComboBox<String>();
		programaComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<?> cb = (JComboBox<?>)e.getSource();
		        setProgramaseleccionado((String)cb.getSelectedItem().toString());
		        programaButton.setEnabled(true);
			}
		});
		programaComboBox.setEnabled(false);
		programaComboBox.setBounds(90, 330, 121, 22);
		getContentPane().add(programaComboBox);
		
		programaLabel = new JLabel("Programa");
		programaLabel.setEnabled(false);
		programaLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		programaLabel.setBounds(12, 330, 75, 20);
		getContentPane().add(programaLabel);
		
		edicionLabel = new JLabel("Edicion");
		edicionLabel.setEnabled(false);
		edicionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		edicionLabel.setBounds(12, 296, 63, 20);
		getContentPane().add(edicionLabel);
		
		edicionComboBox = new JComboBox<String>();
		edicionComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<?> cb = (JComboBox<?>)e.getSource();
		        edicionseleccionada = (String)cb.getSelectedItem().toString();
		        edicionButton.setEnabled(true);
			}
		});
		edicionComboBox.setEnabled(false);
		edicionComboBox.setBounds(90, 296, 121, 22);
		getContentPane().add(edicionComboBox);
		
		edicionButton = new JButton("Seleccionar");
		edicionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infoEdicionCursoInternalFrame.mostrarDos(edicionseleccionada);
				limpiar();
			}
		});
		edicionButton.setEnabled(false);
		edicionButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		edicionButton.setBounds(223, 295, 99, 25);
		getContentPane().add(edicionButton);
		
		cerrarButton = new JButton("Cerrar");
		cerrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				limpiar();
			}
		});
		cerrarButton.setBounds(225, 367, 97, 25);
		getContentPane().add(cerrarButton);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCategoria.setBounds(11, 43, 76, 20);
		getContentPane().add(lblCategoria);
		
		CategoriaComboBox = new JComboBox<String>();
		CategoriaComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<?> cb = (JComboBox<?>)e.getSource();
		        categoriaseleccionada = (String)cb.getSelectedItem().toString();
		        categoriaButton.setEnabled(true);
		        cursoLabel.setEnabled(false);
		        cursoComboBox.setEnabled(false);
		        scrollPane.setEnabled(false);
		        infoCursoTextArea.setEnabled(false);
		        infoCursoTextArea.setText("");
				programaLabel.setEnabled(false);
				programaButton.setEnabled(false);
				programaComboBox.setEnabled(false);
				edicionLabel.setEnabled(false);
				edicionButton.setEnabled(false);
				edicionComboBox.setEnabled(false);
				institutoButtonSelected = false;
			}
		});
		CategoriaComboBox.setBounds(89, 43, 121, 22);
		getContentPane().add(CategoriaComboBox);
		
		categoriaButton = new JButton("Seleccionar");
		categoriaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultComboBoxModel<String> cursocombo = new DefaultComboBoxModel<String>();
				cursoComboBox.setModel(cursocombo);	
				cursoLabel.setEnabled(true);
				cursoComboBox.setEnabled(true);
				scrollPane.setEnabled(false);
				infoCursoTextArea.setEnabled(false);
				infoCursoTextArea.setText("");
				programaLabel.setEnabled(false);
				programaButton.setEnabled(false);
				programaComboBox.setEnabled(false);
				edicionLabel.setEnabled(false);
				edicionButton.setEnabled(false);
				edicionComboBox.setEnabled(false);
				categoriaButtonSelected = true;
				cargarCursos();
			}
		});
		categoriaButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		categoriaButton.setEnabled(false);
		categoriaButton.setBounds(222, 42, 99, 25);
		getContentPane().add(categoriaButton);

		
	}
	
	public String getProgramaseleccionado() {
		return programaseleccionado;
	}

	public void setProgramaseleccionado(String programaseleccionado) {
		this.programaseleccionado = programaseleccionado;
	}

	public InfoEdicionCurso getInfoEdicionCursoInternalFrame() {
		return infoEdicionCursoInternalFrame;
	}

	public void setInfoEdicionCursoInternalFrame(InfoEdicionCurso infoEdicionCursoInternalFrame) {
		this.infoEdicionCursoInternalFrame = infoEdicionCursoInternalFrame;
	}

	public void cargarInstitutos() {
		ArrayList<String> institutos = new ArrayList<String>();
		cursoButton.setVisible(true);
		edicionButton.setVisible(true);
		programaButton.setVisible(true);
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
	
	public void cargarCategorias() {
		ArrayList<String> categorias = new ArrayList<String>();
		try {
			for(String cat: icon.listarCategorias()) {
				categorias.add(cat);
			}
			String [] listcategorias = categorias.toArray(new String[categorias.size()]);
			DefaultComboBoxModel<String> categoriacombo = new DefaultComboBoxModel<String>(listcategorias);
			CategoriaComboBox.setModel(categoriacombo);
		}catch(SinCategorias e) {
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage(), "Consulta Curso", DISPOSE_ON_CLOSE);
			setVisible(false);
		}
	}
	
	private void cargarCursos() {
		ArrayList<String> cursos = new ArrayList<String>();
			try {
				if(institutoButtonSelected && !categoriaButtonSelected) {
					for(DtCursoBase dtc: icon.listarCursosInstituto(institutoseleccionado)) {
						String item = dtc.getNombre();
						cursos.add(item);
					}
				}
				else {
					if(!institutoButtonSelected && categoriaButtonSelected){
						for(DtCursoBase dtc: icon.listarCursosCategoria(categoriaseleccionada)) {
							String item = dtc.getNombre();
							cursos.add(item);
						}
					}
				}
				String [] strcursos = cursos.toArray(new String[cursos.size()]);
				DefaultComboBoxModel<String> cursocombo = new DefaultComboBoxModel<String>(strcursos);
				cursoComboBox.setModel(cursocombo);	
			}catch(InstitutoInexistente | InstitutoSinCursos | CategoriaInexistente | CategoriaSinCursos e) {
				JOptionPane.showMessageDialog(getContentPane(), e.getMessage(), "Consulta Curso", DISPOSE_ON_CLOSE);
			}
		
	}
	
	private void cargarInfoCurso(){
		DtCurso dtcurso = icon.consultarCurso(cursoseleccionado);
		String infoCursoTexto = "";
		infoCursoTexto=infoCursoTexto+dtcurso.getNombre()+"\n";
		infoCursoTexto=infoCursoTexto+dtcurso.getDescripcion()+"\n";
		infoCursoTexto=infoCursoTexto+dtcurso.getDuracion()+"\n";
		infoCursoTexto=infoCursoTexto+(String.valueOf(dtcurso.getCantHoras()))+"\n";
		infoCursoTexto=infoCursoTexto+(String.valueOf(dtcurso.getCreditos()))+"\n";
		infoCursoTexto=infoCursoTexto+dtcurso.getFechaR().toString()+"\n";
		infoCursoTexto=infoCursoTexto+dtcurso.getUrl()+"\n";
		if(!dtcurso.getPrevias().isEmpty()) {
			infoCursoTexto=infoCursoTexto+"Tiene las siguientes Previas:\n";
			for(DtCursoBase dtcb: dtcurso.getPrevias()) {
				infoCursoTexto=infoCursoTexto+dtcb.getNombre()+"\n";
			}
		}
		infoCursoTexto=infoCursoTexto+"Pertenece a las siguientes Categorias:\n";
		for(String strcat: dtcurso.getCategorias()) {
			infoCursoTexto=infoCursoTexto+strcat+"\n";
		}
		infoCursoTextArea.setEnabled(true);
		infoCursoTextArea.setText(infoCursoTexto);
		infoCursoTextArea.setLineWrap(true);
		infoCursoTextArea.setWrapStyleWord(true);
		ArrayList <String> programas = new ArrayList<String>();
		if(!icon.getProgramas().isEmpty()) {
			programaLabel.setEnabled(true);
			programaComboBox.setEnabled(true);
			for(DtProgramaBase dtpb: icon.getProgramas()) {
				String programa = dtpb.getNombre();
				programas.add(programa);
			}
			String [] strprogramas = programas.toArray(new String[programas.size()]);
			DefaultComboBoxModel<String> programacombo = new DefaultComboBoxModel<String>(strprogramas);
			edicionComboBox.setModel(programacombo);
		}
		ArrayList <String> ediciones = new ArrayList<String>();
		if(!dtcurso.getEdiciones().isEmpty()) {
			edicionLabel.setEnabled(true);
			edicionComboBox.setEnabled(true);
			for(DtEdicionBase dted: dtcurso.getEdiciones()) {
				String edicion = dted.getNombre();
				ediciones.add(edicion);
			}
			String [] strediciones = ediciones.toArray(new String[ediciones.size()]);
			DefaultComboBoxModel<String> edicioncombo = new DefaultComboBoxModel<String>(strediciones);
			edicionComboBox.setModel(edicioncombo);
		}
		
	}
	
	private void limpiar() {
		DefaultComboBoxModel<String> emptycombo = new DefaultComboBoxModel<String>();
		cursoComboBox.setModel(emptycombo);
		cursoComboBox.setEnabled(false);
		cursoLabel.setEnabled(false);
		edicionComboBox.setModel(emptycombo);
		edicionComboBox.setEnabled(false);
		edicionLabel.setEnabled(false);
		programaComboBox.setModel(emptycombo);
		programaComboBox.setEnabled(false);
		programaLabel.setEnabled(false);
		institutoButton.setEnabled(false);
		categoriaButton.setEnabled(false);
		cursoButton.setEnabled(false);
		edicionButton.setEnabled(false);
		programaButton.setEnabled(false);
		scrollPane.setEnabled(false);
		infoCursoTextArea.setText("");
		institutoseleccionado = "";
		cursoseleccionado = "";
		edicionseleccionada = "";
		categoriaseleccionada=" ";
		institutoButtonSelected = false;
		categoriaButtonSelected = false;
		setProgramaseleccionado("");
				
	}
	
	public void giveAccess(InfoEdicionCurso infoEdicionCursoInternalFrame) {
		this.setInfoEdicionCursoInternalFrame(infoEdicionCursoInternalFrame);
	}
}
