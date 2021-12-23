package test


fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    var len = 1
    repeat(n - 1){
        len += 4
    }
    val array = Array(len) { Array(len) { ' ' } }
    fun backTracking(s: Int, len: Int) {
        for (i in s until len) {
            array[s][i] = '*'
            array[len - 1][i] = '*'
            array[i][s] = '*'
            array[i][len - 1] = '*'
        }
        if (len == 1) return
        backTracking(s + 2, len - 2)
    }

    backTracking(0, len)

    val sb = StringBuilder()
    for (i in 0 until len) {
        for (j in 0 until len) {
            sb.append(array[i][j])
        }
        sb.append("\n")
    }
    print(sb.toString())
}
