package algorithm264;

import java.util.Scanner;

/**
 * @author suhhyun yeo
 * 창의적 알고리즘 중급 p.264
 * 수학적 계산을 토대로 처리의 효율을 높게함.
 * 1) 임의의 자연수 n이 소수라면 [2, n]에서 약수는 존재하지 않는다.
 * 2) 앞의 문제의 개념을 대입하면 [2, 루트n]의 범위가 된다.
 * 
 * [문제]
 * n번째로 큰 소수의 합을 구하여 출력하라.
 * 
 * [입력]
 * 정수 n을 입력
 * (1 <= n <= 100000)
 * 
 * [출력]
 * n번째로 큰 소수를 출력
 * 
 */
public class PrimeNumber264 {
   // 입력받을 정수
   private static int number; 
   
   public static void main(String[] args) {
      // 입력 함수
      input();
      
      // number번 째인 소수를 구하는 로직
      int i = 1;
      int num = 2;
      while(i <= number) {
         // num이 소수라면 num값을 반환
         if(solve(num)!=0) {
            i++;
         }
         num++;
      }
      
      // 결과 출력
      System.out.println(num-1);
   }
   
   
   /**
    * 소수를 구하는 함수
    * @param num : 정수 
    * @return num : 소수라면 num 반환, 아니라면 0 반환
    */
   private static int solve(int num) {
      
      for(int i= 2; i*i <=num; i++) {
         // 1을 제외한 수에 나누어 나머지가 0이면 소수가 아님
         if(num % i == 0) {
            return 0;
         }
      }
      
      return num;
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
