import kotlin.math.abs
import kotlin.math.min

/**
 *  Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3778/
 * Maximum Units on a Truck
 */

class Solution {
    fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
        val boxes = Array(boxTypes.size) {
            Pair(boxTypes[it][0], boxTypes[it][1])
        }

        boxes.sortWith(compareByDescending { it.second })

        var currentSize = 0
        var totalUnits = 0
        for (currentType in boxes) {
            if (currentSize >= truckSize)
                break

            val boxCount = min(currentType.first, abs(truckSize - currentSize))
            currentSize += boxCount
            totalUnits += boxCount * currentType.second
        }

        return totalUnits
    }
}