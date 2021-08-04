import java.util.Scanner;

public class Main_1120 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		int endi = A.length();
		int answer = endi;
		for (int x = 0, end = B.length() - endi; x <= end; x++) {
			int count = 0;
			for (int i = 0; i < endi; i++) {
				if (A.charAt(i) != B.charAt(i + x)) {
					count++;
				}
			}
			answer = count < answer ? count : answer;
		}
		System.out.println(answer);

	}

}
