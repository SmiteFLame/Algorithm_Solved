package test

import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val s = st.nextToken().toLong()

    val array = Array(n) { 0L }

    st = StringTokenizer(readLine())
    for (i in 0 until n) {
        array[i] = st.nextToken().toLong()
    }

    val leftArrayList = ArrayList<Long>()
    val rightArrayList = ArrayList<Long>()

    fun subset(idx: Int, end: Int, sum: Long, isLeft: Boolean) {
        if (idx == end) {
            if (isLeft) leftArrayList.add(sum)
            else rightArrayList.add(sum)
            return
        }
        subset(idx + 1, end, sum, isLeft)
        subset(idx + 1, end, sum + array[idx], isLeft)
    }

    subset(0, n / 2, 0, true)
    subset(n / 2, n, 0, false)

    leftArrayList.sort()
    rightArrayList.sort()

    var left = 0
    var right = rightArrayList.size - 1
    var cnt: Long = 0

    while (left < leftArrayList.size && right >= 0) {
        val sum = leftArrayList[left] + rightArrayList[right]
        if (sum == s) {
            val a = leftArrayList[left]
            var cnt1 = 0L
            while (left < leftArrayList.size && leftArrayList[left] == a) {
                left++
                cnt1++
            }
            val b = rightArrayList[right]
            var cnt2 = 0L
            while (right >= 0 && rightArrayList[right] == b) {
                right--
                cnt2++
            }
            cnt += cnt1 * cnt2
        } else if (sum < s) left++ else right--
    }
    if(s == 0L){
        cnt--
    }

    print(cnt)
}


