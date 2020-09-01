package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Principal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnAlltas = new JMenu("Alltas");
		menuBar.add(mnAlltas);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Instituto");
		mnAlltas.add(mntmNewMenuItem);
		
		JMenuItem mntmCurso = new JMenuItem("Curso");
		mnAlltas.add(mntmCurso);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Usuario");
		mnAlltas.add(mntmNewMenuItem_1);
	}
}
