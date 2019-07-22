package estate;
public class Active extends State {
    //Child Class for STATE pattern
    public Active(EstateAd context) {
        super(context);
    }
    @Override
    public State transitionState() {
        return new Maintenance(context);
    }
    @Override
    public boolean Added() {
        return true;
    }
    @Override
    public boolean Deactivate() {
        return false;
    }
    @Override
    public boolean callDeletion() {
        return false;
    }
    @Override
    public String stateDesc() {
        return "Ad is Active";
    }
}