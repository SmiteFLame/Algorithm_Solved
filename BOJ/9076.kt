package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()){
        val array = Array(5){0}
        val st = StringTokenizer(readLine())
        for(i in 0 until 5){
            array[i] = st.nextToken().toInt()
        }
        array.sort()
        if(array[3] - array[1] >= 4){
            sb.append("KIN\n")
        } else{
            sb.append("${array[1] + array[2] + array[3]}\n")
        }
    }
    print(sb.toString())
}
