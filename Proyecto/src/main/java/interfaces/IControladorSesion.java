package interfaces;

public interface IControladorSesion {

		public boolean existeUsuario(String id);
		
		public String identificarUsuario(String id, String hashpass);
		
		public String obtenerNick();
}
