package logica;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import datatypes.DtFecha;
import datatypes.EstadoInscripcion;
import persistencia.InscripcionEdID;

@Entity
@IdClass(InscripcionEdID.class)
public class InscripcionEd { 
	private Date fecha;
	@Enumerated(EnumType.STRING)
	private EstadoInscripcion estado;
	
	@Id
	@ManyToOne
	@JoinColumn(
			insertable=false,
			updatable=false
	)
	private Edicion edicion;
	
	@Id
	@ManyToOne
	@JoinColumn(
			insertable=false,
			updatable=false
	)
	private Estudiante nick;
	
	public InscripcionEd () {
		super();
	}
	public InscripcionEd(Date fecha, EstadoInscripcion estado, Edicion edicion, Estudiante nick) {
		super();
		this.fecha = fecha;
		this.setEstado(estado);
		this.edicion = edicion;
		this.nick = nick;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public EstadoInscripcion getEstado() {
		return estado;
	}
	public void setEstado(EstadoInscripcion estado) {
		this.estado = estado;
	}
	public Edicion getEdicion() {
		return edicion;
	}
	public void setEdicion(Edicion edicion) {
		this.edicion = edicion;
	}
	public Estudiante getEstudiante() {
		return nick;
	}
	public void setEstudiante(Estudiante nick) {
		this.nick = nick;
	}
	
	public DtFecha getDtFecha() {
		ArrayList<Integer> datos = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String date = sdf.format(this.fecha); 
		String valores [] = (date).split("/");
		for(String s: valores) {
			int temp = Integer.parseInt(s);
			datos.add(temp);
		}
		DtFecha dtfecha = new DtFecha(datos.get(0),datos.get(1),datos.get(2));
		return dtfecha;
	}
}
