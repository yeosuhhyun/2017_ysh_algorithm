import java.util.Scanner;

/**
 * 
 * @author suhhyun Yeo
 * 
 * 창의적 알고리즘 p.108 전체탐색법
 * [문제] 약수의 합 구하기
 * 한 정수 n을 입력받아서 n의 모든 약수의 합을 구하는 프로그램을 작성하시오.
 * 예를 들어 10의 약수인 1, 2, 5, 10이므로 합은 18
 * 
 * [입력]
 * 10 (1<= n <= 100000)
 * 
 * [출력]
 * n의 약수의 합 출력
 * 18
 *
 */

public class Main {
   public static void main(String[] args) {
      //---입력 start
      Scanner scan = new Scanner(System.in);
      int num = scan.nextInt();
      scan.close();
      //---입력 end
      
      // 소수의 합을 구하는 함수 return 값 출력
      System.out.println(solve(num));
   }
   
   // 소수의 합을 구하는 함수
   private static int solve(int num) {
      int ans = 0;
      for(int i=1; i<=num; i++) {
         // 0으로 나누어지는 수 ans에 계속해서 더함.
         if(num%i==0) {
            ans+=i;
         }
      }
      return ans;
   }
}