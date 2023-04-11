public class Addition {
    static String[] romanList = new String[]{"00", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public static boolean isRoman(String r_val) {
        for (String s : romanList) {
            if (r_val.equals(s)) {
                return true;
            }
        }
        return false;
    }
    public static int toArabian(String raw_roman) {
        for (int i=0; i<=romanList.length;i++) {
            if (raw_roman.equals(romanList[i])) {
                return i;
            }
        }
        return -1;
    }
    static String checkAction(String exp_line) {
        if (exp_line.contains("+")) return "\\+";
        if (exp_line.contains("-")) return "-";
        if (exp_line.contains("/")) return "/";
        if (exp_line.contains("*")) return "\\*";
        else return null;
    }

    static int mathOper(int n1, int n2, String oper) {
        if (oper.equals("+")) return n1+n2;
        if (oper.equals("-")) return n1-n2;
        if (oper.equals("*")) return n1*n2;
        if (n2 > 0) return n1/n2;
        else throw new ArithmeticException("Деление на ноль не разрешено");
    }
}
