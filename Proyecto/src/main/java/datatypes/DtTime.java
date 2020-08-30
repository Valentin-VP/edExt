package datatypes;

public class DtTime {
	private Integer horas;
	private Integer minutos;
	
	public DtTime() {
		super();
	}
	
	public DtTime(Integer horas, Integer minutos) {
		super();
		this.horas = horas;
		this.minutos = minutos;
	}
	
	public Integer getHoras() {
		return horas;
	}
	
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	
	public Integer getMinutos() {
		return minutos;
	}
	
	public void setMinutos(Integer minutos) {
		this.minutos = minutos;
	}
	
}
