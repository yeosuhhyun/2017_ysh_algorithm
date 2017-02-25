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
	 * @author suhhyun yeo â���� �˰��� �� p.161 flood fill �˰��� [����] ġ�� ������ �����
	 *         ġ��� �� ġ�� ����(���� ���簢�� ���)�� �׺� �߿��� ��� �� �� �̻��� �ǳ��µ��� ����� ������ ���� ��Ȯ��
	 *         �� �ð� ���� ��� ������ ������.
	 * 
	 *         [�Է�] ù° �ٿ��� �������� ũ�⸦ ��Ÿ���� �� ���� ���� n, m(5 �� n, m ��100)���־�����. �� ����
	 *         n���� �ٿ��� ������ ���� ���ڿ� ġ� �ִ� �κ��� 1�� ǥ�õǰ�, ġ� ���� �κ��� 0���� ǥ�õȴ�. ����,
	 *         �� 0�� 1�� �ϳ��� �������� �и��Ǿ� �ִ�.
	 * 
	 *         8 9 0 0 0 0 0 0 0 0 0 0 0 0 1 1 0 0 0 0 0 0 0 1 1 0 1 1 0 0 0 1 1
	 *         1 1 1 1 0 0 0 1 1 1 1 1 0 0 0 0 1 1 0 1 1 0 0 0 0 0 0 0 0 0 0 0 0
	 *         0 0 0 0 0 0 0 0
	 * 
	 *         [���] ������δ� �־��� ġ� ��� ��� �������� �� �ɸ��� ��Ȯ�� �ð��� ������ù �ٿ� ����Ѵ� 4
	 * 
	 */

	/**
	 * ���� �޼ҵ�
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		input();
		solve();
	}

	/**
	 * �Է¹��� ���� 0�� �κ��� 2�� �����ϴ� ����Լ�
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
	 * 2�� �̻� ����� �´�� �ִ��� �˻��ϴ� �Լ�.
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
	 * �迭 ������ �Ѿ�� �ʰ� �˻����ִ� �Լ�
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean boundary(int x, int y) {
		return (x >= 0 && x < n) && (y >= 0 && y < m) ? true : false;
	}
	
	
	/**
	 * �� �Լ�
	 *  
	 */
	public static void solve() {
		int hour = 0;
		while (true) {
			fill1(0, 0);
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					// ���� ġ� Ȯ��
					if (board[i][j] == 1 && check(i, j) >= 2) {
						board2[i][j] = 0;
						count++;
					}
				}
			}
			// ���̻� ġ� ���ٸ� ����.
			if (count == 0) {
				System.out.println(hour);
				break;
			}
			hour++;
			// �� �� ���� ������ �迭�� ����
			copy();
		}
	}

	/**
	 * ����� �Է� �޼���
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
