package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.util.List;

/**
 * A program that instantiates an Order object
 * @author Jana Afifi, Amneet Deol, Jam Ivy Gammuac, Shanelle Li Chit Khim
 * @version 1.3
 * @since 1.0 
 */

public class Order {
  private Hamper myHamper;
  private List<NutritionalProfile> theCombo = new ArrayList<NutritionalProfile>();
  private Client bestHamper = new Client();
  private int excess = 0;
  
  /** Constructor **/
  
  /** 
   * @param theHamper - constructor, sets myHamper object to the given hamper
   */
  public Order(Hamper theHamper){
    this.myHamper = theHamper;
  
  }
  
  /** Helper methods **/
  
  /** 
   * Method that checks for several hamper combinations and selects the best by
   * calculating the excess calories (take actual requirement amount - total calories
   * in current hamper), the program then keeps track of the smallest excess
   * the hamper with the smallest excess is then chosen as the best hamper
   * @param generated - a List of Client objects
   * @exception OrderCannotValidatedException thrown whenever an order cannot be made
   * @see OrderCannotBeValidatedException
   */
  public void bestCombo(List<Client> generated) throws OrderCannotBeValidatedException{

    int bestIndex = 0;
    int bestCalories = generated.get(0).getCalories();
    int checkLess = 0;
    int checkGrain = 0;
    int checkFV = 0;
    int checkPro = 0;
    int checkOther = 0;
    Client familyNeeds = myHamper.getNutritionalNeedsFamily();
    for(int i = 1; i<generated.size();i++){
      Client currProfile = generated.get(i);
      checkLess = currProfile.getCalories() - familyNeeds.getCalories();
      checkGrain = currProfile.getGrainContent();
      checkFV = currProfile.getFVContent();
      checkPro = currProfile.getProContent();
      checkOther = currProfile.getOther();
      if(currProfile.getCalories()<bestCalories && checkLess>=0 && checkGrain>=familyNeeds.getGrainContent()
      && checkFV>=familyNeeds.getFVContent()&&checkPro>=familyNeeds.getProContent()&&checkOther>=familyNeeds.getOther()){
        bestCalories = generated.get(i).getCalories();
        bestIndex = i;
      }
    }
    excess = bestCalories- myHamper.getNutritionalNeedsFamily().getCalories();

    this.bestHamper = myHamper.getHamperProfile().get(bestIndex);
    this.theCombo = myHamper.getPossible().get(bestIndex);
    if(bestHamper.getCalories()<myHamper.getNutritionalNeedsFamily().getCalories()){
      throw new OrderCannotBeValidatedException();
    }
    //updateInventory();
  }

  /** 
   * Method to update the inventory, i.e, the program iterates through the list
   * of food in the best hamper combination and removes the items sequentially
   */
  public void updateInventory(){
    Inventory update = new Inventory();
    for(int i = 0; i<theCombo.size(); i++){
      update.remove(theCombo.get(i).getID());
    }
    update.close();
  }
  
  /** Getters and Setters **/
  
  /** 
   * @return List<NutritionalProfile> - returns best combination of food
   * which is stored as a List of NutritionalProfile object
   */
  public List<NutritionalProfile> getBestCombo(){
    return theCombo;
  }

  /** 
   * @param best - sets the bestHamper variable to the 
   * best hamper combination found by calculation
   */
  public void setBestHamper(Client best){
    this.bestHamper = best;
  }

  /** 
   * @return Client - returns the bestHamper variable
   */
  public Client getBestHamper(){
    return bestHamper;
  }
  
  /** 
   * @return int - returns the excess amount of calories between the hamper's and required amount
   */
  public int getExcess(){
    return excess;
  }
} // End of class declaration
