package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_D2_1954_양동혁 {
	static int T, N, count;
	static int[][] data;
	static StringBuffer st = new StringBuffer();
	
	
	static void MakeCircle(int rad) {		
		// NXN이므로 최소와 최대 값 찾아두기
		int X = rad;
		int Y = N - rad - 1;
		
		// 홀수 개 일때 마지막 
		if(X == Y) {
			data[X][Y] = count;
			return;
		}
		
		
		// 위쪽 줄
		for(int i = 0; i < Y - X; i++) {
			data[X][X + i] = count++;
		}
		
		// 오른쪽 줄
		for(int i = 0; i < Y - X; i++) {
			data[X + i][Y] = count++;
		}
		
		// 아래쪽 줄
		for(int i = 0; i < Y - X; i++) {
			data[Y][Y - i] = count++;
		}
		
		// 왼쪽 줄
		for(int i = 0; i < Y - X; i++) {
			data[Y - i][X] = count++;
		}
		
		// 짝수개 일때 마지막
		if(X + 1 == Y) return;
		
		// 재귀함수를 통해서 내부 시작
		MakeCircle(rad + 1);
		
	}
	
	// 출력하는 함수
	static void print() {
		for(int[] d: data) {
			for(int num : d) {
				st.append(num).append(" ");
			}
			st.append("\n");
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st.append("#" + test_case + "\n");
			
			// 테스트 케이스 마다 필요한 변수 초기화
			N = Integer.parseInt(in.readLine());
			count = 1;
			data = new int[N][N];
			
			MakeCircle(0);
			
			print();
		}
		
		//최종적으로 만들어진 StringBuilder 출력
		System.out.println(st.toString());
	}
}
