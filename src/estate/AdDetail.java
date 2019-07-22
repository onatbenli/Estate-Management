package estate;
import java.util.ArrayList;
import java.util.List;
public class AdDetail {
    
    //Fields
    private EstateAd[] ads;
    private int adId;
    private String adName;

    //Constructor
    public AdDetail(int adId, String adName) {
        this.adId = adId;
        this.adName = adName;
        this.ads = new EstateAd[100];
        
        for(int i = 1; i < 6; i++){
        	EstateAd r = new EstateAd(100 + i, this.adId);
            this.ads[i - 1] = r;
        }
    }
    
    //Service Methods
    //method to get the next ad
    public int getNextAd(){
        for(EstateAd e : ads){
            if(e.Added()){
                return e.getAdNum();
            }
        }
        
        return 0;
    }
    
    //method to get array of ads will be deleted
    public List<EstateAd> getAdsToDelete(){
        List<EstateAd> ea = new ArrayList<>();
        for(EstateAd e : ads){
                ea.remove(e);   
        }
        return ea;
    }
    
    //method to get EstateAd object by AdNum
    public EstateAd getAdByNum(int en){
        for(EstateAd e : ads){
            if(e.getAdNum() == en){
                return e;
            }
        }
        return null;
    }

    //Getters and Setters
    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }
    
    
}
