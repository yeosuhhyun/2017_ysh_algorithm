import java.util.Scanner;
/*
 *    https://www.acmicpc.net/problem/1978
 *    소수 찾기 문제
 */
public class Main {
    public static void main(String[] args) {
        // 배열에 입력받기
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        int[] arr = new int[count];
        for(int i=0; i<arr.length; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();
        
        // 소수찾기
        for(int i=0; i<arr.length; i++) {
            if(primeNumber(arr[i])!=-1) {
                count--;
            }
        }
        
        System.out.println(count);
    }
    
    /*
     * 소수 찾기 함수
     */
    public static int primeNumber(int num) {
        int result = 1;
        int i = 2;
        // 1은 소수가 아니기 때문에 num>1
        while(num > 1) {
            if(num%i==0) {
                if(num>i) {
                    result = num;
                    break;
                } else if(num==i) {
                    result = -1;
                    break;
                }               
            }
            i++;
        }
        return result;
        
    }
}