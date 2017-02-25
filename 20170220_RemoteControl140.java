package algorithm140;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author suhhyunYeo
 * 창의적 알고리즘 중급 p.180288                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
 * queue 너비우선탐색
 * [문제] 리모콘
 * 현재 설정 온도와 변경하고자 하는 목표 온도가 주어지면 
 * 이 버튼들을 이용하여목표 온도로 변경하고자 한다.
 * 이 때 버튼 누름의 최소 횟수를 구하시오.
 * 1) 온도를 1도 올리는 버튼
 * 2) 온도를 1도 내리는 버튼
 * 3) 온도를 5도 올리는 버튼
 * 4) 온도를 5도 내리는 버튼
 * 5) 온도를 10도 올리는 버튼
 * 6) 온도를 10도 내리는 버튼
 * 
 * [입력]
 * 현재 온도 a와 목표 온도 b가 입력된다(0 <= a, b <= 40).
 * 7 34
 * 
 * [출력]
 * 최소한의 버튼 사용으로 목표 온도가 되는 버튼 누름의 횟수를 출력한다.
 * 5
 * 
 */
public class RemoteControl140 {
	// res's range is 0 to 40
	private static int res = 40;
	private static int a , b;
	
	public static void main(String[] args) {
		// input start
		InputData input = new InputData();
		input.readData();
		b = input.getB();
		// input end
		
		ELE temp = new ELE();
		Queue<ELE> que = new LinkedList<ELE>();
		que.add(new ELE(input.getA(), 0));
		
		while(!que.isEmpty()) {
			temp = que.peek();
			que.poll();
			if(temp.getVertex() == b) {
				break;
			}
			if(temp.getVertex() < b) {
				que.add(new ELE(temp.getVertex()+10, temp.getCount()+1));
				que.add(new ELE(temp.getVertex()+5, temp.getCount()+1));
				que.add(new ELE(temp.getVertex()+1, temp.getCount()+1));
			}else {
				que.add(new ELE(temp.getVertex()-10, temp.getCount()+1));
				que.add(new ELE(temp.getVertex()-5, temp.getCount()+1));
				que.add(new ELE(temp.getVertex()-1, temp.getCount()+1));
			}
		}
		
		// output start
		OutputData output = new OutputData();
		output.printData(temp.getCount());
		// output end
	}

}

class ELE {
	private int vertex;
	private int count;
	
	public ELE() {
		
	}
	
	public ELE(int vertex, int count) {
		this.vertex = vertex;
		this.count = count;
	}

	public int getVertex() {
		return vertex;
	}

	public void setVertex(int vertex) {
		this.vertex = vertex;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}

class OutputData {
	public OutputData() {
		
	}
	
	public void printData(int data) {
		System.out.println(data);
	}
}

class InputData {
	private int a ;
	private int b ;
	
	public InputData() {
		a = 0;
		b = 0;
	}
	
	public void readData() {
		Scanner scan = new Scanner(System.in);
		a = scan.nextInt();
		b = scan.nextInt();
		scan.close();
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
}
