package logica;

import java.time.LocalDate;

import datatypes.DtFecha;
import excepciones.ProgramaRepetido;
import interfaces.IControladorAltaProgFormacion;

public class ControladorAltaProgFormacion implements IControladorAltaProgFormacion{
	private String nombre;
	private String descripcion;
	private DtFecha fechaI;
	private DtFecha fechaF;
	private LocalDate fechaA;
	
	public ControladorAltaProgFormacion() {
		super();
	}

	@Override
	public boolean ingresarProgFormacion(String nom, String des, DtFecha fechaI, DtFecha fechaF, LocalDate fechaA) throws ProgramaRepetido{
		this.nombre=nom;
		this.descripcion=des;
		this.fechaI=fechaI;
		this.fechaF=fechaF;
		this.fechaA=fechaA;
		ManejadorProgFormacion mPF = ManejadorProgFormacion.getInstancia();
		if (mPF.exists(nom) == true) {
			throw new ProgramaRepetido("El programa " + nom + " ya se encuentra registrado");
		}
		return mPF.exists(nom);
	}
	
	/*@Override
	public void modificarProgFormacion(String nom, String des, DtFecha fechaI, DtFecha fechaF, LocalDate fechaA) {
		this.nombre=nom;
		this.descripcion=des;
		this.fechaI=fechaI;
		this.fechaF=fechaF;
		this.fechaA=fechaA;
	}
	*/
	
	@Override
	public void cancelar() {
		this.nombre="";
		this.descripcion="";
		this.fechaI=null;
		this.fechaF=null;
		this.fechaA=null;
	}
	
	@Override
	public void confirmar() {
		LocalDate fechaI = LocalDate.of(this.fechaI.getAnio(), this.fechaI.getMes(), this.fechaI.getDia());
		LocalDate fechaF = LocalDate.of(this.fechaF.getAnio(), this.fechaF.getMes(), this.fechaF.getDia());
		ProgFormacion pf = new ProgFormacion(this.nombre, this.descripcion, fechaI, fechaF, this.fechaA);
		ManejadorProgFormacion mPF = ManejadorProgFormacion.getInstancia();
		mPF.agregarProgFormacion(pf);
	}
	
}
