package algorithm146;

import java.util.Scanner;

/**
 * @author suhhyunYeo
 * 창의적 알고리즘 중급 p.1460288                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
 * 
 * [문제] 
 * 우리에게는 생소하지만 오른편 절단 가능 소수가 있다. 이 소수는 오른쪽부터 하나씩 제거해도 계속 소수가 되는 소수이다.
 * 
 * [입력]
 * 자릿수 n이 정수로 입력된다.(1 <= n <= 10)
 * 2
 * 
 * [출력]
 * 1. n자리로 이루어진 오른편 절단 가능 소수들을 한 줄에 하나씩 오름차순으로 출력한다.
 * 2. 마지막 줄에 출력된 오른편 절단 가능 소수들의 개수를 출력한다.
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
