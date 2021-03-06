package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import interfaces.IControladorAltaUsuario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import excepciones.SinInstitutos;
import excepciones.UsuarioRepetido;
import datatypes.DtFecha;
import datatypes.DtInstituto;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.security.NoSuchAlgorithmException;

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
	private JComboBox<String> comboBoxInstitutos;
	private JRadioButton DocenteSi;
	private JTextField textFieldPass;
	private JTextField textFieldRepeatPass;
	
	public AgregarUsuario(IControladorAltaUsuario icon) {
		this.icon = icon;
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta de Usuario");
 
		setBounds(100, 100, 511, 640);
		getContentPane().setLayout(null);
		
		JLabel NickUsuario = new JLabel("Nick");
		NickUsuario.setBounds(58, 33, 44, 15);
		getContentPane().add(NickUsuario);
		
		textFieldNick = new JTextField();
		/*textFieldNick.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						agregarUsuarioAceptarActionPerformed();
					} catch (NoSuchAlgorithmException e1) {
						e1.printStackTrace();
					}
				}
			}
		});*/
		textFieldNick.setBounds(170, 31, 144, 19);
		getContentPane().add(textFieldNick);
		textFieldNick.setColumns(10);
		
		JLabel CorreoUsuario = new JLabel("Correo");
		CorreoUsuario.setBounds(58, 87, 70, 15);
		getContentPane().add(CorreoUsuario);
		
		textFieldCorreo = new JTextField();
		/*textFieldCorreo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						agregarUsuarioAceptarActionPerformed();
					} catch (NoSuchAlgorithmException e1) {
						e1.printStackTrace();
					}
				}
			}
		});*/
		textFieldCorreo.setBounds(170, 85, 144, 19);
		getContentPane().add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		JLabel NombreUsuario = new JLabel("Nombre");
		NombreUsuario.setBounds(58, 301, 70, 15);
		getContentPane().add(NombreUsuario);
		
		textFieldNombre = new JTextField();
		/*textFieldNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						agregarUsuarioAceptarActionPerformed();
					} catch (NoSuchAlgorithmException e1) {
						e1.printStackTrace();
					}
				}
			}
		});*/
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(170, 299, 144, 19);
		getContentPane().add(textFieldNombre);
		
		JLabel ApellidoUsuario = new JLabel("Apellido");
		ApellidoUsuario.setBounds(58, 362, 70, 15);
		getContentPane().add(ApellidoUsuario);
		
		textFieldApellido = new JTextField();
		/*textFieldApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						agregarUsuarioAceptarActionPerformed();
					} catch (NoSuchAlgorithmException e1) {
						e1.printStackTrace();
					}
				}
			}
		});*/
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(170, 360, 144, 19);
		getContentPane().add(textFieldApellido);
		
		JLabel lblFechanac = new JLabel("FechaNac.");
		lblFechanac.setBounds(58, 439, 82, 15);
		getContentPane().add(lblFechanac);
		
		diaNac = new JComboBox<String>();
		diaNac.setBounds(170, 430, 54, 24);
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
		diaNac.setSelectedItem("1");
		getContentPane().add(diaNac);
		
		mesNac = new JComboBox<String>();
		mesNac.setBounds(254, 430, 54, 24);
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
		mesNac.setSelectedItem("1");
		getContentPane().add(mesNac);
		
		anioNac = new JComboBox<String>();
		anioNac.setBounds(339, 430, 60, 24);
		anioNac.addItem("1992");
		anioNac.addItem("1993");
		anioNac.addItem("1994");
		anioNac.addItem("1995");
		anioNac.addItem("1996");
		anioNac.addItem("1997");
		anioNac.addItem("1998");
		anioNac.addItem("1999");
		anioNac.addItem("2000");
		anioNac.addItem("2001");
		anioNac.addItem("2002");
		anioNac.setSelectedItem("1992");
		getContentPane().add(anioNac);
		
		JLabel lblDia = new JLabel("dia");
		lblDia.setBounds(170, 403, 44, 15);
		getContentPane().add(lblDia);
		
		JLabel lblMes = new JLabel("mes");
		lblMes.setBounds(254, 403, 44, 15);
		getContentPane().add(lblMes);
		
		JLabel lblAnio = new JLabel("anio");
		lblAnio.setBounds(339, 403, 44, 15);
		getContentPane().add(lblAnio);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					agregarUsuarioAceptarActionPerformed();
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
				setVisible(false);
				limpiar();
			}
		});
		btnAceptar.setBounds(305, 556, 117, 25);
		getContentPane().add(btnAceptar);
		
		JLabel lblDocente = new JLabel("Docente");
		lblDocente.setBounds(58, 511, 70, 15);
		getContentPane().add(lblDocente);
		
		
		DocenteSi = new JRadioButton("");
		DocenteSi.setSelected(false);
		DocenteSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(DocenteSi.isSelected()) {
					comboBoxInstitutos.setEnabled(true);
					agregarUsuarioCargarComboBox(arg0);
				}
				else {
					comboBoxInstitutos.setEnabled(false);
					DefaultComboBoxModel<String> emptycombo = new DefaultComboBoxModel<String>();
					comboBoxInstitutos.setModel(emptycombo);
				}				
			}
		});
		DocenteSi.setBounds(165, 503, 59, 23);
		getContentPane().add(DocenteSi);
		
		comboBoxInstitutos = new JComboBox<String>();
		comboBoxInstitutos.setBounds(254, 502, 145, 24);
		comboBoxInstitutos.setEnabled(false);
		getContentPane().add(comboBoxInstitutos);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiar();
				DocenteSi.setSelected(false);
				setVisible(false);
			}
		});
		btnCancelar.setBounds(58, 556, 117, 25);
		getContentPane().add(btnCancelar);
		
		JLabel PassUsuario = new JLabel("Password");
		PassUsuario.setBounds(58, 159, 70, 15);
		getContentPane().add(PassUsuario);
		
		JLabel RepeatPass = new JLabel("Confirmar");
		RepeatPass.setBounds(58, 220, 70, 15);
		getContentPane().add(RepeatPass);
		
		textFieldPass = new JTextField();
		textFieldPass.setColumns(10);
		textFieldPass.setBounds(170, 157, 144, 19);
		getContentPane().add(textFieldPass);
		
		textFieldRepeatPass = new JTextField();
		textFieldRepeatPass.setColumns(10);
		textFieldRepeatPass.setBounds(170, 218, 144, 19);
		getContentPane().add(textFieldRepeatPass);

	}
	
	protected void agregarUsuarioAceptarActionPerformed() throws NoSuchAlgorithmException {
		String nickname = this.textFieldNick.getText();
		String correo = this.textFieldCorreo.getText();
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		String pass = this.textFieldPass.getText();
		String instituto = (String) this.comboBoxInstitutos.getSelectedItem();
	    String dia = (String) this.diaNac.getSelectedItem();
		String mes = (String) this.mesNac.getSelectedItem();
		String anio = (String) this.anioNac.getSelectedItem();
		DtFecha fechaNac = new DtFecha(Integer.parseInt(dia), Integer.parseInt(mes), Integer.parseInt(anio));
		if (checkeo()) {
			try {
				if (DocenteSi.isSelected()) {
					this.icon.altaUsuario(nickname, correo, nombre, apellido, fechaNac, pass);
					this.icon.seleccionarInstituto(instituto);
					this.icon.confirmarAltaUsuario(DocenteSi.isSelected());
				} else {
					this.icon.altaUsuario(nickname, correo, nombre, apellido, fechaNac, pass);
					this.icon.confirmarAltaUsuario(DocenteSi.isSelected());
				}
				JOptionPane.showMessageDialog(this, "El Usuario se ha agregado con exito", "Agregar Usuario",
				JOptionPane.INFORMATION_MESSAGE);
			} catch (UsuarioRepetido e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Agregar Usuario", JOptionPane.ERROR_MESSAGE);
			}
		}
	}	

	private boolean checkeo() {
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		String pass = this.textFieldPass.getText();
		String confirmPass = this.textFieldRepeatPass.getText();
		String dia = (String) this.diaNac.getSelectedItem();
		String mes = (String) this.mesNac.getSelectedItem();
		String anio = (String) this.anioNac.getSelectedItem();
		if(nombre.isEmpty() || apellido.isEmpty() || dia.equals("") || mes.equals("") || anio.equals("") || pass.isEmpty() || confirmPass.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Agregar Usuario", 
			JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!(pass.equals(confirmPass))) {//chequeo pass
			JOptionPane.showMessageDialog(this, "Confirmacion de contrasenia fallida", "Agregar Usuario", 
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
		this.textFieldPass.setText("");
		this.textFieldRepeatPass.setText("");
		this.DocenteSi.setSelected(false);
		this.diaNac.setSelectedItem("1");
		this.mesNac.setSelectedItem("1");
		this.anioNac.setSelectedItem("1992");
		this.comboBoxInstitutos.removeAllItems();
		this.DocenteSi.setEnabled(true);
	}
	
	private void agregarUsuarioCargarComboBox(ActionEvent arg0) {
		try {
			List<DtInstituto> institutos = icon.listarInstitutos();
			String[] array = new String[institutos.size()];
			int p = 0;
			for (DtInstituto i: institutos) {
				array[p] = i.getNombre();
				p++;
			}
			for (int i = 0; i < institutos.size(); i++) {
				comboBoxInstitutos.addItem(array[i]);
			}
		}catch(SinInstitutos e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "Agregar Usuario", JOptionPane.ERROR_MESSAGE);
		}
	}
}
