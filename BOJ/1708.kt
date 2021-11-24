package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    data class Point(
        val x: Long,
        val y: Long
    )

    val n = readLine().toInt()
    val points = ArrayList<Point>()
    var head = Point(Long.MAX_VALUE, Long.MAX_VALUE)

    fun ccw(p1: Point, p2: Point, p3: Point): Int {
        val result: Long = p1.x * p2.y + p2.x * p3.y + p3.x * p1.y - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y)

        return if (result > 0) 1
        else if (result < 0) -1
        else 0
    }

    fun dist(p1: Point, p2: Point): Long {
        return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y)
    }


    repeat(n) {
        val st = StringTokenizer(readLine())
        points.add(Point(st.nextToken().toLong(), st.nextToken().toLong()))
    }

    for (i in points.indices) {
        if (points[i].y < head.y) {
            head = points[i]
        } else if (points[i].y == head.y) {
            if (points[i].x < head.x) {
                head = points[i]
            }
        }
    }

    points.sortWith(Comparator { p1, p2 ->
        val result: Int = ccw(head, p1, p2)
        if (result > 0) -1
        else if (result < 0) 1
        else if (dist(head, p1) > dist(head, p2)) 1
        else -1
    })
    val stack = Stack<Point>()
    stack.add(head)
    for (i in 1 until points.size) {
        while (stack.size > 1 && ccw(
                stack[stack.size - 2],
                stack[stack.size - 1],
                points[i]
            ) <= 0
        ) {
            stack.pop()
        }
        stack.add(points[i])
    }


    print(stack.size)

}
