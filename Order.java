package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.util.List;

public class Order {
  //public LinkedList[] hamperList;
  private Hamper myHamper;
  private List<NutritionalProfile> theCombo = new ArrayList<NutritionalProfile>();
  private Client bestHamper = new Client();
  
  public Order(Hamper theHamper){
    this.myHamper = theHamper;
  //might need a family object
  
  }
  
  public void bestCombo(List<Client> generated){

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
    System.out.println(bestCalories- myHamper.getNutritionalNeedsFamily().getCalories());

    this.bestHamper = myHamper.getHamperProfile().get(bestIndex);
    this.theCombo = myHamper.getPossible().get(bestIndex);



  }

  public List<NutritionalProfile> getBestCombo(){
    return theCombo;
  }

  public Client getBestHamper(){
    return bestHamper;
  }
}
