class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagram = new HashMap<>();
        for(String word : strs){
            char letter[] = word.toCharArray();
            Arrays.sort(letter);
            String updatedWord = new String(letter);
            List<String> existing = anagram.get(updatedWord);
            if(existing == null){
                anagram.put(updatedWord, new ArrayList<>());
            }
            anagram.get(updatedWord).add(word);
        }
        return new ArrayList<>(anagram.values());
    }
}
