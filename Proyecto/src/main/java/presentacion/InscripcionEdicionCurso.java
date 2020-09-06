package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import datatypes.DtCursoBase;
import interfaces.IControladorInscripcionEdicionCurso;
import logica.Instituto;
import logica.ManejadorInstituto;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class InscripcionEdicionCurso extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	IControladorInscripcionEdicionCurso icon;
	private JComboBox<String> comboBoxIns;
	private JComboBox<String> comboBoxCur;
	private JComboBox<String> comboBoxEst;
	private JComboBox<String> comboBoxDia;
	private JComboBox<String> comboBoxMes;
	private JComboBox<String> comboBoxAnio;
	
	public InscripcionEdicionCurso(IControladorInscripcionEdicionCurso icon) {
		this.icon = icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Inscripcion a edicion de Curso");
		
		setBounds(100, 100, 470, 363);
		getContentPane().setLayout(null);
		
		JComboBox comboBoxIns = new JComboBox();
		comboBoxIns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<DtCursoBase> cursos = icon.seleccionarInstituto(comboBoxIns.getSelectedItem().toString());
				ArrayList<String> nombresCursos = new ArrayList<String>();
				for(DtCursoBase dts:cursos) {
					nombresCursos.add(dts.getNombre());
				}
				
				DefaultComboBoxModel<String> modelclases = new DefaultComboBoxModel<String>(nombresCursos.toArray(new String[0]));
				comboBoxCur.setModel(modelclases);
			}
		});
		comboBoxIns.setBounds(90, 60, 119, 20);
		getContentPane().add(comboBoxIns);
		
		JComboBox comboBoxCur = new JComboBox();
		comboBoxCur.setBounds(90, 116, 119, 20);
		getContentPane().add(comboBoxCur);
		comboBoxCur.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("Seleccione Instituto");
		lblNewLabel.setBounds(90, 35, 99, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione Curso");
		lblNewLabel_1.setBounds(90, 91, 99, 14);
		getContentPane().add(lblNewLabel_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(272, 60, 145, 134);
		getContentPane().add(textPane);
		textPane.setEditable(false);
		
		JLabel lblNewLabel_1_1 = new JLabel("Seleccione Estudiante");
		lblNewLabel_1_1.setBounds(90, 147, 119, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JComboBox comboBoxEst = new JComboBox();
		comboBoxEst.setBounds(90, 172, 119, 20);
		getContentPane().add(comboBoxEst);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				icon.seleccionarInstituto(comboBoxIns.getSelectedItem().toString());
			}
		});
		btnNewButton.setBounds(277, 288, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxCur.setEnabled(false);
				comboBoxCur.removeAll();
				setVisible(false);
				//comboBoxDia.setSelectedIndex(0);;
				//comboBoxMes.setSelectedIndex(0);;
				//comboBoxAnio.setSelectedIndex(0);;
				textPane.setText("");
			}
		});
		btnNewButton_1.setBounds(90, 288, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JComboBox comboBoxDia = new JComboBox();
		comboBoxDia.setBounds(90, 235, 42, 20);
		getContentPane().add(comboBoxDia);
		
		JComboBox comboBoxMes = new JComboBox();
		comboBoxMes.setBounds(164, 235, 45, 20);
		getContentPane().add(comboBoxMes);
		
		JComboBox comboBoxAnio = new JComboBox();
		comboBoxAnio.setBounds(235, 235, 42, 20);
		getContentPane().add(comboBoxAnio);
		
		JLabel lblNewLabel_2 = new JLabel("Dia");
		lblNewLabel_2.setBounds(100, 213, 22, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mes");
		lblNewLabel_3.setBounds(163, 213, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Anio");
		lblNewLabel_4.setBounds(231, 205, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
	}
		
	public void inicializarComboBoxes() {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		
		ArrayList<Instituto> cursos = mI.getInstitutos();
		ArrayList<String> nombresInstitutos = new ArrayList<String>();
		for(Instituto i:cursos) {
			nombresInstitutos.add(i.getNombre());
		}
		
		
		DefaultComboBoxModel<String> modelclases = new DefaultComboBoxModel<String>(nombresInstitutos.toArray(new String[0]));
		comboBoxIns.setModel(modelclases);
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
