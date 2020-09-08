package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorConsultaEdicionCurso;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import datatypes.DtCursoBase;

public class InfoEdicionCurso extends JInternalFrame {
	private JTextField nombreInstituto;
	private JList<String> listEdiciones;
	private JList<String> listCursos;
	
	private ArrayList<DtCursoBase> cursos = new ArrayList<DtCursoBase>();
	
	private static final long serialVersionUID = 1L;

    private IControladorConsultaEdicionCurso icon;
	
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
        
        JLabel Jlabel = new JLabel("Instituto");
        Jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Jlabel.setBounds(160, 23, 69, 22);
        getContentPane().add(Jlabel);
        
        nombreInstituto = new JTextField();
        nombreInstituto.setBounds(239, 25, 180, 22);
        getContentPane().add(nombreInstituto);
        nombreInstituto.setColumns(10);
        
        JList listCursos = new JList();
        listCursos.setBounds(29, 164, 243, 375);
        getContentPane().add(listCursos);
        
        JList listEdiciones = new JList();
        listEdiciones.setBounds(330, 164, 243, 375);
        getContentPane().add(listEdiciones);
        
        JButton btnNewButton = new JButton("Aceptar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		cargarCursos(arg0);
        	}
        });
        btnNewButton.setBounds(330, 69, 89, 23);
        getContentPane().add(btnNewButton);
        
        JButton cancelar = new JButton("Cancelar");
        cancelar.setBounds(183, 69, 89, 23);
        getContentPane().add(cancelar);
        
        JLabel lblNewLabel = new JLabel("Cursos");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(124, 131, 57, 22);
        getContentPane().add(lblNewLabel);
        
        JLabel lblInstitutos = new JLabel("Institutos");
        lblInstitutos.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblInstitutos.setBounds(426, 131, 69, 22);
        getContentPane().add(lblInstitutos);

	}
	
	protected void cargarCursos(ActionEvent e) {
		if(!nombreInstituto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Instituto Vacio", JOptionPane.ERROR_MESSAGE);
		}else {
			try {
				cursos = icon.seleccionarInstituto(nombreInstituto.getText());
				for(DtCursoBase DC: cursos) {
					
					
				}
				
			}catch(Exception exc) {
				JOptionPane.showMessageDialog(this, exc.getLocalizedMessage() , "Curso", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	
	private void limpiar(){
		nombreInstituto.setText("");
		listCursos.setEnabled(false);
		listEdiciones.setEnabled(false);
	}
}







