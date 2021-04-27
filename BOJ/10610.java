package justonly;

import java.util.Scanner;

public class Main_10610 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		int[] data = new int[10];
		int sum = 0;
		for (int i = 0, end = S.length(); i < end; i++) {
			data[S.charAt(i) - '0']++;
			sum += (S.charAt(i) - '0');
		}
		if (data[0] == 0 || sum % 3 != 0)
			System.out.print("-1");
		else {
			for(int i = 9; i >= 0; i--) {
				for(int j = 0, end = data[i]; j < end; j++) {
					System.out.print(i);
				}
			}
		}

	}

}
