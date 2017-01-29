import java.util.Scanner;
/*
    https://www.acmicpc.net/problem/10250
*/
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCase = scan.nextInt();
		String result = "";

		for (int i = 0; i < testCase; i++) {
			int H = scan.nextInt();
			int W = scan.nextInt();
			int N = scan.nextInt();

			int a = N % H;
			int b = N / H;

			
			if (a == 0) {
				result = String.valueOf(H);
				if (b <= 9 && b > 0) {

					result += "0" + String.valueOf(b);

				} else {
					result += String.valueOf(b);
				}
			} else {
				result = String.valueOf(a);
				if (b < 9 && b >= 0) {

					result += "0" + String.valueOf((b) + 1);

				} else {
					result += String.valueOf((b) + 1);
				}
			}
			System.out.println(result);
		}

		scan.close();
	}

}