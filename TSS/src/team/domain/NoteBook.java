package team.domain;

public  class NoteBook implements Equipment {

	private String model;
	private double price;
	
	public NoteBook() {}
	
	public NoteBook(String model,double price) {
		this.model = model;
		this.price = price;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getModel(double Price) {
		return model;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
	@Override
	public String getDescription() {
		return ",ÐÍºÅ£º"+model+",¼Û¸ñ£º"+price;
	}
}
