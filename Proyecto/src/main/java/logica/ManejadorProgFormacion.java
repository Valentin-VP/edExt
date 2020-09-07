package logica;

import java.util.*;

public class ManejadorProgFormacion {
	private static ManejadorProgFormacion instancia;
	private ArrayList<ProgFormacion> programas = new ArrayList<ProgFormacion>();
	
	public static ManejadorProgFormacion getInstancia() {
		if(instancia == null)
			instancia = new ManejadorProgFormacion();
		return instancia;
	}
	
	public boolean exists(String nombre) {
		if(programas != null) {
			for(ProgFormacion pf: programas) {
				if(pf.getNombre().equals(nombre)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void agregarProgFormacion(ProgFormacion pf) {
		programas.add(pf);
	}
	
	public ProgFormacion getProgFormacion(String nombre) {
		ProgFormacion retorno=null;
		for(ProgFormacion pf: programas) {
			if(pf.getNombre()==nombre) {
				retorno = pf;
			}
		}
		return retorno;
	}

	public ArrayList<ProgFormacion> getProgramas() {
		return programas;
	}

	public void setProgramas(ArrayList<ProgFormacion> programas) {
		this.programas = programas;
	}


}
