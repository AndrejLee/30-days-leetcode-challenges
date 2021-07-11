class MedianFinder() {

    /** initialize your data structure here. */
    private val list = mutableListOf<Int>()

    fun addNum(num: Int) {
        val actualInsertionPoint = lowerBound(list, 0, list.size, num)
        list.add(actualInsertionPoint, num)
    }

    fun findMedian(): Double {
        val size = list.size
        return if (size.rem(2) == 0)
            (list[size / 2] + list[size / 2 - 1]) * 1.0 / 2
        else
            list[size / 2].toDouble()
    }

    private fun lowerBound(a: List<Int>, left: Int, right: Int, x: Int): Int {
        var pos = right
        var tempRight = right
        var tempLeft = left
        while (tempLeft < tempRight) {
            val mid = tempLeft + (tempRight - tempLeft) / 2
            if (a[mid] >= x) {
                pos = mid
                tempRight = mid
            } else {
                tempLeft = mid + 1
            }
        }
        return pos
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */