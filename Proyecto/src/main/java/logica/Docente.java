package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//import datatypes.DtEdicion;
import datatypes.DtFecha;

@Entity
@DiscriminatorValue("D")//nuevo
public class Docente extends Usuario {
	@OneToOne
	private Instituto instituto;//visibilidad
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Edicion> dicta = new ArrayList<Edicion>();//visibilidad
	
	public Docente () {
		super();
	}
	
	public Docente(String nick, String nombre, String apellido, String correo, Date fechaNac, Instituto instituto) {
		super(nick, nombre, apellido, correo, fechaNac);
		this.instituto = instituto;
	}

	public Docente(String nick, String nombre, String apellido, String correo, Date fechaNac) {
		super(nick, nombre, apellido, correo, fechaNac);
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
	
}
