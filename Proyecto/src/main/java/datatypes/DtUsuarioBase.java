package datatypes;

public class DtUsuarioBase {
	private String nick;
	private String correo;

	public DtUsuarioBase() {
		super();
	}

	public DtUsuarioBase(String nick, String correo) {
		super();
		this.nick = nick;
		this.correo = correo;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
}
