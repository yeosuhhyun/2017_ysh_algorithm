import java.util.ArrayList;
import java.util.Scanner;


/*
 * https://www.acmicpc.net/problem/10845
 * 큐를 구현하라.
 */

public class Main {
	private static ArrayList<Integer> queue = new ArrayList<Integer>();
	static int front = 0;
	static int rear = -1;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCase = scan.nextInt();
		scan.nextLine();
		
		
		
		for(int k =0; k<testCase; k++) {
			String text = scan.nextLine();
			if(text.contains(" ")) {
				push(Integer.parseInt(text.substring(5)));
			}else {
				if(text.equals("pop"))
					pop();
				else if(text.equals("size")) 
					size();
				else if(text.equals("empty"))
					empty();
				else if(text.equals("front"))
					front();
				else if(text.equals("back"))
					back();
			}
			
		}
		scan.close();
	}

	private static void push(int num) {
		queue.add(num);
		rear++;
	}
	
	private static void pop() {
		if(queue.size()==0) {
			System.out.println(-1);
		}else {
			System.out.println(queue.get(front));
			queue.remove(front);
			rear--;
		}
	}
	
	private static void size() {
		System.out.println(queue.size());
	}
	
	private static void empty() {
		if(queue.size()==0) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
	
	private static void front() {
		if(queue.size()==0) {
			System.out.println(-1);
		}else {
			System.out.println(queue.get(front));
		}
	}
	
	private static void back() {
		if(queue.size()==0) {
			System.out.println(-1);
		}else {
			System.out.println(queue.get(rear));
		}
	}
}