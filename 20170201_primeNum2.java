import java.util.Scanner;
import java.util.ArrayList;
/*
 * https://www.acmicpc.net/problem/2581
 * m과 n 사이에 있는 소수의 합과 최소값을 구하시오.
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        scan.close();
        
        // 소수를 저장할 arr
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        while(m<=n) {
            if(primeNumber(m)!=0) {
                arr.add(m);
            }
            m++;
        }
        
        int sum =0;
        for(int j =0; j<arr.size(); j++) {
            sum+=arr.get(j);
        }
        if(sum==0) {
            System.out.println(-1);
        }else {
            System.out.println(sum);
            System.out.println(arr.get(0));
        }
    }
    
    /*
     * 소수를 찾는 함수
     */
    public static int primeNumber(int m) {
        int i = 2;
        while(m>1) {
            if(m%i==0 && m!=i) {
                return 0;
            }else if(m==i) {
                return m;
            }
            i++;
        }
        return 0;
    }
    
    
}