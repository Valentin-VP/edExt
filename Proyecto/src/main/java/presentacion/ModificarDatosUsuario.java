package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import datatypes.DtFecha;
import datatypes.DtUsuario;
import datatypes.DtUsuarioBase;
import excepciones.SinUsuarios;
import excepciones.UsuarioNoExiste;
import interfaces.IControladorModificarDatosUsuario;

import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;

public class ModificarDatosUsuario extends JInternalFrame {
	private static final long serialVersionUID = 1L;

	IControladorModificarDatosUsuario icon;
	private JComboBox<String> comboBoxUsuario;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JPasswordField passwordField;
	private JPasswordField correctPasswordField;
	private JComboBox<String> comboBoxDia;
	private JComboBox<String> comboBoxMes;
	private JSpinner spinnerAnio;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private DtUsuario usuario;
	
	public ModificarDatosUsuario(IControladorModificarDatosUsuario icon) {
		this.icon = icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Modificar datos de usuario");
        setBounds(100, 100, 367, 439);
		getContentPane().setLayout(null);
		
		comboBoxUsuario = new JComboBox<String>();
		comboBoxUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarUsuarioComboBoxUsuario();
			}
		});
		comboBoxUsuario.setBounds(31, 36, 175, 20);
		getContentPane().add(comboBoxUsuario);
		
		JLabel lblNewLabel = new JLabel("Seleccione el usuario");
		lblNewLabel.setBounds(31, 11, 175, 14);
		getContentPane().add(lblNewLabel);
		
		textFieldNombre = new JTextField();
		textFieldNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					modificarDatosUsuarioAceptarActionPerformed();
				}
			}
		});
		textFieldNombre.setBounds(31, 92, 175, 20);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					modificarDatosUsuarioAceptarActionPerformed();
				}
			}
		});
		textFieldApellido.setBounds(31, 148, 175, 20);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					modificarDatosUsuarioAceptarActionPerformed();
				}
			}
		});
		passwordField.setBounds(31, 204, 175, 20);
		getContentPane().add(passwordField);
		
		lblNewLabel_2 = new JLabel("Nombre nuevo");
		lblNewLabel_2.setBounds(31, 67, 142, 14);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Apellido nuevo");
		lblNewLabel_3.setBounds(31, 123, 142, 14);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Contrasenia nueva");
		lblNewLabel_4.setBounds(31, 179, 142, 14);
		getContentPane().add(lblNewLabel_4);
		
		btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarDatosUsuarioAceptarActionPerformed();
				limpiar();
			}
		});
		btnNewButton.setBounds(187, 368, 89, 23);
		getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				icon.limpiar();
				setVisible(false);
				limpiar();
			}
		});
		btnNewButton_1.setBounds(59, 368, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		comboBoxDia = new JComboBox<String>();
		comboBoxDia.setBounds(31, 316, 75, 20);
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
		comboBoxMes.setBounds(131, 316, 68, 20);
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
		
		spinnerAnio = new JSpinner();
		spinnerAnio.setBounds(225, 316, 68, 20);
		spinnerAnio.setValue(1990);
		getContentPane().add(spinnerAnio);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de nacimiento");
		lblNewLabel_5.setBounds(31, 291, 142, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Confirmacion contrasenia");
		lblNewLabel_6.setBounds(31, 235, 175, 14);
		getContentPane().add(lblNewLabel_6);
		
		correctPasswordField = new JPasswordField();
		correctPasswordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					modificarDatosUsuarioAceptarActionPerformed();
				}
			}
		});
		correctPasswordField.setBounds(31, 260, 175, 20);
		getContentPane().add(correctPasswordField);
	}
	
	private void modificarDatosUsuarioAceptarActionPerformed() {
		if (this.usuario != null) {
			String nick = (String) comboBoxUsuario.getSelectedItem();
			String correo = "";//(String) comboBoxCorreo.getSelectedItem();
			String dia = (String) comboBoxDia.getSelectedItem();
			String mes = (String) comboBoxMes.getSelectedItem();
			Integer anio = (Integer) spinnerAnio.getValue();
			if (checkeo(textFieldNombre.getText(), textFieldApellido.getText(), dia, mes, anio, passwordField.getPassword(), correctPasswordField.getPassword())) {
				DtFecha fecha = new DtFecha(Integer.parseInt(dia),Integer.parseInt(mes),anio);
				icon.modificarDatosUsuario(nick, correo, textFieldNombre.getText(), textFieldApellido.getText(), fecha, passwordField.getPassword());
				JOptionPane.showMessageDialog(this, "Se modifico al usuario con exito", "Modificar datos usuario",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Seleccione un usuario, por favor", "Modificar datos usuario",
					JOptionPane.INFORMATION_MESSAGE);
		}		
	}
	
	private boolean checkeo(String nombre, String apellido, String dia, String mes, Integer anio, char[] passwd, char[] cpasswd) {
		LocalDate date = LocalDate.now();
		int aniomax = (date.getYear() - 12);
		if (nombre.isEmpty() || apellido.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Modificar datos usuario", 
			JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (anio.intValue() < 1900 || anio.intValue() > aniomax) {
			JOptionPane.showMessageDialog(this, "No es un anio valido", "Modificar datos usuario", 
			JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (!Arrays.equals(passwd, cpasswd)) {
			JOptionPane.showMessageDialog(this, "Las contrasenias no coinciden", "Modificar datos usuario", 
			JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void limpiar() {
		this.usuario = null;
		textFieldNombre.setText("");
		textFieldApellido.setText("");
		passwordField.setText("");
		correctPasswordField.setText("");
		comboBoxDia.setSelectedIndex(0);
		comboBoxMes.setSelectedIndex(0);
		spinnerAnio.setValue(1990);
	}
	
	public void inicializarComboBoxUsuariosModificarDatos() {
		try {
			ArrayList<DtUsuarioBase> usuarios = icon.mostrarUsuarios();
			DefaultComboBoxModel<String> dml= new DefaultComboBoxModel<String>();
			for (int i = 0; i < usuarios.size(); i++) {
			  dml.addElement(usuarios.get(i).getNick());
			}
			comboBoxUsuario.setModel(dml);
			
		} catch (SinUsuarios e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Modificar datos usuario", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void cargarUsuarioComboBoxUsuario() {

		String nick = comboBoxUsuario.getSelectedItem().toString();
		String correo = "";//comboBoxCorreo.getSelectedItem().toString();
		
		DtUsuario dtu = null;
		
		try {
			dtu = icon.seleccionarUsuario(nick, correo);
			this.usuario = dtu;
			textFieldNombre.setText(dtu.getNombre());
			textFieldApellido.setText(dtu.getApellido());
			passwordField.setText("");
			correctPasswordField.setText("");
			comboBoxDia.setSelectedItem(dtu.getFechaNac().getDia().toString());
			comboBoxMes.setSelectedItem(dtu.getFechaNac().getMes().toString());
			spinnerAnio.setValue(dtu.getFechaNac().getAnio());
			
		} catch (UsuarioNoExiste n) {
			JOptionPane.showMessageDialog(this, n.getMessage(), "Inscripcion Edicion Curso", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
