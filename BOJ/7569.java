import java.util.*;

class Tuple{
    int X;
    int Y;
    int Z;

    Tuple(int _X, int _Y, int _Z){
        this.X = _X;
        this.Y = _Y;
        this.Z = _Z;
    }
}

public class Main {
    public static void main(String[] args){

        int[][] L = {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};

        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int Z = sc.nextInt();
        int C = 0, M = 0;
        Queue<Tuple> Q = new LinkedList<>();
        int[][][] D = new int[Z][Y][X];
        for(int i = 0; i < Z; i++){
            for(int j = 0; j < Y; j++){
                for(int k = 0; k < X; k++) {
                    D[i][j][k] = sc.nextByte();
                    if(D[i][j][k] == 1){
                        C++;
                        Q.offer(new Tuple(k, j, i));
                    }
                    else if(D[i][j][k] == -1) C++;
                }
            }
        }

        while(!Q.isEmpty()){
            Tuple t = Q.poll();
            M = Math.max(D[t.Z][t.Y][t.X], M);
            for(int i = 0; i < 6; i++){
                if(t.X + L[i][0] >= 0 && t.X+ L[i][0] < X && t.Y + L[i][1] >= 0 && t.Y+ L[i][1] < Y && t.Z + L[i][2] >= 0 && t.Z+ L[i][2] < Z && D[t.Z + L[i][2]][t.Y + L[i][1]][t.X + L[i][0]] == 0){
                    Q.offer(new Tuple(t.X + L[i][0], t.Y + L[i][1], t.Z + L[i][2]));
                    D[t.Z + L[i][2]][t.Y + L[i][1]][t.X + L[i][0]] = D[t.Z][t.Y][t.X] + 1;
                    C++;
                }
            }
        }
        if(C == X * Y * Z) System.out.print(M - 1);
        else System.out.print(-1);
    }
}
