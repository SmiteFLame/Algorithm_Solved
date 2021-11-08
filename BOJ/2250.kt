package test

import java.util.*

data class Node(
    var parent: Int = -1,
    var left: Int = -1,
    var right: Int = -1
)

lateinit var tree: Array<Node>
lateinit var min: Array<Int>
lateinit var max: Array<Int>
var count = 1

fun inOrder(root: Int, level: Int) {
    val now = tree[root]
    if (now.left != -1) {
        inOrder(now.left, level + 1)
    }
    min[level] = min[level].coerceAtMost(count)
    max[level] = count
    count++

    if (now.right != -1) {
        inOrder(now.right, level + 1)
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    tree = Array(n + 1) { Node() }
    min = Array(n + 1) { n }
    max = Array(n + 1) { 0 }

    for (i in 1..n) {
        val st = StringTokenizer(readLine())
        val num = st.nextToken().toInt()
        val left = st.nextToken().toInt()
        val right = st.nextToken().toInt()

        tree[num].left = left
        tree[num].right = right

        if (left != -1) tree[left].parent = num
        if (right != -1) tree[right].parent = num
    }

    var root = 0
    for (i in 1..n) {
        if (tree[i].parent == -1) {
            root = i
            break
        }
    }

    inOrder(root, 1)

    var level = 1
    var answer = max[1] - min[1] + 1

    for (i in 2..n) {
        val now = max[i] - min[i] + 1
        if (answer < now) {
            level = i
            answer = now
        }
    }
    print("$level $answer")
}
