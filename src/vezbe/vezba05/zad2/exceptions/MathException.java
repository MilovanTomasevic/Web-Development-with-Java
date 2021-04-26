// ====================================================================
// Naziv: MathException
// File: MathException.java
// Autor: Cicak Tomas
// Datum: mart, 2009.
// Opis: izuzetak za nedozvoljene dimenzije matrica pri mnozenju
// ====================================================================

package exceptions;

public class MathException extends Exception {

    public MathException(String s) {
        super(s);
    }
    
}