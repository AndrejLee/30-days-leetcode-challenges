/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3907/
 * Rectangle Area II
 * Ref: https://leetcode.com/discuss/explore/august-leetcoding-challenge-2021/1419388/Rectangle-Area-II-oror-Line-Sweep-oror-O(N2)-oror-C%2B%2B-or-Python
 */

class Solution {
    fun rectangleArea(rectangles: Array<IntArray>): Int {
        val ys = TreeSet<Long>()
        for (rect in rectangles) {
            ys.add(rect[1].toLong())
            ys.add(rect[3].toLong())
        }

        val sortedRects = rectangles.sortedWith(object : Comparator<IntArray> {
            override fun compare(o1: IntArray, o2: IntArray): Int {
                return o1[0].compareTo(o2[0])
            }
        })

        var prevY = ys.iterator().next()
        val mod = 1000000007L
        var res = 0L

        for (y in ys) {
            val height = y - prevY
            var xStart: Long = sortedRects[0][0].toLong()
            var xEnd: Long = xStart
            for (rect in sortedRects) {
                if (rect[1] <= prevY && rect[3] >= y) {
                    if (rect[0] > xEnd) {
                        res += (height * (xEnd - xStart)).rem(mod)
                        xStart = rect[0].toLong()
                    }
                    if (rect[2] > xEnd) {
                        xEnd = rect[2].toLong()
                    }
                }
            }
            res += (height * (xEnd - xStart)).rem(mod)
            prevY = y
        }

        return res.rem(mod).toInt()
    }
}