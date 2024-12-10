import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

class Parenthesis {
    public boolean isValid(String s) {
        int strLength = s.length();
        if (strLength % 2 != 0)
            return false;
        Map<Character, Character> parenthesis = Map.of(
                '}', '{',
                ')', '(',
                ']', '[');
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < strLength; i++) {
            char bracket = s.charAt(i);

            if (parenthesis.containsKey(bracket)) {
                if (stack.isEmpty() || stack.pop() != parenthesis.get(bracket)) {
                    return false;
                }

            } else {
                stack.push(bracket);

            }

        }

        return stack.isEmpty();
    }
}