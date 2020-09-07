package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorConsultaEdicionCurso;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JButton;

public class InfoEdicionCurso extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;

    private IControladorConsultaEdicionCurso icon;
    private JTextField textField;
	
	public InfoEdicionCurso(IControladorConsultaEdicionCurso icon) {
		getContentPane().setEnabled(false);
		this.icon = icon;
		setBounds(100, 100, 613, 603);
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Informacion Edicion de un Curso");
        getContentPane().setLayout(null);
        
        JPanel datos = new JPanel();
        datos.setBounds(0, 0, 597, 573);
        getContentPane().add(datos);
        
        JLabel nombreInstituto = new JLabel("Instituto");
        nombreInstituto.setFont(new Font("Tahoma", Font.PLAIN, 16));
        nombreInstituto.setBounds(160, 23, 69, 22);
        getContentPane().add(nombreInstituto);
        
        textField = new JTextField();
        textField.setBounds(239, 25, 180, 22);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        JList list_1 = new JList();
        list_1.setBounds(29, 119, 243, 420);
        getContentPane().add(list_1);
        
        JList list_1_1 = new JList();
        list_1_1.setBounds(330, 119, 243, 420);
        getContentPane().add(list_1_1);
        
        JButton btnNewButton = new JButton("New button");
        btnNewButton.setBounds(330, 69, 89, 23);
        getContentPane().add(btnNewButton);
        
        JButton cancelar = new JButton("Cancelar");
        cancelar.setBounds(183, 69, 89, 23);
        getContentPane().add(cancelar);

	}
}