object Solution {
    def solution(sequence: Vector[Int]): Long = {
        val pulse1 = Array.tabulate(sequence.length)(i => if (i % 2 == 0) 1 else  -1)
        val pulse2 = Array.tabulate(sequence.length)(i => if (i % 2 == 0) -1 else 1)
        
        val seqPulse1 = sequence.zip(pulse1).map {case (a, b) => a * b}
        val seqPulse2 = sequence.zip(pulse2).map {case (a, b) => a * b}
        
        def maxSubArraySum(arr: Vector[Int]): Long = {
            var maxEndingHere = arr(0).toLong
            var maxSoFar = arr(0).toLong
            for (i <- 1 until arr.length) {
                maxEndingHere = Math.max(arr(i), maxEndingHere + arr(i))
                maxSoFar = Math.max(maxSoFar, maxEndingHere)
            }
            maxSoFar
        }
        Math.max(maxSubArraySum(seqPulse1), maxSubArraySum(seqPulse2))
    }
}