package interfaces;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtCursoBase;
import datatypes.DtEdicion;
import datatypes.DtFecha;
import excepciones.EdicionRepetida;
import excepciones.CursoNoExiste;
import datatypes.DtUsuarioBase;
import excepciones.InstitutoInexistente;
import excepciones.UsuarioNoDocente;
import excepciones.UsuarioNoExiste;
import excepciones.DocenteDeOtroInstituto;
import excepciones.DocenteYaAgregado;

public interface IControladorAltaEdicionCurso {
	public List<DtCursoBase> seleccionarInstituto(String instituto) throws InstitutoInexistente;
	
	public void altaEdicionCurso(String curso, String nombre, DtFecha fechaI, DtFecha fechaF, ArrayList<String> docentes, boolean tieneCupos, Integer cupos, DtFecha fechaPub) throws EdicionRepetida, CursoNoExiste, InstitutoInexistente, UsuarioNoDocente;
	
	public ArrayList<DtUsuarioBase> getUsuarios();
	
	public void verificarUsuario(String nick, String correo, ArrayList<String> docentes) throws UsuarioNoExiste, UsuarioNoDocente, DocenteDeOtroInstituto, DocenteYaAgregado;

	public boolean docenteEnArray(String nick, ArrayList<String> docentes);
	
	public ArrayList<DtUsuarioBase> getDocentes();

	public void setInstituto(String instituto);
	
	public void setCurso(String curso);
	
	public String getCurso();
	
	public boolean isTieneCupos();
	
	public void setTieneCupos(boolean tieneCupos);
	
	public Integer getCupos();
	
	public void setCupos(Integer cupos);
	
	public DtEdicion getDtEdi();
	
	public void setDtEdi(DtEdicion dtEdi);
}
