package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    var N = readLine().toInt()
    var max = 0
    repeat(N) {
        var sum = 0
        var st = StringTokenizer(readLine())
        var N1 = st.nextToken().toInt()
        var N2 = st.nextToken().toInt()
        var N3 = st.nextToken().toInt()
        if (N1 == N2 && N2 == N3) {
            sum = 10000 + N1 * 1000
        } else if (N1 == N2) {
            sum = 1000 + N1 * 100
        } else if (N1 == N3) {
            sum = 1000 + N3 * 100
        } else if (N2 == N3) {
            sum = 1000 + N2 * 100
        } else if (N1 > N2 && N1 > N3) {
            sum = N1 * 100
        } else if (N2 > N3) {
            sum = N2 * 100
        } else{
            sum = N3 * 100
        }
        if(sum > max){
            max = sum
        }
    }
    print(max)
}
