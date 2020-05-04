https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3316/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {        
        int lo = 1;
        int hi = n;
        int mid;
        int res = -1;
        // BECAREFUL WITH OVERFLOW VALUE
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return res;
    }
}
