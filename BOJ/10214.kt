import java.util.*
import kotlin.text.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()){
        var y = 0
        var k = 0
        repeat(9){
            val st = StringTokenizer(readLine())
            y += st.nextToken().toInt()
            k += st.nextToken().toInt()
        }
        if(y > k){
            sb.append("Yonsei\n")
        } else if(y == k){
            sb.append("Draw\n")
        } else {
            sb.append("Korea\n")
        }
    }
    print(sb.toString())
}
