package test
import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var N = readLine().toInt()
    var set : TreeSet<Int> = TreeSet()
    var sb = StringBuilder()
    var st = StringTokenizer(readLine())
    repeat(N){
        set.add(st.nextToken().toInt())
    }
    set.forEach{
        n -> sb.append("$n ")
    }
    print(sb.toString())
}