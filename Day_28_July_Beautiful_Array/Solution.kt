/**
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3829/
 * Beautiful Array
 * Ref: https://leetcode.com/discuss/explore/july-leetcoding-challenge-2021/1367966/Beautiful-Array-or-CPP-or-Simple-Iterative-solution-or-Explained
 */

class Solution {
    fun beautifulArray(n: Int): IntArray {
        var beautifulList = mutableListOf<Int>()
        beautifulList.add(1)
        while (beautifulList.size < n) {
            val temp = mutableListOf<Int>()
            for (num in beautifulList) {
                if (num * 2 - 1 <= n) {
                    temp.add(num * 2 - 1)
                }
            }
            for (num in beautifulList) {
                if (num * 2 <= n) {
                    temp.add(num * 2)
                }
            }
            beautifulList = temp
        }

        return beautifulList.toIntArray()
    }
}