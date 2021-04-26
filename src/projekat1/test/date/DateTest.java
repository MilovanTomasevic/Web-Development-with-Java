
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTest {

    public static void main(String[] args) {
        GregorianCalendar d1 = new GregorianCalendar();
        GregorianCalendar d2 = new GregorianCalendar();

        d1.set(2008, Calendar.JANUARY, 1);
        //d2.set(2009, Calendar.JANUARY, 1);
        d2 = null;
        
        if(d2 == null) System.out.println("null");
        
        d2 = new GregorianCalendar();
        
        //d2.set(2009, Calendar.JANUARY, 1);
        
        if(d2 != null) System.out.println("nije null");

        long t1 = d1.getTime().getTime();
        long t2 = d2.getTime().getTime();
        long dt = t2-t1;

        long milPerDay = 1000*60*60*24;

        long days = dt/milPerDay;

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy.");

        System.out.println("Date1: " + formatter.format(d1.getTime()));
        System.out.println("Date2: " + formatter.format(d2.getTime()));
        System.out.println("Razlika u danima:" + days);
    }
}
