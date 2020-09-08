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
	private InfoEdicionCurso2 infoEdicionCurso2Panel;
	
	private JTextField nombreInstituto;

	private DefaultListModel<String> nombreCursos = new DefaultListModel<String>();
	private DefaultListModel<String> nombreEdiciones = new DefaultListModel<String>();
	
	private JList<String> listEdiciones;
	private JList<String> listCursos;
	
	
	private static final long serialVersionUID = 1L;

    private IControladorConsultaEdicionCurso icon;
	
	public InfoEdicionCurso(IControladorConsultaEdicionCurso icon) {
		this.icon = icon;
		infoEdicionCurso2Panel = new InfoEdicionCurso2(icon);
		infoEdicionCurso2Panel.setBounds(0, 0, 477, 494);
		this.getContentPane().add(infoEdicionCurso2Panel);
		infoEdicionCurso2Panel.setVisible(false);
		
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
        listEdiciones.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent me2) {
        		icon.setEdicion(listEdiciones.getSelectedValue().toString());
        		infoEdicionCurso2Panel.mostrarDatos();
        	}
        });
        listEdiciones.setBounds(267, 164, 180, 319);
        getContentPane().add(listEdiciones);
        
        JButton btnNewButton = new JButton("Aceptar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) { 
        		limpiarListas();
        		cargarCursos(arg0);
        	}
        });
        btnNewButton.setBounds(267, 69, 89, 23);
        getContentPane().add(btnNewButton);
        
        JButton cancelar = new JButton("Cancelar");
        cancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        		nombreInstituto.setText("");
        		limpiarListas();
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
        lblInstitutos.setBounds(290, 131, 157, 22);
        getContentPane().add(lblInstitutos);
        
        listCursos = new JList<String>();
        listCursos.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent me1) {
        		nombreEdiciones.clear();
        		listEdiciones.setModel(nombreEdiciones);
				cargarEdicionCurso(me1, listCursos.getSelectedValue().toString());
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
	
	protected void cargarEdicionCurso(MouseEvent me1, String curso) {
		try {
			ArrayList<DtEdicionBase> dtEdicionBase = new ArrayList<>();
			dtEdicionBase = icon.seleccionarCurso(curso);
			for(DtEdicionBase de: dtEdicionBase) {
				nombreEdiciones.addElement(de.getNombre());
			}
			
			listEdiciones.setModel(nombreEdiciones);
			listEdiciones.setEnabled(true);
			listEdiciones.setVisible(true);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, e.getLocalizedMessage() , "Edicion", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void limpiarListas(){
		nombreCursos.clear();
		nombreEdiciones.clear();
		listEdiciones.setModel(nombreEdiciones);
		listCursos.setModel(nombreCursos);
	
	}
}







