package tests;

public class Counter{
	private static Integer value = 0;
	private Integer id = 0;
	
	public Counter() {
		super();
		this.id=value++;
	}
	
	public String getValue() {
		return id.toString();
	}
}
