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
	public void ingresarProgFormacion(String nom, String des, DtFecha fechaI, DtFecha fechaF, LocalDate fechaA) throws ProgramaRepetido{
		this.nombre=nom;
		this.descripcion=des;
		this.fechaI=fechaI;
		this.fechaF=fechaF;
		this.fechaA=fechaA;
		ManejadorProgFormacion mPF = ManejadorProgFormacion.getInstancia();
		if (mPF.existePrograma(nom) == true) {
			throw new ProgramaRepetido("El programa " + nom + " ya se encuentra registrado");
		}
	}
	
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
		System.out.print("Dia de inicio " + this.fechaI.getDia().intValue());
		System.out.print("Mes de inicio " + this.fechaI.getMes().intValue());
		System.out.print("Anio de inicio " + this.fechaI.getAnio());
		LocalDate fechaI = LocalDate.of(this.fechaI.getAnio(), this.fechaI.getMes(), this.fechaI.getDia());
		LocalDate fechaF = LocalDate.of(this.fechaF.getAnio(), this.fechaF.getMes(), this.fechaF.getDia());
		//LocalDate pruebaFecha = LocalDate.parse("2018-10-30");
		//LocalTime time = LocalTime.now();
		//LocalTime time2 = LocalTime.parse("11:00:59.759");
		//LocalTime time3 = LocalTime.of(11, 00, 59);
		//time.getHour();
		//LocalDateTime dateTime = LocalDateTime.now();
		//LocalDateTime dateTime2 = LocalDateTime.of(2018, 10, 10, 11, 25);
		//LocalDateTime dateTime3 = LocalDateTime.parse("2018-10-10T11:25");
		ProgFormacion pf = new ProgFormacion(this.nombre, this.descripcion, fechaI, fechaF, this.fechaA);
		ManejadorProgFormacion mPF = ManejadorProgFormacion.getInstancia();
		mPF.agregarProgFormacion(pf);
	}
	
}
