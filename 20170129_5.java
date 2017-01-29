import java.util.Scanner;
/*
    https://www.acmicpc.net/problem/2775
    ��� �ݻ�ȸ�� �����ϴ� ���� �����ϴ� ����� �̹� ��ȸ�� �γ�ȸ���� �ǰ� �;� �� ���� ������� �ҷ� ��� �ݻ�ȸ�� �����Ϸ��� �Ѵ�.

�� ����Ʈ�� ���ָ� �Ϸ��� ������ �ִµ�, ��a ���� b ȣ�� ����� �ڽ��� �Ʒ�(a-1)���� 1ȣ���� b ȣ���� ������� ���� �ո�ŭ ������� ������ ��ƾ��Ѵ١� �� ��� ������ �� ��Ű�� ���;� �Ѵ�.

����Ʈ�� ����ִ� ���� ���� ��� ���ֹε��� �� ��� ������ ��Ű�� �Դٰ� ���� ���� ��, �־����� ���� ���� k�� n�� ���� k���� nȣ���� �� ���� ��� �ֳ��� ����϶�. ��, ����Ʈ���� 0������ �ְ� �������� 1ȣ���� ������, 0���� iȣ���� i���� ���.
ù ��° �ٿ� Test case�� �� T�� �־�����. �׸��� ������ ���̽����� �Է����� ù ��° �ٿ� ���� k, �� ��° �ٿ� ���� n�� �־�����. (1 <= k <= 14, 1 <= n <= 14)
*/
public class Main {
    public static int sum = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
        int[] info = new int[2];
        
        for(int i=0; i<testCase; i++) {
            info[0] = scan.nextInt();
            info[1] = scan.nextInt();
            sum = 0;
            info = recur(info);
            System.out.println(sum);
        }
        
        scan.close();
    }
    
    public static int[] recur(int[] info) {
    	  int[] newInfo = new int[2];
    	  //System.out.println("recur "+info[0]+", "+info[1]);
          if(info[0] >= 1 ) {
        	  newInfo[0] = info[0]-1;
             // System.out.println(info[0]+", "+info[1]);
              for(int i=1; i <= info[1]; i++) {
              	newInfo[1] = i;
              	recur(newInfo);
              }
          }else {
        	  sum += info[1];
          }
          return newInfo;
    }
}