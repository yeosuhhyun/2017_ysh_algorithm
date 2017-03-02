package algorithm220;

import java.util.Scanner;
/**
 * @author suhhyun yeo
 * â�����˰��� �߱� p.220
 * 
 * ��ü Ž����
 * 
 * [����]
 * ���� ���ο����� ó���� ����� ������ �� ����� �߻��� ��ġ�� �� ���� �������� �ϳ��� �˷� �ְ�, 
 * ���� ���� �������� �� ��ġ�� ���� ���� ���� ���� �̵��Ͽ� ����� ó���Ѵ�(�ϳ��� ����� �� ���� �������� ó���Ѵ�.).
 * �׸��� ����� ó�� �� �������� ���� ���ηκ��� ���� ������ �� ������ ó���� ����� �߻��� ��ġ���� ��ٸ���. 
 * ���� ���ο����� ����� �߻��� ������� �� ���� �������� �ñ���� �Ѵ�.
 *
 * [�Է�]
 * �Է� ������ ù° �ٿ��� �������� ������ ������ ��Ÿ���� ���� n(3��n��1,000)�� �־�����.
 * ��° �ٿ��� ó���ؾ� �ϴ� ����� ������ ��Ÿ���� ���� w(1��w��15)�� �־�����.
 * ��° �ٺ��� (w+2)��° �ٱ��� ����� �߻��� ��ġ�� �� �ٿ� �ϳ��� �־�����.
 * ���������� �� ��ǵ��� �־��� ������� ó���ؾ� �Ѵ�.
 * �� ��ġ�� �������� ���� ��ȣ�� ��Ÿ���� ������ ���Ϲ��� ���� ��ȣ�� ��Ÿ����
 * ������ �־����� �� ���� ���̿��� �� ĭ�� �ϳ� �ִ�. �� ����� �߻��� ��ġ�� ���� �� �ִ�.
6
3
3 5
5 5
2 3
 *
 * [���]
 * ù° �ٿ� �� �������� �̵��� �� �Ÿ��� ����Ѵ�.
 * 9
 * 
 */
public class PoliceCar220 {
	// ������ ������ �޴� ����
	private static int num;
	// ����� ������ �޴� ����
	private static int workNum;
	// ����� ������ �޴� ����
	private static Police[] matrix;
	// �ּҰ��� �ޱ� ���� ����(�ִ밪���� ����)
	private static int ans = 987654321;
	
	public static void main(String[] args) {
		input();
		
		// ����Լ�
		solve(matrix[0], matrix[1], 0, 0);
		
		System.out.println(ans);
	}
	
	/**
	 * ��üŽ�������� �ϱ� ���� ��� �Լ�.
	 * @param tempA : ������1
	 * @param tempB : ������2
	 * @param count : workNum�� ���� ����
	 * @param sum : �� �̵� �Ÿ�
	 */
	private static void solve(Police tempA, Police tempB, int count, int sum) {
		// �־��� ����� ������ ���� �ذ��Ͽ��ٸ� ����
		if(count == workNum) {
			// �ּ� �̵� �Ÿ��� ���ϱ� ���� ���ǹ�
			if(sum < ans) {
				ans = sum;
			}
			return;
		}
		
		// �� �ܰ��� ������1�� ������2�� �����ϱ� ���� ����
		Police temp;
		
		// ���1) ������1�� �ش� ����� �ذ��ϴ� ���
		int d = Math.abs(matrix[count+2].getX()-tempA.getX()) + Math.abs(matrix[count+2].getY() - tempA.getY());
		// ���2�� ���� ���� ������1�� ��ġ�� �ӽ� ����
		temp = tempA;
		// ���1�̱⿡ ������1�� ����� ��ġ�� ����
		tempA = matrix[count+2];
		// ����Լ� ȣ��
		solve( tempA, tempB ,count+1 ,sum+d);
		
		// ���2) ������2�� �ش� ����� �ذ��ϴ� ���
		d=  Math.abs(matrix[count+2].getX()-tempB.getX()) + Math.abs(matrix[count+2].getY() - tempB.getY());
		// ���1���� ������ ������1�� ��ġ�� �ٽ� ����
		tempA = temp;
		// ���2�̱⿡ ������2�� ����� ��ġ�� ����
		tempB = matrix[count+2];
		// ����Լ� ȣ��
		solve(tempA, tempB, count+1, sum+d);		
	}

	
	/**
	 * input function 
	 */
	private static void input() {
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		scan.nextLine();
		
		workNum = scan.nextInt();
		scan.nextLine();
		
		// matrix�� ������1�� ������2�� �����ϰ� work�� ������ ����.
		matrix = new Police[workNum+2];
		
		// ������ 1 ����
		Police temp = new Police(1, 1);
		matrix[0] = temp;
		
		// ������ 2 ����
		temp = new Police(num, num);
		matrix[1] = temp;
		
		// work�� ���� ����
		for(int i=2; i<workNum+2; i++) {
			temp = new Police(scan.nextInt(), scan.nextInt());
			matrix[i] = temp;
			scan.nextLine();
		}
		
		scan.close();
	}
	
	
	


}

/**
 * @author suhhyun yeo
 * x�� y��ǥ�� ���� class 
 */
class Police {
	private int x;
	private int y;
	
	public Police() {
		x = 0;
		y = 0;
	}
	public Police(int x, int y) {
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
