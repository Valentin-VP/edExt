package presentacion;


import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import interfaces.IControladorAltaInstituto;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AgregarInstituto extends JInternalFrame {
	private JTextField nombreInstituto;
	
	private static final long serialVersionUID = 1L;

    private IControladorAltaInstituto icon;

    public AgregarInstituto(IControladorAltaInstituto icon) {
        this.icon = icon;
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta de un Instituto");
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(null);
 
		setBounds(100, 100, 335, 171);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre Instituto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(23, 27, 91, 25);
		getContentPane().add(lblNewLabel);
		
		nombreInstituto = new JTextField();
		nombreInstituto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nombreInstituto.setBounds(117, 27, 174, 25);
		getContentPane().add(nombreInstituto);
		nombreInstituto.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarInstitutoAceptarAP(e);
			}
		});
		btnNewButton.setBounds(174, 84, 106, 34);
		getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				nombreInstituto.setText("");
			}
		});
		btnCancelar.setBounds(38, 84, 106, 34);
		getContentPane().add(btnCancelar);

	}

	private void agregarInstitutoAceptarAP(ActionEvent e) {
		if(nombreInstituto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Nombre Vacio", JOptionPane.ERROR_MESSAGE);
		}else {
			try {
				this.icon.darAltaInstituto(nombreInstituto.getText());
				JOptionPane.showMessageDialog(this, "El Instituto fue ingresado con exito", "Instituto Creado", JOptionPane.INFORMATION_MESSAGE);
				nombreInstituto.setText("");
				setVisible(false);
			}catch(Exception exc){
				JOptionPane.showMessageDialog(this, exc.getLocalizedMessage() , "Error en Alta", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
}
