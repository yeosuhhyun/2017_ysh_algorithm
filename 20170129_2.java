import java.util.Scanner;

/*
https://www.acmicpc.net/problem/1193
 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> �� �� ���� ������ ���ʴ�� 1��, 2��, 3��, 4��, 5��, �� �м���� ����.

X�� �־����� ��, X��° �м��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
*/
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		scan.close();

		int num = 0;
		int sum = 0;
		int count = 0;
		int denominator = 0; // �и�
		int numerator = 0; // ����

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