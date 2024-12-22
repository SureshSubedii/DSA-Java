// 67. Add Binary
class BinaryAddition {
    public String addBinary(String a, String b) {
        int aOrB = a.length() - b.length();
        StringBuilder newB = new StringBuilder(b);
        StringBuilder newA = new StringBuilder(a);
        StringBuilder less = aOrB > 0 ? newB : newA;
        for (int i = 0; i < Math.abs(aOrB); i++) {
            less.insert(i, "0");
        }
        Boolean carry = false;
        StringBuilder result = new StringBuilder("");

        for (int i = newB.length() - 1; i >= 0; i--) {
            String val = "";
            if (newA.charAt(i) == '0' && newB.charAt(i) == '0') {
                val = carry ? "1" : "0";
                carry = false;

            } else if (newA.charAt(i) == '1' && newB.charAt(i) == '1') {
                val = carry ? "1" : "0";
                carry = true;
            } else if (newA.charAt(i) == '1' || newB.charAt(i) == '1' && carry) {
                val = carry ? "0" : "1";

            } else {
                val = "1";
                carry = false;
            }

            result.insert(0, val);

        }
        if (carry)
            result.insert(0, "1");

        return result.toString();

    }
}
