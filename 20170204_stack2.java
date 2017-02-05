import java.util.Scanner;
import java.util.Stack;

/*
 *  https://www.acmicpc.net/problem/9012
 *  ()의 정합이 맞는지 확인하여라.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
        scan.nextLine();
        // testCase만큼 입력받고 검사.
        for(int k=0; k<testCase; k++) {
            String text = scan.nextLine();
            String result = "";
            // (를 만나면 stack에 push(1) 연산.
            // )를 만나면 stack에 pop()연산.
            // stack에 아무것도 없었을 때, )를 만나면 NO출력
            Stack<Integer> stack = new Stack<Integer>();
            for(int i=0; i<text.length(); i++) {
            	if(text.substring(i, i+1).equals("(")) {
            		stack.push(1);
            	}else {
            		if(stack.size()==0) {
            			result = "NO";
            			break;
            		}else {
            			stack.pop();
            		}
            	}
            }
            // ()의 정합이 맞다면 stack.size()는 0이되어서
            // YES를 출력
            // 아닐 경우 NO를 출력
            if(result.equals("") && stack.size()==0) {
            	result = "YES";
            }else {
            	result ="NO";
            }
            System.out.println(result);
            
        }
        scan.close();
    }
}
