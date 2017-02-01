import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
/*
 * https://www.acmicpc.net/problem/4948
 * n이 주어졌을 때, n보다 크고 2n보다 작거나 같은 소수의 갯수를 구하는 프로그램
 * 여러개의 테스트케이스가 주어지고 마지막에는 0이 주어진다.
 */
public class Main {
    
    private static boolean[] primeArray;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> inputArray = new ArrayList<Integer>();
        int input = 0;
        
        // inputArray에 n을 저장, 0이 나오면 입력이 중단된다.
        while(true) {
            input = scan.nextInt();
            if(input!=0){
                inputArray.add(input);
            }else {
                scan.close();
                break;
            }
        }
        
        for(int i =0;i< inputArray.size(); i++) {
            primeNumber(inputArray.get(i),inputArray.get(i)*2);
        }
  
    }
    
	//에라토스테네스의 체 이용
    private static void primeNumber(int min, int max) {
        primeArray = new boolean[max+1];
        Arrays.fill(primeArray,true);
        primeArray[0] = false;
        primeArray[1] = false;
        for(int i=2; (i*i)<=max; i++){
			if(primeArray[i]){
				for(int j = i*i; j<=max; j+=i) 
                    primeArray[j]= false;
			}
		}
        int count = 0;
        for(int i =min+1; i<primeArray.length; i++) {
            if(primeArray[i]==true) {
                count++;
            }
        }
        System.out.println(count);
    }
    
    
    
}