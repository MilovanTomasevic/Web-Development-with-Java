// ====================================================
// Naziv: Matrix
// File: Matrix.java
// Autor: Cicak Tomas
// Datum: mart, 2009.
// Opis: program mnozi dve matrice
// ====================================================

class Matrix {

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
    
    public static void main(String[] args)
    {
        double[][] niz23 = { {1, 2, 3}, 
                             {4, 5, 6} };
        
        double[][] niz32 = { {2,   3}, 
                             {5,  -7}, 
                             {11, 13} };
        
        double[][] niz34 = { {1,   1,  2,  3 }, 
                             {5,  -8, 13, 21 }, 
                             {34, 55, 89, 144} };
        
        double[][] niz43 = { {2,  4, 0}, 
                             {1,  3, 5}, 
                             {0, -5, 1}, 
                             {8,  7, 6} };
        
        Matrix a = new Matrix();
        Matrix b = new Matrix();
        Matrix c = new Matrix();
        Matrix d = new Matrix();
        Matrix e = new Matrix();
        a.setData(niz23);
        b.setData(niz32);
        c.setData(niz34);
        d.setData(niz43);
        
        System.out.println("A:\n"+a);
        System.out.println("B:\n"+b);
        System.out.println("C:\n"+c);
        System.out.println("D:\n"+d);
        
        try{
            e = a.multiply(b);
            System.out.println("A * B =\n"+e);
            
            e = multiply(c, d);
            System.out.println("C * D =\n"+e);
        
            b.multiply2(d);
            System.out.println("B *= D\n"+b);
        
        }catch(Exception ex){
            System.err.println(ex);
        }
        
    }
    
    private double[][] data;
}