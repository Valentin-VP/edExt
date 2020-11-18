package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import datatypes.DtEdicionBase;
import datatypes.DtFecha;

@Entity
@DiscriminatorValue("D")//nuevo
public class Docente extends Usuario {
	@ManyToOne
	@JoinColumn
	private Instituto instituto;//visibilidad
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Edicion> dicta = new ArrayList<Edicion>();//visibilidad
	
	public Docente () {
		super();
	}
	
	public Docente(String nick, String nombre, String apellido, String correo, Date fechaNac, Instituto instituto, String password) {
		super(nick, nombre, apellido, correo, fechaNac, password);
		this.instituto = instituto;
	}

	public Docente(String nick, String nombre, String apellido, String correo, Date  fechaNac, String password) {
		super(nick, nombre, apellido, correo, fechaNac, password);
	}
	
	public boolean find(Edicion edicion) {
		for (Edicion e: dicta) {
			if (e.getNombre() == edicion.getNombre()) {
				return true;
			}
		}
		return false;
	}
	
	public void addDictaEdicion(Edicion edi) {
		this.dicta.add(edi);
	}

	public Instituto getInstituto() {
		return this.instituto;
	}

	public void setInstituto(Instituto instituto) {
		this.instituto = instituto;
	}

	public List<Edicion> getEdiciones() {
		return dicta;
	}

	public void setEdiciones(List<Edicion> ediciones) {
		this.dicta = ediciones;
	}
	
	// Para obtener la edicion vigente que dicta el docente
	public DtEdicionBase getDtEdicionVigente() {
		LocalDate date = LocalDate.now();
		DtEdicionBase dteb=new DtEdicionBase();
		for(int i=dicta.size()-1;i >= 0;i--) {
			if (fechaValidaInicio(dicta.get(i).convertToDtFecha(dicta.get(i).getFechaI()),date) && fechaValidaFin(dicta.get(i).convertToDtFecha(dicta.get(i).getFechaF()),date)) {
			dteb.setNombre(dicta.get(i).getNombre());
			return dteb;
			}
		}
		return null;
	}
	
	/*
	// Para obtener las ediciones vigentes que dicta el docente
	public List<DtEdicionBase> getDtEdicionesVigentes() {
		LocalDate date = LocalDate.now();
		List<DtEdicionBase> edicionesvigentes = new ArrayList<DtEdicionBase>();
		for(int i=dicta.size()-1;i >= 0;i--) {
			if (fechaValidaInicio(dicta.get(i).convertToDtFecha(dicta.get(i).getFechaI()),date) && fechaValidaFin(dicta.get(i).convertToDtFecha(dicta.get(i).getFechaF()),date)) {
			DtEdicionBase dteb = new DtEdicionBase(dicta.get(i).getNombre());
			edicionesvigentes.add(dteb);//return dteb;
			}
		}
		return edicionesvigentes;
	}
	*/
	public boolean fechaValidaInicio(DtFecha fecha,LocalDate date) {
		if(fecha.getAnio().intValue() > date.getYear()) {
			return false;
		} else if(fecha.getAnio().intValue() == date.getYear() && fecha.getMes().intValue() > date.getMonthValue()) {
			return false;
		} else if(fecha.getAnio().intValue() == date.getYear() && fecha.getMes().intValue() == date.getMonthValue() && fecha.getDia().intValue() > date.getDayOfMonth()) {
			return false;
		}
		return true;
	}
	
	public boolean fechaValidaFin(DtFecha fecha,LocalDate date) {
		if(fecha.getAnio().intValue() < date.getYear()) {
			return false;
		} else if(fecha.getAnio().intValue() == date.getYear() && fecha.getMes().intValue() < date.getMonthValue()) {
			return false;
		} else if(fecha.getAnio().intValue() == date.getYear() && fecha.getMes().intValue() == date.getMonthValue() && fecha.getDia().intValue() < date.getDayOfMonth()) {
			return false;
		}
		return true;
	}
	
}
