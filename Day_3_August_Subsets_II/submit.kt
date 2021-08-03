/**
 * Link:https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3837/
 * Subsets II
 * Ref: https://leetcode.com/discuss/explore/august-leetcoding-challenge-2021/1380213/Subset-II-or-2-Approaches-(Backtracking-and-Iterative)-oror-C%2B%2B-or-JAVA-or-Python
 */

class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val ans = mutableListOf<MutableList<Int>>()
        ans.add(mutableListOf())
        if (nums.isEmpty()) return ans
        nums.sort()
        val temp = ans[0].toMutableList()
        temp.add(nums[0])
        ans.add(temp)

        var beginDup = 1
        for (index in 1 until nums.size) {
            val current = nums[index]
            val isDup = current == nums[index - 1]
            val size = ans.size
            if (!isDup) {
                for (resIndex in 0 until size) {
                    val tempList = ans[resIndex].toMutableList()
                    tempList.add(current)
                    ans.add(tempList)
                }
            } else {
                for (cloneIndex in beginDup until size) {
                    val tempList = ans[cloneIndex].toMutableList()
                    tempList.add(current)
                    ans.add(tempList)
                }
            }
            beginDup = size
        }
        return ans
    }
}