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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InfoEdicionCurso extends JInternalFrame {
	private JTextField nombreInstituto;

	private DefaultListModel<String> nombreCursos = new DefaultListModel<String>();
	private DefaultListModel<String> nombreEdiciones = new DefaultListModel<String>();
	
	private JList<String> listEdiciones;
	private JList<String> listCursos;
	
	private static final long serialVersionUID = 1L;

    private IControladorConsultaEdicionCurso icon;
	
	public InfoEdicionCurso(IControladorConsultaEdicionCurso icon) {
		getContentPane().setEnabled(false);
		this.icon = icon;
		setBounds(100, 100, 493, 524);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setTitle("Informacion Edicion de un Curso");
        getContentPane().setLayout(null);
        
        JLabel Jlabel = new JLabel("Instituto");
        Jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Jlabel.setBounds(90, 23, 69, 22);
        getContentPane().add(Jlabel);
        
        nombreInstituto = new JTextField();
        nombreInstituto.setBounds(157, 25, 180, 22);
        getContentPane().add(nombreInstituto);
        nombreInstituto.setColumns(10);
        
        listEdiciones = new JList<String>();
        listEdiciones.setBounds(255, 164, 180, 319);
        getContentPane().add(listEdiciones);
        
        JButton btnNewButton = new JButton("Aceptar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		cargarCursos(arg0);
        	}
        });
        btnNewButton.setBounds(267, 69, 89, 23);
        getContentPane().add(btnNewButton);
        
        JButton cancelar = new JButton("Cancelar");
        cancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        		limpiar();
        	}
        });
        cancelar.setBounds(112, 69, 89, 23);
        getContentPane().add(cancelar);
        
        JLabel lblNewLabel = new JLabel("Cursos");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(102, 131, 57, 22);
        getContentPane().add(lblNewLabel);
        
        JLabel lblInstitutos = new JLabel("Ediciones del Curso");
        lblInstitutos.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblInstitutos.setBounds(278, 131, 157, 22);
        getContentPane().add(lblInstitutos);
        
        listCursos = new JList<String>();
        listCursos.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		String cursoSelected = null;
        		int[] selectedIx = listCursos.getSelectedIndices();
				for (int i = 0; i < selectedIx.length; i++) {
					cursoSelected = listCursos.getModel().getElementAt(selectedIx[i]).toString();
				}
				cargarEdicionCurso(arg0, cursoSelected);
        	}
        });
        listCursos.setBounds(35, 164, 180, 319);
        getContentPane().add(listCursos);

	}
	
	protected void cargarCursos(ActionEvent e) {
		if(nombreInstituto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Instituto Vacio", JOptionPane.ERROR_MESSAGE);
		}else {
			ArrayList<DtCursoBase> DtCursoBase = new ArrayList<DtCursoBase>();
			try {
				DtCursoBase = icon.seleccionarInstituto(nombreInstituto.getText());
				for(DtCursoBase dc: DtCursoBase) {
					nombreCursos.addElement(dc.getNombre());
				}
				
				listCursos.setModel(nombreCursos);
				listCursos.setEnabled(true);
				listCursos.setVisible(true);
			}catch(Exception exc) {
				JOptionPane.showMessageDialog(this, exc.getLocalizedMessage() , "Curso", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	protected void cargarEdicionCurso(MouseEvent me, String curso) {
		try {
			for(DtEdicionBase dc: icon.seleccionarCurso(curso)) {
				nombreEdiciones.addElement(dc.getNombre());
			}
			
			listEdiciones.setModel(nombreCursos);
			listEdiciones.setEnabled(true);
			listEdiciones.setVisible(true);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, e.getLocalizedMessage() , "Edicion", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void limpiar(){
		nombreInstituto.setText("");
	
	}
}







