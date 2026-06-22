class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();

        for (int n : nums){
            hash.add(n);
        }

        int longest = 0;
        for(int n : hash){
            if(!hash.contains(n-1)){
                int length = 1;
                while(hash.contains(n+length)){
                    length++;
                }
                longest = Math.max(longest,length);
            }
        }
        return longest;
    }
}
