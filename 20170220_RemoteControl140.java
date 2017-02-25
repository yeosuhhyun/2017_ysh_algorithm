package algorithm140;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author suhhyunYeo
 * â���� �˰��� �߱� p.180288                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
 * queue �ʺ�켱Ž��
 * [����] ������
 * ���� ���� �µ��� �����ϰ��� �ϴ� ��ǥ �µ��� �־����� 
 * �� ��ư���� �̿��Ͽ���ǥ �µ��� �����ϰ��� �Ѵ�.
 * �� �� ��ư ������ �ּ� Ƚ���� ���Ͻÿ�.
 * 1) �µ��� 1�� �ø��� ��ư
 * 2) �µ��� 1�� ������ ��ư
 * 3) �µ��� 5�� �ø��� ��ư
 * 4) �µ��� 5�� ������ ��ư
 * 5) �µ��� 10�� �ø��� ��ư
 * 6) �µ��� 10�� ������ ��ư
 * 
 * [�Է�]
 * ���� �µ� a�� ��ǥ �µ� b�� �Էµȴ�(0 <= a, b <= 40).
 * 7 34
 * 
 * [���]
 * �ּ����� ��ư ������� ��ǥ �µ��� �Ǵ� ��ư ������ Ƚ���� ����Ѵ�.
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
