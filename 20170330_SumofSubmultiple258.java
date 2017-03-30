package algorithm258;

import java.util.Scanner;

/**
 * @author suhhyun yeo
 * â���� �˰��� �߱� p.258
 * ������ ����� ���� ó���� ȿ���� ������.
 * 1) ��� �ڿ��� n�� ���Ͽ�, 2�̻� n�̸��� �ڿ��� �� �� ���� ū n�� ����� n/2�� ���� �ʴ´�.
 * 2) ���� �������� ���� �����غ��� 4*4 = 16 �߰��� �ִ� ����� ũ��� ��Ʈn�� ���� �ʴ´�.
 * 3) i < ��Ʈn �� i^2 < n �� ���� �ƶ����� ������ �� �ִ�.
 * 4) for(i = 1; i*i <= n; i++) �ϼ�
 * 
 * [����]
 * �� ���� n�� ����� ���� ���϶�.
 * 
 * [�Է�]
 * ���� n�� �Է�
 * 
 * [���]
 * n�� ����� ���� ���
 * 
 */
public class SumofSubmultiple258 {
   // �Է¹��� ����
   private static int number; 
   
   public static void main(String[] args) {
      // �Է� �Լ�
      input();
      // ��� ���
      System.out.println(solve());
   }
   
   /**
    * ����� ���� ���ϴ� �Լ�
    * @return
    */
   private static int solve() {
      int ans = 0, i = 0;
      // ������ ����� ���� ���ǹ�
      for(i = 1; i * i <= number; i++) {
         if(number % i == 0) {
            ans += (i + number/i);
         }
      }
      
      // ���� �������� ����Ͽ��� ��, ���ϴ� ��
      if(i*i==number) ans+=i;
      
      return ans;
   }
   
   /**
    * �Է� �Լ�
    */
   private static void input() {
      Scanner scan  = new Scanner(System.in);
      number = scan.nextInt();
      scan.close();
   }
}
