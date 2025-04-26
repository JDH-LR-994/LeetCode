package jdh.lr.CodeWars.kyu8;

public class RemovingElements {
    public static Object[] removeEveryOther( Object[] arr ) {
        Object[] newArr = new Object[ ( arr.length + 1 ) / 2 ];
        for ( int i = 0; i < newArr.length; i++ ) {
            newArr[ i ] = arr[ i * 2 ];
        }
        return newArr;
    }
}
