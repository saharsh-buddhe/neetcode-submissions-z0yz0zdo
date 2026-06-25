class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i<nums.length; i++){
            if(i > 0 && nums[i]==nums[i-1]){
                continue;
            }
            int first = i+1;
            int end = nums.length-1;

            while(first<end){
                if(nums[first]+nums[end]<-nums[i]){
                    first++;
                } else if(nums[first]+nums[end]>-nums[i]){
                    end--;
                }else{
                    result.add(Arrays.asList(nums[i],nums[first],nums[end]));
                    first++;
                    end--;
                    while(first<end && nums[first] == nums[first-1]) first++;
                     while(first<end && nums[end] == nums[end+1]) end--;
                }
            }
        }
        return result;
    }
}
