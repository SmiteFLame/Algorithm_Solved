import java.util.*

fun main() = with(System.`in`.bufferedReader()){
    var st = StringTokenizer(readLine())
    print((st.nextToken().reversed().toInt() + st.nextToken().reversed().toInt()).toString().reversed().toInt())
}