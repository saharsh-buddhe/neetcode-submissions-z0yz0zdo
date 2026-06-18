class Solution {
    public int[] productExceptSelf(int[] nums) {
        int i = 0;
        int[] output = new int[nums.length];
        
        while (i<nums.length){
            int m = 1;
            int j = 0;
            while(j<nums.length){
                if (j!=i){
                    m = m*nums[j];
                }
                j++;
            }
            output[i] = m;
            i++;
        }
        return output;
    }
}  
