package step04_CountDownByRunnable;

import javax.swing.JFrame;
import javax.swing.JLabel;

//#1
public class CountDownTest extends JFrame{
	private JLabel label;

	//#5
	class MyThread implements Runnable {
		@Override
		//#7
		public void run() {
			for(int i = 10; i >= 0;  i--) {
				System.out.print(i + " ");
					try {
						Thread.sleep(1000);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					label.setText(i + "");
					
		 }
		}
	}
	//#3
	public CountDownTest(){
		this.setTitle("카운트 다운");
		this.setSize(600,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		 label = new JLabel("start");
		 add(label);
		 //#4						#6
		 new Thread(new MyThread()).start();
		 setVisible(true);
		
	}	
	
	public static void main(String[] args) {
			//#2
			new CountDownTest();

	}
}

