package 客户信息管理软件;

//Customer对象的管理类。负责最核心的的业务
//可以添加新对象，删除已有对象，并获取对象
public class CustomerList {
	
//Customer对象数组，这是最核心的数据结构，用来保存实际的Customer对象
	 Customer[] customers;
	//属性的作用是用来指示当前的对象数组中已经保存好的有效对象个数
	private int realCount = 0;
	
	public CustomerList(int totalCount) {
		this.customers = new Customer[totalCount];
	}
	//把参数中指定的对象，保存在customers对象数组中
	public boolean addCustomer(Customer customer) {
		//如果数组已满，则返回false
		if(realCount==customers.length) {//没有空洞，真实对象个数等于数组长度
			return false;
		}
		//把Customer对象插入到this.customer对象数组的适当位置
		this.customers[realCount] = customer;
		//并把有效个数指示器的值做相应的改变
		realCount++;
		return true;
	}
	/* 替换元素*/
	 public boolean replaceCustomer(int index, Customer cust) {
	        if (index < 0 || index >= realCount) return false;
	        
	        customers[index] = cust;
	        return true;
	    }

	/*
	 删除指定索引处的对象
	 */
	 public boolean deleteCustomer(int index) {
		 //1）把要删除的位置的元素置为空
		 customers[index] = null;
		 //2）挨个把要删除的位置的后面的所有有效元素向前移动
		 /*for(int i = index;i<realCount-1;i++) {
			 customers[i] = customers[i+1];
		 }*/
		 for(int i = index+1;i<realCount;i++) {
			 customers[i-1] = customers[i];
		 }
		 //3）并把之前的最后一位置为空
		 customers[realCount - 1] = null;
		 //4）并把有效个数指示器的值做相应的改变
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
