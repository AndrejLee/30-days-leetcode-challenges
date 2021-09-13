import kotlin.math.min

class Solution {
    fun maxNumberOfBalloons(text: String): Int {
        val count = Array(26) {0}
        for (char in text) {
            count[char - 'a']++
        }

        var ans = Int.MAX_VALUE
        for (index in count.indices) {
            when ((index + 'a'.toInt()).toChar()) {
                'a', 'b', 'n' -> ans = min(ans, count[index])
                'l', 'o' -> ans = min(ans, count[index] / 2)
            }
        }
        return ans
    }
}