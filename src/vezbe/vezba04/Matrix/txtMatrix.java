// ====================================================
// Naziv: Matrix
// File: Matrix.java
// Autor: Cicak Tomas
// Datum: mart, 2009.
// ====================================================

public class Matrix {
    /* Postavlja sadr�aj matrice. */
    public void setData(double[][] x) {...}

    /* Vra�a sadr�aj matrice. */
    public double[][] getData() {...}

    /* Mno�i sadr�aj matrice objekta koji je pozvan (this) sa
     sadr�ajem matrice b (objekta koji je prosle�en kao
     parametar). Rezultat mno�enja sme�ta u novi objekat koga
     vra�a kao rezultat metode. */
    public Matrix multiply(Matrix b) {...}

    /* Mno�i sadr�aj dve date matrice i rezultat mno�enja
     vra�a kao rezultat metode. Obratiti pa�nju da je ovo
     stati�ka metoda! */
    public static Matrix multiply(Matrix a, Matrix b){...}

    /* Mno�i sadr�aj matrice objekta koji je pozvan (this) sa
     sadr�ajem matrice b (objekta koji je prosle�en kao
     parametar). Rezultat mno�enja se sme�ta u matricu objekta
     koji je pozvan. Metoda ne vra�a nikakav rezultat! */
    public void multiply2(Matrix b) {...}

    /* Polazna ta�ka programa. Slu�i za testiranje funkcionalnosti
     ostalih metoda klase. Za potrebe testiranja formirati nekoliko
     vi�edimenzionalnih nizova. */
    public static void main(String[] args) {...}

    /* Sadr�aj matrice */
    private double[][] data;
}