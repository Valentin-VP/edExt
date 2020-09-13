package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.*;
import logica.ControladorConsultaCurso;
import logica.ControladorAgregarCursoPrograma;
import logica.ControladorAltaCurso;
import logica.ControladorAltaEdicionCurso;
import logica.ControladorAltaInstituto;
import logica.ControladorAltaProgFormacion;
import logica.ControladorAltaUsuario;
import logica.ControladorConsultaEdicionCurso;
import logica.ControladorConsultaPrograma;
import logica.ControladorConsultaUsuario;
import logica.ControladorInscripcionEdicionCurso;
import logica.ControladorModificarDatosUsuario;

public class Conexion {
	private static Conexion instancia = null;
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	private Conexion(){}
	
	public static Conexion getInstancia() {
		if (instancia == null) {
			instancia = new Conexion();
			emf = Persistence.createEntityManagerFactory("edExt");
			em=emf.createEntityManager();
		}
		return instancia;
	}
	
	public EntityManager getEntityManager() {
		return this.em;
	}
	
	public void close() {
		this.em.close();
		this.emf.close();
	}


}
