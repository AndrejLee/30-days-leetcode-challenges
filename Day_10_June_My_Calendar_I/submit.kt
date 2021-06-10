/**
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3774/
 * My Calendar I
 */

class MyCalendar() {
    private val cached = mutableListOf<Pair<Int, Int>>()

    fun book(start: Int, end: Int): Boolean {
        val realEnd = end - 1
        for (event in cached) {
            if (start in event.first..event.second
                || realEnd in event.first..event.second
                || event.first in start..realEnd
                || event.second in start..realEnd)
                return false
        }
        cached.add(Pair(start, realEnd))
        return true
    }

}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * var obj = MyCalendar()
 * var param_1 = obj.book(start,end)
 */