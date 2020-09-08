package presentacion;

import javax.swing.JPanel;

import datatypes.DtEdicion;
import datatypes.DtEdicionBase;
import datatypes.DtFecha;
import interfaces.IControladorConsultaEdicionCurso;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.JEditorPane;
import javax.swing.JLabel;


public class InfoEdicionCurso2 extends JPanel {
	private IControladorConsultaEdicionCurso icon;
	
	private JEditorPane nombre;
	private JEditorPane fechaIni;
	private JEditorPane fechaFin;
	private JEditorPane cupos;
	private JEditorPane fechaPub;

	public InfoEdicionCurso2(IControladorConsultaEdicionCurso icon) {
		this.icon = icon;
		setLayout(null);
		
		JButton atras = new JButton("Atras");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				limpiar();
			}
		});
		atras.setBounds(10, 11, 89, 23);
		add(atras);
		
		JLabel asdas = new JLabel("Nombre");
		asdas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		asdas.setBounds(34, 55, 126, 20);
		add(asdas);
		
		JLabel asfasf = new JLabel("Fecha inicio");
		asfasf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		asfasf.setBounds(34, 86, 126, 20);
		add(asfasf);
		
		JLabel asdasda = new JLabel("Cupos");
		asdasda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		asdasda.setBounds(34, 148, 126, 20);
		add(asdasda);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Fecha publicacion");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(34, 179, 126, 20);
		add(lblNewLabel_1_1_1);
		
		JLabel af = new JLabel("Fecha finalizacion");
		af.setFont(new Font("Tahoma", Font.PLAIN, 16));
		af.setBounds(34, 117, 126, 20);
		add(af);
		
		nombre = new JEditorPane();
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nombre.setBounds(165, 55, 106, 20);
		add(nombre);
		
		fechaIni = new JEditorPane();
		fechaIni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fechaIni.setBounds(165, 86, 106, 20);
		add(fechaIni);
		
		fechaFin = new JEditorPane();
		fechaFin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fechaFin.setBounds(165, 117, 106, 20);
		add(fechaFin);
		
		cupos = new JEditorPane();
		cupos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cupos.setBounds(165, 148, 106, 20);
		add(cupos);
		
		fechaPub = new JEditorPane();
		fechaPub.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fechaPub.setBounds(165, 179, 106, 20);
		add(fechaPub);
		
		
	}
	
	public void mostrarDatos() {
		DtEdicion dtE = icon.getDtEdicion();
		DtFecha fi = dtE.getFechaI();
		DtFecha ff = dtE.getFechaF();
		DtFecha fp = dtE.getFechaPub();
		nombre.setText(dtE.getNombre());
		fechaIni.setText(fi.getDia().toString() + fi.getMes().toString() + fi.getAnio().toString());
		fechaFin.setText(ff.getDia().toString() + ff.getMes().toString() + ff.getAnio().toString());
		cupos.setText(dtE.getCupo().toString());
		fechaPub.setText(fp.getDia().toString() + fp.getMes().toString() + fp.getAnio().toString());
		setVisible(true);
	}
	
	public void limpiar() {
		nombre.setText("");
		fechaIni.setText("");
		fechaFin.setText("");
		cupos.setText("");
		fechaPub.setText("");
	}
}
