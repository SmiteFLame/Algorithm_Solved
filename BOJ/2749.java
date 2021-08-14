import java.util.Scanner;

public class Main_2749 {
	public static void main(String[] args) {
		long N = new Scanner(System.in).nextLong();
		long[] answer = new long[1500003];
		answer[0] = 0;
		answer[1] = 1;
		for(int i = 0; i < 1500000 && i < N; i++) {
			answer[i + 2] = (answer[i + 1] + answer[i]) % 1000000;
		}
		System.out.println(answer[(int) (N % 1500000)]);
	}
}
