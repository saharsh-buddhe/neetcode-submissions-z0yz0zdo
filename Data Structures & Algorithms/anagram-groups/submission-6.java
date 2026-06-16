class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anagram = new HashMap<>();
        for (String word : strs){
            char characters[] = word.toCharArray();
            Arrays.sort(characters);
            String key = new String(characters);
            List<String> existing = anagram.get(key);
            if(existing == null){
                anagram.put(key, new ArrayList<>());
            }
            anagram.get(key).add(word);
        }
        return new ArrayList<>(anagram.values());
    }
}
