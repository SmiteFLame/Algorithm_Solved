import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dice = new int[10];
    static int[][] map = new int[33][33];
    static int next = 0;
    static int weight = 0;
    static int max = 0;

    public static class Node implements Comparable<Node>{
        int v;
        int w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node n) {
            if(this.v < n.v) return 1;
            else return -1;
        }
    }

    public static void set() {
        for(int i = 0; i < 20; i++) {
            map[i][i + 1] = 2 * (i + 1);
        }
        map[5][21] = 13; map[21][22] = 16; map[22][23] = 19; map[23][24] = 25;

        map[15][27] = 28; map[27][26] = 27; map[26][25] = 26; map[25][24] = 25;

        map[10][28] = 22; map[28][29] = 24; map[29][24] = 25;

        map[24][30] = 30; map[30][31] = 35; map[31][20] = 40;

        map[20][32] = 1;
    }

    public static void move(int cnt, int start) {
        if(cnt == 0) return;
        if(next == 32) {
            weight = 1;
            return;
        }
        ArrayList<Node> l = new ArrayList<>();
        for(int i = 0; i < 33; i++) {
            if(map[next][i] != 0) {
                l.add(new Node(i, map[next][i]));
            }
        }

        if(l.size() == 1) {
            next = l.get(0).v;
            weight = l.get(0).w;
        }

        else if(l.size() > 1) {
            Collections.sort(l);
            if(next == start) {
                next = l.get(0).v;
                weight = l.get(0).w;
            }
            else {
                next = l.get(1).v;
                weight = l.get(1).w;
            }
        }
        move(cnt-1, start);
    }

    public static void select(int h, int[] ph, int x, int sum) {
        if(x == 10) {
            for(int i = 0; i < 4; i++) {
                if(ph[i] == 32) sum--;
            }
            max = Math.max(max, sum);
            return;
        }
        if(ph[h] == 32) return;

        int[] horse = ph.clone();
        next = horse[h];
        move(dice[x], next);

        for(int i = 0; i < 4; i++) {
            if(next != 32 && horse[i] == next) return;
        }
        horse[h] = next;
        sum += weight;

        if(sum + (9 - x) * 40 < max) return;

        for(int i = 0; i < 4; i++) {
            select(i, horse, x + 1, sum);
        }
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        set();
        for(int i = 0; i < 4; i++) {
            int[] horse = new int[4];
            select(i, horse, 0, 0);
        }
        System.out.println(max);
    }
}