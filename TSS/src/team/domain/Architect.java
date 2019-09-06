package team.domain;

import team.service.Status;

public class Architect extends Designer{

		private int stock;
		
		public Architect() {}
		
		public Architect(int id,
						 String name,
						 int age,
						 double salary,
						 int memberId,
						 Status status,
						 Equipment equipment,
						 double bonus,
						 int stock) {
			super(id, 
				  name,
				  age,
				  salary,
				  memberId,
				  status,
				  equipment,
				  bonus);
			this.stock = stock;
		}
		
		public void setStock(int stock) {
			this.stock = stock;
		}
		
		public int getStock() {
			return stock;
		}
		
		@Override
		public String toString() {
			return  super.say() + "\t" + 
					"架构师" + "\t" +
					getStatus() + "\t" + 
					getBonus() + "\t" +
					stock + "\t" +
					getEquipment();
		}
		
		public String toStringForTeam() {
			return getMemberId() + "/" + super.say() + "\t" + "架构师" + "\t" + (int)getBonus() + "\t" + stock;
		}
		
	}