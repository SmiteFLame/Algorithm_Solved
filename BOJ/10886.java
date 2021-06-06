package justonly;

import java.util.Scanner;

public class Main_10886 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for(int i = 0, end = sc.nextInt(); i < end; i++) {
			sum += sc.nextInt() == 1 ? 1 : -1;
		}
		System.out.println("Junhee is " + (sum > 0 ? "" : "not ") + "cute!");
	}
}
