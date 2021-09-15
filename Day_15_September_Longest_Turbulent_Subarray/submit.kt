import kotlin.math.max

class Solution {
    fun maxTurbulenceSize(arr: IntArray): Int {
        if (arr.size == 1)
            return 1

        val sign = ArrayList<Int>()
        for (index in 1 until arr.size) {
            if (arr[index] > arr[index - 1])
                sign.add(1)
            else if (arr[index] < arr[index - 1])
                sign.add(-1)
            else
                sign.add(0)
        }

        var count = if (sign[0] == 0) 0 else 1
        var ans = count

        for (index in 1 until sign.size) {
            if (sign[index] == 0) {
                count = 0
            } else if (sign[index] * sign[index - 1] >= 0) {
                count = 1
            } else {
                count++
            }
            ans = max(ans, count)
        }

        return ans + 1
    }
}