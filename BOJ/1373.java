import java.util.Scanner;

public class Main_1373 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		int len = S.length();
		
		if(len % 3 == 1) {
			System.out.print(S.charAt(0));
		} else if(len % 3 == 2) {
			System.out.print((S.charAt(0) - '0') * 2 + (S.charAt(1) - '0'));
		}
		
		for(int i = len % 3; i < len; i += 3) {
			System.out.print((S.charAt(i) - '0') * 4 + (S.charAt(i + 1) - '0') * 2+ (S.charAt(i + 2) - '0'));
		}
	}
}
