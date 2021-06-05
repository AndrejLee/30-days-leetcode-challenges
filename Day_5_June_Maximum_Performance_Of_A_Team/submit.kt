import kotlin.math.max

/**
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3768/
 * Maximum Performance of a Team
 */

class Solution {
    fun maxPerformance(n: Int, speed: IntArray, efficiency: IntArray, k: Int): Int {
        val engineers = mutableListOf<Pair<Int, Int >>()
        for (i in speed.indices) {
            engineers.add(Pair(efficiency[i], speed[i]))
        }
        engineers.sortByDescending { it.first }
        val queue = PriorityQueue<Int>()
        var res = 0L
        var sum = 0L
        for (engineer in engineers) {
            queue.add(engineer.second)
            sum += engineer.second
            if (queue.size > k) {
                sum -= queue.poll()
            }
            res = max(res, sum * engineer.first)
        }

        return res.rem(1000000007).toInt()
    }
}