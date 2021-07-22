class Solution {
    fun partitionDisjoint(nums: IntArray): Int {
        var minIndex = 0
        var min = nums[0]
        for (index in nums.indices) {
            if (nums[index] < min) {
                min = nums[index]
                minIndex = index
            }
        }
        var maxLeft = nums[0]
        for (index in 1..minIndex) {
            if (nums[index] > maxLeft) {
                maxLeft = nums[index]
            }
        }
        var pivot = minIndex
        var tempMax = maxLeft
        for (index in minIndex until nums.size) {
            if (nums[index] < maxLeft) {
                pivot = index
                maxLeft = tempMax
            } else {
                tempMax = nums[index]
            }
        }

        return pivot + 1
    }
}