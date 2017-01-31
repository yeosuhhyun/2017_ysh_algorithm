import java.util.Scanner;
/*
    https://www.acmicpc.net/problem/2750
    삽입정렬과 버블정렬을 이용하여 수를 오름차순으로 정리
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] array = new int[num];
        for(int i=0; i<array.length; i++) {
            array[i] = scan.nextInt();
        }
        scan.close();
        
        
       array = bubbleSort(array);
       //array = insertSort(array); 
    
        
        for(int i=0; i<array.length; i++) {
            System.out.println(array[i]);
        }
    }
    
    /*
     *	버블 정렬 (안정정렬)
     *	O(n^2) 복잡도  = n(n-1)/2
     *	일반적으로 자료의 교환(swap) 작업이 자료의 이동(move)작업보다 
     *	더 복잡하기 때문에 버블 정렬은 그 단순성에도 불구하고 거의 쓰이지 않고 있다.
     */
    public static int[] bubbleSort(int[] array) {
    	int temp = 0;
        for(int i=0; i<array.length; i++) {
            for(int j =i+1; j<array.length; j++) {
                if(array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
    
    /*
     * 삽입정렬 (안정정렬)
     * O(n^2) 복잡도  = n(n-1)/2
     * 먼저 자료가 정렬되어 있는 경우에는 가장 빠름. : n-1번 = O(n)
     * 삽입정렬은 레코드 수가 많고 레코드 크기가 클 경우에 적합하지 않다.
     * 레코드 수가 적을 경우 매우 간단.
     */
    public static int[] insertSort(int[] array) {
    	 for(int i=1; i<array.length; i++) {
             int key = array[i];
             int j = 0;
             for(j = i-1; j>=0 && array[j] > key; j-- ) {
                 array[j+1] =array [j];
             }
            
             array[j+1] = key;
         } 
    	return array;
    }
}