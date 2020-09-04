package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Dimension;
import java.awt.EventQueue;

import interfaces.Fabrica;
import interfaces.IControladorAltaCurso;

public class Principal_Alternativo extends JFrame {
	
	private JPanel contentPane;
	private JFrame frame;

	private AltaCurso altaCursoInternalFrame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal_Alternativo window = new Principal_Alternativo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal_Alternativo() {
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorAltaCurso iconAC = fabrica.getIControladorAltaCurso();
		
		Dimension desktopSize = frame.getSize();
		Dimension jInternalFrameSize;
		
		
		
		altaCursoInternalFrame = new AltaCurso (iconAC);
		jInternalFrameSize = altaCursoInternalFrame.getSize();
		altaCursoInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		altaCursoInternalFrame.setVisible(false);
		frame.getContentPane().add(altaCursoInternalFrame);
		
		setTitle("edExt - Programacion de Aplicaciones 2020 - Grupo 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 496);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cursos");
		mnNewMenu.setBackground(new Color(153, 204, 153));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Alta");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Ejecutar Alta de Curso
				altaCursoInternalFrame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Consulta");
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
