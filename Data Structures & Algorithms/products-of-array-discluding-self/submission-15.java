class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length]; 
        int prefix = 1;
        int i = 0;
        while (i<nums.length){
            output[i] = prefix;
            prefix = prefix * nums[i];
            i++;
        }

        int suffix = 1;
        int i2 = nums.length-1;
        while (i2>=0){
            output[i2] = output[i2]*suffix;
            suffix = suffix * nums[i2];
            i2--;
        }

        return output;
    }
}  

