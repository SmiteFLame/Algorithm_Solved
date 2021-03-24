package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_S3_1463_¾çµ¿Çõ {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int[] data = new int[X + 1];
		Arrays.fill(data, Integer.MAX_VALUE);
		data[1] = 0;
		for(int i = 2; i <= X; i++) {
			data[i] = data[i - 1] + 1 < data[i] ? data[i - 1] + 1 : data[i];
			if(i % 2 == 0) data[i] = data[i / 2] + 1 < data[i] ? data[i / 2] + 1 : data[i];
			if(i % 3 == 0) data[i] = data[i / 3] + 1 < data[i] ? data[i / 3] + 1 : data[i];
		}
		System.out.println(data[X]);
	}
}
