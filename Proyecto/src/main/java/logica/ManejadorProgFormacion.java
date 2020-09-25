package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtInstituto;
import datatypes.DtProgramaBase;

public class ManejadorProgFormacion {
	private static ManejadorProgFormacion instancia;
	private List<ProgFormacion> programas = new ArrayList<ProgFormacion>();
	
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
	
    public ArrayList<DtProgramaBase> getDtProgramasBase() {
        ArrayList<DtProgramaBase> dtpbs = new ArrayList<DtProgramaBase>();
        List<ProgFormacion> prog = getProgramas();
    	for(int i=0; i < prog.size();i++) {
    		DtProgramaBase dti = new DtProgramaBase(prog.get(i).getNombre());
        	dtpbs.add(dti);
        }
    	return dtpbs;
    }

	public List<ProgFormacion> getProgramas() {
		return programas;
	}

	public void setProgramas(List<ProgFormacion> programas) {
		this.programas = programas;
	}

}
