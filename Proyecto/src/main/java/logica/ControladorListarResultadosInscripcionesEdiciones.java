package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtResultado;
import interfaces.IControladorListarResultadosInscripcionesEdiciones;

public class ControladorListarResultadosInscripcionesEdiciones implements IControladorListarResultadosInscripcionesEdiciones {
	
	private DtResultado resultado;
	
	public ControladorListarResultadosInscripcionesEdiciones() {
		super();
	}

	public ControladorListarResultadosInscripcionesEdiciones(DtResultado resultado) {
		super();
		this.resultado = resultado;
	}

	public DtResultado getResultado() {
		return this.resultado;
	}

	public void setResultado(DtResultado resultado) {
		this.resultado = resultado;
	}
	
	public ArrayList<DtResultado> listarResultados(String nickEstudiante) {
		ArrayList<DtResultado> resultados = new ArrayList<DtResultado>();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario e = mU.findUsuario(nickEstudiante);
		for(InscripcionEd ied: ((Estudiante) e).getInscripcionesEd()) {
			DtResultado dtr = new DtResultado(ied.getEdicion().getNombre(), ied.getEstado());
			resultados.add(dtr);
		}
		return resultados;
	}
}
