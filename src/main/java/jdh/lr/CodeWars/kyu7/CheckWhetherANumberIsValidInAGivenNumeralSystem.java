package jdh.lr.CodeWars.kyu7;

public class CheckWhetherANumberIsValidInAGivenNumeralSystem {
    static String AllBase = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static boolean validateBase(String num, int base) {
        for (int i = 0; i < num.length(); i++) {
            if (AllBase.charAt(base-1) < num.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
