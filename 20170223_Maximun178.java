package algorithm178;

import java.util.Scanner;

/**
 * @author suhhyun yeo
 * 창의적 알고리즘 중급 p.178
 * 
 * [문제]
 * 부분합이란 n개의 원소 중 i번째 원소로부터 j번째 원소까지의 연속적인 합을 의미한다(단, 1 < i <= j <= n ).
 * 
 * [입력]
 * 첫 줄에 원소의 수를 의미하는 정수 n이 입력되고, 둘째 줄에 n개의 정수가 공백으로 구분되어 입력된다.
 * (단, 2 <= n <= 100 , 각 원소의 크기는 -1000부터 1000 사이의 정수이다.)
6
6 -7 3 -1 5 2
 * 
 * [출력]
 * 주어진 집합에서 얻을 수 있는 최대 부분합을 출력한다.
 * 9
 * 
 */
public class Maximun178 {

	private static int n;
	private static int[] A;
	private static int ans;
	
	public static void main(String[] args) {
		input();
		
		// initialize ans
		ans = 0;
		
		// fisrt num 
		for(int s=0; s<n; s++) {
			
			for(int e=s, sum; e<n; e++) {
				sum = 0;
				// Added count
				for(int k=s; k<=e; k++) {
					sum+=A[k];
					
				}
				if(ans < sum) {
					
					ans = sum;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	/**
	 * input function 
	 */
	private static void input() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		scan.nextLine();
		
		A = new int[n];
		
		for(int i=0;i<n; i++) {
			A[i] = scan.nextInt();
		}
		
		scan.close();
	}

}
