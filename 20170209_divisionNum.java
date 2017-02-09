import java.util.Scanner;

/**
 * 
 * @author suhhyun Yeo
 * 
 * â���� �˰��� p.108 ��üŽ����
 * [����] ����� �� ���ϱ�
 * �� ���� n�� �Է¹޾Ƽ� n�� ��� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * ���� ��� 10�� ����� 1, 2, 5, 10�̹Ƿ� ���� 18
 * 
 * [�Է�]
 * 10 (1<= n <= 100000)
 * 
 * [���]
 * n�� ����� �� ���
 * 18
 *
 */

public class Main {
   public static void main(String[] args) {
      //---�Է� start
      Scanner scan = new Scanner(System.in);
      int num = scan.nextInt();
      scan.close();
      //---�Է� end
      
      // �Ҽ��� ���� ���ϴ� �Լ� return �� ���
      System.out.println(solve(num));
   }
   
   // �Ҽ��� ���� ���ϴ� �Լ�
   private static int solve(int num) {
      int ans = 0;
      for(int i=1; i<=num; i++) {
         // 0���� ���������� �� ans�� ����ؼ� ����.
         if(num%i==0) {
            ans+=i;
         }
      }
      return ans;
   }
}