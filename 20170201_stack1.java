import java.util.Scanner;
import java.util.ArrayList;
/*
 * https://www.acmicpc.net/problem/10828
 * 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램 작성
 */

public class Main {
    private static ArrayList<Integer> stack = new ArrayList<Integer>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
        scan.nextLine();
        for(int k=0; k<testCase; k++) {
        	//System.out.println(k);
            String text = scan.nextLine();
            if(text.contains(" ")) {
            	//System.out.println(text.substring(5,6));
                push(Integer.parseInt(text.substring(5)));
            }else if(text.equals("pop")) {
                pop();
            }else if(text.equals("size")) {
                size();
            }else if(text.equals("empty")) {
                empty();
            }else if(text.equals("top")) {
               top();
            }
         }
        scan.close();
    }
    
    private static void push(int num) {
       stack.add(num);
    }
    
    private static void pop() {
         if(stack.size()==0) {
            System.out.println(-1);
        }else {
            System.out.println(stack.get(stack.size()-1));
            stack.remove(stack.size()-1);
        }
        
    }
    
    private static void size() {
        System.out.println(stack.size());
    }
    
    private static void empty() {
        if(stack.size()==0) {
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }
    
    private static void top() {
        if(stack.size()==0) {
            System.out.println(-1);
        }else {
            System.out.println(stack.get(stack.size()-1));
        }
    }
    
    
}