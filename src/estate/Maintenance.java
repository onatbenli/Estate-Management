package estate;
public class Maintenance extends State {
    //Child Class for STATE pattern
    public Maintenance(EstateAd context) {
        super(context);
    }
    @Override
    public State transitionState() {
        return new Empty(context);
    }
    @Override
    public boolean Deactivate() {
        return false;
    }
    @Override
    public boolean Added() {
        return false;
    }
    @Override
    public boolean callDeletion() {
        return true;
    }
    @Override
    public String stateDesc() {
        return "Ad is deactive";
    }
}