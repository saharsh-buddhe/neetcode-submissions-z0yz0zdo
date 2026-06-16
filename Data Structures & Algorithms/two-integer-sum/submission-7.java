class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer,Integer> concept = new HashMap<>();
       for(int i = 0 ; i<nums.length; i++){
         Integer complementIndex = concept.get(nums[i]);
         if(complementIndex != null ){
            return new int[]{complementIndex,i};
            }
         concept.put(target-nums[i],i);
         }
         return nums; 
       }

}
