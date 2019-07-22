package estate;

import java.util.HashMap;

public class EstateFactory {
    
    private static EstateFactory factory;
    private HashMap<Integer, EstateIntr> Estates;

    //private constructor for SINGLETON
    private EstateFactory() {
        Estates = new HashMap<Integer, EstateIntr>();
    }
    
    //public getInstance for SINGLETON
    public static EstateFactory getInstance() {
        if(factory == null){
            factory = new EstateFactory();
        }
        return factory;
    }
    
    //synchronized method for factory-estate
    public synchronized EstateIntr getEstate(int typeID){
        if(Estates.get(typeID) == null){
            EstateIntr estIntr = new Estate(typeID);
            Estates.put(typeID, estIntr);
            return estIntr;
        }
        else{
            return (EstateIntr) Estates.get(typeID);
        }
    }
    
    //inner class for factory-estate
    private class Estate implements EstateIntr{

        private int typeID;
        private String estateName;
        private String category;

        private Estate(int id) {
            if(id == 1){
                setFields("House", "Rental");
            }
            if(id == 2){
                setFields("House", "For Sale");
            }
            if(id == 3){
                setFields("Store", "Rental");
            }
            if(id == 4){
                setFields("Store", "For Sale");
            }
            if(id == 5){
                setFields("Land", "Rental");
            }
            if(id == 6){
                setFields("Land", "For Sale");
            }
            this.typeID = id;
        }

        private void setFields(String en, String c){
        	estateName = en;
            category = c;
        }
        
        //Getters and Setters
        public String getEstateName() {
            return estateName;
        }
        public String getCategory() {
            return category;
        }
        public int getTypeID(){
            return typeID;
        } 
    }
}