package estate;
import java.util.Date;
public class CreatedAds {
    //Fields
    String fName;
    String cName;
    String negName;
    String streetName;
    int price;
    int adNum;
    Date date;
    EstateIntr objEST;
    //Constructor
    public CreatedAds(String fn, String cn, String nn, String sn, int p, int t,Date d, EstateIntr est) {
        fName = fn;
        cName = cn;
        negName = nn;
        streetName = sn;
        price = p;
        adNum = t;
        date= d;
        objEST = est;
    }
    //Print Ad Data method
    public void print() {
        System.out.println("");
        System.out.println("");
        System.out.println("- - - - - - - - AD - - - - - - -");
        System.out.println("Ad Number:\t" + adNum);
        System.out.println("Title:\t\t" + fName);
        System.out.println("Location:\t" + cName+" "+negName+" "+streetName);
        System.out.println("Estate Type:\t" + objEST.getEstateName());
        System.out.println("Category:\t" + objEST.getCategory());
        System.out.println("Price:\t\t" + price + " TL");
        System.out.println("Date:\t\t" + date);
        System.out.println(" - - - - - - - - - - - - - - - - - - -");  
        System.out.println("");
        System.out.println("");
    }
    //Returns Title
    public String getName() {
        return fName;
    }
    //Returns Location (City - Neighbourhood - Street Name)
    public String getLocation() {
    	return cName + " "+ negName +" "+streetName; 	
    }
    //Returns only city name if needed
    public String getCity() {
    	return cName;	
    }
    //Returns Type
    public String getType() {
    	return objEST.getEstateName();
    }
    //Returns Category
    public String getCategory() {
    	return objEST.getCategory();
    }
    //Returns Price
    public int getPrice() {
    	return price;
    }
    //Getters
    public int adNum() {
        return adNum;
    }
    public EstateIntr getObjEST() {
        return objEST;
    }   
    public Date getdate() {
    	return date;
    }
}