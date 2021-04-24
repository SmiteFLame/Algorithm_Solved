package justonly;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2752 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] D = new int[3];
		for (int i = 0; i < 3; i++) {
			D[i] = sc.nextInt();
		}
		Arrays.sort(D);
		for (int i = 0; i < 3; i++) {
			System.out.print(D[i] + " ");
		}

	}

}
