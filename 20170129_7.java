import java.util.Scanner;
/*
    https://www.acmicpc.net/problem/6064
    ���� ���, M = 10 �̰� N = 12��� ����. ù ��° �ش� <1:1>�� ǥ���ǰ�, 11 ��° �ش� <1:11>�� ǥ���ȴ�. <3:1>�� 13 ��° �ظ� ��Ÿ����, <10:12>�� �������� 60 ��° �ظ� ��Ÿ����. 

�� ���� ���� M, N, x �� y�� �־��� ��, <M:N>�� ī�� �޷��� ������ �ض�� �ϸ� <x:y>�� �� ��° �ظ� ��Ÿ���� ���� ���ϴ� ���α׷��� �ۼ��϶�. 
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
        
        for(int i =0; i<testCase; i++) {
            int m = scan.nextInt();
            int n = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();            
            int j =0;
            int sum = 0;
            while(sum <= m*n) {
                sum = (m*j)+x;
               // System.out.println(sum);
                
                if((sum-y)%n==0){
                	System.out.println(sum);
                    break;
                } 
                j++;
            }
            if(sum>m*n) {
            	System.out.println(-1);
            }
            
        }
        scan.close();
    }
}