import java.util.Scanner;

/**
 * 
 * @author suhhyun Yeo
 * 
 * 창의적 알고리즘 p.110
 * [문제] 
 * 9×9 격자판에 쓰여진 81개의 자연수가 주어질 때, 
 * 이들 중 최댓값을 찾고 그 최댓값이 몇 행 몇 열에 위치한 수인지 구하는 프로그램을 작성하시오.
 * 
 * 
 * [입력]
 * 첫째 줄부터 아홉째 줄까지 한 줄에 아홉개씩 자연수가 주어진다.
 * 주어지는 자연수는 100보다 작다.
3 23 85 34 17 74 25 52 65
10 7 39 42 88 52 14 72 63 
87 42 18 78 53 45 18 84 53
34 28 64 85 12 16 75 36 55
21 77 45 35 28 75 90 76 1
25 87 65 15 28 11 37 28 74
65 27 75 41 7 89 78 64 39
47 47 70 45 23 65 3 41 44
87 13 82 38 31 12 29 29 80
 *
 * [출력]
 *  첫째 줄에 최댓값 출력, 둘째 줄에 최댓값이 위치한 행, 열 번호 출력
 *  최댓값이 두 개 이상인 경우 그 중 한 곳의 위치를 출력
 *  90
 *  5 7
 */

public class Main {
   public static void main(String[] args) {
      
      // 입력을 array 배열에 받으면서 동시에 
      // 최댓값을 구분하는 로직
      Scanner scan = new Scanner(System.in);
      int[][] array = new int[9][9];
      int mi = 0, mj = 0;
      
      for(int i=0; i<9; i++) {
         for(int j=0; j<9; j++) {
            array[i][j] = scan.nextInt();
            if(array[mi][mj]<array[i][j]) {
               mi = i;
               mj = j;
            }
         }
         scan.nextLine();
      }
      System.out.println(array[mi][mj]);
      System.out.println(mi+1+" "+mj+1);
   }
   

   
}