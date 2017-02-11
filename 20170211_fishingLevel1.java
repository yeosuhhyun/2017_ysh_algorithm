import java.util.Scanner;

/*
 * 창의적 알고리즘 p.121
 * 고기잡이
 * [문제]
 * 연못의 폭과 각 칸에 있는 물고기의 가치, 그물의 가로의 길이와
 * 세로의 길이가 주어질 때, 잡을 수 있는 물고기의 최대 이득을 구하는 프로그램을 작성하시오.
 * 
 * [입력]
 * 첫 번째 줄에 연못의 폭 N이 입력된다. ( N <= 100 인 자연수 )
 * 두 번째 줄에 그물의 폭 W가 입력된다. ( W <= N 인 자연수 )
 * 세 번째 줄 W개의 물고기의 가치가 공백으로 구분되어 주어진다. 
 * 각 물고기의 가치는 7이하의 자연수이다. 0일 경우에는 물고기가 없다는 의미이다.
 * 예) 
6
3
102043
 *
 * [출력]
 * 잡을 수 있는 물고기의 최대 가치를 출력한다.
 * 예) 7
 *   
 */
public class Main {
   public static void main(String[] args) {
      //--- input start
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      scan.nextLine();
      int w = scan.nextInt();
      scan.nextLine();
      // 물고기의 가치 정보를 저장할 배열
      int[] arr = new int[n];
      // 물고기의 가치 입력받는 String
      String text = scan.nextLine();
      
      for(int i=0; i<n; i++) {
         arr[i] = Integer.parseInt(text.substring(i, i+1));
      }
      scan.close();
      //-- input end
      
      
      // w개의 가치를 더한 값 비교
      int max = 0;
      int temp = 0;
      for(int i=0; i<n-w+1; i++) {
         temp = 0;
         // w번 더함.
         for(int j=i; j<i+w; j++) {
            temp+=arr[j];
         }

         if(temp>max) {
            max = temp;
         }
      }
      
      // 출력
      System.out.println(max);
   }
}