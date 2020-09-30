package datatypes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class DtFecha {
	private Integer dia;
	private Integer mes;
	private Integer anio;
	
	public DtFecha() {
		super();
	}
	
	public DtFecha(Integer dia, Integer mes, Integer anio) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}
	
	public Integer getDia() {
		return dia;
	}
	
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	
	public Integer getMes() {
		return mes;
	}
	
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	
	public Integer getAnio() {
		return anio;
	}
	
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	
	@Override
	public String toString() {
		return ""+dia+"/"+mes+"/"+anio;
	}
	public Date DtFechaToDate() throws ParseException {
		String strdtf = this.toString();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		Date date = sdf.parse(strdtf);
		return date;
	}
	public DtFecha convertToDtFecha(Date fecha){
		ArrayList<Integer> datos = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String date = sdf.format(fecha); 
		String valores [] = (date).split("/");
		for(String s: valores) {
			int temp = Integer.parseInt(s);
			datos.add(temp);
		}
		DtFecha dtfecha = new DtFecha(datos.get(0),datos.get(1),datos.get(2));
		return dtfecha;
	}
}
