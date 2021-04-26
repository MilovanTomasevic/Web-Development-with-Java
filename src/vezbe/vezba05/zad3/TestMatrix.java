import mylib.math.Matrix;
import exceptions.MathException;

public class TestMatrix {

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
            
            e = Matrix.multiply(c, d);
            System.out.println("C * D =\n"+e);
        
            b.multiply2(d);
            System.out.println("B *= D\n"+b);
            
            System.out.println("\nnastavljeno do kraja");
        
        }catch(MathException ex){
            System.err.println(ex);
        }catch(Exception ex){
            System.err.println(ex);
        }
        
    }

}