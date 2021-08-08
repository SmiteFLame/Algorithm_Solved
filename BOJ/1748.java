import java.util.Scanner;

public class Main_1748 {

	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt();
		int cnt = 1;
		int answer = 0;
		int ten = 10;
		for (int i = 1; i <= N; i++) {
			if (i == ten) {
				cnt++;
				ten = ten * 10;
			}
			answer = answer + cnt;
		}
		System.out.println(answer);
	}

}
