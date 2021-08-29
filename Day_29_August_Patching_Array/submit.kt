/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/617/week-5-august-29th-august-31st/3956/
 * Ref: https://leetcode.com/discuss/explore/august-leetcoding-challenge-2021/1432740/Patching-Array-oror-Easy-Solution-w-Approach-oror-C%2B%2B-or-Python3-or-JAVA
 * Patching Array
 */

class Solution {
    fun minPatches(nums: IntArray, n: Int): Int {
        var i = 1
        var ans = 0
        var sum = 1L
        if (nums[0] != 1) {
            ans++
            i--
        }
        while (i < nums.size && sum < n) {
            while (sum < nums[i] - 1 && sum < n) {
                ans++
                sum = sum * 2 + 1
            }
            sum += nums[i]
            i++
        }
        while (sum < n) {
            ans++
            sum = sum * 2 + 1
        }
        return ans
    }
}