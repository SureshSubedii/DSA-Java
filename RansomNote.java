class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            Character str = magazine.charAt(i);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            Character str = ransomNote.charAt(i);
            if (!map.containsKey(str) || map.get(str) == 0)
                return false;

            map.put(str, map.get(str) - 1);

        }
        return true;


    }
}
