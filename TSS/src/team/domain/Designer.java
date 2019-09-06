package team.domain;

import team.service.Status;

public class Designer extends Programmer {
	
	private double bonus;
	
	public Designer() {}
	
	public Designer(int id,
					String name,
					int age,
					double salary,
					int memberId,
					Status status,
					Equipment equipment,
					double bonus) {
		super(id, name, age, salary, memberId, status, equipment);
		this.bonus = bonus;
	}
	
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public double getBonus() {
		return bonus;
	}
	
	@Override
	public String toString() {
		return super.say() + "\t" + 
			   "设计师" + "\t" + 
			   getStatus() + "\t" + 
			   bonus + "\t\t" + 
			   getEquipment();
	}
	
	public String toStringForTeam() {
		return getMemberId() + "/" + super.say() + "\t" + "设计师" + "\t" + (int)bonus;
	}
	
}