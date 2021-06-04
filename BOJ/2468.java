import java.util.*;

public class Main {
    static int[][] NEWS = {{1,0},{-1,0},{0,1},{0,-1}};

    static class Pair{
        int X;
        int Y;
        Pair(int X, int Y){
            this.X = X;
            this.Y = Y;
        }
    }

    public static void main(String[] ar) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max_area = 1;
        int lowest = Integer.MAX_VALUE, highest = 0;
        int[][] water_Area = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                water_Area[i][j] = sc.nextInt();
                lowest = Math.min(water_Area[i][j], lowest);
                highest = Math.max(water_Area[i][j], highest);
            }
        }
        for(int x = lowest; x < highest; x++){
            boolean[][] check_fall = new boolean[N][N];
            int count_area = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(check_fall[i][j]) continue;
                    check_fall[i][j] = true;
                    if(water_Area[i][j] > x){
                        count_area++;
                        Queue<Pair> Q = new LinkedList<>();
                        Q.add(new Pair(i, j));
                        while(!Q.isEmpty()){
                            Pair P = Q.poll();
                            for(int a = 0; a < 4; a++){
                                if(P.X + NEWS[a][0] >= 0 && P.X + NEWS[a][0] < N && P.Y + NEWS[a][1] >= 0 && P.Y + NEWS[a][1] < N && check_fall[P.X + NEWS[a][0]][P.Y + NEWS[a][1]] == false && water_Area[P.X + NEWS[a][0]][P.Y + NEWS[a][1]] > x){
                                    check_fall[P.X + NEWS[a][0]][P.Y + NEWS[a][1]] = true;
                                    Q.add(new Pair(P.X + NEWS[a][0], P.Y + NEWS[a][1]));
                                }
                            }
                        }
                    }
                }
            }
            max_area = Math.max(max_area, count_area);
        }
        System.out.print(max_area);
    }
}
