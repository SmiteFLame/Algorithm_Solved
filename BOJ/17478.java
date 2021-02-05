package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S5_17478_양동혁 {
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
		st.append(under).append("\"재귀함수가 뭔가요?\"").append("\n");
		if(C == N) {
			st.append(under).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n");
		}else {
			st.append(under).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append("\n");
			st.append(under).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append("\n");
			st.append(under).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append("\n");	
			talking(C + 1);
		}
		st.append(under).append("라고 답변하였지.").append("\n");
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		st.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
		talking(0);
		System.out.println(st.toString());
	}
}