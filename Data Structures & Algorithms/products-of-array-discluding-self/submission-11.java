class Solution {
    public int[] productExceptSelf(int[] nums) {
        int i = 0;
        int[] nums2 = new int[nums.length];
        while (i < nums.length){
            int m = 1;
            int j = 0;
            while (j < nums.length){
                if (j != i){
                    m  = m * nums[j];
                }
                j++;
            }
            nums2[i] = m;
            i++;
        }
        return nums2;
    }
}  
