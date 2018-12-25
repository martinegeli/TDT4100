package encapsulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RPNCalc {
	// en ArrayList med Double-objekter
	
	List<Double> kalkulator = new ArrayList<Double>();
	private int i;
	List<Character> validOperator = Arrays.asList('+', '-', '*', '/', '~');

	
	public void push(double number) {
		kalkulator.add(number);
	}
	
	public double pop() {
		if (!(kalkulator.isEmpty())) {
			double lastElement = kalkulator.get(kalkulator.size() -1);
			kalkulator.remove(kalkulator.size()-1);
			return lastElement;
		} else {
			return Double.NaN;
		}
	}
	
	public double peek(int number) {
		if (getSize() > 0) {
			i = kalkulator.size()-number-1;
			return kalkulator.get(i);
		} else return Double.NaN;
	}
	
	public int getSize() {
		return kalkulator.size();
	}
	
	public void performOperation(char operator) {
		
		double first = kalkulator.get(kalkulator.size() - 1);
		double second = kalkulator.get(kalkulator.size() - 2);
		
		kalkulator.remove(kalkulator.size() - 1);
		kalkulator.remove(kalkulator.size() - 1);
		
		int j = validOperator.indexOf(operator);
		
		switch (j) {
			case 0: push(first + second);
			break;
			case 1: push(second - first);
			break;
			case 2: push(second * first);
			break;
			case 3: push(second / first);
			break;
			case 4: push(first); push(second);
			break;
		}
	}
	
	public static void main(String[] args) {
		RPNCalc kalk = new RPNCalc();
		kalk.push(4);
		kalk.push(7);
		System.out.println(kalk.getSize());
		System.out.println(kalk.peek(0));


		kalk.performOperation('+');
		System.out.println(kalk.getSize());
		
	}
	
	
}
