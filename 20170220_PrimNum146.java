package algorithm146;

import java.util.Scanner;

/**
 * @author suhhyunYeo
 * â���� �˰��� �߱� p.1460288                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
 * 
 * [����] 
 * �츮���Դ� ���������� ������ ���� ���� �Ҽ��� �ִ�. �� �Ҽ��� �����ʺ��� �ϳ��� �����ص� ��� �Ҽ��� �Ǵ� �Ҽ��̴�.
 * 
 * [�Է�]
 * �ڸ��� n�� ������ �Էµȴ�.(1 <= n <= 10)
 * 2
 * 
 * [���]
 * 1. n�ڸ��� �̷���� ������ ���� ���� �Ҽ����� �� �ٿ� �ϳ��� ������������ ����Ѵ�.
 * 2. ������ �ٿ� ��µ� ������ ���� ���� �Ҽ����� ������ ����Ѵ�.
 * 11
 * 13
 * 17
 * 19
 * 31
 * 37
 * 71
 * 73
 * 79
 * 9
 * 
 */
public class PrimNum146 {
	private static int n;
	private static int count;
	
	public static void main(String[] args) {
		// input start
		InputData input = new InputData();
		input.readData();
		n = input.getN();
		// input end
		
		solve(0,0);
		
		// output start
		OutputData output = new OutputData();
		output.printData(count);
		// output end
	}
	
	
	/**
	 * check if x is Prime or not
	 * @param x : num to be confirmed
	 * @return if x is prime, return true. else return false.
	 */
	private static boolean isPrime(int x) {
		for(int i=2; i*i<=x; i++) {
			if(x%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	
	// logic
	private static void solve(int num, int len) {
		if(len == n) {
			// num is Prime or not
			if(isPrime(num)) {
				count++;
				OutputData output = new OutputData();
				output.printData(num);
			}
			return;
		} else {
			if(isPrime(num)) {
				// even number and multiples of 5 are not prime
				// so, check only 1 3 7 9
				solve(num*10+1, len+1);
				solve(num*10+3, len+1);
				solve(num*10+7, len+1);
				solve(num*10+9, len+1);
			}
		}
		
	}

}

class OutputData {
	public OutputData() {
		
	}
	
	public void printData(int data) {
		System.out.println(data);
	}
}

class InputData {
	private int n;
	
	public InputData() {
		n = 0;
	}
	
	public void readData() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		scan.close();
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	
}
