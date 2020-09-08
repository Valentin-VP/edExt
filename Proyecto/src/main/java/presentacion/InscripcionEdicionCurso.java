package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import datatypes.DtCursoBase;
import datatypes.DtEdicionBase;
import datatypes.DtFecha;
import datatypes.DtInstituto;
import excepciones.CursoNoExiste;
import excepciones.EdicionVigenteNoExiste;
import excepciones.InscripcionEdRepetido;
import excepciones.InstitutoInexistente;
import excepciones.ProgramaRepetido;
import interfaces.IControladorInscripcionEdicionCurso;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class InscripcionEdicionCurso extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	IControladorInscripcionEdicionCurso icon;
	private JComboBox<String> comboBoxIns;
	private JComboBox<String> comboBoxCur;
	private JComboBox<String> comboBoxDia;
	private JComboBox<String> comboBoxMes;
	private JComboBox<String> comboBoxAnio;
	private JTextField textFieldEst;
	private JTextField textFieldCorreo;
	private JTextField textFieldEd;
	
	public InscripcionEdicionCurso(IControladorInscripcionEdicionCurso icon) {
		this.icon = icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Inscripcion a edicion de Curso");
		setBounds(100, 100, 372, 427);
		
		comboBoxIns = new JComboBox<String>();
		comboBoxIns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					comboBoxCur.setEnabled(true);
					ArrayList<DtCursoBase> cursos = icon.seleccionarInstituto(comboBoxIns.getSelectedItem().toString());
					DefaultComboBoxModel dml= new DefaultComboBoxModel();
					for (int i = 0; i < cursos.size(); i++) {
					  dml.addElement(cursos.get(i).getNombre());
					}
					comboBoxCur.setModel(dml);
					
					//ArrayList<DtCursoBase> cursos = icon.seleccionarInstituto(comboBoxIns.getSelectedItem().toString());
					//ArrayList<String> nombresCursos = new ArrayList<String>();
					//for(int i=0;i<cursos)
					//for(DtCursoBase dts:cursos) {
						//comboBoxCur.addItem(dts.getNombre());//nombresCursos.add(dts.getNombre());
						//System.out.print(dts.getNombre());
					//}
					
				} catch (CursoNoExiste n) {
					JOptionPane.showMessageDialog(null, n.getMessage(), "Inscripcion Edicion Curso", JOptionPane.ERROR_MESSAGE);
				}
			
			}
		});
		comboBoxIns.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				try {
					comboBoxCur.setEnabled(true);
					ArrayList<DtCursoBase> cursos = icon.seleccionarInstituto(comboBoxIns.getSelectedItem().toString());
					DefaultComboBoxModel dml= new DefaultComboBoxModel();
					for (int i = 0; i < cursos.size(); i++) {
					  dml.addElement(cursos.get(i).getNombre());
					}
					comboBoxCur.setModel(dml);
					
					//ArrayList<DtCursoBase> cursos = icon.seleccionarInstituto(comboBoxIns.getSelectedItem().toString());
					//ArrayList<String> nombresCursos = new ArrayList<String>();
					//for(int i=0;i<cursos)
					//for(DtCursoBase dts:cursos) {
						//comboBoxCur.addItem(dts.getNombre());//nombresCursos.add(dts.getNombre());
						//System.out.print(dts.getNombre());
					//}
					
				} catch (CursoNoExiste n) {
					JOptionPane.showMessageDialog(null, n.getMessage(), "Inscripcion Edicion Curso", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		comboBoxIns.setBounds(53, 48, 168, 20);
		getContentPane().setLayout(null);
		getContentPane().add(comboBoxIns);
		
		comboBoxCur = new JComboBox<String>();
		comboBoxCur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					DtEdicionBase dteb = null;
					dteb = icon.seleccionarCurso(comboBoxCur.getSelectedItem().toString());
					if (dteb == null) {
						JOptionPane.showInternalConfirmDialog(null, "Este curso no tiene edicion vigente, seleccione otro", "Edicion vigente",
					             JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
					} else {
						
						textFieldEd.setText(dteb.getNombre());
					}
					
				}catch(EdicionVigenteNoExiste ev) {
					JOptionPane.showMessageDialog(null, ev.getMessage(), "Inscripcion Edicion Curso", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		comboBoxCur.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			
				try {
					
					DtEdicionBase dteb = null;
					dteb = icon.seleccionarCurso(comboBoxCur.getSelectedItem().toString());
					if (dteb == null) {
						JOptionPane.showInternalConfirmDialog(null, "Este curso no tiene edicion vigente, seleccione otro", "Edicion vigente",
					             JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
					} else {
						
						textFieldEd.setText(dteb.getNombre());
					}
					
				}catch(EdicionVigenteNoExiste ev) {
					JOptionPane.showMessageDialog(null, ev.getMessage(), "Inscripcion Edicion Curso", JOptionPane.ERROR_MESSAGE);
				}
				
			
			}
		});
		comboBoxCur.setBounds(53, 104, 168, 20);
		getContentPane().add(comboBoxCur);
		comboBoxCur.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("Seleccione Instituto");
		lblNewLabel.setBounds(53, 23, 99, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione Curso");
		lblNewLabel_1.setBounds(53, 79, 99, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nick del Estudiante");
		lblNewLabel_1_1.setBounds(53, 181, 119, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		textFieldEst = new JTextField();
		textFieldEst.setBounds(53, 196, 168, 20);
		getContentPane().add(textFieldEst);
		textFieldEst.setColumns(10);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(53, 252, 168, 20);
		getContentPane().add(textFieldCorreo);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(165, 350, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InscripcionEdicionCursoAceptarActionPerformed(e);
				setVisible(false);
				limpiar();
			}
		});
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(41, 350, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				icon.cancelar();
				setVisible(false);
				limpiar();
			}
		});
		getContentPane().add(btnNewButton_1);
		
		comboBoxDia = new JComboBox<String>();
		comboBoxDia.setBounds(53, 308, 46, 20);
		comboBoxDia.addItem("1");
		comboBoxDia.addItem("2");
		comboBoxDia.addItem("3");
		comboBoxDia.addItem("4");
		comboBoxDia.addItem("5");
		comboBoxDia.addItem("6");
		comboBoxDia.addItem("7");
		comboBoxDia.addItem("8");
		comboBoxDia.addItem("9");
		comboBoxDia.addItem("10");
		comboBoxDia.addItem("11");
		comboBoxDia.addItem("12");
		comboBoxDia.addItem("13");
		comboBoxDia.addItem("14");
		comboBoxDia.addItem("15");
		comboBoxDia.addItem("16");
		comboBoxDia.addItem("17");
		comboBoxDia.addItem("18");
		comboBoxDia.addItem("19");
		comboBoxDia.addItem("20");
		comboBoxDia.addItem("21");
		comboBoxDia.addItem("22");
		comboBoxDia.addItem("23");
		comboBoxDia.addItem("24");
		comboBoxDia.addItem("25");
		comboBoxDia.addItem("26");
		comboBoxDia.addItem("27");
		comboBoxDia.addItem("28");
		comboBoxDia.addItem("29");
		comboBoxDia.addItem("30");
		comboBoxDia.addItem("31");
		comboBoxDia.setSelectedItem("1");
		getContentPane().add(comboBoxDia);
		
		comboBoxMes = new JComboBox<String>();
		comboBoxMes.setBounds(127, 308, 45, 20);
		comboBoxMes.addItem("1");
		comboBoxMes.addItem("2");
		comboBoxMes.addItem("3");
		comboBoxMes.addItem("4");
		comboBoxMes.addItem("5");
		comboBoxMes.addItem("6");
		comboBoxMes.addItem("7");
		comboBoxMes.addItem("8");
		comboBoxMes.addItem("9");
		comboBoxMes.addItem("10");
		comboBoxMes.addItem("11");
		comboBoxMes.addItem("12");
		comboBoxMes.setSelectedItem("1");
		getContentPane().add(comboBoxMes);
		
		comboBoxAnio = new JComboBox<String>();
		comboBoxAnio.setBounds(202, 308, 64, 20);
		comboBoxAnio.addItem("2020");
		comboBoxAnio.addItem("2021");
		comboBoxAnio.addItem("2022");
		comboBoxAnio.addItem("2023");
		comboBoxAnio.addItem("2024");
		comboBoxAnio.addItem("2025");
		comboBoxAnio.addItem("2026");
		comboBoxAnio.addItem("2027");
		comboBoxAnio.addItem("2028");
		comboBoxAnio.addItem("2029");
		comboBoxAnio.addItem("2030");
		comboBoxAnio.addItem("2031");
		comboBoxAnio.setSelectedItem("2020");
		getContentPane().add(comboBoxAnio);
		
		JLabel lblNewLabel_2 = new JLabel("Dia");
		lblNewLabel_2.setBounds(53, 283, 22, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mes");
		lblNewLabel_3.setBounds(126, 283, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Anio");
		lblNewLabel_4.setBounds(202, 283, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Correo del estudiante");
		lblNewLabel_1_1_1.setBounds(53, 227, 119, 14);
		getContentPane().add(lblNewLabel_1_1_1);
		
		textFieldEd = new JTextField();
		textFieldEd.setColumns(10);
		textFieldEd.setBounds(53, 150, 168, 20);
		getContentPane().add(textFieldEd);
		textFieldEd.setEditable(false);
		
		JLabel lblNewLabel_1_2 = new JLabel("Edicion vigente");
		lblNewLabel_1_2.setBounds(53, 135, 99, 14);
		getContentPane().add(lblNewLabel_1_2);
		
	}
	
	private void InscripcionEdicionCursoAceptarActionPerformed(ActionEvent e) {
		String dia = (String) comboBoxDia.getSelectedItem();
		String mes = (String) comboBoxMes.getSelectedItem();
		String anio = (String) comboBoxAnio.getSelectedItem();
		
		LocalDate date = LocalDate.now();
		if (checkeo(textFieldEst.getText(),textFieldCorreo.getText())) {
			DtFecha fecha = new DtFecha(Integer.parseInt(dia),Integer.parseInt(mes),Integer.parseInt(anio));
		
			try {
				icon.registrarInscripcionEd(textFieldEst.getText(), textFieldCorreo.getText(), comboBoxCur.getSelectedItem().toString(), fecha);
				icon.confirmar();
				JOptionPane.showMessageDialog(this, "El Programa se ha creado con exito", "Crear Programa",
						JOptionPane.INFORMATION_MESSAGE);
				limpiar();
			} catch (InscripcionEdRepetido ie) {
				JOptionPane.showMessageDialog(this, ie.getMessage(), "Crear Programa", JOptionPane.ERROR_MESSAGE);
			}	
		
		}
			//DtFecha fechaA = new DtFecha((Integer)date.getDayOfMonth(),(Integer)date.getMonthValue(),(Integer)date.getYear());
	}
	
	private boolean checkeo(String nombre, String descripcion) {
		if(nombre.isEmpty() || descripcion.isEmpty()){
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Crear Programa", 
			JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void limpiar() {
		textFieldEst.setText("");
		textFieldCorreo.setText("");
		comboBoxCur.removeAll();
		comboBoxCur.setEnabled(false);
	}
	
	public void inicializarComboBoxsInscripcionEdicion() {
		
		try {
			ArrayList<DtInstituto> institutos = icon.listarInstitutos();
			DefaultComboBoxModel dml= new DefaultComboBoxModel();
			for (int i = 0; i < institutos.size(); i++) {
			  dml.addElement(institutos.get(i).getNombre());
			}
			comboBoxIns.setModel(dml);
			
		} catch (InstitutoInexistente in) {
			JOptionPane.showMessageDialog(this, in.getMessage(), "Inscripcion Edicion Curso", JOptionPane.ERROR_MESSAGE);
		}
		
		/*
			String[] array = new String[institutos.size()];
			int p = 0;
			for (DtInstituto i: institutos) {
				array[p] = i.getNombre();
				p++;
			}
			for (int i = 0; i < institutos.size(); i++) {
				comboBoxIns.addItem(array[i]);
			}
		*/	
			
	}
}
