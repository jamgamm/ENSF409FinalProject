package edu.ucalgary.ensf409

import java.sql.*;

public class Inventory {
  //username and password need to be student and ensf409, url is the url for the database we'll use
  private final String URL = "jdbc:mysql://localhost/food_inventory";
  private final String USERNAME = "student";
  private final String PASSWORD = "ensf409";
  
  //need these for connecting and accessing the database
  private connection dbConnect;
  private ResultSet results;
  
  //might be easier to use hashmap for the inventory
  //key is an itemID which maps to a Food object
  //this way we can access elements in a map through ID and access the corresponding Food
  private HashMap<int, Food> inventoryMap = new HashMap<int, Food>();
  
  //similarly, store the client nutritonal info in a hashmap too??
  //key is the Client ID (1,2,3,4) which maps to nutrtional profile or food or family object?
  private HashMap<int, Food> clientMap = new HashMap<int, Food>();
  
  //private LinkedList<Food> inventoryList = new LinkedList<Food>();
  
  public Inventory (String url, String user, String password){
      // Database URL
      this.DBURL = url;

      //  Database credentials
      this.USERNAME = user;
      this.PASSWORD = password;
  }
  


//Must create a connection to the database, no arguments, no return value    
    public void initializeConnection(){
        //User "student" was created in sql command prompt and given access to database
        //getConnection function was used to connect to database
        //arguements for getConnection were taken from getters
      try{
          dbConnect = DriverManager.getConnection(getDburl(),getUsername(),getPassword());
      } 
      catch (SQLException e) {
          e.printStackTrace();
      }
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
        Food makeFood = new Food(itemID, itemName, grainContent, FVContent, proContent, other, calories);
        //store the food into the hash map where the itemID is the key
        inventoryMap.put(itemID, makeFood);
      }
      myStmt.close();
    }
    //catch any errors in accessing/reading database
    catch(SQLException ex) {
            ex.printStackTrace();
    }
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
        Food makeFood = new Food(itemID, itemName, grainContent, FVContent, proContent, other, calories);
        //store the food into the hash map where the itemID is the key
        clientMap.put(clientID, makeFood);
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
  }
  
  //this for if we're going to return Food object
  public Food getItem(int itemID){
    Food wantedFood = inventoryMap.get(itemID);
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
  
  //or if we're going to return String of just the name we can use this
  /*
  public String getItem(int itemID){
    Food wantedFood = inventoryMap.get(itemID);
    String foodName = wantedFood.getName();
    return foodName;
  }
  */
        
  /*
  public remove (String itemID){
    for (int i = 0; i < inventoryList.size(); i++){
      if (inventoryList.get(i).getID == itemID)
        inventoryList.remove(i);
    }
  }
  
  // ********** Not sure if return is food object or string **********
  public String getItem (String itemID){
    for (int i = 0; i < inventoryList.size(); i++){
      if (inventoryList.get(i).getID == itemID)
        return inventoryList.get(i);
    }
}*/
