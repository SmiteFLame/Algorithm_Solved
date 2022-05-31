import scala.collection.mutable
import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val k = StdIn.readInt()
    val list = new Array[String](n)
    for (i <- 0 until n) {
      list(i) = StdIn.readLine()
    }
    val hash = mutable.HashSet[String]()
    val visited = Array.fill(n) {
      false
    }

    def dfs(x: Int, str: String): Unit = {
      if (x == k) {
        hash.add(str)
        return
      }
      for (i <- 0 until n) {
        if (!visited(i)) {
          visited(i) = true
          dfs(x + 1, str + list(i))
          visited(i) = false
        }
      }
    }

    dfs(0, "")
    println(hash.size)
  }
}
