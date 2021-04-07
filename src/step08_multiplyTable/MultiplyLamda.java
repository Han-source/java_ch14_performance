package step08_multiplyTable;

import java.util.ArrayList;
import java.util.List;

public class MultiplyLamda {

	public static void main(String[] args) {
		List<Integer> operand = new ArrayList<>();
		List<Integer> operand2 = new ArrayList<>();
		for(int i = 2; i <= 999999; i ++) {
			operand.add(i);
			operand2.add(i);
		}
		operand.parallelStream().forEach(op1 ->{
		operand2.parallelStream().forEach(op2 ->{
			for( int j = 2; j <=9; j++) {
				System.out.println("" + op1 + " * " + op2 + " = " + op1 * op2);
				try {
				Thread.sleep((int) (Math.random()) * 5);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			}
		}); // 병렬흐름
	 });
	}
		
}
