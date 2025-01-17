import java.util.Arrays;
import java.util.HashMap;

public class Conversion {
    public static long convertToNum(String words){
        HashMap<String, Integer> baseNumbers = new HashMap<>() {{
            put("one", 1);
            put("two", 2);
            put("three", 3);
            put("four", 4);
            put("five", 5);
            put("six", 6);
            put("seven", 7);
            put("eight", 8);
            put("nine", 9);
            put("ten", 10);
            put("eleven", 11);
            put("twelve", 12);
            put("thirteen", 13);
            put("fourteen", 14);
            put("fifteen", 15);
            put("sixteen", 16);
            put("seventeen", 17);
            put("eighteen", 18);
            put("nineteen", 19);
            put("twenty", 20);
            put("thirty", 30);
            put("forty", 40);
            put("fifty", 50);
            put("sixty", 60);
            put("seventy", 70);
            put("eighty", 80);
            put("ninety", 90);

        }};
        HashMap<String, Long> multipliers = new HashMap<>() {{
            put("thousand", 1000L);
            put("million", 1000000L);
            put("billion", 1000000000L);
            put("trillion", 1000000000000L);

        }};
        String[] baseWords = words.split("\\s+|\\s*-\\s*");

        long group = 0;
        long result = 0;
        for(String word: baseWords){
            word = word.toLowerCase();
            if(word.equals("and")) continue;

            if(baseNumbers.containsKey(word)){
                group += baseNumbers.get(word);
            } else if (word.equals("hundred")) {
                group *= 100;
            }else{
                group *= multipliers.get(word);
                result += group;
                group = 0;
            }
        }
        result += group;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(convertToNum("Three hundred and two"));

    }
}
