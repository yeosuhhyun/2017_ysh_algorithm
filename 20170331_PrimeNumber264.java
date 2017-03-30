package algorithm264;

import java.util.Scanner;

/**
 * @author suhhyun yeo
 * â���� �˰��� �߱� p.264
 * ������ ����� ���� ó���� ȿ���� ������.
 * 1) ������ �ڿ��� n�� �Ҽ���� [2, n]���� ����� �������� �ʴ´�.
 * 2) ���� ������ ������ �����ϸ� [2, ��Ʈn]�� ������ �ȴ�.
 * 
 * [����]
 * n��°�� ū �Ҽ��� ���� ���Ͽ� ����϶�.
 * 
 * [�Է�]
 * ���� n�� �Է�
 * (1 <= n <= 100000)
 * 
 * [���]
 * n��°�� ū �Ҽ��� ���
 * 
 */
public class PrimeNumber264 {
   // �Է¹��� ����
   private static int number; 
   
   public static void main(String[] args) {
      // �Է� �Լ�
      input();
      
      // number�� °�� �Ҽ��� ���ϴ� ����
      int i = 1;
      int num = 2;
      while(i <= number) {
         // num�� �Ҽ���� num���� ��ȯ
         if(solve(num)!=0) {
            i++;
         }
         num++;
      }
      
      // ��� ���
      System.out.println(num-1);
   }
   
   
   /**
    * �Ҽ��� ���ϴ� �Լ�
    * @param num : ���� 
    * @return num : �Ҽ���� num ��ȯ, �ƴ϶�� 0 ��ȯ
    */
   private static int solve(int num) {
      
      for(int i= 2; i*i <=num; i++) {
         // 1�� ������ ���� ������ �������� 0�̸� �Ҽ��� �ƴ�
         if(num % i == 0) {
            return 0;
         }
      }
      
      return num;
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
