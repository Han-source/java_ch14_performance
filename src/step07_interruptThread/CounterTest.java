package step07_interruptThread;


class Counter{
	private int value = 0;
	//synchronized 화장실의 키. queue. monitor. interfacene 현상
	public synchronized void increment() {value++;}
	public synchronized void decrement() {value--;}
	public void printCounter() {System.out.println(value);}
	
	
}

class MyThread extends Thread{
	Counter sharedCounter;
	public MyThread(Counter c) {
		this.sharedCounter = c;
	}
	public void run() {
		int i = 0;
		while(i < 20000) {
			sharedCounter.increment();
			sharedCounter.decrement();
			if(i % 40 == 0)
				sharedCounter.printCounter();
			try {
					sleep((int) (Math.random() * 2));
				}catch(InterruptedException e) {}
				i++;
				
	 }
	}
	
}

public class CounterTest {

	public static void main(String[] args) {
		Counter c = new Counter();
		new MyThread(c).start();
		new MyThread(c).start();
		new MyThread(c).start();
		new MyThread(c).start();

	}

}
