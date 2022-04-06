package edu.ucalgary.ensf409

public class Inventory {
  private LinkedList<Food> inventoryList = new LinkedList<Food>();
  
  public Inventory (String url, String user, String password){
    // code to read from database
    // a loop?
    inventoryList.add(foodObj);
  }

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
}
