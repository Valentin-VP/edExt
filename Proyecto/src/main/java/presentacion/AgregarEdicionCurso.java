package presentacion;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import interfaces.IControladorAltaEdicionCurso;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
//import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import javax.swing.JList;
//import javax.swing.JScrollBar;
//import javax.swing.JScrollPane;
//import javax.swing.JFormattedTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JTree;
import javax.swing.JPanel;
import javax.swing.JSpinner;
//import javax.swing.JTabbedPane;
//import javax.swing.LayoutStyle.ComponentPlacement;

public class AgregarEdicionCurso extends JInternalFrame {
	private JTextField nombreCurso;
	
	private static final long serialVersionUID = 1L;
	
	private IControladorAltaEdicionCurso icon;
	private JTextField nombreEdicion;
	private JTextField cantCupos;
	
	public AgregarEdicionCurso(IControladorAltaEdicionCurso icon) {//no se como hacer lo de los docentes
		this.icon = icon;
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta de Edicion de un Curso");
 
		setBounds(100, 100, 511, 549);
		getContentPane().setLayout(null);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(35, 24, 70, 15);
		
		nombreCurso = new JTextField();
		nombreCurso.setBounds(105, 22, 277, 19);
		nombreCurso.setFont(new Font("Dialog", Font.PLAIN, 14));
		nombreCurso.setColumns(10);
		
		JLabel lblfechainicio = new JLabel("Fecha de Inicio");
		lblfechainicio.setBounds(12, 88, 123, 15);
		
		JComboBox<String> fiDia = new JComboBox<String>();
		fiDia.setBounds(161, 83, 48, 24);
		fiDia.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		fiDia.setMaximumRowCount(31);
		
		JComboBox<String> fiMes = new JComboBox<String>();
		fiMes.setBounds(245, 83, 48, 24);
		fiMes.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		fiMes.setMaximumRowCount(12);
		
		JComboBox<String> fiAnio = new JComboBox<String>();
		fiAnio.setBounds(329, 83, 70, 24);
		fiAnio.setModel(new DefaultComboBoxModel<String>(new String[] {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"}));
		fiAnio.setMaximumRowCount(20);
		
		JLabel lblDia = new JLabel("dia");
		lblDia.setBounds(169, 56, 40, 15);
		
		JLabel lblMes = new JLabel("mes");
		lblMes.setBounds(245, 56, 70, 15);
		
		JLabel lblAno = new JLabel("anio");
		lblAno.setBounds(329, 56, 70, 15);
		
		JLabel lblFechaDeFin = new JLabel("Fecha de fin");
		lblFechaDeFin.setBounds(12, 149, 123, 15);
		
		JLabel lblDia_2 = new JLabel("dia");
		lblDia_2.setBounds(169, 119, 40, 15);
		
		JLabel lblMes_2 = new JLabel("mes");
		lblMes_2.setBounds(245, 119, 70, 15);
		
		JLabel lblAno_2 = new JLabel("anio");
		lblAno_2.setBounds(329, 119, 70, 15);
		
		JComboBox<String> ffDia = new JComboBox<String>();
		ffDia.setBounds(161, 146, 48, 24);
		ffDia.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		ffDia.setMaximumRowCount(31);
		
		JComboBox<String> ffMes = new JComboBox<String>();
		ffMes.setBounds(245, 146, 48, 24);
		ffMes.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		ffMes.setMaximumRowCount(12);
		
		JComboBox<String> ffAnio = new JComboBox<String>();
		ffAnio.setBounds(329, 146, 70, 24);
		ffAnio.setModel(new DefaultComboBoxModel<String>(new String[] {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"}));
		ffAnio.setMaximumRowCount(20);
		
		JLabel lblNombre = new JLabel("Nombre"); 
		lblNombre.setBounds(35, 192, 70, 15);
		
		nombreEdicion = new JTextField();
		nombreEdicion.setBounds(119, 190, 270, 19);
		nombreEdicion.setFont(new Font("Dialog", Font.PLAIN, 14));
		nombreEdicion.setColumns(10);
		
		JRadioButton cuposBool = new JRadioButton("Cupos");
		cuposBool.setBounds(37, 239, 87, 23);
		cuposBool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//no me sale lo del boton y el texto
				cuposBool.setSelected(false);
				cantCupos.setEditable(false);
				cantCupos.setText("");
			}
		});
		
		cantCupos = new JTextField();
		cantCupos.setBounds(161, 241, 61, 19);
		cantCupos.setColumns(10);
		
		cuposBool.setSelected(true);
		cantCupos.setEditable(true);
		cuposBool.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblCantCupos = new JLabel("Cant Cupos");
		lblCantCupos.setBounds(152, 221, 129, 15);
		
		JLabel lblFechaDePub = new JLabel("Fecha de publicacion");
		lblFechaDePub.setBounds(12, 307, 123, 15);
		
		JLabel lblDia_2_1 = new JLabel("dia");
		lblDia_2_1.setBounds(169, 277, 40, 15);
		
		JComboBox<String> ffDia_1 = new JComboBox<String>();
		ffDia_1.setBounds(161, 304, 48, 24);
		ffDia_1.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		ffDia_1.setMaximumRowCount(31);
		
		JComboBox<String> ffMes_1 = new JComboBox<String>();
		ffMes_1.setBounds(245, 304, 48, 24);
		ffMes_1.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		ffMes_1.setMaximumRowCount(12);
		
		JLabel lblMes_2_1 = new JLabel("mes");
		lblMes_2_1.setBounds(245, 277, 70, 15);
		
		JLabel lblAno_2_1 = new JLabel("anio");
		lblAno_2_1.setBounds(329, 277, 70, 15);
		
		JComboBox<String> ffAnio_1 = new JComboBox<String>();
		ffAnio_1.setBounds(329, 304, 70, 24);
		ffAnio_1.setModel(new DefaultComboBoxModel<String>(new String[] {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"}));
		ffAnio_1.setMaximumRowCount(20);
		
		getContentPane().setLayout(null);
		getContentPane().add(lblCurso);
		getContentPane().add(nombreCurso);
		getContentPane().add(lblDia);
		getContentPane().add(lblMes);
		getContentPane().add(lblAno);
		getContentPane().add(lblfechainicio);
		getContentPane().add(fiDia);
		getContentPane().add(fiMes);
		getContentPane().add(fiAnio);
		getContentPane().add(lblDia_2);
		getContentPane().add(lblMes_2);
		getContentPane().add(lblAno_2);
		getContentPane().add(lblFechaDeFin);
		getContentPane().add(ffDia);
		getContentPane().add(ffMes);
		getContentPane().add(ffAnio);
		getContentPane().add(lblNombre);
		getContentPane().add(nombreEdicion);
		getContentPane().add(lblCantCupos);
		getContentPane().add(cuposBool);
		getContentPane().add(cantCupos);
		getContentPane().add(lblDia_2_1);
		getContentPane().add(lblMes_2_1);
		getContentPane().add(lblAno_2_1);
		getContentPane().add(lblFechaDePub);
		getContentPane().add(ffDia_1);
		getContentPane().add(ffMes_1);
		getContentPane().add(ffAnio_1);

	}
}
