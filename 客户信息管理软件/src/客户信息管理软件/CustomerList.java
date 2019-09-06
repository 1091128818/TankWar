package �ͻ���Ϣ�������;

//Customer����Ĺ����ࡣ��������ĵĵ�ҵ��
//��������¶���ɾ�����ж��󣬲���ȡ����
public class CustomerList {
	
//Customer�������飬��������ĵ����ݽṹ����������ʵ�ʵ�Customer����
	 Customer[] customers;
	//���Ե�����������ָʾ��ǰ�Ķ����������Ѿ�����õ���Ч�������
	private int realCount = 0;
	
	public CustomerList(int totalCount) {
		this.customers = new Customer[totalCount];
	}
	//�Ѳ�����ָ���Ķ��󣬱�����customers����������
	public boolean addCustomer(Customer customer) {
		//��������������򷵻�false
		if(realCount==customers.length) {//û�пն�����ʵ��������������鳤��
			return false;
		}
		//��Customer������뵽this.customer����������ʵ�λ��
		this.customers[realCount] = customer;
		//������Ч����ָʾ����ֵ����Ӧ�ĸı�
		realCount++;
		return true;
	}
	/* �滻Ԫ��*/
	 public boolean replaceCustomer(int index, Customer cust) {
	        if (index < 0 || index >= realCount) return false;
	        
	        customers[index] = cust;
	        return true;
	    }

	/*
	 ɾ��ָ���������Ķ���
	 */
	 public boolean deleteCustomer(int index) {
		 //1����Ҫɾ����λ�õ�Ԫ����Ϊ��
		 customers[index] = null;
		 //2��������Ҫɾ����λ�õĺ����������ЧԪ����ǰ�ƶ�
		 /*for(int i = index;i<realCount-1;i++) {
			 customers[i] = customers[i+1];
		 }*/
		 for(int i = index+1;i<realCount;i++) {
			 customers[i-1] = customers[i];
		 }
		 //3������֮ǰ�����һλ��Ϊ��
		 customers[realCount - 1] = null;
		 //4��������Ч����ָʾ����ֵ����Ӧ�ĸı�
		 realCount--;
		 return true;
	 }
	 
	 public Customer[] getAllCustomers() {
		 Customer[] cust = new Customer[realCount];
		  for (int i = 0; i < realCount; i++) {
	            cust[i] = customers[i];
	        }
	        return cust;
	    }

	    public int getRealCount() {
	        return realCount;
	    }

	    public Customer getCustomer(int index) {
	        if (index < 0 || index >= realCount) return null;
	        
	        return customers[index];
	    

	 }
}
