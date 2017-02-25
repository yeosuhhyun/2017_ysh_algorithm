package algorithm181;

import java.util.Scanner;

/**
 * @author suhhyun yeo
 * 창의적 알고리즘 중급 p.181
 * 
 * [문제]
 * 길동이는 계단을 오를 때 기분에 따라서 한 번에 1단 또는 2단을 올라갈 수 있다.
 * 계단의 크기 n이 주어질 때, 길동이가 이 계단을 올라갈 수 있는 모든 경우의 수를 구하는 프로그램을 작성하시오.
 *  3 -> (1,1,1), (1,2), (2,1)
 * [입력]
 * 계단의 수 n이 입력된다(단 n은 20보다 작은 자연수).
 * 3
 * 
 * [출력]
 * 길동이가 계단을 오르는 모든 방법의 수를 출력한다.
 * 3
 */
public class Stairs181 {
	private static int n, ans;
	
	public static void main(String[] args) {
		// input start
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		scan.close();
		// input end
		
		
		solve(0);
		System.out.println(ans);
	}
	
	/**
	 * add num using like tree
	 * @param v
	 */
	private static void solve(int v) {
		if(v>n) {
			return;
		}
		
		if(v==n) {
			ans++;
			return;
		}
		
		solve(v+1);
		solve(v+2);
	}
}
