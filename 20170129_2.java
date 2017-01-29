import java.util.Scanner;

/*
https://www.acmicpc.net/problem/1193
 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> … 과 같은 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.

X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
*/
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		scan.close();

		int num = 0;
		int sum = 0;
		int count = 0;
		int denominator = 0; // 분모
		int numerator = 0; // 분자

		Loop1: while (input > sum) {
			num++;
			Loop2: for (int i = 0; i < num; i++) {
				
				if (num % 2 == 0) {
					numerator = i + 1;
					denominator = num - i;
				} else {
					numerator = num - i;
					denominator = i + 1;
				}
				count++;
				if (count == input) {
					System.out.println(numerator + "/" + denominator);
					break Loop1;
				}
			}

			sum += num;

		}
	}
}