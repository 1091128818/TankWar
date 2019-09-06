package ×Ô¼ºÁ·;

public class Customer {
	
	private String name;
	private char gender;
	private int age;
	private String phone;
	private String email;
 
	public Customer() {
		
	}
	
	public Customer(String name,
			        char gender,
					int age,
					String phone,
					String email) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email =email;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
