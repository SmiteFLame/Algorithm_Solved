package test

import java.lang.StringBuilder
import java.util.*

var data = LongArray(0)
var tree= LongArray(0)

fun init(node: Int, start : Int, end : Int) : Long{
    if(start == end){
        tree[node] = data[start]
    } else {
        var mid = (start + end) / 2
        var left = init(node * 2, start, mid)
        var right = init(node * 2 + 1, mid + 1, end)

        tree[node] = left + right
    }
    return tree[node]
}
fun sum(node: Int, start : Int, end : Int, left : Int, right : Int) : Long{
    if(right < start || left > end){
        return 0
    }
    if(left <= start && end <= right){
        return tree[node]
    }
    var mid = (start + end) / 2
    var leftsum = sum(node * 2, start, mid, left, right)
    var rightsum = sum(node * 2 + 1, mid + 1, end, left, right)

    return leftsum + rightsum
}

fun update(node: Int, start : Int, end : Int, index : Int, change : Long){
    if(index < start || index > end){
        return
    }
    tree[node] += change
    if(start != end){
        var mid = (start + end) / 2
        update(node * 2, start, mid, index, change)
        update(node * 2 + 1, mid + 1, end, index, change)
    }
}


fun main() = with(System.`in`.bufferedReader()) {
    var answer = StringBuilder()

    var st = StringTokenizer(readLine())
    val N = st.nextToken().toInt()
    var M = st.nextToken().toInt()

    data = LongArray(N)
    tree = LongArray(N * 4)
    st = StringTokenizer(readLine())
    for(i in 0 until N){
        data[i] = st.nextToken().toLong()
    }

    init(1, 0, N - 1)

    repeat(M){
        st = StringTokenizer(readLine())
        var x = st.nextToken().toInt() - 1
        var y = st.nextToken().toInt() - 1
        var a = st.nextToken().toInt() - 1
        var b = st.nextToken().toLong()
        if(x > y){
            var temp = x
            x = y
            y = temp
        }
        answer.append(sum(1, 0, N - 1, x, y)).append("\n")
        var change = b - data[a]
        data[a] = b
        update(1, 0, N - 1, a, change)
    }
    print(answer.toString())
}