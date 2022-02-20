package test


fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while(true){
        val str = readLine() ?: break
        val n = str.toInt()
        var num = 0
        for(i in 1..n){
            num = num * 10 + 1
            num %= n
            if(num == 0){
                sb.append("$i\n")
                break
            }
        }
    }
    print(sb.toString())
}
