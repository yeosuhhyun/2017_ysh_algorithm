import java.util.Scanner;
/*
    https://www.acmicpc.net/problem/2750
    �������İ� ���������� �̿��Ͽ� ���� ������������ ����
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
     *	���� ���� (��������)
     *	O(n^2) ���⵵  = n(n-1)/2
     *	�Ϲ������� �ڷ��� ��ȯ(swap) �۾��� �ڷ��� �̵�(move)�۾����� 
     *	�� �����ϱ� ������ ���� ������ �� �ܼ������� �ұ��ϰ� ���� ������ �ʰ� �ִ�.
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
     * �������� (��������)
     * O(n^2) ���⵵  = n(n-1)/2
     * ���� �ڷᰡ ���ĵǾ� �ִ� ��쿡�� ���� ����. : n-1�� = O(n)
     * ���������� ���ڵ� ���� ���� ���ڵ� ũ�Ⱑ Ŭ ��쿡 �������� �ʴ�.
     * ���ڵ� ���� ���� ��� �ſ� ����.
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