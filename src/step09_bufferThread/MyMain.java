package step09_bufferThread;


/**
 *  회전 초밥집으로 만들거야  주방장 두명 손님 5명 
 */
class Buffer {
	private int data;
	private boolean filled = true;
	public synchronized int get() {
		while(!filled) {
			try {wait();}
			 catch(InterruptedException e) {
				
			}
		}
			filled = false;
			notifyAll();
			return data;
			
	

	}
	public synchronized void put (int data) {
		while (filled) {
			try {wait();}
			catch (InterruptedException e) {
				
			}
		}
			filled = true;
			this.data = data;
			notifyAll();
		
	}
}

class Producer implements Runnable {
	private Buffer buffer;
	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}
	@Override
	public void run() {
		for ( int i = 0; i < 10; i++) {
			buffer.put(i);
			System.out.println("생산자 : " + i + "번 케익을 생산하였습니당");
			
			try {
					Thread.sleep((int) (Math.random() * 100));
			}catch (InterruptedException e) {
				
			}
		}
		
	}
}

class Consumer implements Runnable {
	private Buffer buffer;
	public Consumer(Buffer drop) {
		this.buffer = drop;
	}
	@Override
	public void run() {
		for ( int i = 0; i < 10; i++) {
				int data = buffer.get();
				System.out.println("소비자 : " + data + "번 케익을 소비하였습니당");
			
				try {
						Thread.sleep((int) (Math.random() * 100));
				}catch (InterruptedException e) {
				
			}
		}
		
	}
}
public class MyMain {

	public static void main(String[] args) {
		Buffer dish = new Buffer();
		new Thread(new Producer(dish)).start();
		new Thread(new Consumer(dish)).start();
		
		
	
	}

}
