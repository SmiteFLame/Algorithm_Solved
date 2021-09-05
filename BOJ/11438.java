import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M, K;
    private static List<List<Integer>> tree;
    private static int[] depth;
    private static int[][] parents;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i < N + 1; i++)
            tree.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        int tmp = 1;
        K = 0;
        while (tmp <= N) {
            tmp <<= 1;
            K++;
        }

        depth = new int[N + 1];
        parents = new int[N + 1][K];

        dfs(1, 1);
        fillParents();

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int lca = lca(a, b);
            bw.write(lca + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int lca(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = K - 1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {
                a = parents[a][i]; 
            }
        }

        if (a == b) return a;

        for (int i = K - 1; i >= 0; i--) {
            if (parents[a][i] != parents[b][i]) {
                a = parents[a][i];
                b = parents[b][i];
            }
        }

        return parents[a][0];
    }

    private static void fillParents() {
        for (int i = 1; i < K; i++) {
            for (int j = 1; j <= N; j++) {
                parents[j][i] = parents[parents[j][i - 1]][i - 1];
            }
        }
    }

    private static void dfs(int node, int cnt) {
        depth[node] = cnt;

        for (Integer next : tree.get(node)) {
            if (depth[next] == 0) {
                dfs(next, cnt + 1);
                parents[next][0] = node;
            }
        }
    }
}