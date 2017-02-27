package algorithm200;

import java.util.Scanner;

/**
 * @author suhhyun yeo
 * â���� �˰��� �߱� p.200
 * 
 * [����] ��üŽ����
 * H*W ���ڿ��� ���� ��(0,0)���� ������ �Ʒ�(H, W)���� �� �� �ִ� ���� ���� ��Ƹ����� �Ѵ�.
 * ���� �� �� �� ���� ��������� �ִ�.
 * (1) ���� ���� ���� ���󰣴�.
 * (2) �Ʒ��� �Ǵ� ���������θ� �� �� �ִ�.
 * (3) (0,0)�� (H, W)�� �մ� �밢������ ���ʿ� �ִ� ������ ����� �� ����.
 * (�밢���� ��ġ�ϴ� ���� ����� �� �ִ�.)
 * 
 * [�Է�]
 * 1. �� ���� ���� H�� W�� �Էµȴ�.
 * 2. H�� ������ ���� ũ�⸦, W�� ������ ���� ũ�⸦ ���� ��Ÿ����.
 * [�Է°��� ���ǿ�]
 * 1 <= H, W <= 10
3 4
 * 
 * [���]
 * (0,0)���� (H, W)���� �� �� �ִ� ���� ���� ����Ѵ�.
 * 5
 * 
 */
public class LatticePath200 {
	// height
	private static int H;
	
	// weight
	private static int W;
	
	// answer
	private static int ans;
	
	public static void main(String[] args) {
		input();
		solve(0,0);
		System.out.println(ans);
	}
	
	/**
	 * input function
	 */
	private static void input() {
		Scanner scan = new Scanner(System.in);
		H = scan.nextInt();
		W = scan.nextInt();
		scan.close();
	}
	
	
	/**
	 * ��ǥ�� ������������ �̵��ϴ� ��� �Լ�.
	 * 1. �Ʒ������� �̵��ϴ� ���, 2. ���������� �̵��ϴ� ���
	 * �ΰ����� ����� ��üŽ������ �̿���.
	 * @param h
	 * @param w
	 */
	private static void solve(int h, int w) {
		// ��ǥ�� ���� ���� ������ ������ ��� ����.
		if(h > H || w > W) {
			return;
		}
		
		// ��ǥ�� ���������� �������� ��, ans 1 ����
		if(h == H && w == W) {
			ans++;
			return;
		}
		
		// 1. �Ʒ������� �̵��ϴ� ���
		solve(h+1, w);
		
		// 2. ���������� �̵��ϴ� ��� (�밢�� ���� ���� ���� ���ϴϱ�)
		if((double)H/W <= (double)h/(w+1)) {
			solve(h, w+1);
		}
	}
}
