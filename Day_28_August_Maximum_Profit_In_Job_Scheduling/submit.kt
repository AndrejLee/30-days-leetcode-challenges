/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3950/
 * Ref: https://leetcode.com/discuss/explore/august-leetcoding-challenge-2021/1430480/Maximum-Profit-in-Job-Scheduling-or-DP-%2B-Binary-Search-wExplanation
 * Maximum Profit In Job Scheduling
 */

class Solution {
    fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
        val list = ArrayList<IntArray>()
        for (index in startTime.indices) {
            list.add(intArrayOf(startTime[index], endTime[index], profit[index]))
        }
        val sortedJobs = list.sortedWith(object : Comparator<IntArray> {
            override fun compare(o1: IntArray, o2: IntArray): Int {
                return o1[1].compareTo(o2[1])
            }

        })
        val dp = TreeMap<Int, Int>()
        dp[0] = 0
        for (job in sortedJobs) {
            val cur = dp.floorEntry(job[0]).value + job[2]
            if (cur > dp.lastEntry().value)
                dp[job[1]] = cur
        }
        return dp.lastEntry().value
    }
}