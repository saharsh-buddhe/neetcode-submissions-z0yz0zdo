class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for(int i = 0; i<prices.length;i++){
            if(maxProfit < prices[i]-minPrice){
                maxProfit = prices[i]-minPrice;
            }

            if(minPrice > prices[i]){
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
