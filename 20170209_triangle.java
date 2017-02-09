import java.util.Scanner;

/**
 * 
 * @author suhhyun Yeo
 * 
 * 창의적 알고리즘 p.115
 * [문제] 전체탐색법
 * 삼각화단 만들기
 * 
 * [입력]
 * 삼각형 화단 둘레의 길이는 반드시 주어진 화단 둘레의 길이와 같아야 한다. 
 * 또한, 화단 둘레의 길이와 각 변의 길이는 자연수이다.
 * 예) 9 (1<=n<=100)
 *
 * [출력]
 * 서로 다른 화단의 수 출력
 * 예) 3
 * 
 */

public class Main {
   // 카운트값
   private static int count = 0;
   // 이미 체크했다는 정보를 위한 check 배열
   private static int check[][][] = new int[21][21][21];
   
   public static void main(String[] args) {
      //-- 입력 start   
      Scanner scan = new Scanner(System.in);
      int num = scan.nextInt();
      scan.close();
      //-- 입력 end
      
      // 함수
      solve(num, 1, 1, 1);
      // 출력
      System.out.println(count);
   }

   private static void solve(int num, int a, int b, int c) {
      // a+b+c=num은 문제의 조건
      if(a+b+c==num) {
         
         // a를 가장 작은 변, c를 가장 큰변으로 설정 -> 1 3 4와  4 3 1의 중복이 발생하지 않기 위하여
         // a+b>c 삼각형의 가본 조건
         // check 방문 여부 함수 체크
         if(a<=b && b<=c && a+b>c && check[a][b][c]==0) {
            count++;
            check[a][b][c]=1;
         }
         // return값지 있지 않으면 계속해서 증가함.
         return;
      }
      
      // 현재 상태에서 3가지 경우의 수 발생
      solve(num ,a+1 ,b , c);
      solve(num ,a ,b+1 , c);
      solve(num ,a ,b , c+1);
      
   }
   

   
}