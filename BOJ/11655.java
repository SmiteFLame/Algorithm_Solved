import java.util.Scanner;

public class Main_11655 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		String answer = "";
		for(int i = 0, end = S.length(); i < end; i++) {
			if(S.charAt(i) >= 'a' && S.charAt(i) <= 'z') {
				int next = S.charAt(i) + 13;
				next = next > 'z' ? next - 'z' + 'a' - 1 : next;
				answer += (char)next;
			}
			else if(S.charAt(i) >= 'A' && S.charAt(i) <= 'Z') {
				int next = S.charAt(i) + 13;
				next = next > 'Z' ? next - 'Z' + 'A' - 1 : next;
				answer += (char)next;
			} else {
				answer += S.charAt(i);
			}
		}
		System.out.println(answer);
	}

}
