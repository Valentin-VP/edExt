package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JList;

public class AgregarCursoAPF extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	//falta terminar esta parte que es la presentacion
	public AgregarCursoAPF() {
		setBounds(100, 100, 497, 395);
		getContentPane().setLayout(null);
		
		@SuppressWarnings("rawtypes")
		JList list = new JList();
		list.setBounds(36, 82, 166, 233);
		getContentPane().add(list);

	}
}
