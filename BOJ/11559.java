import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int[][] NEWS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static boolean canMove(int X, int Y){
        return !(X < 0 || Y < 0 || X >= 12 || Y >= 6);
    }

    public static void main(String[] args) throws IOException {
        char[][] puyo = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String S = br.readLine();
            for (int j = 0; j < 6; j++) {
                puyo[i][j] = S.charAt(j);
            }
        }

        int answer = 0;
        while(true){
            boolean next = false;
            Set<List<Integer>> check = new HashSet<>();
            for(int i = 0; i < 12; i++){
                for(int j = 0; j < 6; j++){
                    if(puyo[i][j] == '.' || check.contains(Arrays.toString(new int[] {i, j}))) continue;
                    Queue<int[]> queue = new LinkedList<>();
                    Set<List<Integer>> set = new HashSet<>();
                    queue.offer(new int[] {i, j});
                    set.add(Arrays.asList(new Integer[] {i, j}));
                    while(!queue.isEmpty()){
                        int[] now = queue.poll();
                        for(int x = 0; x < 4; x++){
                            int nx = now[0] + NEWS[x][0];
                            int ny = now[1] + NEWS[x][1];
                            if(!canMove(nx, ny) || puyo[nx][ny] != puyo[i][j]) continue;
                            if(set.contains(Arrays.asList(new Integer[] {nx, ny}))) continue;
                            set.add(Arrays.asList(new Integer[] {nx, ny}));
                            check.add(Arrays.asList(new Integer[] {nx, ny}));
                            queue.offer(new int[] {nx, ny});
                        }
                    }
                    if(set.size() < 4) continue;
                    for(List<Integer> list : set){
                        puyo[list.get(0)][list.get(1)] = '.';
                    }
                    next = true;
                }
            }

            for(int j = 0; j < 6; j++){
                for(int i = 10; i >= 0; i--){
                    if(puyo[i][j] == '.') continue;
                    for(int x = i + 1; x < 12; x++){
                        if(puyo[x][j] != '.') continue;
                        puyo[x][j] = puyo[x - 1][j];
                        puyo[x - 1][j] = '.';
                    }
                }
            }

            if(!next) break;
            answer++;
        }
        System.out.println(answer);
    }
}
