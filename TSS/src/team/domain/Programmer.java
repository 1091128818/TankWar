package team.domain;

import team.service.Status;

public class Programmer extends Employee {
	
	private int memberId;
	private Status status;
	private Equipment equipment;
	
	public Programmer() {}
	
	public Programmer(int id,
					  String name,
					  int age,
					  double salary,
					  int memberId,
					  Status status,
					  Equipment equipment) {
		super(id, name, age, salary);
		this.memberId = memberId;
		this.status = status;
		this.equipment = equipment;
	}
	
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	public int getMemberId() {
		return memberId;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	
	public Equipment getEquipment() {
		return equipment;
	}
	
	@Override
	public String toString() {
		return super.say() + "\t" + "程序员" + "\t" + status + "\t\t\t" + equipment;
	}
	
	public String toStringForTeam() {
		return memberId + "/" + super.say() + "\t" + "程序员";
	}

}







