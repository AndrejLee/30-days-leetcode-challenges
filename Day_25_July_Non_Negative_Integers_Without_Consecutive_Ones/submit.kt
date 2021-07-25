/**
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3826/
 * Ref: https://leetcode.com/discuss/explore/july-leetcoding-challenge-2021/1361796/Non-ve-Integers-without-Consecutive-1s-oror-Java-oror-Explaination
 * Non-negative Integers without Consecutive Ones
 */

class Solution {
    fun findIntegers(n: Int): Int {
        val k = n.toString(2).length
        val fib = Array(k + 1) {0}
        fib[0] = 1
        fib[1] = 2
        for (index in 2..k) {
            fib[index] = fib[index - 1] + fib[index - 2]
        }
        var isLastBitOne = false
        var res = 0
        var bit = k - 1
        while (bit >= 0) {
            if ((n and (1 shl bit)) == 0) isLastBitOne = false
            else {
                res += fib[bit]
                if (isLastBitOne) return res
                isLastBitOne = true
            }
            bit--
        }

        return res + 1
    }
}