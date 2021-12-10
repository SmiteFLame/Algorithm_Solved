package test

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()){
        val num = readLine().toDouble() * 0.8
        sb.append("$${String.format("%.2f", num)}\n")
    }
    println(sb.toString())
}
