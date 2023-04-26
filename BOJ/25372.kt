package test

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    repeat(n){
        val now = readLine()
        if(now.length < 6 || now.length > 9){
            println("no")
        } else{
            println("yes")
        }

    }
}
