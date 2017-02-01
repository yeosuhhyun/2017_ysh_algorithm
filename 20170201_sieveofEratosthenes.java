import java.util.Scanner;
import java.util.ArrayList;
/*
 * https://www.acmicpc.net/problem/1929
 * m과 n사이의 소수를 전부 출력하시오.
 * 에라토스테네스의 체의 방법으로 구현
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        scan.close();
        
     
       // ArrayList로 구현
		ArrayList<Boolean> primeList;
		
		
		// n+1만큼 할당
		primeList = new ArrayList<Boolean>(n+1);
		// 0번째와 1번째를 소수 아님으로 처리 
		primeList.add(false);
		primeList.add(false);
		// 2~ n 까지 소수로 설정
		for(int i=2; i<=n; i++ )
			primeList.add(i, true);
		
		// 2 부터  ~ i*i <= n
		// 각각의 배수들을 지워간다.
		for(int i=2; (i*i)<=n; i++){
			if(primeList.get(i)){
				for(int j = i*i; j<=n; j+=i) 
                    primeList.set(j, false);
			}
		}
        
        // 출력부분
        for(int i =m; i<primeList.size(); i++) {
            if(primeList.get(i)==true) {
                System.out.println(i);
            }
        }
    } 
    
   
}