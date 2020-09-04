https://leetcode.com/explore/featured/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3448/

class Solution {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> last = new HashMap<Character, Integer>();
        for (int i = 0; i < S.length(); i++) {
            char current = S.charAt(i);
            last.put(current, i);
        }
        
        List<Integer> result = new ArrayList<Integer>();
        int moveIdx = 0;
        int startIdx = 0;
        int endIdx = -1;
        
        do {
            int nextEnd = last.get(S.charAt(moveIdx));
            if (nextEnd > endIdx)
                endIdx = nextEnd;
            
            if (moveIdx == endIdx) {
                result.add(endIdx - startIdx + 1);
                startIdx = endIdx + 1;
            }
            
            moveIdx++;
        } while (moveIdx < S.length());
        
        return result;
    }
}
