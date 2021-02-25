package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_2005_¾çµ¿Çõ {
	public static void main(String[] args) throws IOException{
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(io.readLine());
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + "\n");
			int N = Integer.parseInt(io.readLine());
			int[][] map = new int[N][N];
			map[0][0] = 1;
			sb.append(map[0][0] + "\n");
			
			for(int i = 1; i < N; i++) {
				for(int j = 0; j <= i; j++) {
					if(j == 0 || i == j) {
						map[i][j] = 1;
					} else {
						map[i][j] = map[i - 1][j - 1] + map[i - 1][j];
					}
					sb.append(map[i][j] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
