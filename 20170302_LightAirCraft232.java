package algorithm232;

import java.util.Scanner;

/**
 * @author suhhyun yeo
 * â�����˰��� p.232
 * ��üŽ����
 * [����]
 * 1) ��� ������ �� ���� ���̸� �ݵ�� �������� ���ư���. �Ÿ��� ������ km�̸� ������ ������ ��(����)�̴�. 
 * 1���� ����Ÿ��� 10km�̰� ���� ������ �� ������ �� ��.
 * 2) �� ��ġ ���� �Ÿ��� ������ �Ÿ��̴�. 
 * ���� ���, �� �� g = (2, 1)�� h = (37, 43) ���� �Ÿ� d(g, h)�� sqrt{ (2-37)^2 + (1-43)^2 }= 54.671�̰� 
 * 50 < d(g, h) �� 60�̹Ƿ� �ʿ��� ����� 6���� �ȴ�. 
 * 3) ����� S�� ��ǥ�� �׻� (0, 0)�̰� ������ T�� ��ǥ�� (10000,10000)���� ��� �Է� �����Ϳ��� �����Ǿ� �ִ�. 
 * 4) ������� �������� ������ �������� �� n�� 3 <= n <= 10�̰� �� ��ǥ�� (x, y) �� ������ 0 < x, y < 10,000�� �����̴�. 
 * �׸��� 0 <= k <= 1000�̴�.
 * 
 * [�Է�]
 * �Է��� ù �ٿ��� n�� k�� �ϳ��� ������ �ΰ� �־�����.
 * �� ���� n���� �ٿ��� �� ������(������)�� ������ǥ�� "x y"�� �������� �־�����.
 * 
10 1
10 1000
20 1000
30 1000
40 1000
5000 5000
1000 60
1000 70
1000 80
1000 90
7000 7000
 * 
 * [���]
 * ��¿��� S���� T���� k�� ���Ϸ� �߰������� �Ͽ� �� �� �ִ� �׷ο����� �ּ� ������ �뷮�� �ش��ϴ� ������ ����Ѵ�. 
 * 708
 */
public class LightAirCraft232 {
	// Spot�� �߰������� �������� ���� ����
	private static Spot[] spots;
	// k�� ���� ����
	private static int k;
	// �߰������� ����
	private static int spotNum;
	// �ּҰ��� ���ϱ� ���� ����
	private static int ans = 987654321;
	
	public static void main(String[] args) {
		 input();
		 // �����Ǿ� �ִ� �ʱⰪ
		 Spot start = new Spot(0,0);
		 // ����Լ�
		 solve(start, 0, 0);
		 // �ּҰ� ���
		 System.out.println(ans);
		 
	}
	
	/**
	 * �ּҰ��� ���ϱ� ���� ����Լ�
	 * @param temp : ��ο� �������� Spot ����
	 * @param count : �������� �߰� ���� ����
	 * @param d : spot���� �ּ� ������ �뷮
	 */
	private static void solve(Spot temp, int count, int d) {
		// �ּ� ������ �뷮�� ����ϱ� ���� ����
		int path = 0;
		
		// �������� �� �߰� ������ ������ ������ �� ����
		if(count == k) {
			// ������ ������������ �ּ� ������ ���
			path = sqrtSolve(temp, new Spot(10000,10000));
			// ��� �� ���� ���ݱ����� ������ �뷮���� Ŭ �� ����
			if(path > d) {
				d = path;
			}
			// �ּ� ���������� �˻�
			if( d < ans ) {
				ans = d;
			}
			// ����
			return;
		}
		
		//��� �߰������� ���� ��� �Լ� ȣ��
		for(int i=0; i<spotNum; i++) {
			// ������ �뷮 ���
			path = sqrtSolve(temp, spots[i]);
			// ��� �� ���� ���ݱ����� ������ �뷮���� Ŭ �� ����
			if(path > d) {
				d = path;
			}
			// �߰������� ��ǥ ����
			temp = spots[i];
			// ����Լ� ȣ��
			solve(temp,count+1,d);
		}
		
	}
	
	/**
	 * ������ �뷮 ���
	 * @param temp1 
	 * @param temp2
	 * @return
	 */
	private static int sqrtSolve(Spot temp1, Spot temp2) {
		int x = temp1.getX() - temp2.getX();
		int y = temp1.getY() - temp2.getY();
		int cacul = (int)Math.sqrt(x*x + y*y);
		return cacul/10 +1;
	}
	
	/**
	 * input function
	 */
	private static void input() {
		Scanner scan = new Scanner(System.in);
		spotNum = scan.nextInt();
		k = scan.nextInt();
		scan.nextLine();
		spots = new Spot[spotNum];
		
		for(int i = 0; i<spotNum; i++) {
			spots[i] = new Spot(scan.nextInt(), scan.nextInt());
			scan.nextLine();
		}
		
		scan.close();
	}

}

/**
 * @author suhhyun yeo
 * x��ǥ�� y��ǥ�� ��Ÿ���� class
 */
class Spot {
	private int x;
	private int y;
	
	public Spot() {
		x = 0;
		y = 0;
	}
	
	public Spot(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
