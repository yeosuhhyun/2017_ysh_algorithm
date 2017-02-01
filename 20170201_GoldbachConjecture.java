import java.util.Scanner;
import java.util.Arrays;
/*
 * https://www.acmicpc.net/problem/9020
 * 골드바흐의 추측 : 2보다 큰 짝수는 두 개의 소수로 이루어져있다.
 * 입력된 짝수로 이루어진 두 개의 소수를 출력하시오.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
        boolean[] primeArray;
        
        for(int k=0; k<testCase; k++) {
            int num = scan.nextInt();
            primeArray = new boolean[num+1];
            Arrays.fill(primeArray,true);
            primeArray[0]=false;
            primeArray[1]=false;
            for(int i=2; (i*i)<=num; i++) {
                for(int j=i*i; j<num; j+=i) {
                    primeArray[j] = false;
                }
            }
            
            int min = 0;
            int max = 0;
            int d = num;
			// 에라토스테네스의 체 이용
            for(int i=num; i>=0; i--) {
                if(primeArray[i]==true) {
                    if(primeArray[num-i]==true) {
                        
                        if(Math.abs((i-(num-i)))<=d) {
                        	d=Math.abs((i-(num-i)));
                        	max = i;
                            min = num-i;
                        }
                    }
                }
            }
            System.out.println(max+" "+min);
        }
        
        scan.close();
    }
} 