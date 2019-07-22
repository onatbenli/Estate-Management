package estate;
public abstract class State  {
    //Abstract Class for STATE pattern
	EstateAd context;
    public State(EstateAd context) {
        this.context = context;
    }
    public EstateAd getContext() {
        return context;
    }
    public void setContext(EstateAd context) {
        this.context = context;
    }
    public abstract State transitionState();
    public abstract boolean Deactivate();
    public abstract boolean Added();
    public abstract boolean callDeletion();
    public abstract String stateDesc();
    public static State initialState(EstateAd r){
        return new Empty(r);
    }
}