package algorithm232;

import java.util.Scanner;

/**
 * @author suhhyun yeo
 * 창의적알고리즘 p.232
 * 전체탐색법
 * [문제]
 * 1) 모든 비행기는 두 지점 사이를 반드시 직선으로 날아간다. 거리의 단위는 km이며 연료의 단위는 ℓ(리터)이다. 
 * 1ℓ당 비행거리는 10km이고 연료 주입은 ℓ 단위로 한 다.
 * 2) 두 위치 간의 거리는 평면상의 거리이다. 
 * 예를 들면, 두 점 g = (2, 1)와 h = (37, 43) 간의 거리 d(g, h)는 sqrt{ (2-37)^2 + (1-43)^2 }= 54.671이고 
 * 50 < d(g, h) ≤ 60이므로 필요한 연료는 6ℓ가 된다. 
 * 3) 출발지 S의 좌표는 항상 (0, 0)이고 목적지 T의 좌표는 (10000,10000)으로 모든 입력 데이터에서 고정되어 있다. 
 * 4) 출발지와 목적지를 제외한 비행장의 수 n은 3 <= n <= 10이고 그 좌표값 (x, y) 의 범위는 0 < x, y < 10,000인 정수이다. 
 * 그리고 0 <= k <= 1000이다.
 * 
 * [입력]
 * 입력의 첫 줄에는 n과 k가 하나의 공백을 두고 주어진다.
 * 그 다음 n개의 줄에는 각 비행장(급유지)의 정수좌표가 "x y"의 형식으로 주어진다.
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
 * [출력]
 * 출력에는 S에서 T까지 k번 이하로 중간급유를 하여 갈 수 있는 항로에서의 최소 연료통 용량에 해당하는 정수를 출력한다. 
 * 708
 */
public class LightAirCraft232 {
	// Spot인 중간지점의 정보들을 받을 변수
	private static Spot[] spots;
	// k번 경유 가능
	private static int k;
	// 중간지점의 개수
	private static int spotNum;
	// 최소값을 구하기 위한 변수
	private static int ans = 987654321;
	
	public static void main(String[] args) {
		 input();
		 // 고정되어 있는 초기값
		 Spot start = new Spot(0,0);
		 // 재귀함수
		 solve(start, 0, 0);
		 // 최소값 출력
		 System.out.println(ans);
		 
	}
	
	/**
	 * 최소값을 구하기 위한 재귀함수
	 * @param temp : 경로에 지나가는 Spot 변수
	 * @param count : 지나가는 중간 지점 개수
	 * @param d : spot간의 최소 연료통 용량
	 */
	private static void solve(Spot temp, int count, int d) {
		// 최소 연료통 용량을 계산하기 위한 변수
		int path = 0;
		
		// 지나가야 할 중간 지점의 개수를 끝냈을 때 종료
		if(count == k) {
			// 고정된 도착지점과의 최소 연료통 계산
			path = sqrtSolve(temp, new Spot(10000,10000));
			// 계산 한 값이 지금까지의 연료통 용량보다 클 때 저장
			if(path > d) {
				d = path;
			}
			// 최소 연료통인지 검사
			if( d < ans ) {
				ans = d;
			}
			// 종료
			return;
		}
		
		//모든 중간지점에 대한 재귀 함수 호출
		for(int i=0; i<spotNum; i++) {
			// 연료통 용량 계산
			path = sqrtSolve(temp, spots[i]);
			// 계산 한 값이 지금까지의 연료통 용량보다 클 때 저장
			if(path > d) {
				d = path;
			}
			// 중간지점의 좌표 저장
			temp = spots[i];
			// 재귀함수 호출
			solve(temp,count+1,d);
		}
		
	}
	
	/**
	 * 연료통 용량 계산
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
 * x좌표와 y좌표를 나타내는 class
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
