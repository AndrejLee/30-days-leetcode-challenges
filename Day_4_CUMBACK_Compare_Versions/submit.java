https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3454/

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        
        int length = Math.max(nums1.length, nums2.length);
        
        for (int i = 0; i < length; i++) {
            int current1 = 0;
            if (i < nums1.length) {
                current1 = Integer.parseInt(nums1[i]);
            }
            
            int current2 = 0;
            if (i < nums2.length) {
                current2 = Integer.parseInt(nums2[i]);
            }
            
            if (current1 < current2)
                return -1;
            
            if (current1 > current2)
                return 1;
        }
        
        return 0;
    }
}
