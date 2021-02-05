package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S5_17478_�絿�� {
	private static int N;
	
	private static StringBuilder st = new StringBuilder();
	
	public static String makeUnderbar(int num) {
		String under = "";
		for(int i = 0; i < num; i++) {
			under += "____";
		}
		return under;
	}
	
	public static void talking(int C) {
		String under = makeUnderbar(C);
		st.append(under).append("\"����Լ��� ������?\"").append("\n");
		if(C == N) {
			st.append(under).append("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"").append("\n");
		}else {
			st.append(under).append("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.").append("\n");
			st.append(under).append("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.").append("\n");
			st.append(under).append("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"").append("\n");	
			talking(C + 1);
		}
		st.append(under).append("��� �亯�Ͽ���.").append("\n");
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		st.append("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.").append("\n");
		talking(0);
		System.out.println(st.toString());
	}
}