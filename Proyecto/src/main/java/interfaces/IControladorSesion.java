package interfaces;

import java.security.NoSuchAlgorithmException;

public interface IControladorSesion {

		public boolean existeUsuario(String id);
		
		public String identificarUsuario(String id, String hashpass);
		
		public String obtenerNick();
		
		public String obtenerCorreo();
		
		public String codificarPass(String contrasenia) throws NoSuchAlgorithmException;
}
