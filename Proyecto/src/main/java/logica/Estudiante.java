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
	private List<InscripcionEd> inscripcionesed = new ArrayList<InscripcionEd>();
	@OneToMany(mappedBy = "estudiante",cascade = CascadeType.ALL)
	private List<InscripcionPF> inscripcionespf = new ArrayList<InscripcionPF>();
	
	public Estudiante() {
		super();
	}
	
	public Estudiante(String nick, String nombre, String apellido, String correo, Date  fechaNac, String password) {
		super(nick, nombre, apellido, correo, fechaNac, password);
	}
	
	public void agregarInscripcionEd(InscripcionEd i) {
		inscripcionesed.add(i);
	}
	
	public boolean existeInscripcion(String nomEd) {
		if (!inscripcionesed.isEmpty()) {
			for (int i=0;i < inscripcionesed.size();i++) {
				if (inscripcionesed.get(i).getEdicion().getNombre().equals(nomEd)) {
					return true;
				}
			}
		}
	    return false;
	}
	
	public void agregarInscripcionPF(InscripcionPF i) {
		inscripcionespf.add(i);
	}
	
	public boolean existeInscripcionPF(String nomEd) {
		if (!inscripcionespf.isEmpty()) {
			for (int i=0;i < inscripcionespf.size();i++) {
				if (inscripcionespf.get(i).getPrograma().getNombre().equals(nomEd)) {
					return true;
				}
			}
		}
	    return false;
	}
	
	public List<InscripcionEd> getInscripcionesEd(){
		return this.inscripcionesed;
	}
	
	public List<InscripcionPF> getInscripcionesPf(){
		return this.inscripcionespf;
	}

}
