import java.util.*;

public class Main {
    // R - 82, G - 71, B - 66
    static int[][] NEWS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static class pair{
        int X;
        int Y;
        pair(int X, int Y){
            this.X = X;
            this.Y =Y;
        }
    }
    public static void main(String[] ar) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] data = new int[N][N];
        String S = sc.nextLine();
        for (int i = 0; i < N; i++) {
            S = sc.nextLine();
            for (int j = 0; j < N; j++) {
                data[i][j] = S.charAt(j);
            }
        }

        boolean[][] visited = new boolean[N][N];
        int countOfArea = 0;
        Queue<pair> Q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visited[i][j] == true) continue;
                countOfArea++;
                Q.add(new pair(i, j));
                visited[i][j] = true;
                while(!Q.isEmpty()){
                    pair P = Q.poll();
                    for(int x = 0; x < 4; x++) {
                        if (P.X + NEWS[x][0] >= 0 && P.X + NEWS[x][0] < N && P.Y + NEWS[x][1] >= 0 && P.Y + NEWS[x][1] < N && visited[P.X + NEWS[x][0]][P.Y + NEWS[x][1]] == false && data[P.X + NEWS[x][0]][P.Y + NEWS[x][1]] == data[i][j]) {
                            visited[P.X + NEWS[x][0]][P.Y + NEWS[x][1]] = true;
                            Q.add(new pair(P.X + NEWS[x][0], P.Y + NEWS[x][1]));
                        }
                    }
                }
            }
        }
        System.out.print(countOfArea + " ");

        countOfArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(data[i][j] == 0) continue;
                countOfArea++;
                Q.add(new pair(i, j));
                int color = data[i][j];
                data[i][j] = 0;
                while(!Q.isEmpty()){
                    pair P = Q.poll();
                    for(int x = 0; x < 4; x++) {
                        if (P.X + NEWS[x][0] >= 0 && P.X + NEWS[x][0] < N && P.Y + NEWS[x][1] >= 0 && P.Y + NEWS[x][1] < N && (data[P.X + NEWS[x][0]][P.Y + NEWS[x][1]] == color|| Math.abs(data[P.X + NEWS[x][0]][P.Y + NEWS[x][1]] - color) == 11)) {
                            data[P.X + NEWS[x][0]][P.Y + NEWS[x][1]] = 0;
                            Q.add(new pair(P.X + NEWS[x][0], P.Y + NEWS[x][1]));
                        }
                    }
                }
            }
        }
        System.out.print(countOfArea);
    }
}