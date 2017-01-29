import java.util.Scanner;
import java.util.Arrays;

/*
    https://www.acmicpc.net/problem/1475
    다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다. 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다. 다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최소값을 출력하시오. (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)
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
