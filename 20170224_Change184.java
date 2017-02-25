package algorithm184;

import java.util.Scanner;

/**
 * @author suhhyun yeo
 * 창의적 알고리즘 p.184
 * 
 * [문제]
 * 입력으로 거슬러 줘야할 돈의 액수와 그 나라에서 이용하는 동전의 가짓수 그리고
 * 동전의 종류가 들어오면 여러 가지 방법들 중 가장 적은 동전의 수를 구하는 프로그램을 작성하시오.
 * 
 * [입력]
 * 첫 번째 줄에는 거슬러 줘야할 돈의 액수 m이 입력된다.
 * ( 10 <= m <= 10,000 )
 * 다음 줄에는 그 나라에서 사용되는 동전의 종류의 수 n이 입력된다.
 * ( 1 <= n <= 10 )
 * 마지막 줄에는 동전의 수만큼의 동전 액수가 오름차순으로 입력된다.
 * ( 10 <= 액수 <= m )
730
5
10 50 100 500 1250
 * 
 * [출력]
 * 최소의 동전의 수를 출력한다.
 * 6
 * 
 */
public class Change184 {
	
	private static int m;
	private static int n;
	private static int[] coin;
	private static int ans = 99999999;
	
	public static void main(String[] args) {
		input();
		solve(0,0);
		//solve2(0,0,0);
		System.out.println(ans);
	}
	
	/**
	 * sum개의 동전으로 money원을 사용한 상태
	 * 트리형식으로 m과 같아질 때까지 재귀되는 함수
	 * 즉, 루트가 0일 때, 자식 노드가 각각 n개의 동전 액수가 생성되면서 더하면서 내려간다.
	 * @param money
	 * @param sum
	 */
	private static void solve(int money, int sum) {
		if(money > m) return;
		if(money == m) {
			if(sum<ans) {
				ans = sum;
			}
			return;
		}
		for(int i=0; i<n; i++) {
			solve(money+coin[i], sum+1);
		}
	}
	
	/**
	 * k번째 이하의 동전을 cnt개 사용하여 money원을 거슬러 준 상태
	 * solve의 트리형식과 비슷하지만 해당 방식은 높이마다 같은 동전 액수를 가지고 있고 
	 * 같은 높이의 자식들이 액수는 동일하고 갯수는 다른 값을 가지고 있다. 
	 * @param money
	 * @param k
	 * @param cnt
	 */
	private static void solve2(int money, int k, int cnt) {
		if(k==n || money>m) return;
		
		if(money == m) {
			if(ans>cnt) ans=cnt;
			return;
		}
		for(int i=0; money+coin[k]*i<=m; i++) {
			solve2(money+coin[k]*i, k+1, cnt+i);
		}
	}
	
	/**
	 * input function
	 */
	private static void input() {
		Scanner scan = new Scanner(System.in);
		m = scan.nextInt();
		scan.nextLine();
		n = scan.nextInt();
		scan.nextLine();
		coin = new int[n];
	
		for(int i=0; i<n; i++) {
			System.out.println(i);
			coin[i] = scan.nextInt();
		}
		scan.close();
	}
}
