package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.IControladorAltaCurso;

public class AltaCurso extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private IControladorAltaCurso icon;
	
	public AltaCurso(IControladorAltaCurso iconAC) {
		setBounds(100, 100, 450, 300);

	}

}
