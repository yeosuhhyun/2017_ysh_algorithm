import java.util.Scanner;

/**
 * @author suhhyunYeo
 * â���� �˰��� �߱� p.128                                                                                                           
 * 
 * [����] ����
 * �Է����� �ٵ����� � ���°� �־����� ��, �������� �̰����, 
 * ����� �̰���� �Ǵ� ���� �ºΰ� �������� �ʾҴ����� �Ǵ��ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * ��, �������� ����� ���ÿ� �̱�ų� ������ �Ǵ� ����� �� ���� �̻󿡼� ���ÿ� �̱�� ���� �Է����� ������ �ʴ´�.
 * 
 * [�Է�]
 * �Է� ������ 19�ٿ� �� �ٸ��� 19���� ���ڷ� ǥ���Ǵµ�, 
 * ���� �ٵϾ��� 1, �� �ٵϾ��� 2, ���� ������ ���� �ڸ��� 0���� ǥ�õǸ�, ���ڴ� �� ĭ�� �� ǥ�õȴ�.
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
 * [���]
 * ù ��° �ٿ� �������� �̰��� ��쿡�� 1��, ����� �̰��� ��쿡�� 2��, 
 * ���� �ºΰ� �������� �ʾ��� ��쿡�� 0�� ����Ѵ�. 
 * ������ �Ǵ� ����� �̰��� ��쿡�� ��° �ٿ� ���ӵ� �ټ� ���� �ٵϾ� �߿��� ���� ���ʿ� �ִ� �ٵϾ�
 * (���ӵ� �ټ� ���� �ٵϾ��� ���η� ���� ���, ���� ���� ���� �ִ� ��)�� ������ ��ȣ�� ������ ��ȣ�� ������� ����Ѵ�.
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
   
   //-> ����
   private static int search1(int color, int i, int j, int count) {
      for(; color==array[i][j+1]; j++) {
         count++;
      }
      return count==5 ? 1:0;
   }
   
   // ���� ������ ������ �Ʒ� �밢�� ���� 
   private static int search2(int color, int i, int j, int count) {
      for(; color==array[i+1][j+1]; i++, j++) {
         count++;
      }
      return count==5 ? 1:0;
   }
   
   // �Ʒ� ����
   private static int search3(int color, int i, int j, int count) {
      for(; color==array[i+1][j]; i++) {
         count++;
      }
      return count==5 ? 1:0;
   }
   
   
   // ���� �Ʒ����� ������ �� �밢�� ����
   private static int search4(int color, int i, int j, int count) {
      for(; color==array[i-1][j+1]; i--, j++) {
         count++;
      }
      return count==5 ? 1:0;
   }
}