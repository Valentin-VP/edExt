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
import javax.swing.JToggleButton;

import excepciones.UsuarioRepetido;

import datatypes.DtFecha;

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
		
		JComboBox<String> diaNac = new JComboBox<String>();
		diaNac.setMaximumRowCount(31);
		diaNac.setBounds(170, 283, 54, 24);
		diaNac.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		diaNac.setSelectedIndex(0);
		getContentPane().add(diaNac);
		
		JComboBox<String> mesNac = new JComboBox<String>();
		mesNac.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		mesNac.setMaximumRowCount(12);
		mesNac.setSelectedIndex(0);
		mesNac.setBounds(254, 283, 54, 24);
		getContentPane().add(mesNac);
		
		JComboBox<String> anioNac = new JComboBox<String>();
		anioNac.setModel(new DefaultComboBoxModel<String>(new String[] {"1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002"}));
		anioNac.setMaximumRowCount(10);
		anioNac.setSelectedIndex(0);
		anioNac.setBounds(339, 283, 60, 24);
		getContentPane().add(anioNac);
		
		JLabel lblDia = new JLabel("dia");
		lblDia.setBounds(170, 256, 44, 15);
		getContentPane().add(lblDia);
		
		JLabel NickUsuario_1_1 = new JLabel("mes");
		NickUsuario_1_1.setBounds(254, 256, 44, 15);
		getContentPane().add(NickUsuario_1_1);
		
		JLabel NickUsuario_1_1_1 = new JLabel("anio");
		NickUsuario_1_1_1.setBounds(339, 256, 44, 15);
		getContentPane().add(NickUsuario_1_1_1);
		
		JToggleButton AceptarAltaUsuario = new JToggleButton("Aceptar");
		AceptarAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarUsuarioAceptarActionPerformed(e);
			}
		});
		AceptarAltaUsuario.setBounds(58, 391, 144, 25);
		getContentPane().add(AceptarAltaUsuario);
		
		JToggleButton CancelarAltaUsuario = new JToggleButton("Cancelar");
		CancelarAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarUsuarioCancelarActionPerformed(e);
			}
		});
		CancelarAltaUsuario.setBounds(292, 391, 144, 25);
		getContentPane().add(CancelarAltaUsuario);

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
		Integer dia = (Integer) this.diaNac.getSelectedItem();
		Integer mes = (Integer) this.mesNac.getSelectedItem();
		Integer anio = (Integer) this.anioNac.getSelectedItem();
		DtFecha fechaNac = new DtFecha(dia, mes, anio);
		if (checkeo()) {
			try {
				this.icon.altaUsuario(nickname, correo, nombre, apellido, fechaNac);
				JOptionPane.showMessageDialog(this, "El Usuario se ha agregado con exito", "Agregar Usuario",
				JOptionPane.INFORMATION_MESSAGE);
			} catch (UsuarioRepetido e) {
				JOptionPane.showConfirmDialog(this, e.getMessage(), "Agregar Usuario", JOptionPane.ERROR_MESSAGE);
			}
			limpiar();
			setVisible(false);
		}
		
		
	}
	
	private boolean checkeo() {
		String nickname = this.textFieldNick.getText();
		String correo = this.textFieldCorreo.getText();
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		Integer dia = (Integer) this.diaNac.getSelectedItem();
		Integer mes = (Integer) this.mesNac.getSelectedItem();
		Integer anio = (Integer) this.anioNac.getSelectedItem();
		if(nickname.isEmpty() || correo.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || dia.equals(0) || mes.equals(0) || anio.equals(0)) {
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
		this.diaNac.setSelectedItem(1);
		this.mesNac.setSelectedItem(1);
		this.anioNac.setSelectedItem(1992);
	}

}
