package step08_multiplyTable;

public class SingleProcessingMultiply {

	public static void main(String[] args) {

		for (int i = 2; i <= 999999; i++) {
			for (int j = 2; j <= 999999; j++) {
				System.out.println("" + i + " * " + j + " = " + i * j);
				try {
					Thread.sleep((int) (Math.random()) * 5);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
