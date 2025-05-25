package jdh.lr.LeetCode.Easy;

public class ScoreOfAString {
    public int scoreOfString( String str ) {
        int res = 0;
        for ( int i = 1; i < str.length(); i++ ) {
            res += Math.abs(str.charAt(i) - str.charAt(i - 1));
        }
        return res;
    }
}
