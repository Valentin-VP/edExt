package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorAltaProgFormacion;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import datatypes.DtFecha;
import excepciones.UsuarioRepetido;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class AltaProgFormacion extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	IControladorAltaProgFormacion icon;
	private JTextField textFieldNom;
	private JTextField textFieldDes;
	private JComboBox comboBoxDiaI;
	private JComboBox comboBoxMesI;
	private JComboBox comboBoxAnioI;
	private JComboBox comboBoxDiaF;
	private JComboBox comboBoxMesF;
	private JComboBox comboBoxAnioF;
	
	public AltaProgFormacion(IControladorAltaProgFormacion icon) {
		this.icon = icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Crear Programa de Formacion");
		setBounds(100, 100, 333, 337);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(32, 42, 46, 14);
		getContentPane().add(lblNombre);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(101, 39, 129, 20);
		getContentPane().add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldDes = new JTextField();
		textFieldDes.setBounds(101, 88, 129, 20);
		getContentPane().add(textFieldDes);
		textFieldDes.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Descripcion:");
		lblNewLabel.setBounds(32, 91, 65, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha de Inicio");
		lblNewLabel_1.setBounds(29, 141, 86, 14);
		getContentPane().add(lblNewLabel_1);
		
		comboBoxDiaI = new JComboBox<String>();
		comboBoxDiaI.setBounds(120, 138, 46, 20);
		comboBoxDiaI.addItem("1");
		comboBoxDiaI.addItem("2");
		comboBoxDiaI.addItem("3");
		comboBoxDiaI.addItem("4");
		comboBoxDiaI.addItem("5");
		comboBoxDiaI.addItem("6");
		comboBoxDiaI.addItem("7");
		comboBoxDiaI.addItem("8");
		comboBoxDiaI.addItem("9");
		comboBoxDiaI.addItem("10");
		comboBoxDiaI.addItem("11");
		comboBoxDiaI.addItem("12");
		comboBoxDiaI.addItem("13");
		comboBoxDiaI.addItem("14");
		comboBoxDiaI.addItem("15");
		comboBoxDiaI.addItem("16");
		comboBoxDiaI.addItem("17");
		comboBoxDiaI.addItem("18");
		comboBoxDiaI.addItem("19");
		comboBoxDiaI.addItem("20");
		comboBoxDiaI.addItem("21");
		comboBoxDiaI.addItem("22");
		comboBoxDiaI.addItem("23");
		comboBoxDiaI.addItem("24");
		comboBoxDiaI.addItem("25");
		comboBoxDiaI.addItem("26");
		comboBoxDiaI.addItem("27");
		comboBoxDiaI.addItem("28");
		comboBoxDiaI.addItem("29");
		comboBoxDiaI.addItem("30");
		comboBoxDiaI.addItem("31");
		comboBoxDiaI.setSelectedItem("1");
		getContentPane().add(comboBoxDiaI);
		
		comboBoxMesI = new JComboBox<String>();
		comboBoxMesI.setBounds(176, 138, 46, 20);
		comboBoxMesI.addItem("1");
		comboBoxMesI.addItem("2");
		comboBoxMesI.addItem("3");
		comboBoxMesI.addItem("4");
		comboBoxMesI.addItem("5");
		comboBoxMesI.addItem("6");
		comboBoxMesI.addItem("7");
		comboBoxMesI.addItem("8");
		comboBoxMesI.addItem("9");
		comboBoxMesI.addItem("10");
		comboBoxMesI.addItem("11");
		comboBoxMesI.addItem("12");
		comboBoxMesI.setSelectedItem("1");
		getContentPane().add(comboBoxMesI);
		
		comboBoxAnioI = new JComboBox<String>();
		comboBoxAnioI.setBounds(232, 138, 46, 20);
		comboBoxAnioI.addItem("1");
		comboBoxAnioI.addItem("2");
		comboBoxAnioI.addItem("3");
		comboBoxAnioI.addItem("4");
		comboBoxAnioI.addItem("5");
		comboBoxAnioI.addItem("6");
		comboBoxAnioI.addItem("7");
		comboBoxAnioI.addItem("8");
		comboBoxAnioI.addItem("9");
		comboBoxAnioI.addItem("10");
		comboBoxAnioI.addItem("11");
		comboBoxAnioI.addItem("12");
		comboBoxAnioI.setSelectedItem("1");
		getContentPane().add(comboBoxAnioI);
		
		comboBoxDiaF = new JComboBox<String>();
		comboBoxDiaF.setBounds(143, 191, 46, 20);
		comboBoxDiaF.addItem("1");
		comboBoxDiaF.addItem("2");
		comboBoxDiaF.addItem("3");
		comboBoxDiaF.addItem("4");
		comboBoxDiaF.addItem("5");
		comboBoxDiaF.addItem("6");
		comboBoxDiaF.addItem("7");
		comboBoxDiaF.addItem("8");
		comboBoxDiaF.addItem("9");
		comboBoxDiaF.addItem("10");
		comboBoxDiaF.addItem("11");
		comboBoxDiaF.addItem("12");
		comboBoxDiaF.addItem("13");
		comboBoxDiaF.addItem("14");
		comboBoxDiaF.addItem("15");
		comboBoxDiaF.addItem("16");
		comboBoxDiaF.addItem("17");
		comboBoxDiaF.addItem("18");
		comboBoxDiaF.addItem("19");
		comboBoxDiaF.addItem("20");
		comboBoxDiaF.addItem("21");
		comboBoxDiaF.addItem("22");
		comboBoxDiaF.addItem("23");
		comboBoxDiaF.addItem("24");
		comboBoxDiaF.addItem("25");
		comboBoxDiaF.addItem("26");
		comboBoxDiaF.addItem("27");
		comboBoxDiaF.addItem("28");
		comboBoxDiaF.addItem("29");
		comboBoxDiaF.addItem("30");
		comboBoxDiaF.addItem("31");
		comboBoxDiaF.setSelectedItem("1");
		getContentPane().add(comboBoxDiaF);
		
		comboBoxMesF = new JComboBox<String>();
		comboBoxMesF.setBounds(199, 191, 46, 20);
		comboBoxMesF.addItem("1");
		comboBoxMesF.addItem("2");
		comboBoxMesF.addItem("3");
		comboBoxMesF.addItem("4");
		comboBoxMesF.addItem("5");
		comboBoxMesF.addItem("6");
		comboBoxMesF.addItem("7");
		comboBoxMesF.addItem("8");
		comboBoxMesF.addItem("9");
		comboBoxMesF.addItem("10");
		comboBoxMesF.addItem("11");
		comboBoxMesF.addItem("12");
		comboBoxMesF.setSelectedItem("1");
		getContentPane().add(comboBoxMesF);
		
		comboBoxAnioF = new JComboBox<String>();
		comboBoxAnioF.setBounds(251, 191, 46, 20);
		comboBoxAnioF.addItem("1");
		comboBoxAnioF.addItem("2");
		comboBoxAnioF.addItem("3");
		comboBoxAnioF.addItem("4");
		comboBoxAnioF.addItem("5");
		comboBoxAnioF.addItem("6");
		comboBoxAnioF.addItem("7");
		comboBoxAnioF.addItem("8");
		comboBoxAnioF.addItem("9");
		comboBoxAnioF.addItem("10");
		comboBoxAnioF.addItem("11");
		comboBoxAnioF.addItem("12");
		comboBoxAnioF.setSelectedItem("1");
		getContentPane().add(comboBoxAnioF);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha de Finalizacion");
		lblNewLabel_1_1.setBounds(29, 194, 115, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaProgFormacionAceptarActionPerformed(e);
				setVisible(false);
				limpiar();
			}
		});
		btnNewButton.setBounds(176, 248, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				icon.cancelar();
				setVisible(false);
				limpiar();
			}
		});
		btnNewButton_1.setBounds(55, 248, 89, 23);
		getContentPane().add(btnNewButton_1);

	}
	
	private void altaProgFormacionAceptarActionPerformed(ActionEvent e) {
		
		String diaI = (String) comboBoxDiaI.getSelectedItem();
		String mesI = (String) comboBoxMesI.getSelectedItem();
		String anioI = (String) comboBoxAnioI.getSelectedItem();
		String diaF = (String) comboBoxDiaF.getSelectedItem();
		String mesF = (String) comboBoxMesF.getSelectedItem();
		String anioF = (String) comboBoxAnioF.getSelectedItem();
		
		LocalDate date = LocalDate.now();
		DtFecha fechaI = new DtFecha(Integer.parseInt(diaI),Integer.parseInt(mesI),Integer.parseInt(anioI));
		DtFecha fechaF = new DtFecha(Integer.parseInt(diaF),Integer.parseInt(mesF),Integer.parseInt(anioF));
		DtFecha fechaA = new DtFecha((Integer)date.getDayOfMonth(),(Integer)date.getMonthValue(),(Integer)date.getYear());
		if (checkeo(textFieldNom.getText(),textFieldDes.getText())) {
			if (icon.ingresarProgFormacion(textFieldNom.getText(), textFieldDes.getText(), fechaI, fechaF, fechaA)) {
				int opcion = JOptionPane.showConfirmDialog(null, "Elige una opcion", "Modificar Programa", JOptionPane.YES_NO_OPTION);
				if(opcion == 0) {
					icon.modificarProgFormacion(textFieldNom.getText(), textFieldDes.getText(), fechaI, fechaF, fechaA);
				}
			}
			icon.confirmar();
			JOptionPane.showMessageDialog(this, "El Programa se ha creado con exito", "Crear Programa",
					JOptionPane.INFORMATION_MESSAGE);
			limpiar();
		}

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
		textFieldNom.setText("");
		textFieldDes.setText("");
	}
	
}
