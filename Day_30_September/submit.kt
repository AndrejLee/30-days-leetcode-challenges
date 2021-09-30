/**
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/640/week-5-september-29th-september-30th/3993/
 * Ref: https://leetcode.com/discuss/explore/september-leetcoding-challenge-2021/1495198/Partition-to-K-Equal-Sum-Subsets-oror-C%2B%2B-oror-DFS%2BBACKTRACKING-oror-Explained
 *
 */

class Solution {
    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        var sum = 0
        for (num in nums) {
            sum += num
        }
        if (k <= 0 || sum.rem(k) != 0) return false
        val visited = Array(nums.size) {false}
        return solve(nums, visited, 0, k, 0, 0, sum/k)
    }

    fun solve(nums: IntArray, visited: Array<Boolean>, index: Int, k: Int, curSum: Int, curNum: Int, target: Int): Boolean {
        if (k == 1) return true
        if (curSum > target) return false
        if (curSum == target && curNum > 0) return solve(nums, visited, 0, k - 1, 0, 0, target)
        for (i in index until nums.size) {
            if (!visited[i]) {
                visited[i] = true
                if (solve(nums, visited, i + 1, k, curSum + nums[i], curNum + 1, target)) return true
                visited[i] = false
            }
        }
        return false
    }
}