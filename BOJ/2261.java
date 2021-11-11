import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		ArrayList<Point> arrList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arrList.add(new Point(x, y));
		}
		Collections.sort(arrList, (p1, p2) -> p1.x - p2.x); 

		bw.write(closestPair(arrList, 0, N - 1) + "\n");
		bw.close();
		br.close();
	}

	public static int dist(Point p, Point q) {
		return (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y);
	}

	static int bruteForce(ArrayList<Point> arrList, int start, int end) {
		int minDist = Integer.MAX_VALUE;
		for (int i = start; i < end; i++) {
			for (int j = i + 1; j <= end; j++) {
				int k = dist(arrList.get(i), arrList.get(j));
				minDist = Math.min(k, minDist);
			}
		}

		return minDist;
	}

	public static int closestPair(ArrayList<Point> arrList, int start, int end) {
		int n = end - start + 1;

		if (n <= 3) {
			return bruteForce(arrList, start, end);
		}

		int mid = (start + end) / 2;


		int d = Math.min(closestPair(arrList, start, mid), closestPair(arrList, mid + 1, end));


		ArrayList<Point> band = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			int t = arrList.get(mid).x - arrList.get(i).x;

			if (t * t < d) {
				band.add(arrList.get(i));
			}
		}
		Collections.sort(band, (p1, p2) -> p1.y - p2.y);

		for (int i = 0; i < band.size() - 1; i++) {
			for (int j = i + 1; j < band.size(); j++) {
				int t = band.get(j).y - band.get(i).y;

				if (t * t < d) {
					d = Math.min(d, dist(band.get(i), band.get(j)));
				} else { 
					break;
				}
			}
		}

		return d;
	}

}