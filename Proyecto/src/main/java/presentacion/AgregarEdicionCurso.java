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
		
		nombreCurso = new JTextField();
		nombreCurso.setFont(new Font("Dialog", Font.PLAIN, 14));
		nombreCurso.setColumns(10);
		
		JLabel lblfechainicio = new JLabel("Fecha de Inicio");
		
		JComboBox<String> fiDia = new JComboBox<String>();
		fiDia.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		fiDia.setMaximumRowCount(31);
		
		JComboBox<String> fiMes = new JComboBox<String>();
		fiMes.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		fiMes.setMaximumRowCount(12);
		
		JComboBox<String> fiAnio = new JComboBox<String>();
		fiAnio.setModel(new DefaultComboBoxModel<String>(new String[] {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"}));
		fiAnio.setMaximumRowCount(20);
		
		JLabel lblDia = new JLabel("dia");
		
		JLabel lblMes = new JLabel("mes");
		
		JLabel lblAno = new JLabel("año");
		
		JLabel lblFechaDeFin = new JLabel("Fecha de fin");
		
		JLabel lblDia_2 = new JLabel("dia");
		
		JLabel lblMes_2 = new JLabel("mes");
		
		JLabel lblAno_2 = new JLabel("año");
		
		JComboBox<String> ffDia = new JComboBox<String>();
		ffDia.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		ffDia.setMaximumRowCount(31);
		
		JComboBox<String> ffMes = new JComboBox<String>();
		ffMes.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		ffMes.setMaximumRowCount(12);
		
		JComboBox<String> ffAnio = new JComboBox<String>();
		ffAnio.setModel(new DefaultComboBoxModel<String>(new String[] {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"}));
		ffAnio.setMaximumRowCount(20);
		
		JLabel lblNombre = new JLabel("Nombre"); 
		
		nombreEdicion = new JTextField();
		nombreEdicion.setFont(new Font("Dialog", Font.PLAIN, 14));
		nombreEdicion.setColumns(10);
		
		JRadioButton cuposBool = new JRadioButton("Cupos");
		cuposBool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//no me sale lo del boton y el texto
				cuposBool.setSelected(false);
				cantCupos.setEditable(false);
				cantCupos.setText("");
			}
		});
		
		cantCupos = new JTextField();
		cantCupos.setColumns(10);
		
		cuposBool.setSelected(true);
		cantCupos.setEditable(true);
		cuposBool.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblCantCupos = new JLabel("Cant Cupos");
		
		JLabel lblFechaDePub = new JLabel("Fecha de publicacion");
		
		JLabel lblDia_2_1 = new JLabel("dia");
		
		JComboBox<String> ffDia_1 = new JComboBox<String>();
		ffDia_1.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		ffDia_1.setMaximumRowCount(31);
		
		JComboBox<String> ffMes_1 = new JComboBox<String>();
		ffMes_1.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		ffMes_1.setMaximumRowCount(12);
		
		JLabel lblMes_2_1 = new JLabel("mes");
		
		JLabel lblAno_2_1 = new JLabel("año");
		
		JComboBox<String> ffAnio_1 = new JComboBox<String>();
		ffAnio_1.setModel(new DefaultComboBoxModel<String>(new String[] {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"}));
		ffAnio_1.setMaximumRowCount(20);
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(lblCurso, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addComponent(nombreCurso, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(169)
							.addComponent(lblDia, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(lblMes, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(lblAno, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblfechainicio, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(fiDia, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(fiMes, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(fiAnio, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(169)
							.addComponent(lblDia_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(lblMes_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(lblAno_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblFechaDeFin, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(ffDia, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(ffMes, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(ffAnio, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(nombreEdicion, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(152)
							.addComponent(lblCantCupos, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addComponent(cuposBool, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(cantCupos, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(169)
							.addComponent(lblDia_2_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(lblMes_2_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(lblAno_2_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblFechaDePub, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(ffDia_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(ffMes_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(ffAnio_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(102, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(231, Short.MAX_VALUE)
					.addGap(22))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lblCurso))
						.addComponent(nombreCurso, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDia)
						.addComponent(lblMes)
						.addComponent(lblAno))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblfechainicio))
						.addComponent(fiDia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(fiMes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(fiAnio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDia_2)
						.addComponent(lblMes_2)
						.addComponent(lblAno_2))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblFechaDeFin))
						.addComponent(ffDia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ffMes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ffAnio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNombre))
						.addComponent(nombreEdicion, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addComponent(lblCantCupos)
					.addGap(3)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(cuposBool)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(cantCupos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDia_2_1)
						.addComponent(lblMes_2_1)
						.addComponent(lblAno_2_1))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblFechaDePub))
						.addComponent(ffDia_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ffMes_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ffAnio_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
