package logica;

import java.util.Date;

import datatypes.DtFecha;
import interfaces.IControladorAltaProgFormacion;

public class ControladorAltaProgFormacion implements IControladorAltaProgFormacion{
	private String nombre;
	private String descripcion;
	private DtFecha fechaI;
	private DtFecha fechaF;
	private DtFecha fechaA;
	
	public ControladorAltaProgFormacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean ingresarProgFormacion(String nom, String des, DtFecha fechaI, DtFecha fechaF, DtFecha fechaA) {
		// TODO Auto-generated method stub
		this.nombre=nom;
		this.descripcion=des;
		this.fechaI=fechaI;
		this.fechaF=fechaF;
		this.fechaA=fechaA;
		ManejadorProgFormacion mPF = ManejadorProgFormacion.getInstancia();
		return mPF.exists(nom);
	}
	
	@Override
	public void modificarProgFormacion(String nom, String des, DtFecha fechaI, DtFecha fechaF, DtFecha fechaA) {
		// TODO Auto-generated method stub
		this.nombre=nom;
		this.descripcion=des;
		this.fechaI=fechaI;
		this.fechaF=fechaF;
		this.fechaA=fechaA;
	}
	
	@Override
	public void cancelar() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void confirmar() {
		// TODO Auto-generated method stub
		ProgFormacion pf = new ProgFormacion(this.nombre, this.descripcion, this.fechaI, this.fechaF, this.fechaA);
		ManejadorProgFormacion mPF = ManejadorProgFormacion.getInstancia();
		mPF.agregarProgFormacion(pf);
	}
	
}
