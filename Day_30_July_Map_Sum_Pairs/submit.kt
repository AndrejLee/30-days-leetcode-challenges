/**
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/612/week-5-july-29th-july-31st/3832/
 * Map Sum Pairs
 */

class MapSum() {

    /** Initialize your data structure here. */
    val map = HashMap<String, Int>()

    fun insert(key: String, `val`: Int) {
        map[key] = `val`
    }

    fun sum(prefix: String): Int {
        var sum = 0
        for ((key, value) in map) {
            if (key.startsWith(prefix)) sum += value
        }
        return sum
    }

}

/**
 * Your MapSum object will be instantiated and called as such:
 * var obj = MapSum()
 * obj.insert(key,`val`)
 * var param_2 = obj.sum(prefix)
 */