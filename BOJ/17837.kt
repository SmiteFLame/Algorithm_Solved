import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static final int[][] news = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    static int n, k;
    static int[][] table = new int[12][12];
    static ArrayList<Integer>[][] order = new ArrayList[12][12];
    static ArrayList<Node> a = new ArrayList<>();

    public static class Node {
        int x;
        int y;
        int d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 12; ++i) {
            for (int j = 0; j < 12; ++j) {
                order[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < k; ++i) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            a.add(new Node(x, y, d));
            order[x][y].add(i);
        }

        int count = 0;
        while (count < 1000) {
            count++;

            for (int i = 0; i < k; ++i) {
                int x = a.get(i).x;
                int y = a.get(i).y;

                int nx = x + news[a.get(i).d][0];
                int ny = y + news[a.get(i).d][1];

                if (!(0 <= ny && ny < n && 0 <= nx && nx < n) || table[ny][nx] == 2) {
                    if (a.get(i).d == 0)
                        a.get(i).d = 1;
                    else if (a.get(i).d == 1)
                        a.get(i).d = 0;
                    else if (a.get(i).d == 2)
                        a.get(i).d = 3;
                    else if (a.get(i).d == 3)
                        a.get(i).d = 2;

                    nx = x + news[a.get(i).d][0];
                    ny = y + news[a.get(i).d][1];
                }

                if (!(0 <= ny && ny < n && 0 <= nx && nx < n) || table[ny][nx] == 2) ;
                else if (table[ny][nx] == 0) {
                    int idx = -1;
                    for (int j = 0; j < order[y][x].size(); ++j) {
                        int cand = order[y][x].get(j);

                        if (cand == i) {
                            idx = j;
                        }
                        if (idx == -1)
                            continue;

                        a.get(cand).x = nx;
                        a.get(cand).y = ny;

                        order[ny][nx].add(cand);
                        if (order[ny][nx].size() >= 4) {
                            System.out.println(count);
                            return;
                        }
                    }
                    int cnt = order[y][x].size();
                    for (int j = idx; j < cnt; ++j)
                        order[y][x].remove(order[y][x].size() - 1);
                } else {
                    int idx = -1;
                    for (int j = order[y][x].size() - 1; j >= 0; --j) {
                        int cand = order[y][x].get(j);

                        if (cand == i) {
                            idx = j;
                            break;
                        }
                    }
                    for (int j = order[y][x].size() - 1; j >= idx; --j) {
                        int cand = order[y][x].get(j);

                        a.get(cand).y = ny;
                        a.get(cand).x = nx;
                        order[ny][nx].add(cand);
                        if (order[ny][nx].size() >= 4) {
                            System.out.println(count);
                            return;
                        }

                    }
                    int cnt = order[y][x].size();
                    for (int j = idx; j < cnt; ++j)
                        order[y][x].remove(order[y][x].size() - 1);

                }

            }
        }
        System.out.println(-1);

    }

}