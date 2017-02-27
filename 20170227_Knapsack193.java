package algorithm193;

import java.util.Scanner;


/**
 * @author suhhyun yeo
 * 창의적 알고리즘 중급 p.193
 * 
 * [문제]
 * 어떤 배낭에 W무게만큼 물건을 담을 수 있다. 
 * 물건들은 (무게 wi, 가격 vi) 정보를 가지고 있는데, 물건들을 조합해서 담아 가격의 총합이 최대가 되게 하려고 한다.
 * 물건들은 한 종류씩 밖에 없으며, 절대 배낭의 무게를 초과해서는 안 된다.
 * 
 * [입력]
 * 첫째 줄에 물건의 개수 n(1<= n <= 100)과 배낭의 무게 w(1 <= w <= 10000)가입력된다.
 * 둘째 줄부터 n+1째줄 까지 물건들의 정보가 wi, vi가 한 줄에 하나씩 입력된다.
 * (1 <= wi, vi <= 100)
4 5
2 3
1 2
3 3
2 2
 * 
 * [출력]
 * 배낭의 무게 W를 초과하지 않으면서 물건의 가격의 총합의 최댓값을 출력한다.
 * 7
 * 
 */
public class Knapsack193 {
	// 물건의 갯수
	private static int num;
	// 배난의 무게
	private static int weightSum;
	// 물건들의 정보
	private static KnapSack[] knapsack;
	// 가격의 총합의 최댓값
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
	 * 전체탐색법을 위한 재귀 solve 함수
	 * @param tempCostSum : 계속해서 더해져가는 cost값.
	 * @param tempWeightSum : 계속해서 더해져가는 weight 값.
	 * @param count : 배낭 갯수를 검사해주는 변수
	 */
	private static void solve(int tempCostSum, int tempWeightSum, int count) {
		// tempCostSum이 costSum보다 크고, tempWeightSum이 weightSum과 같을 때, costSum이 tempCostSum이 된다.
		if(tempCostSum > costSum && tempWeightSum == weightSum) {
			costSum = tempCostSum;
		}
		// count가 num이 넘거나, 배낭 무게를 초과할 경우 종료.
		if(count >= num || tempWeightSum > weightSum ) {
			return;
		}
		
		// 전체탐색법을 위한 재귀 함수 호출
		solve(tempCostSum + knapsack[count].getCost(),tempWeightSum + knapsack[count].getWeight(), count+1);
		solve(tempCostSum, tempWeightSum, count+1);
	}
	
	
}	


/**
 * @author suhhyun yeo
 * 배낭 무게와 가격을 저장할 클래스
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