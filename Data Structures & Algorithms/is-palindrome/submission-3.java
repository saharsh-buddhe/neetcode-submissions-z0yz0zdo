class Solution {
    public boolean isPalindrome(String s) {
        String noSpaces = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        char[] java = noSpaces.toCharArray();
        int i = 0;
        int j = java.length - 1;
        while (i<j){
            if(java[i]!=java[j]){ 
                return false;
            }  
            i++;
            j--;
        }
        return true;
    }
}
