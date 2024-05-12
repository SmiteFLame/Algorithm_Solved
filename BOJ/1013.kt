package test

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()){
        val str = readLine()
        val ptn = "(100+1+|01)+"
        sb.append(if (str.matches(Regex(ptn))) "YES\n" else "NO\n")
    } 
    print(sb.toString())
}