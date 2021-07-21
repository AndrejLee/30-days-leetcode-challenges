import kotlin.random.Random

class Solution(nums: IntArray) {
    private var original: IntArray = nums.clone()
    private var shuffle: IntArray = nums.clone()

    /** Resets the array to its original configuration and return it. */
    fun reset(): IntArray {
        shuffle = original.clone()
        return shuffle
    }

    /** Returns a random shuffling of the array. */
    fun shuffle(): IntArray {
        for (i in original.indices) {
            val randomIndex = i + Random.nextInt(0, original.size - i)
            val old = shuffle[i]
            shuffle[i] = shuffle[randomIndex]
            shuffle[randomIndex] = old
        }

        return shuffle
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(nums)
 * var param_1 = obj.reset()
 * var param_2 = obj.shuffle()
 */