package edu.ucalgary.ensf409

import java.util.*;

public class Hamper {
  private NutrionalProfile nutritionalNeedsFamily;
  private LinkedList<Food> foodList = new LinkedList<Food>();
  private NutritionalProfile hamperProfile;
  
  public Hamper(NutritionalProfile familyNeeds) throws IllegalArgumentException{
    this.nutritionalNeedsFamily = familyNeeds;
  }
  
  public void buildHamper(){
    //pick randomly from map or go through list one by one?
    
    
    
    
    
  }
  
  //idea for algorithm using method that randomly picks: https://www.baeldung.com/java-combinations-algorithm
  
  //make hampers with 10/whatever amount random items
  //then once all hampers with 10 items are made, first check if each hamper meets the nutritional requirements
  //if it doesn't, just drop it, if it does, add it to our hamper list
  //then we can send this hamper list to the find best combo in order class
  
  private void helper(List<Food[]> combinations, HashMap<int, Food> data, int start, int end, int index) {
    if (index == data.size()) {
        Food[] combination = data.clone();
        combinations.add(combination);
    } else if (start <= end) {
        data.get(index) = data.get(start);
        //data[index] = start;
        helper(combinations, data, start + 1, end, index + 1);
        helper(combinations, data, start + 1, end, index);
    }
}
  
  //n is total number of items in inventory, r is the number of items we want
  public List<int[]> generate(int n, int r) {
    List<Food[]> combinations = new ArrayList<>();
    helper(combinations, new int[r], 0, n-1, 0);
    return combinations;
}
  

  
  public void addToFoodList(Food foodItem)throws OrderCannotBeValidatedException{
    this.foodList = foodItem;
  }
  
  public NutritionaProfile getNutritionalNeedsFamily(){
    return nutritionalNeedsFamily;
  
  }
  
  public void setNutritionalNeedsFamily(NutritionalProfile nutritionalNeedsFamily){
    this.nutritionalNeedsFamily = nutritionalNeedsFamily;
  }

}
