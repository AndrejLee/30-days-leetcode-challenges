/**
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3773/
 * Jump Game VI
 */

class Solution {
    fun maxResult(nums: IntArray, k: Int): Int {
        val dp = mutableListOf<Int>()
        dp.addAll(nums.asList())

        val queue = PriorityQueue<Pair<Int, Int>> { o1, o2 -> o2.first.compareTo(o1.first) }
        queue.add(Pair(dp[0], 0))

        for (index in 1 until dp.size) {
            while (queue.isNotEmpty() && (queue.peek().second < index - k)) {
                queue.poll()
            }
            dp[index] += queue.peek().first
            queue.add(Pair(dp[index], index))
        }

        return dp.last()
    }
}