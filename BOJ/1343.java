import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        char[] board = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < board.length; i++) {
            if (i + 3 < board.length) {
                boolean four = board[i] == board[i + 1] && board[i] == board[i + 2] && board[i] == board[i + 3];

                if (four && board[i] == 'X') {
                    i += 3;
                    sb.append("AAAA");
                    continue;
                }
            }

            if (i + 1 < board.length) {
                boolean two = board[i] == board[i + 1];

                if (two && board[i] == 'X') {
                    i += 1;
                    sb.append("BB");
                    continue;
                }
            }

            if (board[i] == '.') {
                sb.append(".");
            } else {
                sb = new StringBuilder("-1");
                break;
            }
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}