package com.ssafy.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		
		// 스위치의 개수 입력
		int N = Integer.parseInt(io.readLine());
		
		// 스우치의 정수 입력 후 저장
		StringTokenizer st = new StringTokenizer(io.readLine()," ");
		int[] data = new int[N];
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		// 학생 수 입력
		int T = Integer.parseInt(io.readLine());
		for(int i = 0; i < T; i++) {
		
			// 학생 정보 입력
			st = new StringTokenizer(io.readLine()," ");
			int std = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
		
			// 남학생일 경우
			if(std == 1) {
				
				// 처음 숫자(0부터이므로 -1처리) 부터 num 더하면서 추가
				for(int j = num - 1; j < N; j += num) {
					data[j] = data[j] == 1 ? 0 : 1;
				}				
			}
			
			// 여학생일 경우
			else {
				// 위치 계산 때문에 -1처리
				num--;
				
				// 현재 자신 데이터 변경
				data[num] = data[num] == 1 ? 0 : 1;
				
				// 좌우 데이터가 틀리거나 범위 밖 나올 때 까지 변경
				for(int j = 1; j < N; j++) {
					if(num - j < 0 || num + j >= N) break;
					if(data[num - j] != data[num + j]) break;
					data[num - j] = data[num - j] == 1 ? 0 : 1;
					data[num + j] = data[num + j] == 1 ? 0 : 1;					
				}		
			}	
		}
		
		// 최종 데이터를 출력한다.
		for(int i = 0; i < N; i++) {
			if(i != 0 && i % 20 == 0) System.out.println();
			System.out.print(data[i] + " ");
		}
	}
}
