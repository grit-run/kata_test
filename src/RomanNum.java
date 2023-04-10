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
                int dd = number / decimal[ix];
                number = number % decimal[ix];
                rn.append(String.valueOf(roman[ix]).repeat(Math.max(0, dd)));
            }
            ix++;
        }
        return rn.toString();
    }
}
