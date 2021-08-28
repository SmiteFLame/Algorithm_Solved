package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    var A = st.nextToken().toLong()
    var B = st.nextToken().toLong()
    var sb = StringBuilder()
    repeat(GCP(A.coerceAtLeast(B), A.coerceAtMost(B)).toInt()){
        sb.append(1)
    }
    print(sb.toString())
}

fun GCP(A : Long, B : Long) : Long{
    if(B == 0L) return A;
    return GCP(B, A % B);
}
