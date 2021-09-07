import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());
        int[][] A = new int[100][100];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        int R = 3, C = 3;
        while (A[r][c] != k && time <= 100) {
            if (R >= C) {
                int max = 0;
                for (int i = 0; i < R; i++) {
                    int[] count = new int[101];
                    for (int j = 0; j < C; j++) {
                        count[A[i][j]]++;
                    }
                    int l = 0;
                    for (int j = 1; j <= C && l < 100; j++) {
                        for (int z = 1; z < 101; z++) {
                            if (count[z] == j) {
                                A[i][l++] = z;
                                A[i][l++] = j;
                            }
                        }
                    }
                    for (int j = l; j <= C && j < 100; j++) {
                        A[i][j] = 0;
                    }
                    max = Math.max(l, max);
                }
                C = max;
            } else {
                int max = 0;
                for (int j = 0; j < C; j++) {
                    int[] count = new int[101];
                    for (int i = 0; i < R; i++) {
                        count[A[i][j]]++;
                    }
                    int l = 0;
                    for (int i = 1; i <= R; i++) {
                        for (int z = 1; z < 101; z++) {
                            if (count[z] == i) {
                                A[l++][j] = z;
                                A[l++][j] = i;
                            }
                        }
                    }
                    for (int i = l; i <= R && i < 100; i++) {
                        A[i][j] = 0;
                    }
                    max = Math.max(l, max);
                }
                R = max;
            }
            time++;
        }

        System.out.println(time > 100 ? -1 : time);
    }
}