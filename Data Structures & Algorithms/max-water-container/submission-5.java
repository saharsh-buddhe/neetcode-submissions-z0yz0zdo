class Solution {
    public int maxArea(int[] heights) {
        int area;
        int maxArea =0;
        for(int i = 0; i<heights.length; i++){
            for(int j = i+1; j<heights.length;j++){
                area = (j-i) * Math.min(heights[i],heights[j]);
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}
