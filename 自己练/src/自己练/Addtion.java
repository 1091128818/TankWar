package �Լ���;

import javax.swing.*;

public class Addtion {

	public static void main(String args[]) {
		
		String number1;
		String number2;
		int s1;
		int s2;
		int sum;
		number1 = JOptionPane.showInputDialog("�������");
		number2 = JOptionPane.showInputDialog("���뱻����");
		s1 = Integer.parseInt(number1);
		s2 = Integer.parseInt(number2);
		sum = s1 + s2;
		JOptionPane.showMessageDialog(null, "���"+sum, "���", JOptionPane.PLAIN_MESSAGE);
		System.exit(0);
	}
	
}

