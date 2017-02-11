import java.util.Scanner;

/**
 * @author suhhyunYeo
 * 창의적 알고리즘 중급 p.128                                                                                                           
 * 
 * [문제] 오목
 * 입력으로 바둑판의 어떤 상태가 주어졌을 때, 검은색이 이겼는지, 
 * 흰색이 이겼는지 또는 아직 승부가 결정되지 않았는지를 판단하는 프로그램을 작성하시오.
 * 단, 검은색과 흰색이 동시에 이기거나 검은색 또는 흰색이 두 군데 이상에서 동시에 이기는 경우는 입력으로 들어오지 않는다.
 * 
 * [입력]
 * 입력 파일은 19줄에 각 줄마다 19개의 숫자로 표현되는데, 
 * 검은 바둑알은 1, 흰 바둑알은 2, 알이 놓이지 않은 자리는 0으로 표시되며, 숫자는 한 칸씩 띄어서 표시된다.
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 1 2 0 0 2 2 2 1 0 0 0 0 0 0 0 0 0 0
0 0 1 2 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0
0 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 1 2 2 0 0 0 0 0 0 0 0 0 0 0 0
0 0 1 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 2 1 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
 * 
 * [출력]
 * 첫 번째 줄에 검은색이 이겼을 경우에는 1을, 흰색이 이겼을 경우에는 2를, 
 * 아직 승부가 결정되지 않았을 경우에는 0을 출력한다. 
 * 검은색 또는 흰색이 이겼을 경우에는 둘째 줄에 연속된 다섯 개의 바둑알 중에서 가장 왼쪽에 있는 바둑알
 * (연속된 다섯 개의 바둑알이 세로로 놓인 경우, 그중 가장 위에 있는 것)의 가로줄 번호와 세로줄 번호를 순서대로 출력한다.
 * 1
 * 3 2
 * 
 */
public class Main {
   private static int[][] array= new int[19+2][19+2];
   public static void main(String[] args) {
      //-- input start
      Scanner scan = new Scanner(System.in);
      for(int i =1; i<=19; i++) {
         
         for(int j = 1; j<=19; j++) {
            array[i][j] = scan.nextInt();
         }
         scan.nextLine();
      }
      scan.close();
      //-- input end
      
      
      Loop1 : for(int i=1; i<=19; i++) {
         Loop2 : for(int j=1; j<=19; j++) {
            if(array[i][j]!=0) {
               if((array[i][j-1]!=array[i][j]) && (search1(array[i][j], i, j, 1)==1)) {
                  System.out.println(array[i][j]);
                  System.out.println(i+" "+j);
                  break Loop1;
               }
               if((array[i-1][j-1]!=array[i][j]) && (search2(array[i][j], i, j, 1)==1)) {
                  System.out.println(array[i][j]);
                  System.out.println(i+" "+j);
                  System.out.println("dd");
                  break Loop1;
               }
               if((array[i-1][j]!=array[i][j]) && (search3(array[i][j], i, j, 1)==1)) {
                  System.out.println(array[i][j]);
                  System.out.println(i+" "+j);
                  break Loop1;
               }
               if((array[i+1][j-1]!=array[i][j]) && (search4(array[i][j], i, j, 1)==1)) {
                  System.out.println(array[i][j]);
                  System.out.println(i+" "+j);
                  break Loop1;
               }
            }
         }
         
      }
      //System.out.println(0);
      
   }
   
   //-> 방향
   private static int search1(int color, int i, int j, int count) {
      for(; color==array[i][j+1]; j++) {
         count++;
      }
      return count==5 ? 1:0;
   }
   
   // 왼쪽 위에서 오른쪽 아래 대각선 방향 
   private static int search2(int color, int i, int j, int count) {
      for(; color==array[i+1][j+1]; i++, j++) {
         count++;
      }
      return count==5 ? 1:0;
   }
   
   // 아래 방향
   private static int search3(int color, int i, int j, int count) {
      for(; color==array[i+1][j]; i++) {
         count++;
      }
      return count==5 ? 1:0;
   }
   
   
   // 왼쪽 아래에서 오른쪽 위 대각선 방향
   private static int search4(int color, int i, int j, int count) {
      for(; color==array[i-1][j+1]; i--, j++) {
         count++;
      }
      return count==5 ? 1:0;
   }
}