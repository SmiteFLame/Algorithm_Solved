import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int W, H;
    static char[][] map;
    static int[][] visit;


    static class Node implements Comparable<Node>{
        int x;
        int y;
        int direction;
        int mirror;

        Node (int x, int y, int direction, int mirror) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.mirror = mirror;
        }

        @Override
        public int compareTo(Node o) {
            return mirror - o.mirror;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        visit = new int[H][W];
        int startX = 0;
        int startY = 0;

        for (int i = 0; i < H; i++) {
            String input = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'C') {
                    startX = i;
                    startY = j;
                }
            }
        }
        for (int i = 0; i < H; i++) {
            Arrays.fill(visit[i], Integer.MAX_VALUE);
        }

        map[startX][startY] = '.';
        bfs(startX, startY);
    }

    static void bfs(int x, int y) {
        Queue<Node> q = new PriorityQueue<>();
        q.offer(new Node(x, y, 5, -1));
        visit[x][y] = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (map[node.x][node.y] == 'C') {
                System.out.println(node.mirror);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int newX = node.x + dx[i];
                int newY = node.y + dy[i];

                if (newX < 0 || newY < 0 || newX >= H || newY >= W) continue;
                if (map[newX][newY] == '*') continue;

                int temp = node.mirror;
                if (node.direction != i) temp++;
                if (visit[newX][newY] < temp) continue;

                visit[newX][newY] = temp;
                q.offer(new Node(newX, newY, i, temp));
            }
        }
    }
}
