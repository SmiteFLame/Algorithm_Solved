package test

var map = Array(9) { Array(9) { 0 } }
var end = false

fun dfs(depth: Int) {
    if (depth == 81) {
        end = true
        return
    }
    val y = depth / 9
    val x = depth % 9
    if (map[y][x] !== 0) {
        dfs(depth + 1)
    } else {
        for (i in 1..9) {
            if (!isVaild(y, x, i)) continue
            map[y][x] = i
            dfs(depth + 1)
            if (end) return
            map[y][x] = 0
        }
    }
}

fun isVaild(y: Int, x: Int, n: Int): Boolean {
    for (i in 0..8) {
        if (map[y][i] === n || map[i][x] === n) return false
    }
    val yy = y / 3 * 3
    val xx = x / 3 * 3
    for (i in yy until yy + 3) {
        for (j in xx until xx + 3) {
            if (map[i][j] === n) return false
        }
    }
    return true
}

fun main() = with(System.`in`.bufferedReader()) {
    for (i in 0 until 9) {
        val s = readLine()
        for (j in 0 until 9) {
           map[i][j] = s[j] - '0'
        }
    }
    dfs(0)

    val sb = StringBuilder()
    for(i in 0 until 9){
        for(j in 0 until 9){
            sb.append(map[i][j])
        }
        sb.append("\n")
    }
    print(sb.toString())
}