package jdh.lr.CodeWars.kyu7;

public class CreditCardMask {
    public static String maskify(String str) {
        if (str.length() <= 4) {
            return str;
        }
        var sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.length() - i > 4) {
                sb.append("#");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
