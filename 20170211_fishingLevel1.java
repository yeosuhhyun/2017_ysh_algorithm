import java.util.Scanner;

/*
 * â���� �˰��� p.121
 * �������
 * [����]
 * ������ ���� �� ĭ�� �ִ� ������� ��ġ, �׹��� ������ ���̿�
 * ������ ���̰� �־��� ��, ���� �� �ִ� ������� �ִ� �̵��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * [�Է�]
 * ù ��° �ٿ� ������ �� N�� �Էµȴ�. ( N <= 100 �� �ڿ��� )
 * �� ��° �ٿ� �׹��� �� W�� �Էµȴ�. ( W <= N �� �ڿ��� )
 * �� ��° �� W���� ������� ��ġ�� �������� ���еǾ� �־�����. 
 * �� ������� ��ġ�� 7������ �ڿ����̴�. 0�� ��쿡�� ����Ⱑ ���ٴ� �ǹ��̴�.
 * ��) 
6
3
102043
 *
 * [���]
 * ���� �� �ִ� ������� �ִ� ��ġ�� ����Ѵ�.
 * ��) 7
 *   
 */
public class Main {
   public static void main(String[] args) {
      //--- input start
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      scan.nextLine();
      int w = scan.nextInt();
      scan.nextLine();
      // ������� ��ġ ������ ������ �迭
      int[] arr = new int[n];
      // ������� ��ġ �Է¹޴� String
      String text = scan.nextLine();
      
      for(int i=0; i<n; i++) {
         arr[i] = Integer.parseInt(text.substring(i, i+1));
      }
      scan.close();
      //-- input end
      
      
      // w���� ��ġ�� ���� �� ��
      int max = 0;
      int temp = 0;
      for(int i=0; i<n-w+1; i++) {
         temp = 0;
         // w�� ����.
         for(int j=i; j<i+w; j++) {
            temp+=arr[j];
         }

         if(temp>max) {
            max = temp;
         }
      }
      
      // ���
      System.out.println(max);
   }
}