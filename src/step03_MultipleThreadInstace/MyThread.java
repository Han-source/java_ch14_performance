package step03_MultipleThreadInstace;

public class MyThread implements Runnable {

	@Override
	public void run() {
		for(int i = 10; i >= 0;  i--)
			System.out.print(i + " ");
	}
	public static void main(String[] args) {
		
		new Thread(new MyThread()).start();
		new Thread(new MyThread()).start();
		new Thread(new MyThread()).start();
		new Thread(new MyThread()).start();
		new Thread(new MyThread()).start();
		new Thread(new MyThread()).start();
	
	}
}

