package logica;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import persistencia.InscripcionEdID;
import persistencia.InscripcionPFID;

@Entity
@IdClass(InscripcionPFID.class)
public class InscripcionPF {
	
	private Date fecha;
	
	@Id
	@ManyToOne
	@JoinColumn(
			insertable=false,
			updatable=false
	)
	private Estudiante nick;
	
	@Id
	@ManyToOne
	@JoinColumn(
			insertable=false,
			updatable=false
	)
	private ProgFormacion programa;
	
	public InscripcionPF() {
		super();
	}

	public InscripcionPF(Date fecha, Estudiante nick, ProgFormacion programa) {
		super();
		this.fecha = fecha;
		this.nick = nick;
		this.programa = programa;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Estudiante getEstudiante() {
		return nick;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.nick = estudiante;
	}

	public ProgFormacion getPrograma() {
		return programa;
	}

	public void setPrograma(ProgFormacion programa) {
		this.programa = programa;
	}
	
	
	
	
}
