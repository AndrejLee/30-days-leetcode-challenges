import kotlin.math.ceil
import kotlin.math.log2
import kotlin.math.pow

/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3892/
 * Range Sum Query
 */

class NumArray(private val nums: IntArray) {
    private val segTree: Array<Int>

    init {
        val h = ceil(log2(nums.size * 1.0))
        segTree = Array(2 * 2.0.pow(h).toInt() - 1) {0}
        buildTree(nums, segTree, 0, nums.size - 1, 0)
    }

    private fun buildTree(nums: IntArray, segTree: Array<Int>, left: Int, right: Int, index: Int) {
        if (left == right) {
            segTree[index] = nums[left]
            return
        }
        val mid = (left + right) / 2
        buildTree(nums, segTree, left, mid, 2 * index + 1)
        buildTree(nums, segTree, mid + 1, right, 2 * index + 2)
        segTree[index] = segTree[2 * index + 1] + segTree[2 * index + 2]
    }

    fun sumRange(left: Int, right: Int): Int {
        return doSum(segTree, 0, nums.size - 1, left, right, 0)
    }

    private fun doSum(segTree: Array<Int>, left: Int, right: Int, from: Int, to: Int, index: Int): Int {
        if (from <= left && to >= right) return segTree[index]
        if (from > right || to < left) return 0
        val mid = (left + right) / 2
        return doSum(segTree, left, mid, from, to, 2 * index + 1)+ doSum(segTree, mid + 1, right, from, to, 2 * index + 2)
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */