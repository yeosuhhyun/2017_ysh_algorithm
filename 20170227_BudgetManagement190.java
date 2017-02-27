package algorithm190;

import java.util.Scanner;

/**
 * @author suhhyun yeo 창의적알고지름 중급 p.190 백트랙킹 [문제] 예산관리 예산 내에서 최대로 사용할 수 있는 비용액을
 *         구하시오.
 * 
 *         [입력] 첫째 줄에 남은 예산(B)이 입력된다. ( 10 <= B <= 35,000 ) 둘째 줄에 예산을 사용할 수 있는
 *         활동의 수(n)가 입력된다. (1 <= n <= 21 ) 셋째 줄에 공백을 기준으로 n개의 활동비가 양의 정수로 입력된다.
 *         40 6 7 13 17 19 29 31
 *
 *         [출력] 남은 예산을 초과하지 않으면서 최대로 사용할 수 있는 비용액을 출력한다. 39
 *
 */
public class BudgetManagement190 {
	// 활동비 저장하는 배열
	private static int[] cost;

	// 예산
	private static int budget;

	// 활동의 수
	private static int num;

	// 최대로 사용할 수 있는 비용액
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
	 * 재귀함수를 통해 검사
	 * @param tempSum : 계속해서 합해나가는 값.
	 * @param count : 활동의 수를 검사해는 주는 값.
	 */
	private static void solve(int tempSum, int count) {

		// budget보다 작고, 현재 최대 비용액보다 작은 경우 sum에 저장
		if (tempSum > sum && tempSum <= budget) {
			sum = tempSum;
		}

		// count가 num보다 크고, tempSum이 예산보다 클 때, 해당 케이스는 종료
		if (count >= num || tempSum > budget) {
			return;
		}

		// count 1증가 해주고, 한 경우는 비용액을 더해주고, 다른 경우는 비용액을 더하지 않는다.
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
