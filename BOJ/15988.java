import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long[] data = new long[1000001];
        data[1] = 1;
        data[2] = 2;
        data[3] = 4;
        for(int i = 4; i <= 1000000; i++){
            data[i] = (data[i - 1] + data[i - 2] + data[i - 3]) % 1000000009;
        }

        for(int i = 0; i < N; i++){
            bw.write(data[Integer.parseInt(br.readLine())] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
