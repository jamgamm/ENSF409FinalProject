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
    
    ArrayList<Integer> scoresList = new ArrayList<>();
    NutritionalProfile want = hamperList.get(i).getNutritionalNeedsFamily();
    int grains = want.getGrainContent();
    int fv = want.getFVContent();
    int pro = want.getProContent();
    int other = want.getOtherContent();
    for (int i = 0; i < hamperList.size(); i++)
    {
      NutritionalProfile have = hamperList.get(i).getHamperProfile();
      int grainsH = have.getGrainContent();
      int fvH = have.getFVContent();
      int proH = have.getProContent();
      int otherH = have.getOtherContent();
      
      int difference = (grainsH - grains) + (fvH - fv) + (proH - pro) + (otherH - other);
      scoresList.add(difference);
     }
    
    ArrayList<Integer> scoresSortedList = scoresList.sort();
    int index = scoresList.indexOf(scoresSortedList.get(0));
    
    return hamperList.get(index);
  }

}
