import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_5639 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class node{
		int num = 0;
		node left;
		node right;
		node(int num){
			this.num = num;
		}
	}
	
	private static void DFS(node now) {
		if(now.left != null) DFS(now.left);
		if(now.right != null) DFS(now.right);
		System.out.println(now.num);
	}

	public static void main(String[] args) throws IOException{
		node head = new node(Integer.parseInt(in.readLine()));
		while(true) {
			String S = in.readLine();
			if(S == null) break;
			int n = Integer.parseInt(S);
			node now = head;
			while(true) {
				if(now.num < n) {
					if(now.right == null) {
						now.right = new node(n);
						break;
					} else {
						now = now.right;
					}
				} else {
					if(now.left == null) {
						now.left = new node(n);
						break;
					} else {
						now = now.left;
					}
					
				}
			}
		}
		DFS(head);
	}

}
