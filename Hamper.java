package edu.ucalgary.ensf409

import java.util.*;

public class Hamper {
  private NutrionalProfile nutritionalNeedsFamily;
  private LinkedList<Food> foodList = new LinkedList<Food>();
  
  public Hamper(NutritionalProfile familyNeeds) throws IllegalArgumentException{
    this.nutritionalNeedsFamily = familyNeeds;
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
