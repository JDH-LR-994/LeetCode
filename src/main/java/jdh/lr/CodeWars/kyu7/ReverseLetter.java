package jdh.lr.CodeWars.kyu7;

public class ReverseLetter {
    public static String reverseLetter(final String str) {
        var result = new StringBuilder();
        for ( int i = str.length()-1; i > -1; i-- ) {
            if (Character.isAlphabetic( str.charAt(i))){
                result.append( str.charAt(i) );
            }
        }
        return result.toString();
    }
}
