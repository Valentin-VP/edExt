package persistencia;

import java.io.Serializable;

public class InscripcionPFID implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String estudiante;
	private String programa;
	
	public InscripcionPFID() {
		super();
	}

	public String getNick() {
		return estudiante;
	}

	public void setNick(String nick) {
		this.estudiante = nick;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((programa == null) ? 0 : programa.hashCode());
		result = prime * result + ((estudiante == null) ? 0 : estudiante.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InscripcionPFID other = (InscripcionPFID) obj;
		if (programa == null) {
			if (other.programa != null)
				return false;
		} else if (!programa.equals(other.programa))
			return false;
		if (estudiante == null) {
			if (other.estudiante != null)
				return false;
		} else if (!estudiante.equals(other.estudiante))
			return false;
		return true;
	}
}
