package algorithm208;

import java.util.Scanner;

/**
 * @author suhhyun yeo
 * 창의적알고리즘 p.208
 * 
 * [문제] 최장증가부분수열(longest increasing subsequence, 이하 LIS)
 * 두 전봇대 A와 B 사이에 하나 둘씩 전깃줄을 추가하다 보니 전깃줄이 서로 교차하는 경우가 발생하였다. 
 * 합선의 위험이 있어 이들 중 몇 개의 전깃줄을 없애 전깃줄이 교차하지 않도록 만들려고 한다.
 * 두 전봇대에 연결되는 위치의 번호가 주어질 때, 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 
 * 없애야 하는 전깃줄의 최소 개수를 구하는 프로그램을 작성하시오.
 * 
 * [입력]
 * 첫째 줄에는 두 전봇대 사이의 전깃줄의 개수가 주어진다. 전깃줄의 개수는 100이하의 자연수이다.
 * 둘째 줄부터 한 줄에 하나씩 전깃줄이 A전봇대와 연결되는 위치의 번호와 B전봇대와 연결되는 위치의 번호가 차례로 주어진다.
 * 위치의 번호는 500 이하의 자연수이고, 같은 위치에 두 개 이상의 전깃줄이 연결될 수 없다.
8
1 8
3 9
2 2
4 1
6 4
10 10
9 7
7 6
 *
 * [출력]
 *첫째 줄에 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 출력한다.
 * 3
 * 
 */
public class ElectricWire208 {
	private static int num;
	private static Wire[] wireData;
	
	public static void main(String[] args) {
		input();
		sort();	
		
		int temp ,max = 0;
		
		for(int i=0; i<num; i++) {
			temp = solve(i);
			if(max < temp) {
				max = temp;
			}
		}
		
		System.out.println(num - max);
		
	}
	
	 /**
	 * 입력 함수
	 */
	private static void input() {
		 Scanner scan = new Scanner(System.in);
		 num = scan.nextInt();
		 scan.nextLine();
		 wireData = new Wire[num];
		 Wire temp;
		 for(int i = 0; i < num; i++) {
			 temp = new Wire(scan.nextInt(), scan.nextInt());
			 wireData[i] = temp;
			 scan.nextLine();
		 }
		 scan.close();
	 }
	
	/**
	 * 주 로직 함수
	 * @param k
	 * @return
	 */
	private static int solve(int k) {
		int i, count = 1;
		for(i = k; i >= 0; i--) {
			// B의 위치를 오름차순으로 정렬할 수 있는 개수를 계산
			if(wireData[k].getBLocation() > wireData[i].getBLocation()) {
				// 더 긴 오름차순 정렬 개수를 count에 저장
				count = max(count, solve(i)+1);
			}
		}
		return count;
	}

	/**
	 * p와 q중에 더 큰 숫자를 반환
	 * @param p
	 * @param q
	 * @return
	 */
	private static int max(int p, int q) {
		return p > q ? p:q;
	}
	
	/**
	 * wireData의 A 위치의 오름차순을 기준으로 정렬
	 */
	private static void sort() {
		int temp = 0;
		for(int i=0; i<num; i++) {
			for(int j=i; j<num; j++) {
				if(wireData[i].getALocation() > wireData[j].getALocation()) {
					temp = wireData[i].getBLocation();
					wireData[i].setBLocation(wireData[j].getBLocation()); 
					wireData[j].setBLocation(temp);
					temp = wireData[i].getALocation();
					wireData[i].setALocation(wireData[j].getALocation()); 
					wireData[j].setALocation(temp);
				}
			}
		}
	}


}


/**
 * @author suhhyun yeo
 * A 위치와 B 위치를 저장하는 클래스
 */
class Wire {
	private int ALocation ; 
	private int BLocation ;
	
	public Wire() {
		ALocation = 0;
		BLocation = 0;
	}
	
	public Wire(int aLocation, int bLocation) {
		super();
		ALocation = aLocation;
		BLocation = bLocation;
	}



	public int getALocation() {
		return ALocation;
	}

	public void setALocation(int aLocation) {
		ALocation = aLocation;
	}

	public int getBLocation() {
		return BLocation;
	}

	public void setBLocation(int bLocation) {
		BLocation = bLocation;
	}
	
	
}
