/**
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/608/week-1-july-1st-july-7th/3804/
 * Reduce Array Size to The Half
 */

class Solution {
    fun minSetSize(arr: IntArray): Int {
        val map = HashMap<Int, Int>()
        for (num in arr) {
            var count = map[num]
            if (count == null) {
                count = 0
            }
            map[num] = count + 1
        }

        val queue = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.second })

        for ((key, value) in map) {
            queue.add(Pair(key, value))
        }

        var count = 0
        var res = 0
        while (queue.isNotEmpty() && count < arr.size / 2) {
            count += queue.remove().second
            res++
        }

        return res
    }
}