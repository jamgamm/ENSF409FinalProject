package edu.ucalgary.ensf409;
/**
 * Class that creates possible hampers based on a family's nutritional needs
 * Only creates possible hamper combinations for 1 family at a time
 * @author Jana Afifi, Amneet Deol, Jam Ivy Gammuac, Shanelle Li Chit Khim
 * @version 2.5
 * @since 1.0 
 */
import java.util.*;

public class Hamper {
  private Client nutritionalNeedsFamily;
  private List<List<NutritionalProfile>> possible = new ArrayList<List<NutritionalProfile>>();
  private List<Client> hamperProfile = new ArrayList<Client>();
  private Order theOrder = new Order(this);
  
  /** Constructor **/
  
  /** 
   * @param familyNeeds - the weekly nutritional needs of a family
   */
  public Hamper(Client familyNeeds) throws IllegalArgumentException{
    this.nutritionalNeedsFamily = familyNeeds;
  }

  /**
   * this method will build the hamper that will be given to a single family
   * First a new inventory object will be created to access the database.
   * Through a for loop, the method create will be called up to 1000 times to create 
   * possible combinations of hampersand each combination will be added to the list named possible.
   * After all possible combinations are found, the best combination will be found through the Order class.
   * Once the best combination is found, an update to the database will be made by removing the best combination's
   * foods from the database using the updateInventory method in the Order class.
   */
  public void buildHamper() throws OrderCannotBeValidatedException{
    Inventory foodInventory = new Inventory();
    foodMap = foodInventory.getFoodMap();
    for(int j = 1; j<1001; j++){
      List<NutritionalProfile> generated = create(nutritionalNeedsFamily, j,foodMap);
      possible.add(generated);
    }
    foodInventory.close();
    theOrder.bestCombo(hamperProfile);
    theOrder.updateInventory();
  }
  
/**
   * @param familyNeeds - a Client object that holds the information about the weekly nutritional needs of a family
   * @param j - the starting key used to access the foodInven HashMap
   * @param foodInven - the HashMap holding the nutritional information about foods currently available in the database
   * This method will create one possible combination for a hamper.
   * First it will find a combination of foods that meet the grain requirements for the family.
   * Using a for loop, it will access each nutritional profile in foodInven, starting at position j in the map.
   * Then it will add the nutritional profile to the list called ourFood as long as the grain content is not 0,
   * and each of the item's nutritional values will be added to the corresponding totalGrain, totalFV etc variables.
   * If there does not exist an item associated with a key, the loop will move on and continue to the next item.
   * If the totalGrains of the items exceeds the grain needs of the family, then it will break out of the loop.
   * The second loop works similarly to the first loop which has been described above. Except it will only add items
   * that have grain contents of 0 in order to not affect the totalGrains. A break will occur in this loop if
   * the totalFV exceeds the FV needs of the family.
   * The third loop also works similarly to the two loops described above. But it will only add items
   * that have grain contents and FV contents of 0 in order to not affect the totalGrains and totalFV. 
   * A break will occur in this loop if the totalPro exceeds the protein needs of the family.
   * the totalFV exceeds the FV needs of the family.
   * The fourth loop also works similarly to all the loops described above. But it will only add items
   * that have grain contents, FV contents, and protein contents of 0 in order to not affect the totalGrains, totalFV,
   * and totalPro values. A break will occur in this loop if the totalOther exceeds the other needs of the family.
   * Finally, a new Client object will be created using the values of the totals of each category.
   * Then this Client object will be added to the hamperProfile list to keep track of all the possible hamper combinations.
   * @return List<NutritionalProfile> - returns a list of the nutritional profiles associated of the foods that were added to ourFood.
   */
  public List<NutritionalProfile> create(Client familyNeeds, int j, HashMap<Integer, NutritionalProfile> foodInven){
    List<NutritionalProfile> ourFood = new ArrayList<NutritionalProfile>();
    int totalGrain = 0;
    int totalFV = 0;
    int totalPro = 0;
    int totalOther = 0;
    int totalCal = 0;

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

    Client possibleProfile = new Client(totalGrain, totalFV, totalPro, totalOther, totalCal);
    hamperProfile.add(possibleProfile);
    return ourFood;
  } 

  
  public Client getNutritionalNeedsFamily(){
    return nutritionalNeedsFamily;
  }
  
  public List<Client> getHamperProfile(){
      return hamperProfile;
  }

  public List<List<NutritionalProfile>> getPossible(){
    return possible;
  }

  public void setPossible(List<List<NutritionalProfile>> givenPossible){
    this.possible = givenPossible;
  }
  
  public void setHamperProfile(List<Client> profile){
    this.hamperProfile = profile;
  }

  public Order getOrder(){
    return theOrder;
  }

}
