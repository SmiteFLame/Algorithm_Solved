import java.util.Scanner;

public class Main_2530 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), M = sc.nextInt(), S = sc.nextInt(), N = sc.nextInt();
		S += N;
		M += S / 60;
		S %= 60;
		T += M / 60;
		M %= 60;
		T %= 24;
		System.out.println(T + " " + M + " " + S);

	}

}
