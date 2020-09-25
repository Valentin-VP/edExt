package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtFecha;
import datatypes.DtInstituto;
import excepciones.CursoNoExiste;
import excepciones.EdicionVigenteNoExiste;
import excepciones.InscripcionEdRepetido;
import excepciones.SinInstitutos;
import excepciones.UsuarioNoEstudiante;
import excepciones.UsuarioNoExiste;
import interfaces.IControladorInscripcionEdicionCurso;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InscripcionEdicionCurso extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	IControladorInscripcionEdicionCurso icon;
	private JComboBox<String> comboBoxIns;
	private JComboBox<String> comboBoxCur;
	private JTextField textFieldEst;
	private JTextField textFieldCorreo;
	private JTextField textFieldEd;
	
	public InscripcionEdicionCurso(IControladorInscripcionEdicionCurso icon) {
		this.icon = icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Inscripcion a edicion de Curso");
		setBounds(100, 100, 343, 384);
		
		comboBoxIns = new JComboBox<String>();
		comboBoxIns.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultComboBoxModel<String> cursoNombre = new DefaultComboBoxModel<String>();
				comboBoxCur.setModel(cursoNombre);
				cargarCursosComboBoxInstitutos();
			}
		});
		/*comboBoxIns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultComboBoxModel<String> cursoNombre = new DefaultComboBoxModel<String>();
				comboBoxCur.setModel(cursoNombre);
				cargarCursosComboBoxInstitutos();
			}
		});*/
		comboBoxIns.setBounds(53, 48, 168, 20);
		getContentPane().setLayout(null);
		getContentPane().add(comboBoxIns);
		
		comboBoxCur = new JComboBox<String>();
		comboBoxCur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cargarEdicionVigenteComboBoxCursos();
			}
		});
		/*comboBoxCur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEdicionVigenteComboBoxCursos();
			}
		});*/
		comboBoxCur.setBounds(53, 104, 168, 20);
		comboBoxCur.setEnabled(false);
		getContentPane().add(comboBoxCur);
		
		JLabel lblNewLabel = new JLabel("Seleccione Instituto");
		lblNewLabel.setBounds(53, 23, 150, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione Curso");
		lblNewLabel_1.setBounds(53, 79, 150, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nick del Estudiante");
		lblNewLabel_1_1.setBounds(53, 181, 150, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		textFieldEst = new JTextField();
		textFieldEst.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					InscripcionEdicionCursoAceptarActionPerformed();
				}
			}
		});
		textFieldEst.setBounds(53, 196, 168, 20);
		getContentPane().add(textFieldEst);
		textFieldEst.setColumns(10);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					InscripcionEdicionCursoAceptarActionPerformed();
				}
			}
		});
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(53, 252, 168, 20);
		getContentPane().add(textFieldCorreo);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(173, 301, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InscripcionEdicionCursoAceptarActionPerformed();
				setVisible(false);
				limpiar();
			}
		});
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(43, 301, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				limpiar();
			}
		});
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Correo del estudiante");
		lblNewLabel_1_1_1.setBounds(53, 227, 150, 14);
		getContentPane().add(lblNewLabel_1_1_1);
		
		textFieldEd = new JTextField();
		textFieldEd.setColumns(10);
		textFieldEd.setBounds(53, 150, 168, 20);
		getContentPane().add(textFieldEd);
		textFieldEd.setEditable(false);
		
		JLabel lblNewLabel_1_2 = new JLabel("Edicion vigente");
		lblNewLabel_1_2.setBounds(53, 135, 150, 14);
		getContentPane().add(lblNewLabel_1_2);
		
	}
	
	private void cargarCursosComboBoxInstitutos() {

		String instituto = comboBoxIns.getSelectedItem().toString();
		
		ArrayList<DtCursoBase> cursos = new ArrayList<>();
		
		try {
			cursos = icon.seleccionarInstituto(instituto);
			
		} catch (CursoNoExiste n) {
			JOptionPane.showMessageDialog(this, n.getMessage(), "Inscripcion Edicion Curso", JOptionPane.ERROR_MESSAGE);
		}
	
		String[] array = new String[cursos.size()];
		int p = 0;
		for (DtCursoBase c: cursos) {
			array[p] = c.getNombre();
			p++;
		}
		
		for (int i = 0; i < cursos.size(); i++) {
			comboBoxCur.addItem(array[i]);
		}
		comboBoxCur.setEnabled(true);
		
	}
	
	private void cargarEdicionVigenteComboBoxCursos() {
		textFieldEd.setText("");
		if (comboBoxCur.getSelectedItem() != null) {
			try {
				DtEdicionBase dteb = icon.seleccionarCurso(comboBoxCur.getSelectedItem().toString());
				if (dteb == null) {
					JOptionPane.showInternalConfirmDialog(null, "Este curso no tiene edicion vigente, seleccione otro", "Edicion vigente",
				             JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
				} else {
					textFieldEd.setText(dteb.getNombre());
				}
				
			}catch(EdicionVigenteNoExiste ev) {
				JOptionPane.showMessageDialog(null, ev.getMessage(), "Inscripcion Edicion Curso", JOptionPane.ERROR_MESSAGE);
			}
		}	
	}
	
	private void InscripcionEdicionCursoAceptarActionPerformed() {
		
		if (checkeo(textFieldEst.getText(),textFieldCorreo.getText(),textFieldEd.getText())) {
			LocalDate date = LocalDate.now();
			DtFecha fecha = new DtFecha(date.getDayOfMonth(),date.getMonthValue(),date.getYear());
		
			try {
				icon.registrarInscripcionEd(textFieldEst.getText(), textFieldCorreo.getText(),comboBoxCur.getSelectedItem().toString(), fecha);
				icon.confirmar();
				JOptionPane.showMessageDialog(this, "La inscripcion se realizo con exito", "Inscripcion a Edicion Curso",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (InscripcionEdRepetido | UsuarioNoExiste | UsuarioNoEstudiante un) {
				JOptionPane.showMessageDialog(this, un.getMessage(), "Inscripcion a Edicion Curso", JOptionPane.ERROR_MESSAGE);
			}	
			
		}
		
	}
	
	private boolean checkeo(String estudiante, String correo, String edicion) {
		if(estudiante.isEmpty() || correo.isEmpty() || edicion.isEmpty()){
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Inscripcion a Edicion Curso", 
			JOptionPane.ERROR_MESSAGE);
			return false;
		} 
		return true;
	}
	
	private void limpiar() {
		icon.cancelar();
		DefaultComboBoxModel<String> institutos = new DefaultComboBoxModel<String>();
		comboBoxIns.setModel(institutos);
		DefaultComboBoxModel<String> cursos = new DefaultComboBoxModel<String>();
		comboBoxCur.setModel(cursos);
		comboBoxCur.setEnabled(false);
		textFieldEd.setText("");
		textFieldEst.setText("");
		textFieldCorreo.setText("");
	}
	
	public void inicializarComboBoxInstitutosInscripcionEdicion() {
		
		try {
			ArrayList<DtInstituto> institutos = icon.listarInstitutos();
			DefaultComboBoxModel<String> dml= new DefaultComboBoxModel<String>();
			for (int i = 0; i < institutos.size(); i++) {
			  dml.addElement(institutos.get(i).getNombre());
			}
			comboBoxIns.setModel(dml);
			
		} catch (SinInstitutos in) {
			JOptionPane.showMessageDialog(this, in.getMessage(), "Inscripcion Edicion Curso", JOptionPane.ERROR_MESSAGE);
		}
	}
		
}
