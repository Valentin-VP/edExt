package presentacion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import interfaces.IControladorAltaCategoria;

public class AgregarCategoria extends JInternalFrame {

private JTextField nombreCategoria;
	
	private static final long serialVersionUID = 1L;

    private IControladorAltaCategoria icon;

    public AgregarCategoria(IControladorAltaCategoria icon) {
        this.icon = icon;
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta Categoria");
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(null);
 
		setBounds(100, 100, 335, 171);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre Categoria");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(23, 27, 91, 25);
		getContentPane().add(lblNewLabel);
		
		nombreCategoria = new JTextField();
		nombreCategoria.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					agregarCategoriaAceptarAP();
				}
			}
		});
		nombreCategoria.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nombreCategoria.setBounds(117, 27, 174, 25);
		getContentPane().add(nombreCategoria);
		nombreCategoria.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarCategoriaAceptarAP();
			}
		});
		btnNewButton.setBounds(174, 84, 106, 34);
		getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				nombreCategoria.setText("");
			}
		});
		btnCancelar.setBounds(38, 84, 106, 34);
		getContentPane().add(btnCancelar);

	}

	private void agregarCategoriaAceptarAP() {
		if(nombreCategoria.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Nombre Vacio", JOptionPane.ERROR_MESSAGE);
		}else {
			try {
				this.icon.darAltaCategoria(nombreCategoria.getText());
				JOptionPane.showMessageDialog(this, "La Categoria fue ingresado con exito", "Categoria Creado", JOptionPane.INFORMATION_MESSAGE);
				nombreCategoria.setText("");
				setVisible(false);
			}catch(Exception exc){
				JOptionPane.showMessageDialog(this, exc.getMessage() , "Error en Alta", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
