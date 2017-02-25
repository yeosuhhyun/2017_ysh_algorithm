package algorithm152;

import java.util.Scanner;

/**
 * @author suhhyunYeo
 * â���� �˰��� �߱� p.152                              
 * backtracking
 * [����] 
 * n*n���� ���� �־�����. (1<=n<=10)
 * �̶� ��ġ�� �ʴ� �� ���� �� �࿡�� ���� �ϳ��� �̴´�. (��, �� n���� ���� ���� ���̴�, �׸��� �� ���� 100 ������ ���̴�.)
 * �� n���� ���� ���� ���� �� �ּڰ��� ���Ͻÿ�.
 * 
 * [�Է�]
 * ù �ٿ� n�� �Էµȴ�. ���� �ٺ��� n+1�ٱ��� n������ ������ �Էµȴ�.
3
1 5 3
2 4 7
5 3 5
 * 
 * [���]
 * ���� �ּ� ���� ����Ѵ�
 * 7
 * 
 */
public class MinimunSum152 {
	private static int n ;
	private static int min_sol = 0x7fffffff;
	private static int[][] m = new int[11][11];
	private static int[] col_check = new int[11];
	
	public static void main(String[] args) {
		input();
		solve(0,0);
		System.out.println(min_sol);

	}
	
	private static void solve(int row, int score) {
		if(row==n) {
			if(score < min_sol) {
				min_sol = score;
			}
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(col_check[i] == 0) {
				col_check[i] = 1;
				solve(row+1, score+m[row][i]);
				col_check[i] = 0;
			}
		}
		return;
	}
	
	private static void input() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		scan.nextLine();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				m[i][j] = scan.nextInt();
			}
			scan.nextLine();
		}
	}

}

