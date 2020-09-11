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
		comboBoxIns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ArrayList<DtCursoBase> cursos = new ArrayList<>();
				DefaultComboBoxModel<String> dml= new DefaultComboBoxModel<String>();
				try {
					cursos = icon.seleccionarInstituto(comboBoxIns.getSelectedItem().toString());
				} catch (SinInstitutos | CursoNoExiste n) {
					JOptionPane.showMessageDialog(null, n.getMessage(), "Inscripcion Edicion Curso", JOptionPane.ERROR_MESSAGE);
				}
				
				for (int i = 0; i < cursos.size(); i++) {
					dml.addElement(cursos.get(i).getNombre());
				}
				comboBoxCur.setModel(dml);
				
			}
		});
		comboBoxIns.setBounds(53, 48, 168, 20);
		getContentPane().setLayout(null);
		getContentPane().add(comboBoxIns);
		
		comboBoxCur = new JComboBox<String>();
		comboBoxCur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldEd.setText("");
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
		});
		comboBoxCur.setBounds(53, 104, 168, 20);
		getContentPane().add(comboBoxCur);
		
		JLabel lblNewLabel = new JLabel("Seleccione Instituto");
		lblNewLabel.setBounds(53, 23, 99, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione Curso");
		lblNewLabel_1.setBounds(53, 79, 99, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nick del Estudiante");
		lblNewLabel_1_1.setBounds(53, 181, 119, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		textFieldEst = new JTextField();
		textFieldEst.setBounds(53, 196, 168, 20);
		getContentPane().add(textFieldEst);
		textFieldEst.setColumns(10);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(53, 252, 168, 20);
		getContentPane().add(textFieldCorreo);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(173, 301, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InscripcionEdicionCursoAceptarActionPerformed(e);
				setVisible(false);
				icon.limpiar();
				limpiar();
			}
		});
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(43, 301, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				icon.limpiar();
				limpiar();
			}
		});
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Correo del estudiante");
		lblNewLabel_1_1_1.setBounds(53, 227, 119, 14);
		getContentPane().add(lblNewLabel_1_1_1);
		
		textFieldEd = new JTextField();
		textFieldEd.setColumns(10);
		textFieldEd.setBounds(53, 150, 168, 20);
		getContentPane().add(textFieldEd);
		textFieldEd.setEditable(false);
		
		JLabel lblNewLabel_1_2 = new JLabel("Edicion vigente");
		lblNewLabel_1_2.setBounds(53, 135, 99, 14);
		getContentPane().add(lblNewLabel_1_2);
		
	}
	
	private void InscripcionEdicionCursoAceptarActionPerformed(ActionEvent e) {
		
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
		//comboBoxIns.removeAllItems();
		//comboBoxCur.removeAllItems();
		textFieldEd.setText("");
		textFieldEst.setText("");
		textFieldCorreo.setText("");
	}
	
	public void inicializarComboBoxsInscripcionEdicion() {
		
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
