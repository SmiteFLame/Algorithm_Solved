import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String target = br.readLine();
        PriorityQueue<String> priorityQueue = new PriorityQueue<String>();
        for (int i = 1; i < target.length() - 1; i++) {
            for (int j = i + 1; j < target.length(); j++) {
                String newString = new StringBuffer(target.substring(0, i)).reverse() +
                        new StringBuffer(target.substring(i, j)).reverse().toString() +
                        new StringBuffer(target.substring(j, target.length())).reverse();
                priorityQueue.add(newString);
            }
        }
        System.out.println(priorityQueue.peek());
    }
}