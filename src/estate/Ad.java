package estate;
import java.util.Date;
public class Ad {
    
    //Fields
    String fName;
    String cName;
    String negName;
    String streetName;
    int price;
    int adId;
    Date addate;

    //Constructor
    public Ad(String f,String c,String n , String s, int p, int d,Date date){
        fName = f;
        cName = c;
        negName = n;
        streetName = s;
        price = p;
        adId = d;
        addate= date;
    }
    
}
