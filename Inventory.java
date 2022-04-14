package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.HashMap;

public class Inventory {
  //username and password need to be student and ensf409, url is the url for the database we'll use
  private final String URL = "jdbc:mysql://localhost/food_inventory";
  private String USERNAME = "student";
  private String PASSWORD = "ensf";
  
  //need these for connecting and accessing the database
  private Connection dbConnect;
  private ResultSet results;
  
  //might be easier to use hashmap for the inventory
  //key is an itemID which maps to a Food object
  //this way we can access elements in a map through ID and access the corresponding Food
  private HashMap<Integer, NutritionalProfile> inventoryMap = new HashMap<Integer, NutritionalProfile>();
  
  //similarly, store the client nutritonal info in a hashmap too??
  //key is the Client ID (1,2,3,4) which maps to nutrtional profile or food or family object?
  private HashMap<Integer, NutritionalProfile> clientMap = new HashMap<Integer, NutritionalProfile>();
  
  //private LinkedList<Food> inventoryList = new LinkedList<Food>();
  
  public Inventory (){
      // Database URL
    this.dbConnect = initializeConnection();
    loadFoodMap();
    loadClientMap();
  }
  


//Must create a connection to the database, no arguments, no return value    
    public Connection initializeConnection(){
        //User "student" was created in sql command prompt and given access to database
        //getConnection function was used to connect to database
        //arguements for getConnection were taken from getters
      try{
          dbConnect = DriverManager.getConnection(getURL(),getUsername(),getPassword());
      } 
      catch (SQLException e) {
          e.printStackTrace();
      }
      return dbConnect;
    }
    
    public String getURL(){
        return this.URL;
    }

    public String getUsername(){
        return this.USERNAME;
    }
    
    public String getPassword(){
        return this.PASSWORD;
    }

  //populate the inventory map with food items from the avaiable food table in the database
  public void loadFoodMap(){
    try{
      Statement myStmt = dbConnect.createStatement();
      //get the items in the available food table
      results = myStmt.executeQuery("SELECT * FROM AVAILABLE_FOOD");
      
      //go through the items in the table
      while(results.next()){
        //save each element in each column into a variable
        int itemID = results.getInt("ItemID");
        String itemName = results.getString("Name");
        int grainContent = results.getInt("GrainContent");
        int FVContent = results.getInt("FVContent");
        int proContent = results.getInt("ProContent");
        int other = results.getInt("Other");
        int calories = results.getInt("Calories");
        
        //make a new food object using the values we got for each item as the arguements
        //combine nutri profile and food class?? will make it easier to keep all the info in 1 class
        NutritionalProfile makeProfile = new NutritionalProfile(itemID, itemName, grainContent, FVContent, proContent, other, calories);
        //store the food into the hash map where the itemID is the key
        inventoryMap.put(itemID, makeProfile);
      }
      myStmt.close();
    }
    //catch any errors in accessing/reading database
    catch(SQLException ex) {
            ex.printStackTrace();
    }
  }

  public HashMap<Integer, NutritionalProfile> getFoodMap(){
      return this.inventoryMap;
  }

  public HashMap<Integer, NutritionalProfile> getClientMap(){
    return this.clientMap;
}
  
  //populate the client map with the infomation about each client's nutri needs
  //store the nutri needs in a food/nutri profile object?
  //mostly the same thing as food method above
  public void loadClientMap(){
    try{
      Statement myStmt = dbConnect.createStatement();
      //get the items in the available food table
      results = myStmt.executeQuery("SELECT * FROM DAILY_CLIENT_NEEDS");
      
      //go through the items in the table
      while(results.next()){
        //save each element in each column into a variable
        int clientID = results.getInt("ClientID");
        String category = results.getString("Client");
        int grainContent = results.getInt("WholeGrains");
        int FVContent = results.getInt("FruitVeggies");
        int proContent = results.getInt("Protein");
        int other = results.getInt("Other");
        int calories = results.getInt("Calories");
        
        //make a new food object using the values we got for each item as the arguements
        //combine nutri profile and food class?? will make it easier to keep all the info in 1 class
        NutritionalProfile makeProfile = new NutritionalProfile(clientID, category, grainContent, FVContent, proContent, other, calories);
        //store the food into the hash map where the itemID is the key
        clientMap.put(clientID, makeProfile);
      }
      myStmt.close();
    }
    //catch any errors in accessing/reading database
    catch(SQLException ex) {
            ex.printStackTrace();
    }
  }
  
  public void remove(int itemID){
    //remove the key, which will in turn also remove all the food data associated with it from the map
    inventoryMap.remove(itemID);
    //remove the item from the database too
    		try {
            //create a general template for the parameters
            String query = "DELETE FROM available_food WHERE itemID = ?";
            //store this template into a preparedStatement for easy access
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setInt(1, itemID);
                        
            int rowCount = myStmt.executeUpdate();
            System.out.println("Rows affected: " + rowCount);
            
            myStmt.close();

        }
        //catch exception if database cannot be accessed/any sort of errors
        catch (SQLException ex) {
            ex.printStackTrace();
        }
  }
  
  //this for if we're going to return Food object
  public NutritionalProfile getItem(int itemID){
    NutritionalProfile wantedFood = inventoryMap.get(itemID);
    return wantedFood;
  }
  
  public void close() {
        
      //for closing everything after we are done using them
      try {
          results.close();
          dbConnect.close();

      }
      //catch exception if database cannot be accessed/any sort of errors
      catch (SQLException e) {
          e.printStackTrace();
      }           

    }

}
