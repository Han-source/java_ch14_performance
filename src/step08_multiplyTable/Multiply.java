package step08_multiplyTable;

public class Multiply implements Runnable {
	private int operand;
	
	private Multiply(int operand) {
		this.operand = operand;
	}
	@Override
	public void run() {
		for( int i = 2; i <=9; i++) {
			System.out.println("" + operand + " * " + i + " = " + operand * i);
		}
		
	}
	public static void main(String[] args) {
		for ( int i = 2; i <= 9; i++) {
			new Thread(new Multiply(i)).start();
		}

	}

	


}
