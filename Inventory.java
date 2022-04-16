package edu.ucalgary.ensf409;
/**
 * A class that is responsible for creating connections to the database
 * @author Jana Afifi, Amneet Deol, Jam Ivy Gammuac, Shanelle Li Chit Khim
 * @version 1.6
 * @since 1.0 
 */
import java.sql.*;
import java.util.HashMap;

public class Inventory {
  private final String URL = "jdbc:mysql://localhost/food_inventory";
  private final String USERNAME = "student";
  private final String PASSWORD = "ensf";
  
  private Connection dbConnect;
  private ResultSet results;
  
  private HashMap<Integer, NutritionalProfile> inventoryMap = new HashMap<Integer, NutritionalProfile>();

  private HashMap<Integer, NutritionalProfile> clientMap = new HashMap<Integer, NutritionalProfile>();

  /*
   * Constructor for the Inventory object
   * The constructor will connect to the database so that the database can be accessed
   * It will also call the loadFoodMap and loadClientMap methods to build the HashMaps
   * that will contain the information about the NutritionalProfiles of the food inventory
   * and clients from the database
   */
  public Inventory (){
    this.dbConnect = initializeConnection();
    loadFoodMap();
    loadClientMap();
  }
  

/**
   * this method will create the connection to the database
   * the method getConnection will take in the database URL, the username "student"
   * and the password "ensf"
   * It will catch an SQLException if there is a failure or error in connecting to the database
   * @return Connection - the connection to the database
   */
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

  /**
   * this method will populate the inventoryMap HashMap with the foods available in the database
   * The available food table will be read and store the values in each column in a
   * NutritionalProfile object. Then each food item's Nutritional Profile will be added to
   * the HashMap with the food's ID number as the key.
   */
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
        
        //make a new nutritional profile object using the values we got for each item as the arguements
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

   /**
   * this method will populate the clientMap HashMap with the client daily needs provided
   * in the database.
   * The daily client needs table will be read and store the values in each column in a
   * NutritionalProfile object. Then each client's Nutritional Profile will be added to
   * the HashMap with the client's ID number as the key.
   */
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
        
        //make a new nutritional profile object using the values we got for each item as the arguements
        NutritionalProfile makeProfile = new NutritionalProfile(clientID, category, grainContent, FVContent, proContent, other, calories);
        //store the client's information into the hash map where the itemID is the key
        clientMap.put(clientID, makeProfile);
      }
      myStmt.close();
    }
    //catch any errors in accessing/reading database
    catch(SQLException ex) {
            ex.printStackTrace();
    }
  }
  
  /**
  * @param itemID - the ID of an item in the inventoryMap that needs to be removed
   * this method will remove a given item in the inventoryMap and also
   * remove the same item in the database.
   * First the item will be removed from the inventoryMap using the item's ID as the key,
   * which will remove the key and the NutritionalProfile associated with it from the map.
   * Then it will go to the database and delete the item in the available food table
   * that corresponds to the given ID
   */
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
                        
            myStmt.executeUpdate();
            
            myStmt.close();

        }
        //catch exception if database cannot be accessed/any sort of errors
        catch (SQLException ex) {
            ex.printStackTrace();
        }
  }
  
    /** Getters **/
  
  /**
   * @return String - returns the URL needed to connect to the database
   */
    public String getURL(){
        return this.URL;
    }

  /**
   * @return String - returns the username needed to connect to the database
   */
    public String getUsername(){
        return this.USERNAME;
    }
  
    /**
   * @return String - returns the password needed to connect to the database
   */
    public String getPassword(){
        return this.PASSWORD;
    }
  
  /**
   * @return HashMap<Integer,NutritionalProfile> - returns the HashMap that contains the
   * food nutritional profile information
   */
  public HashMap<Integer, NutritionalProfile> getFoodMap(){
      return this.inventoryMap;
  }

  /**
   * @return HashMap<Integer,NutritionalProfile> - returns the HashMap that contains the
   * client nutritional profile information
   */
  public HashMap<Integer, NutritionalProfile> getClientMap(){
    return this.clientMap;
  }
  
  /**
   * @param itemID - the ID number of the item that needs to be returned
   * @return NutritionalProfile - returns the NutritionalProfile that corresponds to the given itemID
   * this method will access the inventoryMap HashMap and get the NutritionalProfile associated with
   * the key, which is the item ID
   */
  public NutritionalProfile getItem(int itemID){
    NutritionalProfile wantedFood = inventoryMap.get(itemID);
    return wantedFood;
  }
  
  /**
    * this method is for closing the results and dbConnect when
    * we are done with using the database.
    * It is important to close these connections to prevent crashes
    * or memory leakages
    */
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
