package algorithm220;

import java.util.Scanner;
/**
 * @author suhhyun yeo
 * 창의적알고리즘 중급 p.220
 * 
 * 전체 탐색법
 * 
 * [문제]
 * 경찰 본부에서는 처리할 사건이 있으면 그 사건이 발생된 위치를 두 대의 경찰차중 하나에 알려 주고, 
 * 연락 받은 경찰차는 그 위치로 가장 빠른 길을 통해 이동하여 사건을 처리한다(하나의 사건은 한 대의 경찰차가 처리한다.).
 * 그리고 사건을 처리 한 경찰차는 경찰 본부로부터 다음 연락이 올 때까지 처리한 사건이 발생한 위치에서 기다린다. 
 * 경찰 본부에서는 사건이 발생한 순서대로 두 대의 경찰차에 맡기려고 한다.
 *
 * [입력]
 * 입력 파일의 첫째 줄에는 동서방향 도로의 개수를 나타내는 정수 n(3≤n≤1,000)이 주어진다.
 * 둘째 줄에는 처리해야 하는 사건의 개수를 나타내는 정수 w(1≤w≤15)가 주어진다.
 * 셋째 줄부터 (w+2)번째 줄까지 사건이 발생된 위치가 한 줄에 하나씩 주어진다.
 * 경찰차들은 이 사건들을 주어진 순서대로 처리해야 한다.
 * 각 위치는 동서방향 도로 번호를 나타내는 정수와 남북방향 도로 번호를 나타내는
 * 정수로 주어지며 두 정수 사이에는 빈 칸이 하나 있다. 두 사건이 발생한 위치가 같을 수 있다.
6
3
3 5
5 5
2 3
 *
 * [출력]
 * 첫째 줄에 두 경찰차가 이동한 총 거리를 출력한다.
 * 9
 * 
 */
public class PoliceCar220 {
	// 격자의 정보를 받는 변수
	private static int num;
	// 사건의 개수를 받는 변수
	private static int workNum;
	// 사건의 정보를 받는 변수
	private static Police[] matrix;
	// 최소값을 받기 위한 변수(최대값으로 설정)
	private static int ans = 987654321;
	
	public static void main(String[] args) {
		input();
		
		// 재귀함수
		solve(matrix[0], matrix[1], 0, 0);
		
		System.out.println(ans);
	}
	
	/**
	 * 전체탐색법으로 하기 위한 재귀 함수.
	 * @param tempA : 경찰차1
	 * @param tempB : 경찰차2
	 * @param count : workNum의 현재 개수
	 * @param sum : 총 이동 거리
	 */
	private static void solve(Police tempA, Police tempB, int count, int sum) {
		// 주어진 사건의 개수를 전부 해결하였다면 종료
		if(count == workNum) {
			// 최소 이동 거리를 구하기 위한 조건문
			if(sum < ans) {
				ans = sum;
			}
			return;
		}
		
		// 각 단계의 경찰차1과 경찰차2를 저장하기 위한 변수
		Police temp;
		
		// 경우1) 경찰차1이 해당 사건을 해결하는 경우
		int d = Math.abs(matrix[count+2].getX()-tempA.getX()) + Math.abs(matrix[count+2].getY() - tempA.getY());
		// 경우2를 위해 현재 경찰차1의 위치를 임시 저장
		temp = tempA;
		// 경우1이기에 경찰차1에 사건의 위치를 저장
		tempA = matrix[count+2];
		// 재귀함수 호출
		solve( tempA, tempB ,count+1 ,sum+d);
		
		// 경우2) 경찰차2가 해당 사건을 해결하는 경우
		d=  Math.abs(matrix[count+2].getX()-tempB.getX()) + Math.abs(matrix[count+2].getY() - tempB.getY());
		// 경우1에서 저장한 경찰차1의 위치를 다시 저장
		tempA = temp;
		// 경우2이기에 경찰차2에 사건의 위치를 저장
		tempB = matrix[count+2];
		// 재귀함수 호출
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
		
		// matrix에 경찰차1과 경찰차2를 저장하고 work의 정보를 저장.
		matrix = new Police[workNum+2];
		
		// 경찰차 1 저장
		Police temp = new Police(1, 1);
		matrix[0] = temp;
		
		// 경찰차 2 저장
		temp = new Police(num, num);
		matrix[1] = temp;
		
		// work의 정보 저장
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
 * x와 y좌표를 갖는 class 
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
