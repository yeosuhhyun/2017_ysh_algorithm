import java.util.Scanner;

/**
 * 
 * @author suhhyunYeo
 * â���� �˰��� �߱� p.125
 * 
 * [����] �������
 * ������ ���� �� ĭ�� �ִ� ������� ��ġ, �׹��� ������ ���̰� �־��� ��, 
 * ������ �ִ� ������� �ִ��̵��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * [�Է�]
 * ù ��° �ٿ� ������ �� N, M�� �Էµȴ�. ( N, M <= 100 �� �ڿ��� )
 * �� ��° �ٿ� �׹��� �� W, H�� �Էµȴ�. ( W <= N, H <= M �� �ڿ��� )
 * �� ��° �ٿ� N*M���� ������� ��ġ�� �������� ���еǾ� �־�����. 
 * �� ������� ��ġ�� 7 ������ �ڿ����̴�. 0�� ��쿡�� ����Ⱑ ���ٴ� �ǹ��̴�.
2 6
1 3
1 0 2 0 4 3
3 4 0 2 0 1
 * 
 * [���]
 * ���� �� �ִ� ������� �ִ� ��ġ�� ����Ѵ�.
7
 *
 */
public class Main {
   public static void main(String[] args) {
      //-- input start
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      int m = scan.nextInt();
      scan.nextLine();
      int w = scan.nextInt();
      int h = scan.nextInt();
      scan.nextLine();
      // ����� ��ġ ������ ������ �迭
      int[][] arr = new int[n][m];
      
      // ���� ������ �̿��Ͽ� ����
      for(int i=0; i<n; i++) {
         for(int j=0; j<m; j++) {
            arr[i][j] = scan.nextInt();
         }
         scan.nextLine();   
      }
      scan.close();
      //-- input end
      
      // ��� ��.
      int result = 0;
      // ���� ���� �ӽ� ��.
      int temp = 0;
      
      
      // ��� 
      // Loop1�� Loop2�� w, h���� ũ�⿡ ���� �迭 ũ�� ������ �Ѿ�� �ʵ��� ������ �������
      Loop1 : for(int i=0; i<n-w+1; i++) {
         Loop2 : for(int j=0; j<m-h+1; j++) {
            temp = 0;
            // Loop3�� Loop4�� w, h ũ�⿡ ���� ��������.
            Loop3 : for(int k=0; k<w; k++) {
               Loop4 : for(int l=0; l<h; l++) {
                  temp+=arr[i+k][j+l];
               }
            }
            
            if(temp>result)  {
               result = temp;
            }
         }
      }
      
      // ���
      System.out.println(result);
      
   }
}