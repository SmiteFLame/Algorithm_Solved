package test

import java.util.*
import kotlin.collections.ArrayList

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val data = Array<Int>(m){0}
    val cnt = Array<Int>(101){0}
    val list = ArrayList<Int>()

    st = StringTokenizer(readLine())
    for(i in 0 until m){
        data[i] = st.nextToken().toInt()
        cnt[data[i]]++
    }
    var answer = 0
    for(i in 0 until m){
        cnt[data[i]]--
        if(list.contains(data[i])) continue
        if(list.size >= n){
            answer++
            var check = false
            for(j in 0 until list.size){
                if(cnt[list[j]] <= 0){
                    list.remove(list[j])
                    check = true
                    break
                }
            }
            if(!check){
                val visited = Array<Boolean>(n){false}
                var temp = n
                next@
                for(k in i + 1 until m){
                    for(l in 0 until n){
                        if(list[l] == data[k] && ! visited[l]){
                            visited[l] = true
                            temp--
                            if(temp == 0){
                                list.remove(data[k])
                                break@next
                            }
                            break
                        }
                    }
                }
            }
        }
        list.add(data[i])
    }
    print(answer)
}