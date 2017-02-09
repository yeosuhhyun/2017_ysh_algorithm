import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * â���� �˰��� �� p.96 - �δ��� �� �ʺ�켱Ž������ �ذ�
 * ������ ���簢���̰� ���� ���� ������ 0 �Ǵ� 1�� ǥ���Ѵ�. 
 * 0�� ���̰� 1�� �δ��� ���� ��Ÿ����. 
 * 1�� �����¿�� ����Ǿ� ������ �� ������ �δ����� ��� ������ ������ �� �ִ�.
 * 
 * ��° �ٿ� ����, ������ ũ�⸦ ��Ÿ���� n�� �Էµȴ�.(n�� 30������ �ڿ���)
 * �� ��° �ٺ��� n�ٿ� ���ļ� n���� 0�� 1�� �������� ���еǾ� �Էµȴ�.
 * �Է� ��)
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
 * ù° �ٿ� �δ��� ���� ���� ����Ѵ�. 
 * ��° �ٺ��� �� �δ��� ���� ũ�⸦ ���� �������� �� �ٿ� �ϳ��� ����Ѵ�.
 * ��� ��)
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
   private static Queue<Integer> queue = new LinkedList<Integer>();
   public static void main(String[] args) {
      
      // �Է� ��
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
      
      // bfs ȣǮ
      for(int i=0; i<size; i++) {
         for(int j=0; j<size; j++) {
            if(array[i][j]==1) {
               count = 0;
               bfs(i,j, sizeResult.size()+2);
               sizeResult.add(count);
            }
         }
      }
      
      // ���
      System.out.println(sizeResult.size());
      for(int i=0; i<sizeResult.size(); i++) {
         System.out.println(sizeResult.get(i));
      }
   }
   
   // �迭�� ����� ����� �ʴ��� Ȯ�����ִ� �Լ�
   private static boolean safe(int a, int b) {
      return (0<=a && a<size) && (0<=b && b<size);
   }
   
   // �ʺ� �켱Ž��
   private static void bfs(int row, int col, int num) {
      int[] dx = {1,0,-1,0};
      int[] dy = {0, 1,0,-1};
      count++;
      queue.add(row);
      queue.add(col);
      array[row][col] = num;
      int a ;
      int b ;
      while(!queue.isEmpty()) {
      a = queue.peek();
      queue.poll();
      b = queue.peek();
      queue.poll();
      for(int i=0; i<4; i++) {
         if(safe(a+dx[i],b+dy[i]) && array[a+dx[i]][b+dy[i]]==1) {
            array[a+dx[i]][b+dy[i]]=num;
            queue.add(a+dx[i]);
            queue.add(b+dy[i]);
            count++;
         }
      }
      }
   }
}