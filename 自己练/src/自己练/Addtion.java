package 自己练;

import javax.swing.*;

public class Addtion {

	public static void main(String args[]) {
		
		String number1;
		String number2;
		int s1;
		int s2;
		int sum;
		number1 = JOptionPane.showInputDialog("输入加数");
		number2 = JOptionPane.showInputDialog("输入被加数");
		s1 = Integer.parseInt(number1);
		s2 = Integer.parseInt(number2);
		sum = s1 + s2;
		JOptionPane.showMessageDialog(null, "结果"+sum, "结果", JOptionPane.PLAIN_MESSAGE);
		System.exit(0);
	}
	
}

