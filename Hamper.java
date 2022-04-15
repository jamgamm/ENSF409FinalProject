package edu.ucalgary.ensf409;

import java.util.*;

public class Hamper {
  private Client nutritionalNeedsFamily;
  private List<List<NutritionalProfile>> possible = new ArrayList<List<NutritionalProfile>>();
  private List<Client> hamperProfile = new ArrayList<Client>();
  private Order theOrder = new Order(this);
  
  public Hamper(Client familyNeeds) throws IllegalArgumentException{
    this.nutritionalNeedsFamily = familyNeeds;
    /*System.out.println("Family grains: " + nutritionalNeedsFamily.getGrainContent());
    System.out.println("Family FV: " + nutritionalNeedsFamily.getFVContent());
    System.out.println("Family Protein: " + nutritionalNeedsFamily.getProContent());
    System.out.println("Family Other: " + nutritionalNeedsFamily.getOther());
    System.out.println("Family calories: "+ nutritionalNeedsFamily.getCalories());*/
    //this.possible = buildHamper();
    //theOrder.bestCombo(hamperProfile);
  }

  
  public void buildHamper() throws OrderCannotBeValidatedException{
    System.out.println("making hampers...");
    Inventory foodInventory = new Inventory();
    for(int j = 1; j<1001; j++){
      List<NutritionalProfile> generated = create(nutritionalNeedsFamily, j,foodInventory);
      possible.add(generated);
    }
    //System.out.println(numOfHampers);
    foodInventory.close();
    theOrder.bestCombo(hamperProfile);
    theOrder.updateInventory();
    //return possible;
    //List<List<NutritionalProfile>>
  }
  

  public List<NutritionalProfile> create(Client familyNeeds, int j, Inventory foodInventory){
    List<NutritionalProfile> ourFood = new ArrayList<NutritionalProfile>();
    int totalGrain = 0;
    int totalFV = 0;
    int totalPro = 0;
    int totalOther = 0;
    int totalCal = 0;
    HashMap<Integer, NutritionalProfile> foodInven = foodInventory.getFoodMap();

    for(int i = j; i<foodInven.size(); i++){
      if(foodInven.get(i) == null){
        continue;
      }
      if(foodInven.get(i).getGrainContent() != 0){
        ourFood.add(foodInven.get(i));
        totalGrain += foodInven.get(i).getGrainContent();
        totalFV += foodInven.get(i).getFVContent();
        totalPro += foodInven.get(i).getProContent();
        totalOther += foodInven.get(i).getOther();
        totalCal += foodInven.get(i).getCalories();
      }
      if(totalGrain>nutritionalNeedsFamily.getGrainContent()){
        break;
      }
    }
    //System.out.println("Current grain:"+totalGrain);

    for(int i = j; i<foodInven.size(); i++){
      if(foodInven.get(i) == null){
        continue;
      }
      if(totalFV>nutritionalNeedsFamily.getFVContent()){
        break;
      }
      if(foodInven.get(i).getGrainContent() == 0 && foodInven.get(i).getFVContent()!=0){
        ourFood.add(foodInven.get(i));
        totalFV += foodInven.get(i).getFVContent();
        totalPro += foodInven.get(i).getProContent();
        totalOther += foodInven.get(i).getOther();
        totalCal += foodInven.get(i).getCalories();
      }
    }
    //System.out.println("Current FV:"+totalFV);
    for(int i = j; i<foodInven.size(); i++){
      if(foodInven.get(i) == null){
        continue;
      }
      if(totalPro>nutritionalNeedsFamily.getProContent()){
        break;
      }
      if(foodInven.get(i).getGrainContent() == 0 && 
        foodInven.get(i).getFVContent()== 0 && foodInven.get(i).getProContent()!=0
        ){
        ourFood.add(foodInven.get(i));
        totalPro += foodInven.get(i).getProContent();
        totalOther += foodInven.get(i).getOther();
        totalCal += foodInven.get(i).getCalories();
      }
    }
    //System.out.println("Current Protien:"+totalPro);
    for(int i = j; i<foodInven.size(); i++){
      if(foodInven.get(i) == null){
        continue;
      }
      if(totalOther>nutritionalNeedsFamily.getOther()){
        break;
      }
      if(foodInven.get(i).getGrainContent() == 0 && 
        foodInven.get(i).getFVContent()== 0 && foodInven.get(i).getProContent() == 0
        && foodInven.get(i).getOther()!=0){
        ourFood.add(foodInven.get(i));
        totalOther += foodInven.get(i).getOther();
        totalCal += foodInven.get(i).getCalories();
      }
  }
    //System.out.println("Current Other:"+totalOther);
    Client possibleProfile = new Client(totalGrain, totalFV, totalPro, totalOther, totalCal);
    hamperProfile.add(possibleProfile);
    ourFood = trimRepeats(ourFood);
    return ourFood;
  } 
  public List<NutritionalProfile> trimRepeats(List<NutritionalProfile> generated){
    for(int i=1; i<generated.size(); i++){
      int currID = generated.get(i).getID();
      for(int j = 2; j<generated.size(); j++){
        int theID = generated.get(j).getID();
        if(theID == currID){
          generated.remove(j);
        }
      }
    }
    return generated;
  }
  

  
  public Client getNutritionalNeedsFamily(){
    return nutritionalNeedsFamily;
  }
  

  public List<Client> getHamperProfile(){
      return hamperProfile;
  }

  public void setHamperProfile(List<Client> profile){
    this.hamperProfile = profile;
  }

  public List<List<NutritionalProfile>> getPossible(){
    return possible;
  }

  public void setPossible(List<List<NutritionalProfile>> givenPossible){
    this.possible = givenPossible;
  }

  public Order getOrder(){
    return theOrder;
  }

}
