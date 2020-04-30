https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3313/

class FirstUnique {
    Set<Integer> set = new LinkedHashSet<>();
    Set<Integer> cache = new HashSet<>();

    public FirstUnique(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }
    
    public int showFirstUnique() {
        Iterator<Integer> iterator = set.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return -1;
    }
    
    public void add(int value) {
        if (cache.contains(value)) {
            set.remove(value);
        } else {
            set.add(value);
        }
        cache.add(value);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
