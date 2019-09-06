import team.service.*;

import javax.management.modelmbean.ModelMBean;

import team.domain.*;


public class CompanyService {
	
	private Employee[] employees;
	
	/**
	 *	��ȡData��,�����е�����ת��Ϊ��������
	*/
	public CompanyService() {
		Equipment[] equipments = new Equipment[Data.EQIPMENTS.length];
		for (int i = 1; i < Data.EQIPMENTS.length; i++) {
			String[] arr = Data.EQIPMENTS[i];
			String codeString = arr[0];
			int code = Integer.parseInt(codeString);
			if (code == Data.PC) {
				equipments[i] = new PC(arr[1], arr[2]);
			} else if (code == Data.NOTEBOOK) {
				equipments[i] = new NoteBook(arr[1], Integer.parseInt(arr[2]));
			} else if (code == Data.PRINTER) {
				equipments[i] = new Printer(arr[1], arr[2]);
			}
		}
				
		this.employees = new Employee[Data.EMPLOYEES.length];
		for (int i = 0; i < Data.EMPLOYEES.length; i++) {
			String[] childArr = Data.EMPLOYEES[i];
			String codeString = childArr[0];
			int code = Integer.parseInt(codeString);
			if (code == Data.EMPLOYEE) {
				int id = Integer.parseInt(childArr[1]);
				String name = childArr[2];
				int age = Integer.parseInt(childArr[3]);
				double salary = Integer.parseInt(childArr[4]);
				employees[i] = new Employee(id, name, age, salary);
			} else if (code == Data.PROGRAMMER) {
				int id = Integer.parseInt(childArr[1]);
				String name = childArr[2];
				int age = Integer.parseInt(childArr[3]);
				double salary = Integer.parseInt(childArr[4]);
				employees[i] = new Programmer(id,
											  name,
											  age,
											  salary,
											  0,
											  Status.FREE,
											  equipments[i]);
			} else if (code == Data.DESIGNER) {
				int id = Integer.parseInt(childArr[1]);
				String name = childArr[2];
				int age = Integer.parseInt(childArr[3]);
				double salary = Integer.parseInt(childArr[4]);
				double bonus = Integer.parseInt(childArr[5]);
				employees[i] = new Designer(id,
											name,
											age,
											salary,
											0,
											Status.FREE,
											equipments[i],
											bonus);
			} else if (code == Data.ARCHITECT) {
				int id = Integer.parseInt(childArr[1]);
				String name = childArr[2];
				int age = Integer.parseInt(childArr[3]);
				double salary = Integer.parseInt(childArr[4]);
				double bonus = Integer.parseInt(childArr[5]);
				int stock = Integer.parseInt(childArr[6]);
				employees[i] = new Architect(id,
											 name,
											 age,
											 salary,
											 0,
											 Status.FREE,
											 equipments[i],
											 bonus,
											 stock);
			}
		}
	}
	
	/**
	 *	���ع�˾������Ա�����������
	*/
	public Employee[] getAllEmployees() {
		return employees;
	}
	
	/**
	 *	������ָ��һ��ID��,�����������ID�Ŷ�Ӧ��
	 *	Ա������
	*/
	public Employee getEmployee(int id) throws TeamException {
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getId() == id) {
				return employees[i];
			}
		}
		throw new TeamException("������ID[" + id + "]��Ա��δ�ҵ�!");
	}
	
}