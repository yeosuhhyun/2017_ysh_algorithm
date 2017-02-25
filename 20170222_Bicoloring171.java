package algorithm171;

import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @author suhhyun yeo
 * 창의적 알고리즘 중급 p.171
 * 
 * [문제]
 * 그래프가 연결 그래프이고 무방향 그래프이며 자체 루프가 없다고 가정하자. 
 * 0부터 n-1까지의 n개의 정점과 간선의 수 m이 입력될 때, 2가지 색깔로 칠할 수 있는지 결정하는 프로그램을 작성하시오.
 * 
 * [입력]
 * 첫째 줄에는 정점의 개수 n(1 ≤ n ≤ 200)과 간선의 수 m이 입력된다.
 * 둘째 줄부터 m줄에 걸쳐서 각 간선이 연결하는 정점의 번호가 공백으로 구분되어입력된다.
예1)
3 3
1 0
1 2
2 0

예2)
9 8
0 1
0 2
0 3
0 4
0 5
0 6
0 7
0 8
 * 
 * [출력]
 * 입력된 그래프가 두 색으로 칠할 수 있는 그래프인지를 판단하고 아래 예에 나온 형식에 맞게 결과를 출력하라.
 * 예1) IMPOSSIBLE
 * 예2) OK
 */

public class Bicoloring171 {
	
	private static int n;
	private static int m;
	private static int[] visited;
	private static int[][] G;
	
	public static void main(String[] args) {
		input();
		solve(0,1);
		
		// 모야 너
		for(int i=0; i<n; i++) {
			if(visited[i]==0) {
				System.out.println("IMPOSSIBLE");
				break;
			}
			System.out.println("OK");
			break;
		}
	}
	
	private static void solve(int v, int c) {
		visited[v] = c;
		int can = 1;
		for(int i=0; i<n; i++) {
			if(G[v][i]==1 && visited[i] == c) {
				can = 0;
			}
		}
		if(can != 0) {
			visited[v] = 0;
			return;
		}
		for(int i=0; i<n; i++) {
			if(visited[i]!=0 && G[v][i]==1) {
				solve(i,1);
				solve(i,2);
			}
		}
	}
	
	
	/**
	 * 입력함수 
	 */
	private static void input() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		visited = new int[n];
		G = new int[n][n];
		scan.nextLine();
		for(int i=0; i<m; i++) {
			int s = scan.nextInt();
			int e = scan.nextInt();
			G[s][e] = G[e][s] = 1;
			scan.nextLine();
		}
		scan.close();
		
	}

}
