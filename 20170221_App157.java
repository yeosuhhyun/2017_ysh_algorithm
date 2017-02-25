package algorithm157;

import java.util.Scanner;

/**
 * @author student
 * 창의적 알고리즘 p.157 
 * 
 * [문제] app
 * 
 * [입력] 
 * 첫 줄에는 정수 n과 M이 공백문자로 구분되어 주어지며,
 * 둘째 줄과 셋째 줄에는 각각 n개의 정수가 공백문자로 구분되어 주어진다.
 * 둘째 줄의 n개의 정수는 현재 활성화되어 있는 앱 A1,…, An이 사용 중인 메모리의 바이트 수인 m1, …, mn을 의미하며,
 * 셋째 줄의 n 개의 정수는 각 앱을 비활성화했을 경우의 비용 c1,…, cn을 의미한다
5 60
30 10 20 35 40
3 0 3 5 4
 * 
 * [출력]
 * 필요한 메모리 M 바이트를 확보하기 위한 앱 비활성화의 최소의 비용을 계산하여한 줄에 출력해야 한다.
 * 6
 * 
 */
public class App157 {
	final static int MAXV = 999999;
	private static int N;
	private static int M;
	private static int i;
	private static int[] m;
	private static int[] c;
	
	public static void main(String[] args) {
		readData();
		System.out.println(solve(N,M));
	}
	
	private static int min(int a, int b) {
		return a<b ? a:b;
	}
	
	private static int solve(int i, int r) {
		if(i==0) {
			if(r<=0) return 0;
			else return MAXV;
		}else if(r<0) {
			return solve(i-1, r);
		}else {
			return min(solve(i-1, r), solve(i-1,r-m[i])+c[i]);
		}
	}
	
	private static void readData() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		scan.nextLine();
		m = new int[N+1];
		c = new int[N+1];
		for(int i=0; i<2; i++) {
			for(int j=1; j<=N; j++) {
				if(i==0) {
					m[j] = scan.nextInt();
				}else {
					c[j] = scan.nextInt();
				}
			}
			scan.nextLine();
		}
		scan.close();
	}

}

