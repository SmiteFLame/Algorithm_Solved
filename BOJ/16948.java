import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,cnt;
    static int dx [] = {-2,-2,0,0,2,2};
    static int dy [] = {-1,1,-2,2,-1,1};
    static boolean visited[][];
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());


        String [] t = br.readLine().split(" ");
        int r1 = Integer.parseInt(t[0]);
        int c1 = Integer.parseInt(t[1]);
        int r2 = Integer.parseInt(t[2]);
        int c2 = Integer.parseInt(t[3]);

        bfs(r1,c1,r2,c2);

    }
    public static void bfs(int r1, int c1, int r2, int c2) {
        visited = new boolean[n+1][n+1];
        Queue<Node>q = new LinkedList<>();
        q.add(new Node(r1,c1,0));

        while(!q.isEmpty()) {
            Node a = q.poll();
            if(a.x ==r2 && a.y==c2) {
                System.out.println(a.cnt);
                return ;
            }
            for(int i=0; i<6; i++) {
                int nx = a.x+dx[i];
                int ny = a.y+dy[i];

                if(isRange(nx,ny) && !visited[nx][ny]) {
                    q.add(new Node(nx,ny,a.cnt+1));
                    visited[nx][ny] = true;
                }
            }
        }
        System.out.println(-1);
    }
    public static boolean isRange(int x, int y) {
        if(x>=0 && y>=0 && x<=n && y<=n) {
            return true;
        }
        return false;
    }
}
class Node{
    int x,y,cnt;
    Node(int x, int y, int cnt){
        this.x=x;
        this.y=y;
        this.cnt=cnt;
    }
}