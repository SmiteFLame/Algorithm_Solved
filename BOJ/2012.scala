import scala.collection.mutable
import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val pq = new mutable.PriorityQueue[Int].reverse
    for (i <- 0 until n) {
      pq.enqueue(StdIn.readInt())
    }
    var answer = 0L
    for (i <- 0 until n) {
      answer += Math.abs(pq.dequeue() - i - 1)
    }
    println(answer)
  }
}
