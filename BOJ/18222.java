package ssafy.study.week10;

import java.util.Scanner;

public class Main_18222 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong() - 1;

		int cnt = 0;
		for(long i = 0, flag = 1; i < 61; flag <<= 1, i++) {
			if((N & flag) != 0) cnt++;
		}
		System.out.println(cnt % 2 == 0 ? 0 : 1);
	}
}
