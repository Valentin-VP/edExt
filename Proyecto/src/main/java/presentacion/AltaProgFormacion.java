package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorAltaProgFormacion;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AltaProgFormacion extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	IControladorAltaProgFormacion icon;
	private JTextField textFieldNom;
	private JTextField textFieldDes;
	private JComboBox comboBoxDiaI;
	
	public AltaProgFormacion(IControladorAltaProgFormacion icon) {
		this.icon = icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Crear Programa de Formacion");
		setBounds(100, 100, 283, 356);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(32, 29, 46, 14);
		getContentPane().add(lblNombre);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(32, 54, 129, 20);
		getContentPane().add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldDes = new JTextField();
		textFieldDes.setBounds(32, 104, 129, 20);
		getContentPane().add(textFieldDes);
		textFieldDes.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Descripcion");
		lblNewLabel.setBounds(32, 85, 65, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha de Inicio");
		lblNewLabel_1.setBounds(32, 135, 86, 14);
		getContentPane().add(lblNewLabel_1);
		
		comboBoxDiaI = new JComboBox<String>();
		comboBoxDiaI.setBounds(32, 163, 46, 20);
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
		
		JComboBox comboBoxMesI = new JComboBox();
		comboBoxMesI.setBounds(101, 163, 46, 20);
		getContentPane().add(comboBoxMesI);
		
		JComboBox comboBoxAnioI = new JComboBox();
		comboBoxAnioI.setBounds(169, 163, 46, 20);
		getContentPane().add(comboBoxAnioI);
		
		JComboBox comboBoxDiaF = new JComboBox();
		comboBoxDiaF.setBounds(32, 219, 46, 20);
		getContentPane().add(comboBoxDiaF);
		
		JComboBox comboBoxMesF = new JComboBox();
		comboBoxMesF.setBounds(101, 219, 46, 20);
		getContentPane().add(comboBoxMesF);
		
		JComboBox comboBoxAnioF = new JComboBox();
		comboBoxAnioF.setBounds(169, 219, 46, 20);
		getContentPane().add(comboBoxAnioF);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha de Finalizacion");
		lblNewLabel_1_1.setBounds(32, 194, 115, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*Calendar calendar = Calendar.getInstance();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				System.out.println(formatter.format(calendar.getTime()));
				*/

				//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				//String fechaA = formatter.format(date);

				Date fechaA = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String fi = comboBoxDiaI.getSelectedItem().toString() + "/" + comboBoxMesI.getSelectedItem().toString() + "/" + comboBoxAnioI.getSelectedItem().toString();
				String ff = comboBoxDiaF.getSelectedItem().toString() + "/" + comboBoxMesF.getSelectedItem().toString() + "/" + comboBoxAnioF.getSelectedItem().toString();
				Date fechaI;
				Date fechaF;
				try {
					fechaI = sdf.parse(fi);
					fechaF = sdf.parse(ff);
					if (icon.ingresarProgFormacion(textFieldNom.getText(), textFieldDes.getText(), fechaI, fechaF, fechaA) == true) {
						int opcion = JOptionPane.showConfirmDialog(null, "Elige una opcion", "Modificar Programa", JOptionPane.YES_NO_OPTION);
						if(opcion == 0) {
							icon.modificarProgFormacion(textFieldNom.getText(), textFieldDes.getText(), fechaI, fechaF, fechaA);
						}
					}
					icon.confirmar();
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(143, 272, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				icon.cancelar();
				textFieldNom.setText("");
				textFieldDes.setText("");
			}
		});
		btnNewButton_1.setBounds(29, 272, 89, 23);
		getContentPane().add(btnNewButton_1);

	}
}
