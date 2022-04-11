package edu.ucalgary.ensf409

public class Order {
  //public LinkedList[] hamperList;
  
  public Order(){
  //might need a family object
  
  }
  
  public Hamper findBestCombo(LinkedList[] hamperList){
    // have a score system to determine best hamper combination
    // if a hamper does not reach the requirement for a particular nutrition then the score is  and hamper should be dropped
    // eg grainScore = 1; fvScore = 1; proScore = 2; otherScore = 2; tCaloriesScore = ; 
    //score could be the amount that is over the minimum needed
    //implementation
    
    // maybe a different building algorithm for each order
    // depending on number of family members
    // approximate an amount of food items to be chosen
    // if too small or too large
    // increment or decrement the amount and construct
    // a new list of hampers
    
    // pseudocode
    // get number of family members e.g 1
    // determine number of food items
    // from items available in inventory
    // build hampers with said number of items
    // for each hamper, keep record of the nutritional value
    // add hamper to list
    // once all possible hampers have been made
    // compare and choose the best
    
    
  
    return bestHamper;
  }

}
