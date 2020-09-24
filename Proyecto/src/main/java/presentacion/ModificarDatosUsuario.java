package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import datatypes.DtFecha;
import interfaces.IControladorModificarDatosUsuario;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class ModificarDatosUsuario extends JInternalFrame {
	private static final long serialVersionUID = 1L;

	IControladorModificarDatosUsuario icon;
	private JComboBox<String> comboBoxUsuario;
	private JTextField textFieldCorreo;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JPasswordField passwordField;
	private JComboBox<String> comboBoxDia;
	private JComboBox<String> comboBoxMes;
	private JSpinner spinnerAnio;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	
	public ModificarDatosUsuario(IControladorModificarDatosUsuario icon) {
		this.icon = icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Modificar datos de usuario");
        setBounds(100, 100, 390, 432);
		getContentPane().setLayout(null);
		
		comboBoxUsuario = new JComboBox<String>();
		comboBoxUsuario.setBounds(31, 36, 175, 20);
		getContentPane().add(comboBoxUsuario);
		
		JLabel lblNewLabel = new JLabel("Seleccione el usuario");
		lblNewLabel.setBounds(31, 11, 115, 14);
		getContentPane().add(lblNewLabel);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(31, 92, 175, 20);
		getContentPane().add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Correo nuevo");
		lblNewLabel_1.setBounds(31, 67, 96, 14);
		getContentPane().add(lblNewLabel_1);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(31, 148, 175, 20);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(31, 204, 175, 20);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(31, 260, 175, 20);
		getContentPane().add(passwordField);
		
		lblNewLabel_2 = new JLabel("Nombre nuevo");
		lblNewLabel_2.setBounds(31, 123, 75, 14);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Apellido nuevo");
		lblNewLabel_3.setBounds(31, 179, 75, 14);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Contrasenia nueva");
		lblNewLabel_4.setBounds(31, 235, 96, 14);
		getContentPane().add(lblNewLabel_4);
		
		btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarDatosUsuarioAceptarActionPerformed();
				limpiar();
			}
		});
		btnNewButton.setBounds(245, 368, 89, 23);
		getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				icon.limpiar();
				limpiar();
			}
		});
		btnNewButton_1.setBounds(84, 368, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		comboBoxDia = new JComboBox<String>();
		comboBoxDia.setBounds(31, 323, 75, 20);
		getContentPane().add(comboBoxDia);
		
		comboBoxMes = new JComboBox<String>();
		comboBoxMes.setBounds(145, 323, 68, 20);
		getContentPane().add(comboBoxMes);
		
		spinnerAnio = new JSpinner();
		spinnerAnio.setBounds(245, 323, 68, 20);
		getContentPane().add(spinnerAnio);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de nacimiento");
		lblNewLabel_5.setBounds(31, 298, 142, 14);
		getContentPane().add(lblNewLabel_5);

	}
	
	private void modificarDatosUsuarioAceptarActionPerformed() {
		String nick = (String) comboBoxUsuario.getSelectedItem();
		String dia = (String) comboBoxDia.getSelectedItem();
		String mes = (String) comboBoxMes.getSelectedItem();
		Integer anio = (Integer) spinnerAnio.getValue();
		if (checkeo(nick, textFieldCorreo.getText(), textFieldNombre.getText(), textFieldApellido.getText(), dia, mes, anio, passwordField.getPassword())) {
			DtFecha fecha = new DtFecha(Integer.parseInt(dia),Integer.parseInt(mes),anio);
			icon.modificarDatosUsuario(nick, textFieldCorreo.getText(), textFieldNombre.getText(), textFieldApellido.getText(), fecha, passwordField.getPassword());
			icon.limpiar();
		}
	}
	
	private boolean checkeo(String nick, String correo, String nombre, String apellido, String dia, String mes, Integer anio, char[] password) {
		String passwd = new String(password);
		if (nick.isEmpty() || correo.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || passwd.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Modificar datos usuario", 
			JOptionPane.ERROR_MESSAGE);
			return false;	
		} else if (anio.intValue() < 1900 || anio.intValue() > 2008) {
			JOptionPane.showMessageDialog(this, "No es un anio valido", "Modificar datos usuario", 
			JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void limpiar() {
		textFieldCorreo.setText("");
		textFieldNombre.setText("");
		textFieldApellido.setText("");
		passwordField.setText("");
		comboBoxDia.setSelectedIndex(0);
		comboBoxMes.setSelectedIndex(0);
		spinnerAnio.setValue(2020);
	}
	
}
