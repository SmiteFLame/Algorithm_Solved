package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val set = TreeSet<String>()
    repeat(readLine().toInt()){
        val st = StringTokenizer(readLine())
        val name = st.nextToken();
        val check = st.nextToken();
        if(check == "enter"){
            set.add(name)
        } else{
            set.remove(name)
        }
    }
    val sb = StringBuilder()
    set.reversed().forEach{
        now ->
        sb.append(now + "\n")
    }
    print(sb.toString())
}
