package estate;
public class EstateAd {
    //Fields
    int adNum;
    State state;
    int adId;
    //Constructor
    public EstateAd(int adNum, int h) {
        this.adNum = adNum;
        this.adId = h;       
        this.state = State.initialState(this);
    }
    //Getters and Setters
    public int getAdNum() {
        return adNum;
    }
    public void setAdNum(int adNum) {
        this.adNum = adNum;
    }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
    //Service Methods to check ad's state
    public boolean Added(){
        return state.Added();
    }
    public boolean Deactivate(){
        return state.Deactivate();
    }
    public boolean callDelete(){
        return state.callDeletion();
    }
}