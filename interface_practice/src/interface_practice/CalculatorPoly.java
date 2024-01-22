package interface_practice;

// Polymorphism 다형성

// public static final : 모든 상수 기본값
// public abstract : 모든 method 기본값

interface Calculable {
	
	double PI = 3.14;
	int sum(int v1, int v2);
}


interface Printable {
	
	void print();
}


class CalImpl implements Calculable, Printable {
	
	public int sum(int v1, int v2) {
		return v1 + v2;
	}
	
	public void print() {
		System.out.println("Calculator");
	}
}


class newCalImpl implements Printable {
	
	public void print() {
		System.out.println("newCalculator");
	}
	
	public int minus(int v1, int v2) {
		return v1 - v2;
	}
}


public class CalculatorPoly {

	public static void main(String[] args) {

		CalImpl c = new CalImpl(); //(o)
//		Calculable c = new CalImpl(); //(x)
//		Printable c = new CalImpl(); //(x)
//		이게 다형성이다
		System.out.println(c.sum(2, 1));
		c.print();
		System.out.println(c.PI);
		
		newCalImpl c1 = new newCalImpl();
//		printable c1 = newCalImpl(); //(x)
		System.out.println(c1.minus(2, 1));
		c1.print();

	}

}
