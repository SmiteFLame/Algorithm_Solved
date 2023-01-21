import java.util.*
import javax.swing.text.html.HTML.Attribute.N




fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val array = Array(n) { 0 }
    (0 until n).forEach { i ->
        array[i] = readLine().toInt()
    }
    array.sort()

    var answer = Int.MAX_VALUE
    var i = 0
    var j = 0
    while (i < n) {
        if (array[i] - array[j] < m) {
            i++
            continue
        }
        if (array[i] - array[j] == m ) {
            answer = m
            break
        }
        answer = answer.coerceAtMost(array[i] - array[j])
        j++
    }
    println(answer)
}
