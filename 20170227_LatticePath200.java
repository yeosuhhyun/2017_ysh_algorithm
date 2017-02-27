package algorithm200;

import java.util.Scanner;

/**
 * @author suhhyun yeo
 * 창의적 알고리즘 중급 p.200
 * 
 * [문제] 전체탐색법
 * H*W 격자에서 왼쪽 위(0,0)에서 오른쪽 아래(H, W)까지 갈 수 있는 길의 수를 헤아리고자 한다.
 * 길을 갈 때 몇 가지 제약사항이 있다.
 * (1) 격자 위의 선을 따라간다.
 * (2) 아래쪽 또는 오른쪽으로만 갈 수 있다.
 * (3) (0,0)과 (H, W)를 잇는 대각선보다 위쪽에 있는 점들은 통과할 수 없다.
 * (대각선에 위치하는 점은 통과할 수 있다.)
 * 
 * [입력]
 * 1. 두 개의 정수 H와 W가 입력된다.
 * 2. H는 격자의 세로 크기를, W는 격자의 가로 크기를 각각 나타낸다.
 * [입력값의 정의역]
 * 1 <= H, W <= 10
3 4
 * 
 * [출력]
 * (0,0)에서 (H, W)까지 갈 수 있는 길의 수를 출력한다.
 * 5
 * 
 */
public class LatticePath200 {
	// height
	private static int H;
	
	// weight
	private static int W;
	
	// answer
	private static int ans;
	
	public static void main(String[] args) {
		input();
		solve(0,0);
		System.out.println(ans);
	}
	
	/**
	 * input function
	 */
	private static void input() {
		Scanner scan = new Scanner(System.in);
		H = scan.nextInt();
		W = scan.nextInt();
		scan.close();
	}
	
	
	/**
	 * 좌표가 종료지점까지 이동하는 재귀 함수.
	 * 1. 아래쪽으로 이동하는 경우, 2. 오른쪽으로 이동하는 경우
	 * 두가지로 나누어서 전체탐색법을 이용함.
	 * @param h
	 * @param w
	 */
	private static void solve(int h, int w) {
		// 좌표가 기준 격자 밖으로 나가는 경우 종료.
		if(h > H || w > W) {
			return;
		}
		
		// 좌표가 종료지점에 도착했을 때, ans 1 증가
		if(h == H && w == W) {
			ans++;
			return;
		}
		
		// 1. 아래쪽으로 이동하는 경우
		solve(h+1, w);
		
		// 2. 오른쪽으로 이동하는 경우 (대각선 위의 경우는 가지 못하니까)
		if((double)H/W <= (double)h/(w+1)) {
			solve(h, w+1);
		}
	}
}
