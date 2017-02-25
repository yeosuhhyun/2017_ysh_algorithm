package algorithm181;

import java.util.Scanner;

/**
 * @author suhhyun yeo
 * â���� �˰��� �߱� p.181
 * 
 * [����]
 * �浿�̴� ����� ���� �� ��п� ���� �� ���� 1�� �Ǵ� 2���� �ö� �� �ִ�.
 * ����� ũ�� n�� �־��� ��, �浿�̰� �� ����� �ö� �� �ִ� ��� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 *  3 -> (1,1,1), (1,2), (2,1)
 * [�Է�]
 * ����� �� n�� �Էµȴ�(�� n�� 20���� ���� �ڿ���).
 * 3
 * 
 * [���]
 * �浿�̰� ����� ������ ��� ����� ���� ����Ѵ�.
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
