package algorithm171;

import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @author suhhyun yeo
 * â���� �˰��� �߱� p.171
 * 
 * [����]
 * �׷����� ���� �׷����̰� ������ �׷����̸� ��ü ������ ���ٰ� ��������. 
 * 0���� n-1������ n���� ������ ������ �� m�� �Էµ� ��, 2���� ����� ĥ�� �� �ִ��� �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * [�Է�]
 * ù° �ٿ��� ������ ���� n(1 �� n �� 200)�� ������ �� m�� �Էµȴ�.
 * ��° �ٺ��� m�ٿ� ���ļ� �� ������ �����ϴ� ������ ��ȣ�� �������� ���еǾ��Էµȴ�.
��1)
3 3
1 0
1 2
2 0

��2)
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
 * [���]
 * �Էµ� �׷����� �� ������ ĥ�� �� �ִ� �׷��������� �Ǵ��ϰ� �Ʒ� ���� ���� ���Ŀ� �°� ����� ����϶�.
 * ��1) IMPOSSIBLE
 * ��2) OK
 */

public class Bicoloring171 {
	
	private static int n;
	private static int m;
	private static int[] visited;
	private static int[][] G;
	
	public static void main(String[] args) {
		input();
		solve(0,1);
		
		// ��� ��
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
	 * �Է��Լ� 
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
