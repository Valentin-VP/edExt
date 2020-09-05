package presentacion;

//import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorAltaUsuario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
//import javax.swing.JToggleButton;

import excepciones.UsuarioRepetido;

import datatypes.DtFecha;
import javax.swing.JButton;
//import javax.swing.JSpinner;
//import javax.swing.SpinnerNumberModel;
//import java.awt.Choice;
//import javax.swing.JPasswordField;

public class AgregarUsuario extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IControladorAltaUsuario icon;
	private JTextField textFieldNick;
	private JTextField textFieldCorreo;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JComboBox<String> diaNac;
	private JComboBox<String> mesNac;
	private JComboBox<String> anioNac;

	public AgregarUsuario(IControladorAltaUsuario icon) {
		this.icon = icon;
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta de Usuario");
 
		setBounds(100, 100, 511, 549);
		getContentPane().setLayout(null);
		
		JLabel NickUsuario = new JLabel("Nick");
		NickUsuario.setBounds(58, 33, 44, 15);
		getContentPane().add(NickUsuario);
		
		textFieldNick = new JTextField();
		textFieldNick.setBounds(170, 31, 144, 19);
		getContentPane().add(textFieldNick);
		textFieldNick.setColumns(10);
		
		JLabel CorreoUsuario = new JLabel("Correo");
		CorreoUsuario.setBounds(58, 87, 70, 15);
		getContentPane().add(CorreoUsuario);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(170, 85, 144, 19);
		getContentPane().add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		JLabel NombreUsuario = new JLabel("Nombre");
		NombreUsuario.setBounds(58, 150, 70, 15);
		getContentPane().add(NombreUsuario);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(170, 148, 144, 19);
		getContentPane().add(textFieldNombre);
		
		JLabel ApellidoUsuario = new JLabel("Apellido");
		ApellidoUsuario.setBounds(58, 211, 70, 15);
		getContentPane().add(ApellidoUsuario);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(170, 209, 144, 19);
		getContentPane().add(textFieldApellido);
		
		JLabel lblFechanac = new JLabel("FechaNac.");
		lblFechanac.setBounds(58, 288, 82, 15);
		getContentPane().add(lblFechanac);
		
		diaNac = new JComboBox<String>();
		//diaNac.setMaximumRowCount(2);
		diaNac.setBounds(170, 283, 54, 24);
		diaNac.addItem("1");
		diaNac.addItem("2");
		diaNac.addItem("3");
		diaNac.addItem("4");
		diaNac.addItem("5");
		diaNac.addItem("6");
		diaNac.addItem("7");
		diaNac.addItem("8");
		diaNac.addItem("9");
		diaNac.addItem("10");
		diaNac.addItem("11");
		diaNac.addItem("12");
		diaNac.addItem("13");
		diaNac.addItem("14");
		diaNac.addItem("15");
		diaNac.addItem("16");
		diaNac.addItem("17");
		diaNac.addItem("18");
		diaNac.addItem("19");
		diaNac.addItem("20");
		diaNac.addItem("21");
		diaNac.addItem("22");
		diaNac.addItem("23");
		diaNac.addItem("24");
		diaNac.addItem("25");
		diaNac.addItem("26");
		diaNac.addItem("27");
		diaNac.addItem("28");
		diaNac.addItem("29");
		diaNac.addItem("30");
		diaNac.addItem("31");
		//diaNac.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		diaNac.setSelectedItem("1");
		getContentPane().add(diaNac);
		
		mesNac = new JComboBox<String>();
		mesNac.setBounds(254, 283, 54, 24);
		mesNac.addItem("1");
		mesNac.addItem("2");
		mesNac.addItem("3");
		mesNac.addItem("4");
		mesNac.addItem("5");
		mesNac.addItem("6");
		mesNac.addItem("7");
		mesNac.addItem("8");
		mesNac.addItem("9");
		mesNac.addItem("10");
		mesNac.addItem("11");
		mesNac.addItem("12");
		//mesNac.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		//mesNac.setMaximumRowCount(12);
		mesNac.setSelectedItem("1");
		getContentPane().add(mesNac);
		
		anioNac = new JComboBox<String>();
		anioNac.setBounds(339, 283, 60, 24);
		anioNac.addItem("1");
		anioNac.addItem("2");
		anioNac.addItem("3");
		anioNac.addItem("4");
		anioNac.addItem("5");
		anioNac.addItem("6");
		anioNac.addItem("7");
		anioNac.addItem("8");
		anioNac.addItem("9");
		anioNac.addItem("10");
		//anioNac.setModel(new DefaultComboBoxModel(new String[] {"1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002"}));
		//anioNac.setMaximumRowCount(10);
		anioNac.setSelectedItem("1992");
		getContentPane().add(anioNac);
		
		JLabel lblDia = new JLabel("dia");
		lblDia.setBounds(170, 256, 44, 15);
		getContentPane().add(lblDia);
		
		JLabel lblMes = new JLabel("mes");
		lblMes.setBounds(254, 256, 44, 15);
		getContentPane().add(lblMes);
		
		JLabel lblAnio = new JLabel("anio");
		lblAnio.setBounds(339, 256, 44, 15);
		getContentPane().add(lblAnio);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarUsuarioCancelarActionPerformed(arg0);
			}
		});
		btnCancelar.setBounds(79, 400, 117, 25);
		getContentPane().add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarUsuarioAceptarActionPerformed(arg0);
			}
		});
		btnAceptar.setBounds(293, 400, 117, 25);
		getContentPane().add(btnAceptar);

	}
	
	protected void agregarUsuarioCancelarActionPerformed(ActionEvent arg0) {
		limpiar();
		setVisible(false);
	}
	
	protected void agregarUsuarioAceptarActionPerformed(ActionEvent arg0) {
		String nickname = this.textFieldNick.getText();
		String correo = this.textFieldCorreo.getText();
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
	    String dia = (String) this.diaNac.getSelectedItem();
		String mes = (String) this.mesNac.getSelectedItem();
		String anio = (String) this.anioNac.getSelectedItem();
		DtFecha fechaNac = new DtFecha(Integer.parseInt(dia), Integer.parseInt(mes), Integer.parseInt(anio));
		if (checkeo()) {
			try {
				this.icon.altaUsuario(nickname, correo, nombre, apellido, fechaNac);
				this.icon.confirmarAltaUsuario();
				JOptionPane.showMessageDialog(this, "El Usuario se ha agregado con exito", "Agregar Usuario",
				JOptionPane.INFORMATION_MESSAGE);
			} catch (UsuarioRepetido e) {
				JOptionPane.showConfirmDialog(this, e.getMessage(), "Agregar Usuario", JOptionPane.ERROR_MESSAGE);
			}
			limpiar();
			//setVisible(false);
		}
	}	

	private boolean checkeo() {
		String nickname = this.textFieldNick.getText();
		String correo = this.textFieldCorreo.getText();
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		String dia = (String) this.diaNac.getSelectedItem();
		String mes = (String) this.mesNac.getSelectedItem();
		String anio = (String) this.anioNac.getSelectedItem();
		if(nickname.isEmpty() || correo.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || dia.equals("") || mes.equals("") || anio.equals("")) {
			JOptionPane.showConfirmDialog(this, "No puede haber campos vacios", "Agregar Usuario", 
			JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void limpiar() {
		this.textFieldNick.setText("");
		this.textFieldCorreo.setText("");
		this.textFieldNombre.setText("");
		this.textFieldApellido.setText("");
		this.diaNac.setSelectedItem("1");
		this.mesNac.setSelectedItem("1");
		this.anioNac.setSelectedItem("1992");
	}
}
