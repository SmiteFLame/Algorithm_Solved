import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static Baseball[] baseballs;

    static class Baseball {
        String num;
        int s;
        int b;

        Baseball(String num, int s, int b) {
            this.num = num;
            this.s = s;
            this.b = b;
        }
    }

    private static boolean check(int X) {
        String S = Integer.toString(X);
        if (S.charAt(0) == S.charAt(1)) {
            return false;
        }
        if (S.charAt(0) == S.charAt(2)) {
            return false;
        }
        if (S.charAt(1) == S.charAt(2)) {
            return false;
        }
        if(S.charAt(0) == '0' || S.charAt(1) == '0' || S.charAt(2) == '0'){
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        baseballs = new Baseball[N];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            baseballs[i] = new Baseball(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(baseballs, new Comparator<Baseball>() {
            @Override
            public int compare(Baseball o1, Baseball o2) {
                return o1.s == o2.s ? Integer.compare(o2.b, o1.b) : Integer.compare(o2.s, o1.s);
            }
        });

        next:
        for (int x = 123; x <= 987; x++) {
            if (!check(x)) continue;
            String now = Integer.toString(x);
            for(int i = 0; i < N; i++){
                int cnt = 0;
                for(int j = 0; j < 3; j++){
                    if(baseballs[i].num.charAt(j) != now.charAt(j)) continue;
                    cnt++;
                }

                if(cnt != baseballs[i].s) continue next;
                cnt = 0;
                for(int j = 0; j < 3; j++){
                    for(int k = 0; k < 3; k++){
                        if(j == k) continue;
                        if(baseballs[i].num.charAt((j)) != now.charAt(k)) continue;
                        cnt++;
                    }
                }
                if(cnt != baseballs[i].b) continue next;
            }

            answer++;
        }
        System.out.println(answer);

    }
}
