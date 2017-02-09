import java.util.Scanner;

/**
 * 
 * @author suhhyun Yeo
 * 
 * â���� �˰��� p.115
 * [����] ��üŽ����
 * �ﰢȭ�� �����
 * 
 * [�Է�]
 * �ﰢ�� ȭ�� �ѷ��� ���̴� �ݵ�� �־��� ȭ�� �ѷ��� ���̿� ���ƾ� �Ѵ�. 
 * ����, ȭ�� �ѷ��� ���̿� �� ���� ���̴� �ڿ����̴�.
 * ��) 9 (1<=n<=100)
 *
 * [���]
 * ���� �ٸ� ȭ���� �� ���
 * ��) 3
 * 
 */

public class Main {
   // ī��Ʈ��
   private static int count = 0;
   // �̹� üũ�ߴٴ� ������ ���� check �迭
   private static int check[][][] = new int[21][21][21];
   
   public static void main(String[] args) {
      //-- �Է� start   
      Scanner scan = new Scanner(System.in);
      int num = scan.nextInt();
      scan.close();
      //-- �Է� end
      
      // �Լ�
      solve(num, 1, 1, 1);
      // ���
      System.out.println(count);
   }

   private static void solve(int num, int a, int b, int c) {
      // a+b+c=num�� ������ ����
      if(a+b+c==num) {
         
         // a�� ���� ���� ��, c�� ���� ū������ ���� -> 1 3 4��  4 3 1�� �ߺ��� �߻����� �ʱ� ���Ͽ�
         // a+b>c �ﰢ���� ���� ����
         // check �湮 ���� �Լ� üũ
         if(a<=b && b<=c && a+b>c && check[a][b][c]==0) {
            count++;
            check[a][b][c]=1;
         }
         // return���� ���� ������ ����ؼ� ������.
         return;
      }
      
      // ���� ���¿��� 3���� ����� �� �߻�
      solve(num ,a+1 ,b , c);
      solve(num ,a ,b+1 , c);
      solve(num ,a ,b , c+1);
      
   }
   

   
}