package algorithm193;

import java.util.Scanner;


/**
 * @author suhhyun yeo
 * â���� �˰��� �߱� p.193
 * 
 * [����]
 * � �賶�� W���Ը�ŭ ������ ���� �� �ִ�. 
 * ���ǵ��� (���� wi, ���� vi) ������ ������ �ִµ�, ���ǵ��� �����ؼ� ��� ������ ������ �ִ밡 �ǰ� �Ϸ��� �Ѵ�.
 * ���ǵ��� �� ������ �ۿ� ������, ���� �賶�� ���Ը� �ʰ��ؼ��� �� �ȴ�.
 * 
 * [�Է�]
 * ù° �ٿ� ������ ���� n(1<= n <= 100)�� �賶�� ���� w(1 <= w <= 10000)���Էµȴ�.
 * ��° �ٺ��� n+1°�� ���� ���ǵ��� ������ wi, vi�� �� �ٿ� �ϳ��� �Էµȴ�.
 * (1 <= wi, vi <= 100)
4 5
2 3
1 2
3 3
2 2
 * 
 * [���]
 * �賶�� ���� W�� �ʰ����� �����鼭 ������ ������ ������ �ִ��� ����Ѵ�.
 * 7
 * 
 */
public class Knapsack193 {
	// ������ ����
	private static int num;
	// �賭�� ����
	private static int weightSum;
	// ���ǵ��� ����
	private static KnapSack[] knapsack;
	// ������ ������ �ִ�
	private static int costSum = 0;
	
	public static void main(String[] args) {
		input();
		
		solve(0,0,0);
		
		System.out.println(costSum);
	}
	
	
	/**
	 * input function
	 */
	private static void input() {
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		weightSum = scan.nextInt();
		scan.nextLine();
		
		knapsack = new KnapSack[num];
		KnapSack temp;
		
		for(int i=0; i<num; i++) {
			temp = new KnapSack(scan.nextInt(), scan.nextInt());
			knapsack[i] = temp;
			scan.nextLine();
		}
		
		scan.close();
	}
	
	 
	/**
	 * ��üŽ������ ���� ��� solve �Լ�
	 * @param tempCostSum : ����ؼ� ���������� cost��.
	 * @param tempWeightSum : ����ؼ� ���������� weight ��.
	 * @param count : �賶 ������ �˻����ִ� ����
	 */
	private static void solve(int tempCostSum, int tempWeightSum, int count) {
		// tempCostSum�� costSum���� ũ��, tempWeightSum�� weightSum�� ���� ��, costSum�� tempCostSum�� �ȴ�.
		if(tempCostSum > costSum && tempWeightSum == weightSum) {
			costSum = tempCostSum;
		}
		// count�� num�� �Ѱų�, �賶 ���Ը� �ʰ��� ��� ����.
		if(count >= num || tempWeightSum > weightSum ) {
			return;
		}
		
		// ��üŽ������ ���� ��� �Լ� ȣ��
		solve(tempCostSum + knapsack[count].getCost(),tempWeightSum + knapsack[count].getWeight(), count+1);
		solve(tempCostSum, tempWeightSum, count+1);
	}
	
	
}	


/**
 * @author suhhyun yeo
 * �賶 ���Կ� ������ ������ Ŭ����
 */
class KnapSack {
	private int weight;
	private int cost;
	
	public KnapSack(int weight, int cost) {
		this.weight = weight;
		this.cost = cost;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
}