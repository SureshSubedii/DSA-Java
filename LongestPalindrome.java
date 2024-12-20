class LongestPalindrome {
    public int isLongestPalindrome(String s) {
        Boolean oddFound = false;
        int sum = 0;
        Map<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character str = s.charAt(i);
            if (!frequency.containsKey(str))
                frequency.put(str, 0);

            frequency.put(str, frequency.get(str) + 1);
        }
        for (Integer value : frequency.values()) {
            Boolean isOdd = value % 2 == 1;
            if (isOdd && oddFound)
                value--;
            else if (isOdd)
                oddFound = true;

            sum += value;
        }
        return sum;

    }
}
