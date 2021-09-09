import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main_14226 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static class Emoticon{
		int size = 0;
		int clip = 0;
		int cnt = 0;
		
		public Emoticon(int size, int clip, int cnt) {
			this.size = size;
			this.clip = clip;
			this.cnt = cnt;
		}
		
		public Emoticon(Emoticon emto) {
			this.size = emto.size;
			this.clip = emto.clip;
			this.cnt = emto.cnt;
		}

		@Override
		public String toString() {
			return "size=" + size + ", clip=" + clip + ", cnt=" + cnt;
		}		
	}

	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		
		Set<String> set = new HashSet<>();
		PriorityQueue<Emoticon> pQueue = new PriorityQueue<>(new Comparator<Emoticon>() {
			@Override
			public int compare(Emoticon o1, Emoticon o2) {
				return Integer.compare(o1.cnt, o2.cnt);
			}
		});
		
		pQueue.offer(new Emoticon(1, 0, 0));
		set.add(new Emoticon(1, 0, 0).toString());
		
		while(!pQueue.isEmpty()) {
			Emoticon now = pQueue.poll();
			if(now.size == N) {
				System.out.println(now.cnt);
				return;
			}
			
			if(now.size != now.clip) {
				Emoticon next = new Emoticon(now);
				next.clip = now.size;
				next.cnt++;
				if(!set.contains(next.toString())) {
					pQueue.add(next);
					set.add(next.toString());
				}
			}

			if(now.clip != 0) {
				Emoticon next = new Emoticon(now);
				next.size += next.clip;
				next.cnt++;
				if(!set.contains(next.toString())) {
					pQueue.add(next);
					set.add(next.toString());
				}
			}
			
			if(now.size != 0) {
				Emoticon next = new Emoticon(now);
				next.size -= 1;
				next.cnt++;
				if(!set.contains(next.toString())) {
					pQueue.add(next);
					set.add(next.toString());
				}
			}
			
		}
		
	}

}
