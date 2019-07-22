package estate;

public class LogAdapter extends Logger implements LogInterface{
    
    //Adapter class
    
    @Override
    public void printLog(String msg){
        super.logMsg(msg);
    }
    
}
