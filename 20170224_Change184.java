package algorithm184;

import java.util.Scanner;

/**
 * @author suhhyun yeo
 * â���� �˰��� p.184
 * 
 * [����]
 * �Է����� �Ž��� ����� ���� �׼��� �� ���󿡼� �̿��ϴ� ������ ������ �׸���
 * ������ ������ ������ ���� ���� ����� �� ���� ���� ������ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * [�Է�]
 * ù ��° �ٿ��� �Ž��� ����� ���� �׼� m�� �Էµȴ�.
 * ( 10 <= m <= 10,000 )
 * ���� �ٿ��� �� ���󿡼� ���Ǵ� ������ ������ �� n�� �Էµȴ�.
 * ( 1 <= n <= 10 )
 * ������ �ٿ��� ������ ����ŭ�� ���� �׼��� ������������ �Էµȴ�.
 * ( 10 <= �׼� <= m )
730
5
10 50 100 500 1250
 * 
 * [���]
 * �ּ��� ������ ���� ����Ѵ�.
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
	 * sum���� �������� money���� ����� ����
	 * Ʈ���������� m�� ������ ������ ��͵Ǵ� �Լ�
	 * ��, ��Ʈ�� 0�� ��, �ڽ� ��尡 ���� n���� ���� �׼��� �����Ǹ鼭 ���ϸ鼭 ��������.
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
	 * k��° ������ ������ cnt�� ����Ͽ� money���� �Ž��� �� ����
	 * solve�� Ʈ�����İ� ��������� �ش� ����� ���̸��� ���� ���� �׼��� ������ �ְ� 
	 * ���� ������ �ڽĵ��� �׼��� �����ϰ� ������ �ٸ� ���� ������ �ִ�. 
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
