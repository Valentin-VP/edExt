package presentacion;

import javax.swing.JPanel;

import datatypes.DtEdicion;
import datatypes.DtFecha;
import interfaces.IControladorConsultaEdicionCurso;

import javax.swing.DefaultListModel;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;

public class InfoEdicionCurso2 extends JPanel {

	private static final long serialVersionUID = 1L;

	private IControladorConsultaEdicionCurso icon;
	
	private JEditorPane nombre;
	private JEditorPane fechaIni;
	private JEditorPane fechaFin;
	private JEditorPane cupos;
	private JEditorPane fechaPub;
	private JLabel docentesEdicion;
	private JList<String> listDocentes;
	private DefaultListModel<String> docentes;

	public InfoEdicionCurso2(IControladorConsultaEdicionCurso icon) {
		this.icon = icon;
		setLayout(null);
		
		
		
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
		
		docentesEdicion = new JLabel("Docentes");
		docentesEdicion.setFont(new Font("Dialog", Font.PLAIN, 16));
		docentesEdicion.setBounds(34, 230, 126, 20);
		add(docentesEdicion);
		
		listDocentes = new JList<String>();
		listDocentes.setBounds(62, 262, 303, 178);
		add(listDocentes);
		
		
	}
	
	public void mostrarDatos(String edicion) {
		DtEdicion dtE = icon.getDtEdicion(edicion);
		DtFecha fi = dtE.getFechaI();
		DtFecha ff = dtE.getFechaF();
		DtFecha fp = dtE.getFechaPub();
		nombre.setText(dtE.getNombre());
		fechaIni.setText(fi.getDia().toString() +"/" + fi.getMes().toString() + "/" + fi.getAnio().toString());
		fechaFin.setText(ff.getDia().toString() + "/" + ff.getMes().toString() + "/" + ff.getAnio().toString());
		cupos.setText(dtE.getCupo().toString());
		fechaPub.setText(fp.getDia().toString() + "/" + fp.getMes().toString() + "/" + fp.getAnio().toString());
		docentes = new DefaultListModel<String>();
		ArrayList<String> docentesDictan = new ArrayList<>();
		docentesDictan = icon.getDocentes(dtE.getNombre());
		for (String s: docentesDictan) {
			docentes.addElement(s);
		}
		this.listDocentes.setModel(docentes);
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
