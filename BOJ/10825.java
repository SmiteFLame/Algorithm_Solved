package justonly;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_10825 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static PriorityQueue<Node> pQueue = new PriorityQueue<>(new Comparator<Node>() {


		@Override
		public int compare(Node o1, Node o2) {
			// 1. 국어점수가 감소하는 순
			if(o1.kor != o2.kor) {
				return Integer.compare(o2.kor, o1.kor);
			}
			
			// 2, 영어 점수 증가하는 순

			if(o1.eng != o2.eng) {
				return Integer.compare(o1.eng, o2.eng);
			}
			
			// 3. 수학점수 감소하는 순
			if(o1.mat != o2.mat) {
				return Integer.compare(o2.mat, o1.mat);
			}
			
			return o1.name.compareTo(o2.name);
		}
	});

	static class Node{
		String name;
		int kor;
		int eng;
		int mat;
		Node(StringTokenizer st){
			this.name = st.nextToken();
			this.kor = Integer.parseInt(st.nextToken());
			this.eng = Integer.parseInt(st.nextToken());
			this.mat = Integer.parseInt(st.nextToken());
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			pQueue.add(new Node(new StringTokenizer(in.readLine())));
		}
		
		while(!pQueue.isEmpty()) {
			System.out.println(pQueue.poll().name);
		}
	}

}
