import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        scan.close();
        
        input = input.toLowerCase();
        String[] alphabet = {"a","b","c","d","e","f","g"
            ,"h","i","j","k","l","m","n","o","p","q","r"
            ,"s","t","u","v","w","x","y","z"};
        int[] result = new int[26];
        Arrays.fill(result,0);
        
        for(int i=0; i<input.length(); i++) {
            for(int j=0; j<alphabet.length; j++) {
                if(input.substring(i, i+1).equals(alphabet[j])) {
                    result[j]++;
                }
            }
        }
        
        int max = 0;
        boolean duplicate = false;
        int at = 0;
        for(int i=0; i<result.length; i++) {
            if(max < result[i]) {
                max = result[i];
                at = i;
                duplicate = false;
            }else if(max== result[i]){
                duplicate = true;             
            }
        }
        
        if(duplicate) {
            System.out.println("?");
        }else {
            System.out.println(alphabet[at].toUpperCase());
        }
        
    }
}