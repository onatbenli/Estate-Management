package estate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
public class Main {
    
    private static Scanner read = new Scanner(System.in);
	private static Scanner scan;
        
    public static void main(String[] args) {
        
        //Fields
        List<CreatedAds> createdAds = new ArrayList<>();
        boolean running = true;
        Facade clientFacade = new Facade();
        
        //Opening Title
        System.out.println("Welcome To Estate Manager");
        
        //Main Menu Switch
        while(running){
            System.out.println("\n");
            System.out.println("***********Main Menu*************");
            System.out.println("Please Choose An Option:");
            System.out.println("1\tCreate an Estate");
            System.out.println("2\tList All Estates");
            System.out.println("3\tClear the List");
            System.out.println("4\tSearch in the List");
            System.out.println("5\tExit");
            System.out.println("*********************************");
            
            System.out.print("Enter a number: ");
            String in = read.next();
            int i;
            try{
                i = Integer.parseInt(in);
            }catch(Exception e){
                i = 0;
            }
            
            switch(i){
                case 1:
                    Ad g = estatesMenu();
                    CreatedAds ca = clientFacade.createAd(g);
                    if(ca == null){
                        System.out.println("Sorry, there are no estates available at this location.");
                        break;
                    }
                    System.out.print("Press ENTER to view the Ad:");
                    read.nextLine();
                    read.nextLine();
                    ca.print();
                    System.out.print("Press ENTER to return to Main Menu");
                    read.nextLine();
                    createdAds.add(ca);
                    break;
                case 2:
                    CreatedAds caDA = DeactiveMenu(createdAds);
                    if(caDA == null){
                        break;
                    }
                    clientFacade.Deactivate(caDA);
                    System.out.print("Press ENTER to return to Main Menu");
                    read.nextLine();
                    read.nextLine();
                    break;
                case 3:
                    deletionMenu();
                    clientFacade.callDeletion();
                    System.out.print("Press ENTER to return to Main Menu");
                    read.nextLine();
                    read.nextLine();
                    break;
                case 4:
                	CreatedAds caSearch = SearchMenu(createdAds);
                    if(caSearch == null){
                        break;
                    }
                    System.out.print("Press ENTER to return to Main Menu");
                    read.nextLine();
                    read.nextLine();
                    break;
                case 5:
                    System.out.println("Thank You");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Selection. Please, try again.");
                    break;
            }
            
        }
        
    }
    
    //Estate adding menu method
    public static Ad estatesMenu(){
    	scan = new Scanner(System.in);
        int typeID = 0;
        while(typeID <= 0 || typeID >= 6){
            System.out.println("Please Select A Category");
            System.out.println("\t1. House - Rental");
            System.out.println("\t2. House - For Sale");
            System.out.println("\t3. Store - Rental");
            System.out.println("\t4. Store - For Sale");
            System.out.println("\t5. Land - Rental");
            System.out.println("\t6. Land - For Sale");

            System.out.print("Enter a number: ");
            String in = read.next();
            int i;
            try{
                i = Integer.parseInt(in);
            }catch(Exception e){
                i = 0;
            } 
            if(i <= 0 || i >= 6){
                System.out.println("Invalid Selection. Please, try again.");
            }
            typeID = i;
        }
        
        System.out.println("\nEnter Estate's Title:");
        String f = 	scan.nextLine();

        System.out.println("\nEnter Estate's City:");
        String c = scan.nextLine();
        
        System.out.println("\nEnter Estate's Neighbourhood:");
        String n = scan.nextLine(); 
        
        System.out.println("\nEnter Estate's Street:");
        String s = scan.nextLine();
        
        System.out.println("\nEnter Estate's Price:");
        int p = scan.nextInt();
        
        Date date = new Date();
        System.out.println("\nEnter Estate's AD Date:"+date.toString());
        
        
        
		return new Ad(f, c,n, s, p, typeID - 1, date);        
    }
    
    //Deactivate Menu Method
    public static CreatedAds DeactiveMenu(List<CreatedAds> ads){
        if(ads.size() <= 0){
            System.out.println("There are no estate to show.");
            System.out.println("Press ENTER to return to Main Menu");
            read.nextLine();
            read.nextLine();
            return null;
        }
        
        String menuOptions = "";
        for(int i = 0; i < ads.size(); i++){
            menuOptions += "\t" + (i+1) + ". " 
            			+ ads.get(i).getName() 
            			+ " " + ads.get(i).getLocation()
            			+ " " + ads.get(i).getCategory() 
            			+ " " + ads.get(i).getType() 
            			+ " " + ads.get(i).getPrice() + " TL" + "\n" ;
        }
        
        int adIndex = -1;
        while(adIndex < 0 || adIndex >= ads.size()){
            System.out.println("Please Select An Ad To Deactivate");
            System.out.println(menuOptions);

            System.out.print("Enter a number: ");
            String in = read.next();
            
            int i;
            try{
                i = Integer.parseInt(in);
            }catch(Exception e){
                i = -1;
            } 
            if(i <= 0 || i > ads.size()){
                System.out.println("Invalid Selection. Please, try again.");
            }
            adIndex = i-1;
        }
        
        return ads.remove(adIndex);
    }
  //Search Menu Method
    public static CreatedAds SearchMenu(List<CreatedAds> ads){
    	scan = new Scanner(System.in);
        if(ads.size() <= 0){
            System.out.println("There are no estate to show.");
            System.out.println("Press ENTER to return to Main Menu");
            read.nextLine();
            read.nextLine();
            return null;
        }
        
        System.out.println("\nEnter Max Price:");
        int p = scan.nextInt();
        
        
        String menuOptions = "";
        for(int i = 0; i < ads.size(); i++){
        	if(p >= ads.get(i).getPrice()) {
            menuOptions += "\t" + (i+1) + ". " 
            			+ ads.get(i).getName() 
            			+ " " + ads.get(i).getLocation()
            			+ " " + ads.get(i).getCategory() 
            			+ " " + ads.get(i).getType() 
            			+ " " + ads.get(i).getPrice() + " TL" + "\n" ;

            
        	}
        	else {
        		
        	}
        	
        }
        System.out.println(menuOptions);
        System.out.println("Press ENTER to return to Main Menu");
        read.nextLine();
        read.nextLine();
        return null;
    }
    
    
    //Deletion Menu Method
    public static void deletionMenu(){
        System.out.println("All deactivated ads will be deleted.");
    }
}
