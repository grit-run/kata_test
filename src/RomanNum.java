public class RomanNum {
    static String[] roman = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    static int[] decimal = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

//    public static void main(String[] args) {
//        System.out.println(decToRome(9));
//    }
    public static String decToRome(int number) {
        StringBuilder rn = new StringBuilder();
        int ix = 0;
        while (ix < roman.length) {
            while (number >= decimal[ix]) {
                var dd = number / decimal[ix];
                number = number % decimal[ix];
                for (int i=0; i<dd; i++) {
                    rn.append(roman[ix]);
                }
            }
            ix++;
        }
        return rn.toString();
    }
}
