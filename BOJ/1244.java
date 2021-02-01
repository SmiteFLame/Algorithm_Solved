package com.ssafy.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		
		// ����ġ�� ���� �Է�
		int N = Integer.parseInt(io.readLine());
		
		// ����ġ�� ���� �Է� �� ����
		StringTokenizer st = new StringTokenizer(io.readLine()," ");
		int[] data = new int[N];
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		// �л� �� �Է�
		int T = Integer.parseInt(io.readLine());
		for(int i = 0; i < T; i++) {
		
			// �л� ���� �Է�
			st = new StringTokenizer(io.readLine()," ");
			int std = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
		
			// ���л��� ���
			if(std == 1) {
				
				// ó�� ����(0�����̹Ƿ� -1ó��) ���� num ���ϸ鼭 �߰�
				for(int j = num - 1; j < N; j += num) {
					data[j] = data[j] == 1 ? 0 : 1;
				}				
			}
			
			// ���л��� ���
			else {
				// ��ġ ��� ������ -1ó��
				num--;
				
				// ���� �ڽ� ������ ����
				data[num] = data[num] == 1 ? 0 : 1;
				
				// �¿� �����Ͱ� Ʋ���ų� ���� �� ���� �� ���� ����
				for(int j = 1; j < N; j++) {
					if(num - j < 0 || num + j >= N) break;
					if(data[num - j] != data[num + j]) break;
					data[num - j] = data[num - j] == 1 ? 0 : 1;
					data[num + j] = data[num + j] == 1 ? 0 : 1;					
				}		
			}	
		}
		
		// ���� �����͸� ����Ѵ�.
		for(int i = 0; i < N; i++) {
			if(i != 0 && i % 20 == 0) System.out.println();
			System.out.print(data[i] + " ");
		}
	}
}
