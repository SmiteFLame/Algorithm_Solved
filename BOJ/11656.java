package justonly;

import java.util.Arrays;
import java.util.Scanner;

public class Main_11656 {

	public static void main(String[] args) {
		String now = new Scanner(System.in).nextLine();
		String[] answer = new String[now.length()];
		answer[0] = now;
		for (int i = 1, end = now.length(); i < end; i++) {
			answer[i] = now.substring(i);
		}
		Arrays.sort(answer);
		for (int i = 0, end = now.length(); i < end; i++) {
			System.out.println(answer[i]);
		}

	}

}
