package algorithm249;

import java.util.Scanner;

 
/**
 * @author suhyun yeo
 * 창의적 알고리즘 중급 p.249 
 * 재귀 함수를 이용한 전체탐색법
 * [문제]
 * 하나의 펌프에는 하나의 소방차만 연결될 수 있다. 사용하는 호스의 길이는 펌프와소방차 사이의 거리이다. 
 * 펌프들의 위치와 소방차들의 위치가 주어질 때 호스 길이의 합을 최소로 하면서 펌프들을 소방차들에 연결하는 방법을 구하는 프로그램을 작성하시오.
 * 
 * [일력]
 * 첫째 줄에는 펌프의 수를 나타내는 정수 p와 소방차의 수를 나타내는 f가 주어진다. 1 ≤ p ≤ 11이고 1 ≤ f ≤ 10이며 p≥f이다.
 * 둘째 줄에는 펌프들의 위치를 나타내는 서로 다른 p개의 정수가 오름차순으로 주어진다. 
 * 셋째 줄에는 소방차들의 위치를나타내는 서로 다른 f개의 정수가 오름차순으로 주어진다.
 * 펌프와 소방차가 같은 위치에 있을 수도 있다. 주어진 정수는 모두 1,000,000 이하의 양수이다
 * 
3 2
12 50 81
27 73
 *
 * [출력]
 * 사용하는 호스 길이의 합을 출력한다. 출력 결과는 2^31 - 1을 넘지 않는다.
 * 
 * 23
 */
public class FireEngine249 {
   // 펌프 정보를 갖고 있는 변수
   private static Pump[] pump;
   // 소방차 정보를 갖고 있는 변수
   private static int[] fireEngine;
   
   // 펌프 수
   private static int pumpNum;
   // 소방차 수
   private static int fireEngineNum;
   
   // 임의의 큰 값 설정
   private static int sum = 999999999;
   
   public static void main(String[] args) {
      // 입력
      input();
      
      // 재귀 함수 호출
      for(int i=0; i<pumpNum; i++) {
         solve(0, i, 0);
      }
      
      // 최소값 출력
      System.out.println(sum);
   }
   
   /**
    * 전체탐새을 위한 함수
    * @param num : 소방차와 펌프의 거리를 더해가는 변수
    * @param pumpCount : 펌프
    * @param fireCount : 소방차
    */
   private static void solve(int num, int pumpCount, int fireCount) {
      // 재귀 과정에서 현재 최솟값보다 크다면 종료
      if(num > sum) {
         return;
      } 
      
      // 하나의 경우의 수를 전부 보았을 때, 최솟값을 설정하고 종료
      if(fireCount >= fireEngineNum) {
         sum = num;
         return;
      }
      
      // 거리 계산해서 더함
      num = num + Math.abs(pump[pumpCount].getLocation()-fireEngine[fireCount]);
      pump[pumpCount].setVisited(1);
      // 재귀함수 호출
      for(int i = 0; i<pumpNum; i++) {
         // 방문여부를 통해 본인의 펌프는 포함하지 않음
         if(pump[i].getVisited()==0) {
            solve(num, i, fireCount+1);
            pump[i].setVisited(0);
         }
      }
      
   }
   

   
   /**
    *  입력함수
    */
   private static void input() {
      Scanner scan = new Scanner(System.in);
      pumpNum = scan.nextInt();
      fireEngineNum = scan.nextInt();
      
      pump = new Pump[pumpNum];
      fireEngine = new int[fireEngineNum];
      
      scan.nextLine();
      
      Pump temp;
      for(int j=0; j < pumpNum; j++) {
         temp = new Pump(scan.nextInt(), 0);
         pump[j] = temp;
      }
      
      scan.nextLine();
      
      for(int i=0; i < fireEngineNum; i++) {
         fireEngine[i] = scan.nextInt();
      }
      
      scan.nextLine();
      
      scan.close();
            
   }

}

// Pump의 위치와 방문여부를 담는 객체
class Pump{
   private int location;
   private int visited;
   
   public Pump() {
      location = 0;
      visited = 0;
   }
   
   public Pump(int location, int visited) {
      super();
      this.location = location;
      this.visited = visited;
   }


   public int getLocation() {
      return location;
   }

   public void setLocation(int location) {
      this.location = location;
   }

   public int getVisited() {
      return visited;
   }

   public void setVisited(int visited) {
      this.visited = visited;
   }
   
}