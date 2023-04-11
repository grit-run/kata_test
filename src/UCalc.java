import java.io.IOException;
import java.util.Scanner;

public class UCalc {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число, желаемое арифметическое действие и второе число (числа арабские или римские)");
        String exp_line = scanner.nextLine();
        System.out.println(parse(exp_line));
    }

    public static String parse(String exp_line) throws IOException {
        int[] digit = new int[2];
        boolean isRomanN;
        String operation = Addition.checkAction(exp_line);
        if (operation == null) throw new IOException("Неправильное математическое действие");
        String[] sym_digits = exp_line.split(operation);
        if (sym_digits.length > 2) throw new IOException("Слишком много чисел");
        if (Addition.isRoman(sym_digits[0]) && Addition.isRoman(sym_digits[1]))  {
            digit[0] = Addition.toArabian(sym_digits[0]);
            digit[1] = Addition.toArabian(sym_digits[1]);
            isRomanN = true;
        }
        else if (!Addition.isRoman(sym_digits[0]) && !Addition.isRoman(sym_digits[1])) {
            digit[0] = Integer.parseInt(sym_digits[0]);
            digit[1] = Integer.parseInt(sym_digits[1]);
            isRomanN = false;
        }
        else {
            throw new IOException("Числа должны быть в одной системе исчисления");
        }
        if (digit[0] > 10 || digit[1] > 10) {
            throw new IOException("Числв не могут быть больше 10!");
        }
        int result = Addition.mathOper(digit[0], digit[1], String.valueOf(operation.charAt(operation.length() - 1))) ;
        if (isRomanN) {
            if (result <= 0) {
                throw new IOException("арабские цифры больше нуля");
            }
            return RomanNum.decToRome(result);
        }
        else {
            return String.valueOf(result);
        }
    }
}