https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3291/

// Another solution, using stack
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int sizeS = S.length();
        int sizeT = T.length();
        int indexS = sizeS;
        int countS = 0;
        int indexT = sizeT;
        int countT = 0;
        int maxSize = Math.max(sizeS, sizeT);
        
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        
        for (int i = maxSize - 1; i >= 0; --i) {
            if (i < sizeS) {
                if (s[i] == '#') {
                    ++countS;
                } else {
                    if (countS == 0) {
                        s[--indexS] = s[i];
                    } else if (countS > 0) {
                        --countS;
                    }
                }
            }
            
            if (i < sizeT) {
                if (t[i] == '#') {
                    ++countT;
                } else {
                    if (countT == 0) {
                        t[--indexT] = t[i];
                    } else if (countT > 0) {
                        --countT;
                    }
                }
            }
        }
        
        int difS = sizeS - indexS;
        int difT = sizeT - indexT;
        
        if (difS != difT)
            return false;
        
        indexS = sizeS - 1;
        indexT = sizeT - 1;
        
        for (int i = 1; i <= difS; ++i) {
            if (s[indexS--] != t[indexT--])
                return false;
        }
        
        return true;
    }
}
