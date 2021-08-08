import java.util.Scanner;

public class Main_7567 {

	public static void main(String[] args) {
		String S = (new Scanner(System.in)).next();
		int sum = 10;
		for(int i = 1, end = S.length(); i < end; i++) {
			if(S.charAt(i - 1) == S.charAt(i)) {
				sum += 5;
			} else {
				sum += 10;
			}
		}
		System.out.println(sum);

	}

}
