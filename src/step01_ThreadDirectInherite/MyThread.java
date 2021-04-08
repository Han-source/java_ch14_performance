package step01_ThreadDirectInherite;

import java.util.stream.IntStream;

public class MyThread extends Thread {

	@Override
	public void run() {
		for(int i = 10; i > 0;  i--)
			System.out.print(i + " ");
	}
	private void doSome() {
		IntStream.range(0,10).forEach(i -> {System.out.println("" +i); });
	}
	public static void main(String[] args) {
		MyThread xx = new MyThread();
		xx.start();
		xx.doSome();
		xx.run();
		
	
	}
}

