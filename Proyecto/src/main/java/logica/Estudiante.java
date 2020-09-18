package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("E")
public class Estudiante extends Usuario {
	@OneToMany(mappedBy = "nick",cascade = CascadeType.ALL)
	List<InscripcionEd> inscripciones = new ArrayList<InscripcionEd>();
	
	public Estudiante() {
		super();
	}
	
	public Estudiante(String nick, String nombre, String apellido, String correo, Date  fechaNac) {
		super(nick, nombre, apellido, correo, fechaNac);
	}
	
	public void agregarInscripcionEd(InscripcionEd i) {
		inscripciones.add(i);
	}
	
	public boolean existeInscripcion(String nomEd) {
		if (!inscripciones.isEmpty()) {
			for (int i=0;i < inscripciones.size();i++) {
				if (inscripciones.get(i).getEdicion().getNombre().equals(nomEd)) {
					return true;
				}
			}
		}
	    return false;
	}

}
