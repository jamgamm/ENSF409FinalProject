package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.util.List;

public class Order {
  private Hamper myHamper;
  private List<NutritionalProfile> theCombo = new ArrayList<NutritionalProfile>();
  private Client bestHamper = new Client();
  private int excess = 0;
  
  public Order(Hamper theHamper){
    this.myHamper = theHamper;
  
  }
  
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
    updateInventory();
  }



  public List<NutritionalProfile> getBestCombo(){
    return theCombo;
  }

  public Client getBestHamper(){
    return bestHamper;
  }

  public void updateInventory(){
    for(int i = 0; i<theCombo.size(); i++){
      Inventory update = myHamper.getInventory();
      update.remove(theCombo.get(i).getID());
    }
  }

  public int getExcess(){
    return excess;
  }
}
