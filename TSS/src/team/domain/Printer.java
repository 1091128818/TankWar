package team.domain;

public  class Printer implements Equipment {

	private String type;
	private String name;
	
	public Printer() {}
	
	public Printer(String type,String name) {
		this.type = type;
		this.name = name;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String getDescription() {
		return "¿‡–Õ£∫"+type+",√˚≥∆£∫"+name;
	}
}

