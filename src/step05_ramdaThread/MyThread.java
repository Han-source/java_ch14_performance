package step05_ramdaThread;

public class MyThread  {

	public static void main(String[] args) {
		Runnable task = ()->{
			for(int i = 10; i >= 0;  i--)
				System.out.print(i + " ");
		};
		new Thread(task).start();
	}
}

