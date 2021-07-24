import java.util.Scanner;

public class Main_1292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int F = sc.nextInt(), E = sc.nextInt();
		int answer = 0;
		for(int i = 1, now = 1, next = 1; i <= E; i++, next--) {
			if(next == 0) {
				now++;
				next = now;
			}
			if(F <= i) {
				answer += now;
			}
		}
		System.out.println(answer);
	}
}
