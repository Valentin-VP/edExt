package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;

import interfaces.Fabrica;
import interfaces.IControladorAltaInstituto;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JTable;

@SuppressWarnings("unused")
public class Principal {
	
	private JFrame frame;
	private AgregarInstituto agregarInstitutoInternalFrame;
	
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
		
		Fabrica fabrica = Fabrica.getInstancia();

		//Dimension desktopSize = frame.getMaximumSize(); esto y lo de abajo es para dejar el internal frame en el medio
		//Dimension jInternalFrameSize;
		
		agregarInstitutoInternalFrame = new AgregarInstituto(fabrica.getIControladorAltaInstituto());
		agregarInstitutoInternalFrame.setLocation(188, 105);
		frame.getContentPane().add(agregarInstitutoInternalFrame);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 643, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnAlltas = new JMenu("Altas");
		menuBar.add(mnAlltas);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Instituto");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//mostrar internal frame para el nombre del instituto
				agregarInstitutoInternalFrame.setVisible(true);
			}
		});
		mnAlltas.add(mntmNewMenuItem);
		
		JMenuItem mntmCurso = new JMenuItem("Curso");
		mnAlltas.add(mntmCurso);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Usuario");
		mnAlltas.add(mntmNewMenuItem_1);
		
		JMenu mnInformacin = new JMenu("Informaci\u00F3n");
		menuBar.add(mnInformacin);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Usuario");
		mnInformacin.add(mntmNewMenuItem_2);
	}
}
