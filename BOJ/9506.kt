import java.util.*
import kotlin.collections.ArrayList
import kotlin.text.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while(true) {
        val n = readLine().toInt()
        if(n == -1) break
        val list = ArrayList<Int>()
        var sum = 0
        for (i in 1 until n) {
            if (n % i == 0) {
                list.add(i)
                sum += i
            }
        }
        if (sum == n) {
            sb.append("$n = ")
            for(i in list.indices){
                sb.append("${list[i]} ")
                if(i != list.size - 1){
                    sb.append("+ ")
                }
            }
            sb.append("\n")
        } else {
            sb.append("$n is NOT perfect.\n")
        }
    }
    print(sb.toString())
}
