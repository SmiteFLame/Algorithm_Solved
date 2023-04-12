package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val grade: List<String> = listOf("A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F")
    val point: List<Double> = listOf(4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0)
    val gradePointMap: Map<String, Double> = grade.zip(point).toMap()

    var totalD = 0.0
    var totalP = 0.0

    for (i in 0 until 20) {
        val now = readLine()
        val st = StringTokenizer(now)
        st.nextToken()
        val gd = st.nextToken().toDouble()
        val getGrade = st.nextToken()
        if (!getGrade.equals("P")) {
            totalD += gd
            totalP += gd * gradePointMap[getGrade]!!
        }
    }
    println(totalP / totalD)
}
