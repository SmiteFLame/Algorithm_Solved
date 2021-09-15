package test

import java.lang.StringBuilder
import java.util.*

val news = arrayOf(arrayOf(-1, 0), arrayOf(1, 0), arrayOf(0, -1), arrayOf(0, 1))
var n : Int = 0
var m : Int = 0

fun canMove(X : Int, Y : Int) :Boolean{
    return !(X < 0 || Y < 0 || X >= n || Y >= m)
}

fun main() = with(System.`in`.bufferedReader()) {

    val st = StringTokenizer(readLine())
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()
    val array = Array<IntArray>(n) { IntArray(m) }
    for (i in 0 until n) {
        val st = StringTokenizer(readLine())
        for (j in 0 until m) {
            array[i][j] = st.nextToken().toInt()
        }
    }
    var cnt = 0
    var answer = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (array[i][j] == 0) continue
            val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
            queue.offer(Pair(i, j))
            array[i][j] = 0
            cnt++
            var nowCnt = 0
            while(!queue.isEmpty()){
                val now = queue.poll()
                nowCnt++
                for(x in 0 until 4){
                    val nx = now.first + news[x][0]
                    val ny = now.second + news[x][1]
                    if(!canMove(nx, ny) || array[nx][ny] == 0) continue
                    queue.offer(Pair(nx, ny))
                    array[nx][ny] = 0
                }
            }
            answer = nowCnt.coerceAtLeast(answer)
        }
    }
    println(cnt)
    println(answer)
}
