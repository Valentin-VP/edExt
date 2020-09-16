package persistencia;

import java.io.Serializable;

public class InscripcionEdID implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nick;
	private String edicion;
	
	public InscripcionEdID() {
		super();
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edicion == null) ? 0 : edicion.hashCode());
		result = prime * result + ((nick == null) ? 0 : nick.hashCode());
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
		InscripcionEdID other = (InscripcionEdID) obj;
		if (edicion == null) {
			if (other.edicion != null)
				return false;
		} else if (!edicion.equals(other.edicion))
			return false;
		if (nick == null) {
			if (other.nick != null)
				return false;
		} else if (!nick.equals(other.nick))
			return false;
		return true;
	}
	
}
