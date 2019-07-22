package estate;
import java.util.List;
public class Facade {
    //Fields
    EstateFactory ef;
    AdDetail[] ads;
    LogInterface log;
    //Constructor
    public Facade() {
        this.ads = new AdDetail[] { 
            new AdDetail(1, "House"),
            new AdDetail(2, "House"),
            new AdDetail(3, "Store"),
            new AdDetail(4, "Store"),
            new AdDetail(5, "Land"),
            new AdDetail(6, "Land")
        };   
        ef = EstateFactory.getInstance();
        log = new LogAdapter();
    }
    //Service Methods
    //create ad
    public CreatedAds createAd(Ad g){
        AdDetail h = ads[g.adId]; 
        int aNum = h.getNextAd();
        if(aNum == 0){
            return null;
        }
        EstateAd r = h.getAdByNum(aNum);
        EstateIntr fwi = ef.getEstate(h.getAdId());
        CreatedAds result = new CreatedAds(g.fName,g.cName,g.negName,g.streetName, g.price, aNum, g.addate, fwi);
        r.setState(r.state.transitionState());      
        String logMsg =  
                  "\t\tAction: New ad created\n"
                + "\t\tAd No #: " + aNum + "\n"
                + "\t\tTitle: " + g.fName + "\n"
                + "\t\tCity: " + g.cName + "\n"
                + "\t\tNeighbourhood: " + g.negName + "\n"
                + "\t\tStreet: " + g.streetName + "\n"
                + "\t\tEstate: " + h.getAdName() + "\n"
                + "\t\tPrice: " + g.price + " TL\n"
                + "\t\tStatus: " + r.state.stateDesc() + "\n"
                + "\t\tDate: " + g.addate + "\n";
        log.printLog(logMsg);
        return result;
    }
    //deactivate
    public void Deactivate(CreatedAds ad){
        AdDetail h = ads[ad.objEST.getTypeID() - 1];
        EstateAd r = h.getAdByNum(ad.adNum);
        r.setState(r.state.transitionState());
        String logMsg =  
                  "\t\tAction: Ad Deactivation\n"
                + "\t\tCategory: " + h.getAdName() + " - " + h.getAdId() + "\n"
                + "\t\tAd No #: " + ad.adNum + "\n"
                + "\t\tTitle: " + ad.getName() + "\n"
                + "\t\tStatus: " + r.state.stateDesc() + "\n";
        log.printLog(logMsg);
    }
    //call deletion
    public void callDeletion(){
        for(AdDetail h : ads){
            List<EstateAd> rms = h.getAdsToDelete();
        }
    }
}