import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var x = 100
    var y = 100
    repeat(readLine().toInt()){
        val st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        if(a > b){
            y -= a
        } else if(a < b){
            x -= b
        }
    }
    print("$x\n$y")
}