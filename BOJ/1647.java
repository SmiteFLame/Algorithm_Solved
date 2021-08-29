import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M;
    static int[] parent;
    static List<Road> road = new ArrayList<>();

    static class Road {
        int A, B, C;

        Road(int A, int B, int C) {
            this.A = A;
            this.B = B;
            this.C = C;
        }
    }


    private static boolean union(int X, int Y) {
        int XP = find(X);
        int YP = find(Y);
        if (XP == YP) return false;
        parent[XP] = YP;
        return true;
    }

    private static int find(int N) {
        if (parent[N] == N) return N;
        return parent[N] = find(parent[N]);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            road.add(new Road(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

        }
        road.sort(new Comparator<Road>() {
            @Override
            public int compare(Road o1, Road o2) {
                return Integer.compare(o1.C, o2.C);
            }
        });


        int cnt = 2;
        int answer = 0;

        for (int i = 0; i < M && cnt != N; i++) {
            if (!union(road.get(i).A, road.get(i).B)) continue;
            cnt++;
            answer += road.get(i).C;
        }

        System.out.println(answer);
    }
}
