import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class info implements Comparable<info> {
        int index, num, cnt;

        public info(int index, int num, int cnt) {
            super();
            this.index = index;
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(info o) {
            if (this.cnt == o.cnt) {
                return this.index - o.index;
            }
            return this.cnt - o.cnt;
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        ArrayList<info> list = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int student = Integer.parseInt(st.nextToken());
            if (list.size() < N) {
                boolean flag = false;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).num == student) {
                        list.get(j).cnt++;
                        flag = true;
                        break;
                    }
                }
                if (!flag) list.add(new info(i, student, 1));
            } else {
                Collections.sort(list);
                boolean flag = false;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).num == student) {
                        list.get(j).cnt++;
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    list.remove(0);
                    list.add(new info(i, student, 1));
                }
            }
        }

        for (Main.info info : list) {
            answer.add(info.num);
        }

        Collections.sort(answer);

        for (Integer integer : answer) sb.append(integer).append(" ");

        System.out.println(sb.toString());
    }

}
