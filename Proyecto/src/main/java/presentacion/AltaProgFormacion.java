package presentacion;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorAltaProgFormacion;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import datatypes.DtFecha;
import excepciones.ProgramaRepetido;

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
	private JComboBox<String> comboBoxDiaI;
	private JComboBox<String> comboBoxMesI;
	private JComboBox<String> comboBoxAnioI;
	private JComboBox<String> comboBoxDiaF;
	private JComboBox<String> comboBoxMesF;
	private JComboBox<String> comboBoxAnioF;
	
	public AltaProgFormacion(IControladorAltaProgFormacion icon) {
		this.icon = icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Crear Programa de Formacion");
		setBounds(100, 100, 390, 358);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(32, 42, 83, 14);
		getContentPane().add(lblNombre);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(136, 39, 142, 20);
		getContentPane().add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldDes = new JTextField();
		textFieldDes.setBounds(136, 88, 142, 20);
		getContentPane().add(textFieldDes);
		textFieldDes.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Descripcion:");
		lblNewLabel.setBounds(32, 91, 83, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha de Inicio");
		lblNewLabel_1.setBounds(29, 141, 86, 14);
		getContentPane().add(lblNewLabel_1);
		
		comboBoxDiaI = new JComboBox<String>();
		comboBoxDiaI.setBounds(154, 138, 46, 20);
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
		comboBoxMesI.setBounds(215, 138, 46, 20);
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
		comboBoxAnioI.setBounds(279, 138, 65, 20);
		comboBoxAnioI.addItem("2020");
		comboBoxAnioI.addItem("2021");
		comboBoxAnioI.addItem("2022");
		comboBoxAnioI.addItem("2023");
		comboBoxAnioI.addItem("2024");
		comboBoxAnioI.addItem("2025");
		comboBoxAnioI.addItem("2026");
		comboBoxAnioI.addItem("2027");
		comboBoxAnioI.addItem("2028");
		comboBoxAnioI.addItem("2029");
		comboBoxAnioI.addItem("2030");
		comboBoxAnioI.addItem("2031");
		comboBoxAnioI.setSelectedItem("2020");
		getContentPane().add(comboBoxAnioI);
		
		comboBoxDiaF = new JComboBox<String>();
		comboBoxDiaF.setBounds(154, 191, 46, 20);
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
		comboBoxMesF.setBounds(215, 191, 46, 20);
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
		comboBoxAnioF.setBounds(279, 191, 65, 20);
		comboBoxAnioF.addItem("2020");
		comboBoxAnioF.addItem("2021");
		comboBoxAnioF.addItem("2022");
		comboBoxAnioF.addItem("2023");
		comboBoxAnioF.addItem("2024");
		comboBoxAnioF.addItem("2025");
		comboBoxAnioF.addItem("2026");
		comboBoxAnioF.addItem("2027");
		comboBoxAnioF.addItem("2028");
		comboBoxAnioF.addItem("2029");
		comboBoxAnioF.addItem("2030");
		comboBoxAnioF.addItem("2031");
		comboBoxAnioF.setSelectedItem("2020");
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
		if (checkeo(textFieldNom.getText(),textFieldDes.getText(),diaI,mesI,anioI,diaF,mesF,anioF)) {
			DtFecha fechaI = new DtFecha(Integer.parseInt(diaI),Integer.parseInt(mesI),Integer.parseInt(anioI));
			DtFecha fechaF = new DtFecha(Integer.parseInt(diaF),Integer.parseInt(mesF),Integer.parseInt(anioF));
			DtFecha fechaA = new DtFecha((Integer)date.getDayOfMonth(),(Integer)date.getMonthValue(),(Integer)date.getYear());
			try {
				icon.ingresarProgFormacion(textFieldNom.getText(), textFieldDes.getText(), fechaI, fechaF, fechaA);
				icon.confirmar();
				JOptionPane.showMessageDialog(this, "El Programa se ha creado con exito", "Crear Programa",
						JOptionPane.INFORMATION_MESSAGE);
				limpiar();
			}catch(ProgramaRepetido pr) {
				JOptionPane.showMessageDialog(this, pr.getMessage(), "Crear Programa", JOptionPane.ERROR_MESSAGE);
			}
		}

	}
	
	private boolean checkeo(String nombre, String descripcion, String diaI, String mesI, String anioI, String diaF, String mesF, String anioF) {
		if(nombre.isEmpty() || descripcion.isEmpty()){
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Crear Programa", 
			JOptionPane.ERROR_MESSAGE);
			return false;
		} else if(Integer.parseInt(anioI) > Integer.parseInt(anioF)) {
			JOptionPane.showMessageDialog(this, "Error en el año", "Crear Programa", 
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else if(Integer.parseInt(anioI) == Integer.parseInt(anioF) && Integer.parseInt(mesI) > Integer.parseInt(mesF)) {
			JOptionPane.showMessageDialog(this, "Error en el mes", "Crear Programa", 
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else if(Integer.parseInt(anioI) == Integer.parseInt(anioF) && Integer.parseInt(mesI) == Integer.parseInt(mesF) && Integer.parseInt(diaI) > Integer.parseInt(diaF)) {
			JOptionPane.showMessageDialog(this, "Error en el dia", "Crear Programa", 
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void limpiar() {
		textFieldNom.setText("");
		textFieldDes.setText("");
		comboBoxDiaI.setSelectedIndex(0);
		comboBoxMesI.setSelectedIndex(0);
		comboBoxAnioI.setSelectedIndex(0);
		comboBoxDiaF.setSelectedIndex(0);
		comboBoxMesF.setSelectedIndex(0);
		comboBoxAnioF.setSelectedIndex(0);
	}
	
}
