package test

import java.lang.StringBuilder
import java.util.*
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue


var tree = arrayOf<node>()
var array = IntArray(0)

class node {
    var min: Int
    var max: Int

    constructor(min: Int, max: Int) {
        this.min = min
        this.max = max
    }
}


fun init(now: Int, start: Int, end: Int): node {
    if (start == end) {
        tree[now] = node(start, start)
    } else {
        var mid = (start + end) / 2
        var left = init(now * 2, start, mid)
        var right = init(now * 2 + 1, mid + 1, end)
        tree[now].min = Math.min(left.min, right.min)
        tree[now].max = Math.max(left.max, right.max)
    }
    return tree[now]
}

fun get(now: Int, start: Int, end: Int, left: Int, right: Int): Boolean {
    if (left > end || right < start) {
        return true
    }
    if (left <= start && end <= right) {
        return left <= tree[now].min && tree[now].max <= right
    } else {
        var mid = (start + end) / 2
        return get(now * 2, start, mid, left, right) && get(now * 2 + 1, mid + 1, end, left, right)
    }
}

fun update(now: Int, start: Int, end: Int, X : Int): node {
    if (X > end || X < start) {
        return tree[now]
    }
    if (start == end) {
        if (start == X) {
            tree[now] = node(array[X], array[X])
        }
        return tree[now]
    }
    var mid = (start + end) / 2
    var leftTree = update(now * 2, start, mid, X)
    var rightTree = update(now * 2 + 1, mid + 1, end, X)
    tree[now].min = Math.min(leftTree.min, rightTree.min)
    tree[now].max = Math.max(leftTree.max, rightTree.max)
    return tree[now]
}


fun main() = with(System.`in`.bufferedReader()) {
    var sb = StringBuilder()
    repeat(readLine().toInt()) {
        var st = StringTokenizer(readLine())
        var N = st.nextToken().toInt()

        tree = Array(N * 4) { node(min = Int.MAX_VALUE, max = Int.MIN_VALUE) }

        init(1, 0, N - 1)

        array = IntArray(N)

        for (i in 0 until N) {
            array[i] = i
        }

        repeat(st.nextToken().toInt()) {
            st = StringTokenizer(readLine())
            var x = st.nextToken().toInt()
            var A = st.nextToken().toInt()
            var B = st.nextToken().toInt()
            if (x == 0) {
                var temp = array[A]
                array[A] = array[B]
                array[B] = temp
                update(1, 0, N - 1, A)
                update(1, 0, N - 1, B)
            } else if (get(1, 0, N - 1, A, B)) {
                sb.append("YES\n")
            } else {
                sb.append("NO\n")
            }
        }
    }
    println(sb.toString())
}