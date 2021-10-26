package test

fun main() = with(System.`in`.bufferedReader()) {
    val news = arrayOf(arrayOf(-1, 0), arrayOf(0, 1), arrayOf(1, 0), arrayOf(0, -1))
    val n = readLine().toInt()
    val m = readLine().toInt()
    val answer = Array<Array<Int>>(n) { Array<Int>(n) { 0 } }
    var i = n / 2
    var j = n / 2
    var num = 1
    var dis = 3
    var answerI = 0
    var answerJ = 0
    while(num <= n * n){
        answer[i][j] = num
        if(num == m){
            answerI = i + 1
            answerJ = j + 1
        }
        num++
        var ndis = dis + 1
        if(ndis == 4){
            ndis = 0
        }
        val ni = i + news[ndis][0]
        val nj = j + news[ndis][1]
        if(answer[ni][nj] == 0){
            dis = ndis
            i = ni
            j = nj
        } else{
            i += news[dis][0]
            j += news[dis][1]
        }
    }
    val sb = StringBuilder()
    for(x in 0 until n){
        for(y in 0 until n){
            sb.append("${answer[x][y]} ")
        }
        sb.append("\n")
    }
    sb.append("$answerI $answerJ")
    print(sb.toString())
}
