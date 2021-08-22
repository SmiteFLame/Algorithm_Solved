package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    var N = st.nextToken().toInt()
    var B = st.nextToken().toInt()

    var list = LinkedList<Int>()
    var sb = StringBuilder()

    while(N != 0){
        list.add(N % B)
        N /= B
    }

    list.forEach{
        lt ->
        if(lt >= 10){
            sb.append(((lt - 10) + 'A'.toInt()).toChar())
        } else{
            sb.append(lt)
        }
    }
    println(sb.toString().reversed())
}