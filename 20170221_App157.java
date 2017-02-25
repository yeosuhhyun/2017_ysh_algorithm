package algorithm157;

import java.util.Scanner;

/**
 * @author student
 * â���� �˰��� p.157 
 * 
 * [����] app
 * 
 * [�Է�] 
 * ù �ٿ��� ���� n�� M�� ���鹮�ڷ� ���еǾ� �־�����,
 * ��° �ٰ� ��° �ٿ��� ���� n���� ������ ���鹮�ڷ� ���еǾ� �־�����.
 * ��° ���� n���� ������ ���� Ȱ��ȭ�Ǿ� �ִ� �� A1,��, An�� ��� ���� �޸��� ����Ʈ ���� m1, ��, mn�� �ǹ��ϸ�,
 * ��° ���� n ���� ������ �� ���� ��Ȱ��ȭ���� ����� ��� c1,��, cn�� �ǹ��Ѵ�
5 60
30 10 20 35 40
3 0 3 5 4
 * 
 * [���]
 * �ʿ��� �޸� M ����Ʈ�� Ȯ���ϱ� ���� �� ��Ȱ��ȭ�� �ּ��� ����� ����Ͽ��� �ٿ� ����ؾ� �Ѵ�.
 * 6
 * 
 */
public class App157 {
	final static int MAXV = 999999;
	private static int N;
	private static int M;
	private static int i;
	private static int[] m;
	private static int[] c;
	
	public static void main(String[] args) {
		readData();
		System.out.println(solve(N,M));
	}
	
	private static int min(int a, int b) {
		return a<b ? a:b;
	}
	
	private static int solve(int i, int r) {
		if(i==0) {
			if(r<=0) return 0;
			else return MAXV;
		}else if(r<0) {
			return solve(i-1, r);
		}else {
			return min(solve(i-1, r), solve(i-1,r-m[i])+c[i]);
		}
	}
	
	private static void readData() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		scan.nextLine();
		m = new int[N+1];
		c = new int[N+1];
		for(int i=0; i<2; i++) {
			for(int j=1; j<=N; j++) {
				if(i==0) {
					m[j] = scan.nextInt();
				}else {
					c[j] = scan.nextInt();
				}
			}
			scan.nextLine();
		}
		scan.close();
	}

}

