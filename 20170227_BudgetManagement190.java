package algorithm190;

import java.util.Scanner;

/**
 * @author suhhyun yeo â�����˰����� �߱� p.190 ��Ʈ��ŷ [����] ������� ���� ������ �ִ�� ����� �� �ִ� ������
 *         ���Ͻÿ�.
 * 
 *         [�Է�] ù° �ٿ� ���� ����(B)�� �Էµȴ�. ( 10 <= B <= 35,000 ) ��° �ٿ� ������ ����� �� �ִ�
 *         Ȱ���� ��(n)�� �Էµȴ�. (1 <= n <= 21 ) ��° �ٿ� ������ �������� n���� Ȱ���� ���� ������ �Էµȴ�.
 *         40 6 7 13 17 19 29 31
 *
 *         [���] ���� ������ �ʰ����� �����鼭 �ִ�� ����� �� �ִ� ������ ����Ѵ�. 39
 *
 */
public class BudgetManagement190 {
	// Ȱ���� �����ϴ� �迭
	private static int[] cost;

	// ����
	private static int budget;

	// Ȱ���� ��
	private static int num;

	// �ִ�� ����� �� �ִ� ����
	private static int sum;

	public static void main(String[] args) {
		// -- input start
		Input input = new Input();
		cost = input.inputData(cost);
		budget = input.getBudget();
		num = input.getNum();
		// -- input end

		solve(0, 0);

		System.out.println(sum);

	}

	
	/**
	 * ����Լ��� ���� �˻�
	 * @param tempSum : ����ؼ� ���س����� ��.
	 * @param count : Ȱ���� ���� �˻��ش� �ִ� ��.
	 */
	private static void solve(int tempSum, int count) {

		// budget���� �۰�, ���� �ִ� ���׺��� ���� ��� sum�� ����
		if (tempSum > sum && tempSum <= budget) {
			sum = tempSum;
		}

		// count�� num���� ũ��, tempSum�� ���꺸�� Ŭ ��, �ش� ���̽��� ����
		if (count >= num || tempSum > budget) {
			return;
		}

		// count 1���� ���ְ�, �� ���� ������ �����ְ�, �ٸ� ���� ������ ������ �ʴ´�.
		solve(tempSum + cost[count], count + 1);
		solve(tempSum, count + 1);

	}

}


/**
 * @author suhhyun yeo 
 * input class
 */
class Input {
	private int budget = 0;
	private int num = 0;

	public Input() {
		budget = 0;
		num = 0;
	}

	public int[] inputData(int[] cost) {
		Scanner scan = new Scanner(System.in);
		budget = scan.nextInt();
		scan.nextLine();
		num = scan.nextInt();
		scan.nextLine();

		cost = new int[num];

		for (int i = 0; i < num; i++) {
			cost[i] = scan.nextInt();
		}

		scan.close();

		return cost;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
