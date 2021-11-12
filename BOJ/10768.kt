package test

fun main() = with(System.`in`.bufferedReader()) {
    val m = readLine().toInt()
    val d = readLine().toInt()
    when(m){
        1 -> print("Before")
        2 ->{
            when(d) {
                in 0 until 18 -> print("Before")
                18 -> print("Special")
                else -> print("After")
            }
        }
        else -> print("After")
    }
}
