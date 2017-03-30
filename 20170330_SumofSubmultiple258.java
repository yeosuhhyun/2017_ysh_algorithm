package algorithm258;

import java.util.Scanner;

/**
 * @author suhhyun yeo
 * 창의적 알고리즘 중급 p.258
 * 수학적 계산을 토대로 처리의 효율을 높게함.
 * 1) 모든 자연수 n에 대하여, 2이상 n미만의 자연수 들 중 가장 큰 n의 약수는 n/2를 넘지 않는다.
 * 2) 완전 제곱수의 예를 생각해보면 4*4 = 16 중간에 있는 약수의 크기는 루트n을 넘지 않는다.
 * 3) i < 루트n 와 i^2 < n 은 같은 맥락에서 이해할 수 있다.
 * 4) for(i = 1; i*i <= n; i++) 완성
 * 
 * [문제]
 * 한 정수 n의 약수의 합을 구하라.
 * 
 * [입력]
 * 정수 n을 입력
 * 
 * [출력]
 * n의 약수의 합을 출력
 * 
 */
public class SumofSubmultiple258 {
   // 입력받을 정수
   private static int number; 
   
   public static void main(String[] args) {
      // 입력 함수
      input();
      // 결과 출력
      System.out.println(solve());
   }
   
   /**
    * 약수의 합을 구하는 함수
    * @return
    */
   private static int solve() {
      int ans = 0, i = 0;
      // 수학적 계산을 통한 조건문
      for(i = 1; i * i <= number; i++) {
         if(number % i == 0) {
            ans += (i + number/i);
         }
      }
      
      // 완전 제곱수를 고려하였을 때, 더하는 수
      if(i*i==number) ans+=i;
      
      return ans;
   }
   
   /**
    * 입력 함수
    */
   private static void input() {
      Scanner scan  = new Scanner(System.in);
      number = scan.nextInt();
      scan.close();
   }
}
