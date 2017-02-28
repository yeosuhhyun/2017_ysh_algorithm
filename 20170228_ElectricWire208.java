package algorithm208;

import java.util.Scanner;

/**
 * @author suhhyun yeo
 * â�����˰��� p.208
 * 
 * [����] ���������κм���(longest increasing subsequence, ���� LIS)
 * �� ������ A�� B ���̿� �ϳ� �Ѿ� �������� �߰��ϴ� ���� �������� ���� �����ϴ� ��찡 �߻��Ͽ���. 
 * �ռ��� ������ �־� �̵� �� �� ���� �������� ���� �������� �������� �ʵ��� ������� �Ѵ�.
 * �� �����뿡 ����Ǵ� ��ġ�� ��ȣ�� �־��� ��, �����ִ� ��� �������� ���� �������� �ʰ� �ϱ� ���� 
 * ���־� �ϴ� �������� �ּ� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * [�Է�]
 * ù° �ٿ��� �� ������ ������ �������� ������ �־�����. �������� ������ 100������ �ڿ����̴�.
 * ��° �ٺ��� �� �ٿ� �ϳ��� �������� A������� ����Ǵ� ��ġ�� ��ȣ�� B������� ����Ǵ� ��ġ�� ��ȣ�� ���ʷ� �־�����.
 * ��ġ�� ��ȣ�� 500 ������ �ڿ����̰�, ���� ��ġ�� �� �� �̻��� �������� ����� �� ����.
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
 * [���]
 *ù° �ٿ� �����ִ� ��� �������� ���� �������� �ʰ� �ϱ� ���� ���־� �ϴ� �������� �ּ� ������ ����Ѵ�.
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
	 * �Է� �Լ�
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
	 * �� ���� �Լ�
	 * @param k
	 * @return
	 */
	private static int solve(int k) {
		int i, count = 1;
		for(i = k; i >= 0; i--) {
			// B�� ��ġ�� ������������ ������ �� �ִ� ������ ���
			if(wireData[k].getBLocation() > wireData[i].getBLocation()) {
				// �� �� �������� ���� ������ count�� ����
				count = max(count, solve(i)+1);
			}
		}
		return count;
	}

	/**
	 * p�� q�߿� �� ū ���ڸ� ��ȯ
	 * @param p
	 * @param q
	 * @return
	 */
	private static int max(int p, int q) {
		return p > q ? p:q;
	}
	
	/**
	 * wireData�� A ��ġ�� ���������� �������� ����
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
 * A ��ġ�� B ��ġ�� �����ϴ� Ŭ����
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
