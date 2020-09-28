package logica;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import persistencia.InscripcionPFID;

@Entity
@IdClass(InscripcionPFID.class)
public class InscripcionPF {
	private LocalDate fecha;
	
	@Id
	@ManyToOne
	@JoinColumn(
			insertable=false,
			updatable=false
	)
	private ProgFormacion programa;
	
	@Id
	@ManyToOne
	@JoinColumn(
			insertable=false,
			updatable=false
	)
	private Estudiante estudiante;
	
	public InscripcionPF() {
		super();
	}

	public InscripcionPF(LocalDate fecha, Estudiante estudiante, ProgFormacion programa) {
		super();
		this.fecha = fecha;
		this.estudiante = estudiante;
		this.programa = programa;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public ProgFormacion getPrograma() {
		return programa;
	}

	public void setPrograma(ProgFormacion programa) {
		this.programa = programa;
	}
	
}
