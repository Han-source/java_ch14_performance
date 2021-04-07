package step01_ThreadDirectInherite;

public class MyThread extends Thread {

	@Override
	public void run() {
		for(int i = 10; i >= 0;  i--)
			System.out.print(i + " ");
	}
	public static void main(String[] args) {
		
		new MyThread().start();
	
	}
}

