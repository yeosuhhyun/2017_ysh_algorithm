import java.util.Scanner;
/*
    https://www.acmicpc.net/problem/6064
    예를 들어, M = 10 이고 N = 12라고 하자. 첫 번째 해는 <1:1>로 표현되고, 11 번째 해는 <1:11>로 표현된다. <3:1>은 13 번째 해를 나타내고, <10:12>는 마지막인 60 번째 해를 나타낸다. 

네 개의 정수 M, N, x 와 y가 주어질 때, <M:N>이 카잉 달력의 마지막 해라고 하면 <x:y>는 몇 번째 해를 나타내는 지를 구하는 프로그램을 작성하라. 
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