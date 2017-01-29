import java.util.Scanner;
import java.util.Arrays;

/*
    https://www.acmicpc.net/problem/1475
    �ټ����� ���������� �ö�ƽ ���ڸ� �� ��Ʈ�� �Ǵ�. �� ��Ʈ���� 0������ 9������ ���ڰ� �ϳ��� ����ִ�. �ټ����� �� ��ȣ�� �־����� ��, �ʿ��� ��Ʈ�� ������ �ּҰ��� ����Ͻÿ�. (6�� 9�� ����� �̿��� �� �ְ�, 9�� 6�� ����� �̿��� �� �ִ�.)
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        scan.close();
        int[] result = new int[9];
        Arrays.fill(result,0);
        
        for(int i=0; i< input.length(); i++) {
            int temp = Integer.parseInt(input.substring(i,i+1));
            
            if(temp == 9) {
                temp = 6;
            }
          
            result[temp] = result[temp] +1;
        }
        
       
        int max = 0;
        int temp = result[6];
        result[6] = (temp/2) + (temp%2);
        
        for(int i=0; i<result.length; i++ ) {
            if(max <= result[i]) {
                max = result[i];
            }
        }
        System.out.println(max);
    }
}
