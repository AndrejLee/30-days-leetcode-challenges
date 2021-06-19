import kotlin.math.*

/**
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3783/
 * Range Sum Query - Mutable
 *
 */

class NumArray(private val nums: IntArray) {
    private val segTree: IntArray

    init {
        val n = nums.size
        // Height of segment tree
        val h = ceil(log2(n.toDouble()))
        // Max size of tree
        val temp = 2.0
        val maxSize: Int = (temp * temp.pow(h) - 1).roundToInt()
        segTree = IntArray(maxSize)
        buildTree(0, n - 1, 0)
    }

    private fun buildTree(left: Int, right: Int, index: Int) {
        if (left == right) {
            segTree[index] = nums[left]
            return
        }
        val mid = (left + right) / 2
        buildTree(left, mid, 2 * index + 1)
        buildTree(mid + 1, right, 2 * index + 2)
        segTree[index] = segTree[2 * index + 1] + segTree[2 * index + 2]
    }

    fun update(index: Int, `val`: Int) {
        updateQuery(0, nums.size - 1, 0, index, `val`)
    }

    private fun updateQuery(left: Int, right: Int, index: Int, pos: Int, value: Int) {
        if (pos < left || pos > right) return

        if (left == right) {
            nums[pos] = value
            segTree[index] = value
            return
        }

        val mid = (left + right) / 2
        if (pos <= mid) updateQuery(left, mid, 2 * index + 1, pos, value)
        else updateQuery(mid + 1, right, 2 * index + 2, pos, value)

        segTree[index] = segTree[2 * index + 1] + segTree[2 * index + 2]
    }

    fun sumRange(left: Int, right: Int): Int {
        return sumQuery(0, nums.size - 1, left, right, 0)
    }

    private fun sumQuery(left: Int, right: Int, from: Int, to: Int, index: Int): Int {
        if (from <= left && to >= right) return segTree[index]

        if (from > right || to < left) return 0

        val mid = (left + right) / 2

        return sumQuery(left, mid, from, to, 2 * index + 1) + sumQuery(mid + 1, right, from, to, 2 * index + 2)
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * obj.update(index,`val`)
 * var param_2 = obj.sumRange(left,right)
 */