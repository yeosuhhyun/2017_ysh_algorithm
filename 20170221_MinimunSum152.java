package algorithm152;

import java.util.Scanner;

/**
 * @author suhhyunYeo
 * 창의적 알고리즘 중급 p.152                              
 * backtracking
 * [문제] 
 * n*n개의 수가 주어진다. (1<=n<=10)
 * 이때 겹치지 않는 각 열과 각 행에서 수를 하나씩 뽑는다. (즉, 총 n개의 수를 뽑을 것이다, 그리고 각 수는 100 이하의 값이다.)
 * 이 n개의 수의 합을 구할 때 최솟값을 구하시오.
 * 
 * [입력]
 * 첫 줄에 n이 입력된다. 다음 줄부터 n+1줄까지 n개씩의 정수가 입력된다.
3
1 5 3
2 4 7
5 3 5
 * 
 * [출력]
 * 구한 최소 합을 출력한다
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

