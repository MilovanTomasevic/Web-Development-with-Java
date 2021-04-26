// ====================================================
// Naziv: Matrix
// File: Matrix.java
// Autor: Cicak Tomas
// Datum: mart, 2009.
// Opis: program mnozi dve matrice
// ====================================================

package mylib.math;

import exceptions.MathException;

public class Matrix {

    public void setData(double[][] x) {
        data = x;
    }
    
    public double[][] getData() {
        return data;
    }
    
    public Matrix multiply(Matrix b) throws MathException {
        int ar = this.getData().length;     // broj redova u a
        int ac = this.getData()[0].length;  // broj kolona u a
        int br = b.getData().length;        // broj redova u b
        int bc = b.getData()[0].length;     // broj kolona u b
        if(ac != br) {
            throw new MathException("Pogresne dimenzije matrice.");
        }else{
            double[][] r = new double[ar][bc];
            for(int i = 0; i < ar; i++)
                for(int j = 0; j < bc; j++)
                    for(int k = 0; k < br; k++)
                        r[i][j] +=  this.getData()[i][k] * b.getData()[k][j];
            
            Matrix val = new Matrix();
            val.setData(r);
            
            return val;
        }
    }
    
    public static Matrix multiply(Matrix a, Matrix b) {
        Matrix val = new Matrix();
        
        try{
            val = a.multiply(b);
        }catch(MathException e){
            System.err.println(e);
        }
        
        return val;
    }
    
    public void multiply2(Matrix b) {
        Matrix tmp = new Matrix();
        tmp = multiply(this, b);
        this.setData(tmp.getData());
    }
    
    public String toString() {
        String retVal = "";
        for(int i=0; i<data.length; i++) {
            for(int j=0; j<data[0].length; j++)
                retVal += data[i][j] + "\t";
            retVal += "\n";
        }
                
        return retVal;
    }
    
    
    
    private double[][] data;
}