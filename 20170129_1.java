import java.util.Scanner;
/*
    https://www.acmicpc.net/problem/2292
   ���� �׸��� ���� ���������� �̷���� ������ �ִ�. �׸����� ���� �ٿ� ���� �߾��� �� 1���� �����ؼ� �̿��ϴ� �濡 ���ư��鼭 1�� �����ϴ� ��ȣ�� �ּҷ� �ű� �� �ִ�. ���� N�� �־����� ��, ������ �߾� 1���� N�� ����� �ּ� ������ ���� ������ �� �� �� ���� ���� ����������(���۰� ���� �����Ͽ�)�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. ���� ���, 13������ 3��, 58������ 5���� ������. 
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        scan.close();
        
        int d = 0;
        int count = 0;
        int num = 0;
        int criteria = 0;
        
        while(input > criteria) {
        
            criteria = 6*num + 1;
            count++;
            d++;
            num += d;
          
        }
        
        System.out.println(count);
    }
}