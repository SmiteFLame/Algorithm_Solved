import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static class Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Pair> deque = new LinkedList<>();
        for(int i = 0; i < n; i++){
            int now = Integer.parseInt(st.nextToken());

            while(!deque.isEmpty() && deque.getLast().first> now) {
                deque.removeLast();
            }

            while(!deque.isEmpty() && deque.getFirst().second <= i - l) {
                deque.removeFirst();
            }

            deque.addLast(new Pair(now, i));

            bw.write(deque.getFirst().first + " ");
        }
        br.close();
        bw.flush();
        bw.close();

    }

}