import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        for (int t = 1, end = Integer.parseInt(br.readLine()); t <= end; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] level = new int[N + 1];
            int[] array = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer>[] list = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++)
                list[i] = new ArrayList<>();

            for (int i = 1; i <= N; i++) {
                int from = array[i];
                for (int j = i + 1; j <= N; j++) {
                    list[from].add(array[j]);
                    level[array[j]]++;
                }
            }

            int M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());

                if (list[left].contains(right)) {
                    list[left].remove((Integer) right);
                    list[right].add(left);
                    level[left]++;
                    level[right]--;
                } else {
                    list[right].remove((Integer) left);
                    list[left].add(right);
                    level[right]++;
                    level[left]--;
                }
            }

            StringBuilder sb = new StringBuilder();

            Queue<Integer> queue = new LinkedList<>();

            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (level[i] == 0) {
                    cnt++;
                    queue.add(i);
                }
            }

            if (cnt > 1) {
                System.out.println("?");
                continue;
            }

            int result = 0;

            boolean isFinished = false;
            for (int i = 1; i <= N; i++) {
                if (queue.isEmpty()) {
                    System.out.println("IMPOSSIBLE");
                    isFinished = true;
                    break;
                }

                int from = queue.poll();
                result++;
                sb.append(from).append(" ");
                for (int to : list[from]) {
                    level[to]--;
                    if (level[to] == 0) queue.add(to);
                }
            }
            if (isFinished) continue;

            System.out.println(sb.toString());
        }
    }

}