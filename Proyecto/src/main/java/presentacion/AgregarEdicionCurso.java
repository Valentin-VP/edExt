package presentacion;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import interfaces.IControladorAltaEdicionCurso;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JRadioButton;
import datatypes.DtFecha;
import datatypes.DtCursoBase;
import excepciones.CursoNoExiste;
import excepciones.DocenteDeOtroInstituto;
import excepciones.DocenteYaAgregado;
import excepciones.EdicionRepetida;
import excepciones.InstitutoInexistente;
import excepciones.UsuarioNoDocente;
import excepciones.UsuarioNoExiste;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AgregarEdicionCurso extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IControladorAltaEdicionCurso icon;
	private JTextField nombreEdicion;
	private JTextField cantCupos;
	private JComboBox<String> fiDia;
	private JComboBox<String> fiMes;
	private JComboBox<String> fiAnio;
	private JComboBox<String> ffDia;
	private JComboBox<String> ffMes;
	private JComboBox<String> ffAnio;
	private JComboBox<String> fpDia;
	private JComboBox<String> fpMes;
	private JComboBox<String> fpAnio;
	private JTextField nickDocente;
	private JTextField correoDocente;
	private JRadioButton cuposBool;
	private JComboBox<String> comboBoxNombreCurso;
	private JTextField textFieldInstituto;
	private JButton btnRefresh;
	
	String nick;
	String correo;
	String Curso;
	
	List<DtCursoBase> cursos = new ArrayList<>();
	ArrayList<String> docentes = new ArrayList<>();
	
	public AgregarEdicionCurso(IControladorAltaEdicionCurso icon) {
		this.icon = icon;
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta de Edicion de un Curso");
 
		setBounds(100, 100, 511, 599);
		getContentPane().setLayout(null);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(35, 60, 70, 15);
		
		JLabel lblfechainicio = new JLabel("Fecha de Inicio");
		lblfechainicio.setBounds(35, 119, 93, 15);
		
		fiDia = new JComboBox<String>();
		fiDia.setBounds(161, 114, 48, 24);
		fiDia.addItem("1");
		fiDia.addItem("2");
		fiDia.addItem("3");
		fiDia.addItem("4");
		fiDia.addItem("5");
		fiDia.addItem("6");
		fiDia.addItem("7");
		fiDia.addItem("8");
		fiDia.addItem("9");
		fiDia.addItem("10");
		fiDia.addItem("11");
		fiDia.addItem("12");
		fiDia.addItem("13");
		fiDia.addItem("14");
		fiDia.addItem("15");
		fiDia.addItem("16");
		fiDia.addItem("17");
		fiDia.addItem("18");
		fiDia.addItem("19");
		fiDia.addItem("20");
		fiDia.addItem("21");
		fiDia.addItem("22");
		fiDia.addItem("23");
		fiDia.addItem("24");
		fiDia.addItem("25");
		fiDia.addItem("26");
		fiDia.addItem("27");
		fiDia.addItem("28");
		fiDia.addItem("29");
		fiDia.addItem("30");
		fiDia.addItem("31");
		
		fiMes = new JComboBox<String>();
		fiMes.setBounds(245, 114, 48, 24);
		fiMes.addItem("1");
		fiMes.addItem("2");
		fiMes.addItem("3");
		fiMes.addItem("4");
		fiMes.addItem("5");
		fiMes.addItem("6");
		fiMes.addItem("7");
		fiMes.addItem("8");
		fiMes.addItem("9");
		fiMes.addItem("10");
		fiMes.addItem("11");
		fiMes.addItem("12");
		
		fiAnio = new JComboBox<String>();
		fiAnio.setBounds(329, 114, 70, 24);
		fiAnio.addItem("2000");
		fiAnio.addItem("2001");
		fiAnio.addItem("2002");
		fiAnio.addItem("2003");
		fiAnio.addItem("2004");
		fiAnio.addItem("2005");
		fiAnio.addItem("2006");
		fiAnio.addItem("2007");
		fiAnio.addItem("2008");
		fiAnio.addItem("2009");
		fiAnio.addItem("2010");
		fiAnio.addItem("2011");
		fiAnio.addItem("2012");
		fiAnio.addItem("2013");
		fiAnio.addItem("2014");
		fiAnio.addItem("2015");
		fiAnio.addItem("2016");
		fiAnio.addItem("2017");
		fiAnio.addItem("2018");
		fiAnio.addItem("2019");
		fiAnio.addItem("2020");
		fiAnio.addItem("2021");
		fiAnio.addItem("2022");
		
		JLabel lblDia = new JLabel("dia");
		lblDia.setBounds(161, 88, 40, 15);
		
		JLabel lblMes = new JLabel("mes");
		lblMes.setBounds(245, 88, 70, 15);
		
		JLabel lblAno = new JLabel("anio");
		lblAno.setBounds(329, 88, 70, 15);
		
		JLabel lblFechaDeFin = new JLabel("Fecha de fin");
		lblFechaDeFin.setBounds(35, 182, 100, 15);
		
		JLabel lblDia_2 = new JLabel("dia");
		lblDia_2.setBounds(169, 150, 40, 15);
		
		JLabel lblMes_2 = new JLabel("mes");
		lblMes_2.setBounds(245, 150, 70, 15);
		
		JLabel lblAno_2 = new JLabel("anio");
		lblAno_2.setBounds(329, 150, 70, 15);
		
		ffDia = new JComboBox<String>();
		ffDia.setBounds(161, 177, 48, 24);
		ffDia.addItem("1");
		ffDia.addItem("2");
		ffDia.addItem("3");
		ffDia.addItem("4");
		ffDia.addItem("5");
		ffDia.addItem("6");
		ffDia.addItem("7");
		ffDia.addItem("8");
		ffDia.addItem("9");
		ffDia.addItem("10");
		ffDia.addItem("11");
		ffDia.addItem("12");
		ffDia.addItem("13");
		ffDia.addItem("14");
		ffDia.addItem("15");
		ffDia.addItem("16");
		ffDia.addItem("17");
		ffDia.addItem("18");
		ffDia.addItem("19");
		ffDia.addItem("20");
		ffDia.addItem("21");
		ffDia.addItem("22");
		ffDia.addItem("23");
		ffDia.addItem("24");
		ffDia.addItem("25");
		ffDia.addItem("26");
		ffDia.addItem("27");
		ffDia.addItem("28");
		ffDia.addItem("29");
		ffDia.addItem("30");
		ffDia.addItem("31");
		
		ffMes = new JComboBox<String>();
		ffMes.setBounds(245, 177, 48, 24);
		ffMes.addItem("1");
		ffMes.addItem("2");
		ffMes.addItem("3");
		ffMes.addItem("4");
		ffMes.addItem("5");
		ffMes.addItem("6");
		ffMes.addItem("7");
		ffMes.addItem("8");
		ffMes.addItem("9");
		ffMes.addItem("10");
		ffMes.addItem("11");
		ffMes.addItem("12");
		
		ffAnio = new JComboBox<String>();
		ffAnio.setBounds(329, 177, 70, 24);
		ffAnio.addItem("2000");
		ffAnio.addItem("2001");
		ffAnio.addItem("2002");
		ffAnio.addItem("2003");
		ffAnio.addItem("2004");
		ffAnio.addItem("2005");
		ffAnio.addItem("2006");
		ffAnio.addItem("2007");
		ffAnio.addItem("2008");
		ffAnio.addItem("2009");
		ffAnio.addItem("2010");
		ffAnio.addItem("2011");
		ffAnio.addItem("2012");
		ffAnio.addItem("2013");
		ffAnio.addItem("2014");
		ffAnio.addItem("2015");
		ffAnio.addItem("2016");
		ffAnio.addItem("2017");
		ffAnio.addItem("2018");
		ffAnio.addItem("2019");
		ffAnio.addItem("2020");
		ffAnio.addItem("2021");
		ffAnio.addItem("2022");
		
		cantCupos = new JTextField();
		cantCupos.setEnabled(false);
		cantCupos.setText("0");
		cantCupos.setBounds(161, 285, 61, 19);
		
		JLabel lblNombre = new JLabel("Nombre"); 
		lblNombre.setBounds(35, 227, 70, 15);
		
		nombreEdicion = new JTextField();
		nombreEdicion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					AgregarEdicionCursoAceptarActionPerformed();
				}
			}
		});
		nombreEdicion.setBounds(143, 223, 270, 19);
		nombreEdicion.setFont(new Font("Dialog", Font.PLAIN, 14));
		nombreEdicion.setColumns(10);
		
		JLabel lblCantCupos = new JLabel("Cant Cupos");
		lblCantCupos.setBounds(161, 258, 129, 15);
		
		JLabel lblFechaDePub = new JLabel("Fecha de publicacion");
		lblFechaDePub.setBounds(35, 353, 117, 15);
		
		JLabel lblDia_2_1 = new JLabel("dia");
		lblDia_2_1.setBounds(169, 317, 40, 15);
		
		cuposBool = new JRadioButton("Cupos");
		cuposBool.setSelected(false);
		cuposBool.setBounds(35, 283, 87, 23);
		cuposBool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cuposBool.isSelected())
					cantCupos.setEnabled(true);
				else {
					cantCupos.setEnabled(false);
					cantCupos.setText("0");
				}
			}
		});

		
		fpDia = new JComboBox<String>();
		fpDia.setBounds(161, 344, 48, 24);
		fpDia.addItem("1");
		fpDia.addItem("2");
		fpDia.addItem("3");
		fpDia.addItem("4");
		fpDia.addItem("5");
		fpDia.addItem("6");
		fpDia.addItem("7");
		fpDia.addItem("8");
		fpDia.addItem("9");
		fpDia.addItem("10");
		fpDia.addItem("11");
		fpDia.addItem("12");
		fpDia.addItem("13");
		fpDia.addItem("14");
		fpDia.addItem("15");
		fpDia.addItem("16");
		fpDia.addItem("17");
		fpDia.addItem("18");
		fpDia.addItem("19");
		fpDia.addItem("20");
		fpDia.addItem("21");
		fpDia.addItem("22");
		fpDia.addItem("23");
		fpDia.addItem("24");
		fpDia.addItem("25");
		fpDia.addItem("26");
		fpDia.addItem("27");
		fpDia.addItem("28");
		fpDia.addItem("29");
		fpDia.addItem("30");
		fpDia.addItem("31");
		
		fpMes = new JComboBox<String>();
		fpMes.setBounds(245, 344, 48, 24);
		fpMes.addItem("1");
		fpMes.addItem("2");
		fpMes.addItem("3");
		fpMes.addItem("4");
		fpMes.addItem("5");
		fpMes.addItem("6");
		fpMes.addItem("7");
		fpMes.addItem("8");
		fpMes.addItem("9");
		fpMes.addItem("10");
		fpMes.addItem("11");
		fpMes.addItem("12");		
		
		JLabel lblMes_2_1 = new JLabel("mes");
		lblMes_2_1.setBounds(245, 317, 70, 15);
		
		JLabel lblAno_2_1 = new JLabel("anio");
		lblAno_2_1.setBounds(329, 317, 70, 15);
		
		fpAnio = new JComboBox<String>();
		fpAnio.setBounds(329, 344, 70, 24);
		fpAnio.addItem("2000");
		fpAnio.addItem("2001");
		fpAnio.addItem("2002");
		fpAnio.addItem("2003");
		fpAnio.addItem("2004");
		fpAnio.addItem("2005");
		fpAnio.addItem("2006");
		fpAnio.addItem("2007");
		fpAnio.addItem("2008");
		fpAnio.addItem("2009");
		fpAnio.addItem("2010");
		fpAnio.addItem("2011");
		fpAnio.addItem("2012");
		fpAnio.addItem("2013");
		fpAnio.addItem("2014");
		fpAnio.addItem("2015");
		fpAnio.addItem("2016");
		fpAnio.addItem("2017");
		fpAnio.addItem("2018");
		fpAnio.addItem("2019");
		fpAnio.addItem("2020");
		fpAnio.addItem("2021");
		fpAnio.addItem("2022");		
		
		getContentPane().setLayout(null);
		getContentPane().add(lblCurso);
		getContentPane().add(lblDia);
		getContentPane().add(lblMes);
		getContentPane().add(lblAno);
		getContentPane().add(lblfechainicio);
		getContentPane().add(fiDia);
		getContentPane().add(fiMes);
		getContentPane().add(fiAnio);
		getContentPane().add(lblDia_2);
		getContentPane().add(lblMes_2);
		getContentPane().add(lblAno_2);
		getContentPane().add(lblFechaDeFin);
		getContentPane().add(ffDia);
		getContentPane().add(ffMes);
		getContentPane().add(ffAnio);
		getContentPane().add(lblNombre);
		getContentPane().add(nombreEdicion);
		getContentPane().add(lblCantCupos);
		getContentPane().add(cuposBool);
		getContentPane().add(cantCupos);
		getContentPane().add(lblDia_2_1);
		getContentPane().add(lblMes_2_1);
		getContentPane().add(lblAno_2_1);
		getContentPane().add(lblFechaDePub);
		getContentPane().add(fpDia);
		getContentPane().add(fpMes);
		getContentPane().add(fpAnio);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				comboBoxNombreCurso.setEnabled(true);
				btnRefresh.setEnabled(true);
				nombreEdicion.setEditable(true);
				textFieldInstituto.setEditable(true);
				limpiar();
				setVisible(false);
			}
		});
		btnCancelar.setBounds(54, 505, 117, 25);
		getContentPane().add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				AgregarEdicionCursoAceptarActionPerformed();
				comboBoxNombreCurso.setEnabled(true);
				btnRefresh.setEnabled(true);
				nombreEdicion.setEditable(true);
				textFieldInstituto.setEditable(true);
			}
		});
		btnAceptar.setBounds(296, 505, 117, 25);
		getContentPane().add(btnAceptar);
		
		JLabel lblDocentes = new JLabel("Docentes");
		lblDocentes.setBackground(Color.WHITE);
		lblDocentes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDocentes.setBounds(35, 392, 70, 15);
		getContentPane().add(lblDocentes);
		
		nickDocente = new JTextField();
		nickDocente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					AgregarDocenteActionPerformed();	
				}
			}
		});
		nickDocente.setBounds(119, 419, 145, 19);
		getContentPane().add(nickDocente);
		nickDocente.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ag) {
				AgregarDocenteActionPerformed();
				nickDocente.setText("");
				correoDocente.setText("");
			}
		});
		btnAgregar.setBounds(296, 416, 117, 25);
		getContentPane().add(btnAgregar);
		
		correoDocente = new JTextField();
		correoDocente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					AgregarDocenteActionPerformed();	
				}
			}
		});
		correoDocente.setColumns(10);
		correoDocente.setBounds(119, 462, 145, 19);
		getContentPane().add(correoDocente);
		
		JLabel lblNick = new JLabel("nick");
		lblNick.setBounds(58, 422, 40, 15);
		getContentPane().add(lblNick);
		
		JLabel lblCorreo = new JLabel("correo");
		lblCorreo.setBounds(54, 465, 70, 15);
		getContentPane().add(lblCorreo);
		
		textFieldInstituto = new JTextField();
		textFieldInstituto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					DefaultComboBoxModel<String> cursoNombre = new DefaultComboBoxModel<String>();
					comboBoxNombreCurso.setModel(cursoNombre);
					AgregarEdicionCursoRefreshActionPerformed();
				}
			}
		});
		textFieldInstituto.setBounds(122, 12, 193, 19);
		getContentPane().add(textFieldInstituto);
		textFieldInstituto.setColumns(10);
		
		JLabel lblInstituto = new JLabel("Instituto");
		lblInstituto.setBounds(35, 15, 70, 15);
		getContentPane().add(lblInstituto);
		
		comboBoxNombreCurso = new JComboBox<String>();
		comboBoxNombreCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curso = (String) comboBoxNombreCurso.getSelectedItem();
			}
		});
		comboBoxNombreCurso.setBounds(161, 55, 192, 24);
		getContentPane().add(comboBoxNombreCurso);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent r) {
				DefaultComboBoxModel<String> cursoNombre = new DefaultComboBoxModel<String>();
				comboBoxNombreCurso.setModel(cursoNombre);
				AgregarEdicionCursoRefreshActionPerformed();
			}
		});
		btnRefresh.setBounds(357, 9, 117, 25);
		getContentPane().add(btnRefresh);
				
	}
	
	private void AgregarEdicionCursoRefreshActionPerformed() {
		String instituto = (String) this.textFieldInstituto.getText();
		try {
			cursos = icon.seleccionarInstituto(instituto);
		} catch (InstitutoInexistente e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Agregar Edicion", JOptionPane.ERROR_MESSAGE);
		}	
		
		String[] array = new String[cursos.size()];
		int p = 0;
		for (DtCursoBase c: cursos) {
			array[p] = c.getNombre();
			p++;
		}
		for (int i = 0; i < cursos.size(); i++) {
			comboBoxNombreCurso.addItem(array[i]);
		}
	}	
	
	protected void limpiar() {
		
		this.nombreEdicion.setText("");
		this.nickDocente.setText("");
		this.correoDocente.setText("");
		this.textFieldInstituto.setText("");
		this.fiDia.setSelectedItem("1");
		this.fiMes.setSelectedItem("1");
		this.fiAnio.setSelectedItem("1992");
		this.ffDia.setSelectedItem("1");
		this.ffMes.setSelectedItem("1");
		this.ffAnio.setSelectedItem("1992");
		this.fpDia.setSelectedItem("1");
		this.fpMes.setSelectedItem("1");
		this.fpAnio.setSelectedItem("1992");
		this.cuposBool.setSelected(false);
		this.cantCupos.setText("0");
		this.cantCupos.setEditable(true);
		DefaultComboBoxModel<String> cursoNombre = new DefaultComboBoxModel<String>();
		comboBoxNombreCurso.setModel(cursoNombre);
		Curso = "";
		docentes.clear();
	}
	
	protected void AgregarDocenteActionPerformed() {
		nick = this.nickDocente.getText();
		correo = this.correoDocente.getText();
		if (nick.isEmpty() || correo.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios doc", "Agregar Usuario", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				icon.verificarUsuario(nick, correo, docentes);
				docentes.add(nick);
				JOptionPane.showMessageDialog(this, "El docente fue agregado con exito", "Agregar Usuario", JOptionPane.INFORMATION_MESSAGE);
			}catch(UsuarioNoExiste | DocenteDeOtroInstituto | DocenteYaAgregado | UsuarioNoDocente exc) {
				JOptionPane.showMessageDialog(this, exc.getLocalizedMessage(), "Agregar Usuario", JOptionPane.ERROR_MESSAGE);
				}
		}
		comboBoxNombreCurso.setEnabled(false);
		btnRefresh.setEnabled(false);
		nombreEdicion.setEditable(false);
		textFieldInstituto.setEditable(false);
	}
	
	protected void AgregarEdicionCursoAceptarActionPerformed() {
		String nombre = this.nombreEdicion.getText();
		int cupos = Integer.parseInt(this.cantCupos.getText());
		boolean tieneCupos = this.cuposBool.isSelected();
		String diaI =  this.fiDia.getSelectedItem().toString();
		String mesI = this.fiMes.getSelectedItem().toString();
		String anioI = this.fiAnio.getSelectedItem().toString();
		String diaF = this.ffDia.getSelectedItem().toString();
		String mesF = this.ffMes.getSelectedItem().toString();
		String anioF = this.ffAnio.getSelectedItem().toString();
		String diaP = this.fpDia.getSelectedItem().toString();
		String mesP = this.fpMes.getSelectedItem().toString();
		String anioP = this.fpAnio.getSelectedItem().toString(); 
		DtFecha fechaI = new DtFecha(Integer.parseInt(diaI), Integer.parseInt(mesI), Integer.parseInt(anioI));
		DtFecha fechaF = new DtFecha(Integer.parseInt(diaF), Integer.parseInt(mesF), Integer.parseInt(anioF));
		DtFecha fechaPub = new DtFecha(Integer.parseInt(diaP), Integer.parseInt(mesP), Integer.parseInt(anioP));
		if (Curso.isEmpty() || nombre.isEmpty() || docentes.isEmpty()) {
		 	JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Agregar Edicion", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				this.icon.altaEdicionCurso(Curso, nombre, fechaI, fechaF, docentes, tieneCupos, cupos, fechaPub);
				JOptionPane.showMessageDialog(this, "La edicion fue agregada con exito", "Agregar Edicion", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
				limpiar();
			} catch (EdicionRepetida | CursoNoExiste | UsuarioNoDocente | InstitutoInexistente a) {
				JOptionPane.showMessageDialog(this, a.getLocalizedMessage(), "Agregar Edicion", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}


