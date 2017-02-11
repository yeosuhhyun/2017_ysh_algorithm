import java.util.Scanner;

/**
 * 
 * @author suhhyunYeo
 * 창의적 알고리즘 중급 p.125
 * 
 * [문제] 고기잡이
 * 연못의 폭과 각 칸에 있는 물고기의 가치, 그물의 가로의 길이가 주어질 때, 
 * 잡을수 있는 물고기의 최대이득을 구하는 프로그램을 작성하시오.
 * 
 * [입력]
 * 첫 번째 줄에 연못의 폭 N, M이 입력된다. ( N, M <= 100 인 자연수 )
 * 두 번째 줄에 그물의 폭 W, H가 입력된다. ( W <= N, H <= M 인 자연수 )
 * 세 번째 줄에 N*M개의 물고기의 가치가 공백으로 구분되어 주어진다. 
 * 각 물고기의 가치는 7 이하의 자연수이다. 0일 경우에는 물고기가 없다는 의미이다.
2 6
1 3
1 0 2 0 4 3
3 4 0 2 0 1
 * 
 * [출력]
 * 잡을 수 있는 물고기의 최대 가치를 출력한다.
7
 *
 */
public class Main {
   public static void main(String[] args) {
      //-- input start
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      int m = scan.nextInt();
      scan.nextLine();
      int w = scan.nextInt();
      int h = scan.nextInt();
      scan.nextLine();
      // 물고기 가치 정보를 저장할 배열
      int[][] arr = new int[n][m];
      
      // 이중 포문을 이용하여 저장
      for(int i=0; i<n; i++) {
         for(int j=0; j<m; j++) {
            arr[i][j] = scan.nextInt();
         }
         scan.nextLine();   
      }
      scan.close();
      //-- input end
      
      // 결과 값.
      int result = 0;
      // 합을 비교할 임시 값.
      int temp = 0;
      
      
      // 계산 
      // Loop1과 Loop2는 w, h값의 크기에 따라 배열 크기 밖으로 넘어가지 않도록 조건을 만들어줌
      Loop1 : for(int i=0; i<n-w+1; i++) {
         Loop2 : for(int j=0; j<m-h+1; j++) {
            temp = 0;
            // Loop3와 Loop4는 w, h 크기에 따라 조정해줌.
            Loop3 : for(int k=0; k<w; k++) {
               Loop4 : for(int l=0; l<h; l++) {
                  temp+=arr[i+k][j+l];
               }
            }
            
            if(temp>result)  {
               result = temp;
            }
         }
      }
      
      // 출력
      System.out.println(result);
      
   }
}