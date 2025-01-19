//273. Integer to English Words
import java.util.HashMap;

class ConversionTwo {
    HashMap<Integer, String> baseNumbers = new HashMap<>() {
        {
            put(1, " One");
            put(2, " Two");
            put(3, " Three");
            put(4, " Four");
            put(5, " Five");
            put(6, " Six");
            put(7, " Seven");
            put(8, " Eight");
            put(9, " Nine");
            put(10, " Ten");
            put(11, " Eleven");
            put(12, " Twelve");
            put(13, " Thirteen");
            put(14, " Fourteen");
            put(15, " Fifteen");
            put(16, " Sixteen");
            put(17, " Seventeen");
            put(18, " Eighteen");
            put(19, " Nineteen");
            put(20, " Twenty");
            put(30, " Thirty");
            put(40, " Forty");
            put(50, " Fifty");
            put(60, " Sixty");
            put(70, " Seventy");
            put(80, " Eighty");
            put(90, " Ninety");
        }
    };

    public String handleHundredAndLess(int num) {
        String result = "";
        if (num >= 100) {
            result += baseNumbers.get(num / 100) + " Hundred";
            num %= 100;

        }
        if (num > 20) {
            int remainder = num % 10;
            result += baseNumbers.get(num - remainder);
            num = remainder;
        }
        if (num > 0) {
            result += baseNumbers.get(num);
        }
        return result;
    }

    public String numberToWords(int num) {
        String result = "";
        if (num == 0)
            return "Zero";

        if (num >= 1000000000) {
            result += handleHundredAndLess(num / 1000000000) + " Billion";
            num = num % 1000000000;

        }

        if (num >= 1000000) {
            result += handleHundredAndLess(num / 1000000) + " Million";
            num = num % 1000000;
        }

        if (num >= 1000) {
            result += handleHundredAndLess(num / 1000) + " Thousand";
            num = num % 1000;
        }
        result += handleHundredAndLess(num);
        return result.trim();

    }
}