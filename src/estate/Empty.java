package estate;
public class Empty extends State {
    //Child Class for STATE pattern
    public Empty(EstateAd context) {
        super(context);
    }
    @Override
    public State transitionState() {
        return new Active(context);
    }
    @Override
    public boolean Deactivate() {
        return false;
    }
    @Override
    public boolean Added() {
        return true;
    }
    @Override
    public boolean callDeletion() {
        return false;
    }
    @Override
    public String stateDesc() {
        return "Deleted.";
    }  
}