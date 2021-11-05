package test

var parent = Array(0) { 0 }

fun find(x: Int): Int {
    return if (x == parent[x]) x
    else find(parent[x]).also { parent[x] = it }
}

fun union(x: Int, y: Int) {
    val px = find(x)
    val py = find(y)
    if (px != py) {
        parent[px] = py
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val g = readLine().toInt()
    val p = readLine().toInt()
    parent = Array(g + 1) { 0 }
    for (i in 1..g) {
        parent[i] = i
    }
    var answer = 0
    for (i in 0 until p) {
        val now = readLine().toInt()
        val next = find(now)
        if (next == 0) {
            break
        }
        answer++
        union(next, next - 1)
    }
    print(answer)
}