package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtFecha;
import interfaces.IControladorInscripcionEdicionCurso;
import logica.Instituto;
import logica.ManejadorInstituto;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class InscripcionEdicionCurso extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	IControladorInscripcionEdicionCurso icon;
	private JComboBox<String> comboBoxIns;
	private JComboBox<String> comboBoxCur;
	private JComboBox<String> comboBoxDia;
	private JComboBox<String> comboBoxMes;
	private JComboBox<String> comboBoxAnio;
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
		
		setBounds(100, 100, 372, 427);
		
		comboBoxIns = new JComboBox<String>();
		comboBoxIns.setBounds(53, 48, 168, 20);
		comboBoxIns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<DtCursoBase> cursos = icon.seleccionarInstituto(comboBoxIns.getSelectedItem().toString());
				//ArrayList<String> nombresCursos = new ArrayList<String>();
				for(DtCursoBase dts:cursos) {
					comboBoxCur.addItem(dts.getNombre());//nombresCursos.add(dts.getNombre());
				}
				
				//DefaultComboBoxModel<String> modelclases = new DefaultComboBoxModel<String>(nombresCursos.toArray(new String[0]));
				//comboBoxCur.setModel(modelclases);
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(comboBoxIns);
		
		comboBoxCur = new JComboBox<String>();
		comboBoxCur.setBounds(53, 104, 168, 20);
		comboBoxCur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DtEdicionBase dteb = null;
				dteb = icon.seleccionarCurso(comboBoxCur.getSelectedItem().toString());
				if (dteb == null) {
					JOptionPane.showInternalConfirmDialog(null, "Este curso no tiene edicion vigente, seleccione otro", "Edicion vigente",
				             JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
				} else {
					textFieldEd.setText(dteb.getNombre());
				}

			}
		});
		getContentPane().add(comboBoxCur);
		comboBoxCur.setEnabled(false);
		
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
		btnNewButton.setBounds(165, 350, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InscripcionEdicionCursoAceptarActionPerformed(e);
				setVisible(false);
				limpiar();
			}
		});
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(41, 350, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				icon.cancelar();
				setVisible(false);
				limpiar();
			}
		});
		getContentPane().add(btnNewButton_1);
		
		comboBoxDia = new JComboBox<String>();
		comboBoxDia.setBounds(53, 308, 46, 20);
		comboBoxDia.addItem("1");
		comboBoxDia.addItem("2");
		comboBoxDia.addItem("3");
		comboBoxDia.addItem("4");
		comboBoxDia.addItem("5");
		comboBoxDia.addItem("6");
		comboBoxDia.addItem("7");
		comboBoxDia.addItem("8");
		comboBoxDia.addItem("9");
		comboBoxDia.addItem("10");
		comboBoxDia.addItem("11");
		comboBoxDia.addItem("12");
		comboBoxDia.addItem("13");
		comboBoxDia.addItem("14");
		comboBoxDia.addItem("15");
		comboBoxDia.addItem("16");
		comboBoxDia.addItem("17");
		comboBoxDia.addItem("18");
		comboBoxDia.addItem("19");
		comboBoxDia.addItem("20");
		comboBoxDia.addItem("21");
		comboBoxDia.addItem("22");
		comboBoxDia.addItem("23");
		comboBoxDia.addItem("24");
		comboBoxDia.addItem("25");
		comboBoxDia.addItem("26");
		comboBoxDia.addItem("27");
		comboBoxDia.addItem("28");
		comboBoxDia.addItem("29");
		comboBoxDia.addItem("30");
		comboBoxDia.addItem("31");
		comboBoxDia.setSelectedItem("1");
		getContentPane().add(comboBoxDia);
		
		comboBoxMes = new JComboBox<String>();
		comboBoxMes.setBounds(127, 308, 45, 20);
		comboBoxMes.addItem("1");
		comboBoxMes.addItem("2");
		comboBoxMes.addItem("3");
		comboBoxMes.addItem("4");
		comboBoxMes.addItem("5");
		comboBoxMes.addItem("6");
		comboBoxMes.addItem("7");
		comboBoxMes.addItem("8");
		comboBoxMes.addItem("9");
		comboBoxMes.addItem("10");
		comboBoxMes.addItem("11");
		comboBoxMes.addItem("12");
		comboBoxMes.setSelectedItem("1");
		getContentPane().add(comboBoxMes);
		
		comboBoxAnio = new JComboBox<String>();
		comboBoxAnio.setBounds(202, 308, 64, 20);
		for(int i=1980;i<2005;i++) {
			comboBoxAnio.addItem(Integer.toString(i));
		}
		getContentPane().add(comboBoxAnio);
		
		JLabel lblNewLabel_2 = new JLabel("Dia");
		lblNewLabel_2.setBounds(53, 283, 22, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mes");
		lblNewLabel_3.setBounds(126, 283, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Anio");
		lblNewLabel_4.setBounds(202, 283, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
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
		String dia = (String) comboBoxDia.getSelectedItem();
		String mes = (String) comboBoxMes.getSelectedItem();
		String anio = (String) comboBoxAnio.getSelectedItem();
		DtFecha fecha = new DtFecha(Integer.parseInt(dia),Integer.parseInt(mes),Integer.parseInt(anio));

			if (icon.registrarInscripcionEd(textFieldEst.getText(), textFieldCorreo.getText(), comboBoxCur.getSelectedItem().toString(), fecha) == true) {
				int opcion = JOptionPane.showConfirmDialog(null, "Elige una opcion", "Modificar Inscripcion", JOptionPane.YES_NO_OPTION);
					if(opcion == 0) {
						icon.modificarInscripcionEd(textFieldEst.getText(), textFieldCorreo.getText(), comboBoxCur.getSelectedItem().toString(), fecha);
					}
			}
			icon.confirmar();
		
	}
	
	
	private boolean checkeo(String nombre, String descripcion) {
		if(nombre.isEmpty() || descripcion.isEmpty()){
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Crear Programa", 
			JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void limpiar() {
		textFieldEst.setText("");
		textFieldCorreo.setText("");
		comboBoxCur.setEnabled(false);
		comboBoxCur.removeAll();
	}
	
	
	
	
	public void inicializarComboBoxes() {
		
		ArrayList<Instituto> institutos = icon.listarInstitutos();
		//ArrayList<String> nombresInstitutos = new ArrayList<String>();
		for(Instituto i:institutos) {
			comboBoxIns.addItem(i.getNombre());//nombresInstitutos.add(i.getNombre());
		}
		
		//DefaultComboBoxModel<String> modelclases = new DefaultComboBoxModel<String>(nombresInstitutos.toArray(new String[0]));
		//comboBoxIns.setModel(modelclases);
		//DefaultComboBoxModel<Integer> modelclases = new DefaultComboBoxModel<Integer>(icon.);
		//comboBoxIDClase.setModel(modelclases);
		
		/*
		DefaultComboBoxModel dml= new DefaultComboBoxModel();
		for (int i = 0; i < <ArrayList>.size(); i++) {
		  dml.addElement(<ArrayList>.get(i).getField());
		}
		<ComboBoxName>.setModel(dml);
		*/
		
	}
}
