import java.util.ArrayList;
import java.util.Scanner;

/*
 * 창의적 알고르짐 중 p.77 - 두더지 굴
 * 지도는 직사각형이고 가로 세로 영역을 0 또는 1로 표현한다. 
 * 0은 땅이고 1은 두더지 굴을 나타낸다. 
 * 1이 상하좌우로 연결되어 있으면 한 마리의 두더지가 사는 집으로 정의할 수 있다.
 * 
 * 번째 줄에 가로, 세로의 크기를 나타내는 n이 입력된다.(n은 30이하의 자연수)
 * 두 번째 줄부터 n줄에 걸쳐서 n개의 0과 1이 공백으로 구분되어 입력된다.
 * 입력 예)
 7
 0 1 1 0 1 0 0
 0 1 1 0 1 0 1
 1 1 1 0 1 0 1
 0 0 0 0 1 1 1
 0 1 0 0 0 0 0
 0 1 1 1 1 1 0
 0 1 1 1 0 0 0
 *
 *
 * 첫째 줄에 두더지 굴의 수를 출력한다. 
 * 둘째 줄부터 각 두더지 굴의 크기를 내림 차순으로 한 줄에 하나씩 출력한다.
 * 출력 예)
 3
 9
 8
 7
 *
 */
public class Main {
   private static int[][] array;
   private static ArrayList<Integer> sizeResult = new ArrayList<Integer>();
   private static int count = 0;
   private static int size;
   
   public static void main(String[] args) {
      
      // 입력 폼
      Scanner scan = new Scanner(System.in);
      size = scan.nextInt();
      scan.nextLine();
      
      array = new int[size][size];
      for(int i=0; i<size; i++) {
         for(int j=0; j<size; j++) {
            array[i][j] = scan.nextInt();
         }
         scan.nextLine();
      }
      scan.close();
      
      // dfs 호풀
      for(int i=0; i<size; i++) {
         for(int j=0; j<size; j++) {
            if(array[i][j]==1) {
               count = 0;
               dfs(i,j, sizeResult.size()+2);
               sizeResult.add(count);
            }
         }
      }
      
      // 출력
      System.out.println(sizeResult.size());
      for(int i=0; i<sizeResult.size(); i++) {
         System.out.println(sizeResult.get(i));
      }
   }
   
   // 배열의 사이즈를 벗어나지 않는지 확인해주는 함수
   private static boolean safe(int a, int b) {
      return (0<=a && a<size) && (0<=b && b<size);
   }
   
   // 깊이 우선탐색
   private static void dfs(int row, int col, int num) {
      int[] dx = {1,0,-1,0};
      int[] dy = {0, 1,0,-1};
      count++;
      array[row][col] = num;
      for(int i=0; i<4; i++) {
         if(safe(row+dx[i],col+dy[i]) && array[row+dx[i]][col+dy[i]]==1) {
            
            dfs(row+dx[i], col+dy[i], num);
         }
      }
      
   }
}