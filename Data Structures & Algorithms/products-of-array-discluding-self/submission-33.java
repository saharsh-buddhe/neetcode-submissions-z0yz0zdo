class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefix = 1;

        int i = 0;
        int[] output = new int[nums.length];

        while(i < nums.length){
            output[i] = prefix;
            prefix = prefix * nums[i];
            i++;
        }

        int suffix = 1;
        int j = nums.length - 1;
         
        while(j >= 0){
            output[j] = output[j] * suffix;
            suffix = suffix * nums[j];
            j--;
        }

        return output;
    }
}  
