import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N = 4, answer;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}, dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static class Fish {
        int x, y, dir;

        public Fish(int x, int y, int dir) {
            super();
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

    }

    public static void main(String[] args) throws IOException {
        int[][] map = new int[N][N];
        Fish[] fish = new Fish[17];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken()) - 1;

                map[i][j] = a;
                fish[a] = new Fish(i, j, b);
            }
        }

        answer = map[0][0];
        Fish shark = new Fish(0, 0, fish[map[0][0]].dir);
        fish[map[0][0]] = null;
        map[0][0] = -1;

        process(map, shark, fish, answer);

        System.out.println(answer);

    }

    private static void process(int[][] map, Fish shark, Fish[] fish, int sum) {
        int[][] tmpMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, tmpMap[i], 0, N);
        }

        Fish tmpShark = new Fish(shark.x, shark.y, shark.dir);

        Fish[] tmpFish = new Fish[17];
        for (int i = 1; i <= 16; i++) {
            if(fish[i] == null) continue;
            tmpFish[i] = new Fish(fish[i].x, fish[i].y, fish[i].dir);
        }

        for (int f = 1; f <= 16; f++) {

            Fish now = tmpFish[f];
            if(now == null) continue;

            int origDir = now.dir;
            do {
                int xx = now.x + dx[now.dir];
                int yy = now.y + dy[now.dir];

                if(xx < 0 || xx >= N || yy < 0 || yy >= N || tmpMap[xx][yy] == -1) {
                    now.dir = (now.dir + 1) % 8;
                    continue;
                }

                Fish ftmp = tmpFish[tmpMap[xx][yy]];

                if (ftmp != null) {
                    tmpFish[tmpMap[xx][yy]] = new Fish(now.x, now.y, ftmp.dir);
                }
                tmpFish[f] = new Fish(xx, yy, now.dir);

                int tmp = tmpMap[xx][yy];
                tmpMap[xx][yy] = f;
                tmpMap[now.x][now.y] = tmp;

                break;

            } while (now.dir != origDir);
        }

        for (int d = 1; d <= 3; d++) {
            int xx = tmpShark.x + dx[tmpShark.dir] * d;
            int yy = tmpShark.y + dy[tmpShark.dir] * d;

            if(xx < 0 || xx >= N || yy < 0 || yy >= N) break;
            if(tmpMap[xx][yy] == 0) continue;

            int eatNum = tmpMap[xx][yy];
            Fish newFish = tmpFish[tmpMap[xx][yy]];

            tmpFish[tmpMap[xx][yy]] = null;
            tmpShark = new Fish(newFish.x, newFish.y, newFish.dir);
            tmpMap[xx][yy] = -1;
            tmpMap[shark.x][shark.y] = 0;

            process(tmpMap, tmpShark, tmpFish, sum + eatNum);

            tmpMap[shark.x][shark.y] = -1;
            tmpMap[xx][yy] = eatNum;
            tmpShark = new Fish(shark.x, shark.y, shark.dir);
            tmpFish[tmpMap[xx][yy]] = new Fish(newFish.x, newFish.y, newFish.dir);
        }

        answer = Math.max(answer, sum);
    }

}
