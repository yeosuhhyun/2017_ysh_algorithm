package algorithm161;

import java.util.Scanner;

/**
 * @author student
 *
 */
public class Cheese161 {
	public static Scanner sc = new Scanner(System.in);
	public static int n, m;
	public static int[][] board, board2;

	/**
	 * @author suhhyun yeo 창의적 알고리즘 중 p.161 flood fill 알고리즘 [문제] 치즈 모눈종이 모양의
	 *         치즈에서 각 치즈 격자(작은 정사각형 모양)의 네변 중에서 적어도 두 변 이상이 실내온도의 공기와 접촉한 것은 정확히
	 *         한 시간 만에 녹아 없어져 버린다.
	 * 
	 *         [입력] 첫째 줄에는 모눈종이의 크기를 나타내는 두 개의 정수 n, m(5 ≤ n, m ≤100)이주어진다. 그 다음
	 *         n개의 줄에는 모눈종이 위의 격자에 치즈가 있는 부분은 1로 표시되고, 치즈가 없는 부분은 0으로 표시된다. 또한,
	 *         각 0과 1은 하나의 공백으로 분리되어 있다.
	 * 
	 *         8 9 0 0 0 0 0 0 0 0 0 0 0 0 1 1 0 0 0 0 0 0 0 1 1 0 1 1 0 0 0 1 1
	 *         1 1 1 1 0 0 0 1 1 1 1 1 0 0 0 0 1 1 0 1 1 0 0 0 0 0 0 0 0 0 0 0 0
	 *         0 0 0 0 0 0 0 0
	 * 
	 *         [출력] 출력으로는 주어진 치즈가 모두 녹아 없어지는 데 걸리는 정확한 시간을 정수로첫 줄에 출력한다 4
	 * 
	 */

	/**
	 * 메인 메소드
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		input();
		solve();
	}

	/**
	 * 입력받은 값을 0인 부분을 2로 변경하는 재귀함수
	 * 
	 * @param x
	 * @param y
	 */
	public static void fill1(int x, int y) {
		if (!boundary(x, y)) {
			return;
		}
		if (board[x][y] == 0) {
			board[x][y] = 2;
			fill1(x + 1, y);
			fill1(x - 1, y);
			fill1(x, y + 1);
			fill1(x, y - 1);
		}
	}

	/**
	 * 2변 이상 공기와 맞닿아 있는지 검사하는 함수.
	 * @param x
	 * @param y
	 * @return
	 */
	public static int check(int x, int y) {
		int t = 0;
		if (boundary(x + 1, y) && board[x + 1][y] == 2)
			t++;
		if (boundary(x - 1, y) && board[x - 1][y] == 2)
			t++;
		if (boundary(x, y + 1) && board[x][y + 1] == 2)
			t++;
		if (boundary(x, y - 1) && board[x][y - 1] == 2)
			t++;
		return t;
	}
	
	
	/**
	 * 배열 밖으로 넘어가지 않게 검사해주는 함수
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean boundary(int x, int y) {
		return (x >= 0 && x < n) && (y >= 0 && y < m) ? true : false;
	}
	
	
	/**
	 * 주 함수
	 *  
	 */
	public static void solve() {
		int hour = 0;
		while (true) {
			fill1(0, 0);
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					// 녹을 치즈를 확인
					if (board[i][j] == 1 && check(i, j) >= 2) {
						board2[i][j] = 0;
						count++;
					}
				}
			}
			// 더이상 치즈가 없다면 종료.
			if (count == 0) {
				System.out.println(hour);
				break;
			}
			hour++;
			// 한 번 끝날 때마다 배열을 복사
			copy();
		}
	}

	/**
	 * 사용자 입력 메서드
	 */
	public static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		board = new int[n][m];
		board2 = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = sc.nextInt();
				board2[i][j] = board[i][j];
			}
		}
	}

	public static void copy() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = board2[i][j];
			}
		}
	}
}
