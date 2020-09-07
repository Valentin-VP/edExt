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
import interfaces.IControladorAltaEdicionCurso;
import interfaces.IControladorAltaUsuario;
import interfaces.IControladorConsultaCurso;
import interfaces.IControladorAltaCurso;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JTable;

@SuppressWarnings("unused")
public class Principal {
	
	private JFrame frame;
	private AgregarEdicionCurso agregarEdicionCursoInternalFrame;
	private AgregarUsuario agregarUsuarioInternalFrame;
	private AgregarCurso agregarCursoInternalFrame;
	private AgregarInstituto agregarInstitutoInternalFrame;
	
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

	public Principal() {
		initialize();
		
		//Dimension desktopSize = frame.getMaximumSize(); esto y lo de abajo es para dejar el internal frame en el medio
		//Dimension jInternalFrameSize;
	
		
		Fabrica fabrica = Fabrica.getInstancia();
		
		agregarInstitutoInternalFrame = new AgregarInstituto(fabrica.getIControladorAltaInstituto()); // Alta Instituto
		agregarInstitutoInternalFrame.setBounds(255, 23, 335, 171);
		frame.getContentPane().add(agregarInstitutoInternalFrame);
		
		agregarUsuarioInternalFrame = new AgregarUsuario(fabrica.getIControladorAltaUsuario());  //Alta usuario
		agregarUsuarioInternalFrame.setLocation(124, 23);
		frame.getContentPane().add(agregarUsuarioInternalFrame);
		
		agregarCursoInternalFrame = new AgregarCurso(fabrica.getIControladorAltaCurso(), fabrica.getIControladorConsultaCurso());  //Alta Curso
		agregarCursoInternalFrame.setLocation(651, 117);
		frame.getContentPane().add(agregarCursoInternalFrame);
		
		
	}

	private void initialize() {
		frame = new JFrame();
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); INICIAR MAXIMIZADO
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnAltas = new JMenu("Altas");
		menuBar.add(mnAltas);
		
		JMenuItem mntmInstituto = new JMenuItem("Instituto");
		mntmInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent AEInstituo) {//mostrar internal frame para el nombre del instituto
				agregarInstitutoInternalFrame.setVisible(true);
			}
		});
		mnAltas.add(mntmInstituto);
		
		JMenuItem mntmCurso = new JMenuItem("Curso");
		mntmCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent AECurso) {
				agregarCursoInternalFrame.setVisible(true);
			}
		});
		mnAltas.add(mntmCurso);
		
		JMenuItem mntmUsuario = new JMenuItem("Usuario");
		mntmUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarUsuarioInternalFrame.setVisible(true);
			}
		});
		mnAltas.add(mntmUsuario);
		
		JMenu mnInformacin = new JMenu("Informaci\u00F3n");
		menuBar.add(mnInformacin);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Usuario");
		mnInformacin.add(mntmNewMenuItem_2);
	}
}
