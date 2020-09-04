package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.IControladorAltaCurso;

public class AltaCurso extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private IControladorAltaCurso icon;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaCurso frame = new AltaCurso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AltaCurso(IControladorAltaCurso iconAC) {
		setBounds(100, 100, 450, 300);

	}

}
