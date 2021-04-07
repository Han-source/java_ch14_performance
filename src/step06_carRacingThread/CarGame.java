package step06_carRacingThread;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CarGame extends JFrame{

	class MyThread extends Thread{
		private JLabel label;
		private int x, y;
		public MyThread(String fname, int x, int y) {
			this.x = x;
			this.y = y;
			label = new JLabel();
			label.setIcon(new ImageIcon(fname));
			label.setBounds(x, y, 50, 700);
			add(label);
		}
		public void run() {
			for(int i = 0; i < 200; i ++) {
				x += 10 * Math.random();
				label.setBounds(x, y, 100, 100);
				
				try {
					Thread.sleep(100);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public CarGame() {
		this.setTitle("경주");
		this.setSize(1500,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		(new MyThread("car1.png",100,50)).start();
		(new MyThread("car2.jpg",100,200)).start();
		(new MyThread("car3.jpg",100,350)).start();
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new CarGame();
		

	}
}
