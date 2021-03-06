package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;

import datatypes.DtCursoBase;
import datatypes.DtFecha;
import interfaces.IControladorConsultaCurso;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import interfaces.IControladorAltaCurso;
import excepciones.InstitutoInexistente;
import excepciones.InstitutoSinCursos;
import excepciones.SinCategorias;
import excepciones.CursoRepetido;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	private JRadioButton altaCursoPreviasButtonNo;
	private JRadioButton altaCursoPreviasButtonSi;
	public JList<String> altaCursoPreviasList;
	public JList<String> altaCursoCategoriasList;
	public DefaultListModel<String> previasmodel;
	public DefaultListModel<String> categoriasmodel;
	public JButton altaCursoAgregarPreviasButton;
	public JButton altaCursoLimpiarPreviasButton;
	private ArrayList<String> previasseleccionadas = new ArrayList<String>();
	private ArrayList<String> categoriasseleccionadas = new ArrayList<String>();
	private JButton agregarCategoriasButton;
	private JButton limpiarCategoriasButton;


	public AgregarCurso(IControladorAltaCurso icon, IControladorConsultaCurso iconaux) {
		this.icon = icon;
		setTitle("Alta Curso");
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setBounds(100, 100, 687, 410);
		getContentPane().setLayout(null);
		
		JLabel altaCursoInstitutoLabel = new JLabel("Instituto");
		altaCursoInstitutoLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		altaCursoInstitutoLabel.setBounds(12, 13, 86, 28);
		getContentPane().add(altaCursoInstitutoLabel);
		
		altaCursoInstitutotextField = new JTextField();
		altaCursoInstitutotextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					altaCursoAceptarActionPerformed();
				}
			}
		});
		altaCursoInstitutotextField.setBounds(110, 16, 203, 22);
		getContentPane().add(altaCursoInstitutotextField);
		altaCursoInstitutotextField.setColumns(10);
		
		JLabel altaCursoCustoLabel = new JLabel("Nombre");
		altaCursoCustoLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		altaCursoCustoLabel.setBounds(12, 54, 86, 28);
		getContentPane().add(altaCursoCustoLabel);
		
		altaCursoNombretextField = new JTextField();
		altaCursoNombretextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					altaCursoAceptarActionPerformed();
				}
			}
		});
		altaCursoNombretextField.setColumns(10);
		altaCursoNombretextField.setBounds(110, 57, 203, 22);
		getContentPane().add(altaCursoNombretextField);
		
		JLabel altaCursoDescripcionLabel = new JLabel("Descripcion");
		altaCursoDescripcionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		altaCursoDescripcionLabel.setBounds(12, 95, 86, 28);
		getContentPane().add(altaCursoDescripcionLabel);
		
		altaCursoDescripciontextField = new JTextField();
		altaCursoDescripciontextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					altaCursoAceptarActionPerformed();
				}
			}
		});
		altaCursoDescripciontextField.setColumns(10);
		altaCursoDescripciontextField.setBounds(110, 98, 203, 22);
		getContentPane().add(altaCursoDescripciontextField);
		
		JLabel altaCursoDuracionLabel = new JLabel("Duracion");
		altaCursoDuracionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		altaCursoDuracionLabel.setBounds(12, 136, 93, 28);
		getContentPane().add(altaCursoDuracionLabel);
		
		altaCursoDuraciontextField = new JTextField();
		altaCursoDuraciontextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					altaCursoAceptarActionPerformed();
				}
			}
		});
		altaCursoDuraciontextField.setColumns(10);
		altaCursoDuraciontextField.setBounds(110, 139, 203, 22);
		getContentPane().add(altaCursoDuraciontextField);
		
		JLabel altaCursoCantHorasLabel = new JLabel("Cant. Horas");
		altaCursoCantHorasLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		altaCursoCantHorasLabel.setBounds(12, 177, 93, 28);
		getContentPane().add(altaCursoCantHorasLabel);
		
		altaCursoCantHorastextField = new JTextField();
		altaCursoCantHorastextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					altaCursoAceptarActionPerformed();
				}
			}
		});
		altaCursoCantHorastextField.setColumns(10);
		altaCursoCantHorastextField.setBounds(110, 180, 203, 22);
		getContentPane().add(altaCursoCantHorastextField);
		
		JLabel altaCursoCreditosLabel = new JLabel("Creditos");
		altaCursoCreditosLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		altaCursoCreditosLabel.setBounds(12, 218, 93, 28);
		getContentPane().add(altaCursoCreditosLabel);
		
		altaCursoCreditostextField = new JTextField();
		altaCursoCreditostextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					altaCursoAceptarActionPerformed();
				}
			}
		});
		altaCursoCreditostextField.setColumns(10);
		altaCursoCreditostextField.setBounds(110, 221, 203, 22);
		getContentPane().add(altaCursoCreditostextField);
		
		JButton altaCursoCancelarButton = new JButton("Cancelar");
		altaCursoCancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				altaCursoPreviasButtonNo.setSelected(true);
				altaCursoPreviasButtonSi.setSelected(false);
				limpiar();
				icon.cancelarAltaCurso();
			}
		});
		altaCursoCancelarButton.setBounds(22, 326, 97, 25);
		getContentPane().add(altaCursoCancelarButton);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// altaCurso
				altaCursoAceptarActionPerformed();
			}
		});
		btnNewButton.setBounds(216, 326, 97, 25);
		getContentPane().add(btnNewButton);
		
		JLabel altaCursoUrlLabel = new JLabel("URL");
		altaCursoUrlLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		altaCursoUrlLabel.setBounds(12, 259, 93, 28);
		getContentPane().add(altaCursoUrlLabel);
		
		altaCursoUrltextField = new JTextField();
		altaCursoUrltextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					altaCursoAceptarActionPerformed();
				}
			}
		});
		altaCursoUrltextField.setColumns(10);
		altaCursoUrltextField.setBounds(110, 262, 203, 22);
		getContentPane().add(altaCursoUrltextField);
		
		JScrollPane scrollPanePrevias = new JScrollPane((Component) null);
		scrollPanePrevias.setBounds(325, 54, 159, 229);
		getContentPane().add(scrollPanePrevias);
		
		altaCursoPreviasList = new JList<String>();
		scrollPanePrevias.setViewportView(altaCursoPreviasList);
		altaCursoPreviasList.setVisible(false);
		altaCursoAgregarPreviasButton = new JButton("Agregar");
		altaCursoAgregarPreviasButton.setEnabled(false);
		altaCursoAgregarPreviasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] selectedIx = altaCursoPreviasList.getSelectedIndices();
				for (int i = 0; i < selectedIx.length; i++) {
				      String previa = altaCursoPreviasList.getModel().getElementAt(selectedIx[i]).toString();
				      if(!previasseleccionadas.contains(previa)) {
				    	  previasseleccionadas.add(previa);
				      } 
				      
				    }
				JOptionPane.showMessageDialog(getContentPane(), "Se han agregado las Previas asociadas", "Alta Curso", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		altaCursoAgregarPreviasButton.setBounds(398, 299, 86, 25);
		getContentPane().add(altaCursoAgregarPreviasButton);
		
		altaCursoLimpiarPreviasButton = new JButton("Borrar");
		altaCursoLimpiarPreviasButton.setEnabled(false);
		altaCursoLimpiarPreviasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<DtCursoBase> previas = new ArrayList<DtCursoBase>();
				icon.setPrevias(previas); // Setea las previas en null
				altaCursoPreviasList.clearSelection();
				JOptionPane.showMessageDialog(getContentPane(), "Se han eliminado las Previas asociadas", "Alta Curso", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		altaCursoLimpiarPreviasButton.setBounds(325, 299, 75, 25);
		getContentPane().add(altaCursoLimpiarPreviasButton);
		
		JLabel altaCursotienePreviasLabel = new JLabel("Previas");
		altaCursotienePreviasLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		altaCursotienePreviasLabel.setBounds(325, 13, 58, 28);
		getContentPane().add(altaCursotienePreviasLabel);
		
		altaCursoPreviasButtonNo = new JRadioButton("No");
		altaCursoPreviasButtonNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaCursoPreviasButtonNo.setSelected(true);
				altaCursoPreviasButtonSi.setSelected(false);
				altaCursoPreviasList.setVisible(false);
				altaCursoPreviasList.setEnabled(false);
				altaCursoAgregarPreviasButton.setEnabled(false);
				altaCursoLimpiarPreviasButton.setEnabled(false);
			}
		});
		altaCursoPreviasButtonNo.setSelected(true);
		altaCursoPreviasButtonNo.setBounds(394, 16, 43, 25);
		getContentPane().add(altaCursoPreviasButtonNo);
		
		altaCursoPreviasButtonSi = new JRadioButton("Si");
		altaCursoPreviasButtonSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaCursoPreviasButtonSi.setSelected(true);
				altaCursoPreviasButtonNo.setSelected(false);
				populatePreviasList(iconaux);			}
		});
		altaCursoPreviasButtonSi.setSelected(false);
		altaCursoPreviasButtonSi.setBounds(441, 16, 43, 25);
		getContentPane().add(altaCursoPreviasButtonSi);
		
		JScrollPane scrollPaneCategorias = new JScrollPane((Component) null);
		scrollPaneCategorias.setBounds(496, 54, 159, 229);
		getContentPane().add(scrollPaneCategorias);
		
		altaCursoCategoriasList = new JList<String>();
		scrollPaneCategorias.setViewportView(altaCursoCategoriasList);
		
		JLabel lblCategorias = new JLabel("Categorias");
		lblCategorias.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCategorias.setBounds(492, 13, 86, 28);
		getContentPane().add(lblCategorias);
		
		limpiarCategoriasButton = new JButton("Borrar");
		limpiarCategoriasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//limpiar categorias
				icon.cleanCategorias();
				altaCursoCategoriasList.clearSelection();
				JOptionPane.showMessageDialog(getContentPane(), "Se han eliminado las Categorias seleccionadas", "Alta Curso", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		limpiarCategoriasButton.setEnabled(false);
		limpiarCategoriasButton.setBounds(496, 299, 75, 25);
		getContentPane().add(limpiarCategoriasButton);
		
		agregarCategoriasButton = new JButton("Agregar");
		agregarCategoriasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selectedIx = altaCursoCategoriasList.getSelectedIndices();
				for (int i = 0; i < selectedIx.length; i++) {
				      String categoria = altaCursoCategoriasList.getModel().getElementAt(selectedIx[i]).toString();
				      if(!categoriasseleccionadas.contains(categoria)) {
				    	  categoriasseleccionadas.add(categoria);
				      } 
				      
				    }
				JOptionPane.showMessageDialog(getContentPane(), "Se han agregado las Categorias seleccionadas", "Alta Curso", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		agregarCategoriasButton.setEnabled(false);
		agregarCategoriasButton.setBounds(569, 299, 86, 25);
		getContentPane().add(agregarCategoriasButton);
		
		JButton cargarButton = new JButton("Cargar");
		cargarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//populate categories
				populateCategoriasList();
			}
		});
		cargarButton.setBounds(569, 16, 86, 25);
		getContentPane().add(cargarButton);

	}

	protected void altaCursoAceptarActionPerformed() {
		String instituto = this.altaCursoInstitutotextField.getText();
		String nombre = this.altaCursoNombretextField.getText();
		String descripcion = this.altaCursoDescripciontextField.getText();
		String duracion = this.altaCursoDuraciontextField.getText();
		String strcantHoras = this.altaCursoCantHorastextField.getText();
		String strcreditos = this.altaCursoCreditostextField.getText();
		String url = this.altaCursoUrltextField.getText();
		
		LocalDate date = LocalDate.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("d-M-u");
		ArrayList<Integer> datos = new ArrayList<>();
		String valores [] = (date.format(format)).split("-");
		for(String s: valores) {
			int temp = Integer.parseInt(s);
			datos.add(temp);
		}
		DtFecha fechaR = new DtFecha(datos.get(0),datos.get(1),datos.get(2));
		
		if(checkeo(instituto,nombre,descripcion,duracion,strcantHoras,strcreditos,url)) {
			int cantHoras = Integer.parseInt(this.altaCursoCantHorastextField.getText());
			int creditos = Integer.parseInt(this.altaCursoCreditostextField.getText());
			try {
				this.icon.altaCurso(instituto, nombre, descripcion, duracion, cantHoras, creditos, url, fechaR);
				if(previasseleccionadas!=null) {
					for(String previa: previasseleccionadas) {
						this.icon.agregarPrevia(previa);
					}
				}
				if(categoriasseleccionadas!=null) {
					for(String categoria: categoriasseleccionadas) {
						this.icon.agregarCategoria(categoria);
					}
				}
				
				this.icon.confirmarAltaCurso();
				JOptionPane.showMessageDialog(this, "El curso fue ingresado con exito", "Alta Curso", JOptionPane.INFORMATION_MESSAGE);
				altaCursoPreviasButtonNo.setSelected(true);
				altaCursoPreviasButtonSi.setSelected(false);
				limpiar();
				setVisible(false);
			}catch(CursoRepetido | InstitutoInexistente e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Alta Curso", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private boolean checkeo(String instituto, String nombre, String descripcion, String duracion, String strcantHoras, String strcreditos, String url) {
		int cantHoras = 0;
		int creditos = 0;
		if(instituto.isEmpty() || nombre.isEmpty() || nombre.isEmpty() || descripcion.isEmpty() || duracion.isEmpty()){
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Alta Curso", 
			JOptionPane.ERROR_MESSAGE);
			return false;
		}else {
			try {
				cantHoras = Integer.parseInt(strcantHoras);
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Valor incorrecto en cantHoras", "Alta Curso", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			try {
				creditos = Integer.parseInt(strcreditos);
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Valor incorrecto en creditos", "Alta Curso", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			
			if(cantHoras < 1 || creditos < 1) {
				JOptionPane.showMessageDialog(this, "No se permiten valores menores a 1", "Alta Curso", 
				JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else {
				if (altaCursoPreviasButtonSi.isSelected() && previasseleccionadas.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Debe seleccionar alguna Previa", "Alta Curso", JOptionPane.ERROR_MESSAGE);
					return false;
				}
				else {
					if (categoriasseleccionadas.isEmpty()) {
						JOptionPane.showMessageDialog(this, "Debe seleccionar alguna Categoria", "Alta Curso", JOptionPane.ERROR_MESSAGE);
						return false;
					}
				}
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
		previasmodel = new DefaultListModel<String>();
		categoriasmodel = new DefaultListModel<String>();
		this.altaCursoPreviasList.setModel(previasmodel);
		this.altaCursoCategoriasList.setModel(categoriasmodel);
		altaCursoAgregarPreviasButton.setEnabled(false);
		altaCursoLimpiarPreviasButton.setEnabled(false);
		agregarCategoriasButton.setEnabled(false);
		limpiarCategoriasButton.setEnabled(false);
		previasseleccionadas = new ArrayList<String>();
		categoriasseleccionadas = new ArrayList<String>();
	}
	
	private void populatePreviasList(IControladorConsultaCurso iconaux) {
		ArrayList<DtCursoBase> dtcursosbase = new ArrayList<DtCursoBase>();
		try {
			String instituto = (String) this.altaCursoInstitutotextField.getText();
			previasmodel = new DefaultListModel<String>();
			dtcursosbase = iconaux.listarCursosInstituto(instituto);
			for(DtCursoBase cb: dtcursosbase) {
				previasmodel.addElement(cb.getNombre());
			}
			altaCursoPreviasList.setModel(previasmodel);
			altaCursoPreviasList.setVisible(true);
			altaCursoPreviasList.setEnabled(true);
			altaCursoAgregarPreviasButton.setEnabled(true);
			altaCursoLimpiarPreviasButton.setEnabled(true);
		}catch(InstitutoInexistente | InstitutoSinCursos ex) { 
			altaCursoPreviasButtonNo.setSelected(true);
			altaCursoPreviasButtonSi.setSelected(false);
			altaCursoAgregarPreviasButton.setEnabled(false);
			altaCursoLimpiarPreviasButton.setEnabled(false);
			previasmodel = new DefaultListModel<String>();
			this.altaCursoPreviasList.setModel(previasmodel);
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Alta Curso", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void populateCategoriasList() { //Llamado con boton y desde menu en principal. Se deberia poder sacar el boton, probar
		ArrayList<String> strcategories = new ArrayList<String>();
		try {
			strcategories = icon.listarCategorias();
			categoriasmodel = new DefaultListModel<String>();
			for (String cat: strcategories) {
				categoriasmodel.addElement(cat);
			}
			altaCursoCategoriasList.setModel(categoriasmodel);
			agregarCategoriasButton.setEnabled(true);
			limpiarCategoriasButton.setEnabled(true);
		}catch(SinCategorias ex) {
			categoriasmodel = new DefaultListModel<String>();
			this.altaCursoCategoriasList.setModel(categoriasmodel);
			JOptionPane.showMessageDialog(getContentPane(), ex.getMessage(), "Alta Curso", DISPOSE_ON_CLOSE);
			setVisible(false);
			limpiar();
		}
	}
}
