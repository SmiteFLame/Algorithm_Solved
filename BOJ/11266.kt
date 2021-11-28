package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {

    var st = StringTokenizer(readLine())
    val v = st.nextToken().toInt()
    val e = st.nextToken().toInt()

    val arrayList = Array(v + 1) { ArrayList<Int>() }
    val count = Array(v + 1) { 0 }
    val answer = TreeSet<Int>()

    repeat(e){
        st = StringTokenizer(readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        arrayList[x].add(y)
        arrayList[y].add(x)
    }

    var order = 1
    
    fun dfs(id: Int, isRoot: Boolean, parent: Int): Int {
        count[id] = order
        order++
        var ret = count[id]
        var child = 0

        val len = arrayList[id].size
        for (i in 0 until len) {
            val now = arrayList[id][i] as Int

            if (now == parent) continue

            ret = if (count[now] == 0) {
                child++
                val low = dfs(now, false, id)
                if (!isRoot && low >= count[id]) {
                    answer.add(id)
                }
                ret.coerceAtMost(low)
            } else {
                ret.coerceAtMost(count[now])
            }
        }
        if (isRoot && child >= 2) {
            answer.add(id)
        }
        return ret
    }

    for(i in 1..v){
        if(count[i] == 0){
            dfs(i, true, 0)
        }
    }

    println(answer.size)
    answer.forEach{ now ->
        print("$now ")
    }

}
